package com.pearson.consumer.latextogrammer.parser;

import java.util.Stack;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.pearson.consumer.latextogrammer.constants.PreNativeOperatorEnum;
import com.pearson.consumer.latextogrammer.parser.operator.Operator;

/**
 * The Class LatexParser.
 */
@Component("LatexParser")
public class LatexParser extends AbstractParser {

	/**
	 * @see com.pearson.consumer.latextogrammer.parser.AbstractParser#expressionToCollection(com.pearson.consumer.latextogrammer.parser.Expression)
	 * converts the latex expression, identify native characters and prepare the stack of keywords from them.
	 */
	@Override
	public Stack<Object> expressionToCollection(Expression exp) {
		String expression = exp.asString();
		Stack<Object> opertaorStack = new Stack<>();
		for (int k = 0; k < expression.length(); k++) {

			PreNativeOperatorEnum preNativeOperator = PreNativeOperatorEnum
					.asOperator(String.valueOf(expression.charAt(k)).trim());
			opertaorStack.push(String.valueOf(expression.charAt(k)));

			if (preNativeOperator != null) {
				preNativeOperator.getOperator().prepare(opertaorStack);
			}

		}

		return reverseStack(opertaorStack);
	}

	/**
	 * @see com.pearson.consumer.latextogrammer.parser.AbstractParser#expressionToNative(java.util.Stack)
	 * sentence creation from grammar keywords.
	 */
	@Override
	public String expressionToNative(Stack<Object> stack) {
		StringBuilder sentence = new StringBuilder();
		while (!stack.isEmpty()) {
			String element = String.valueOf(stack.pop());
			PreNativeOperatorEnum preNativeOperator = PreNativeOperatorEnum.asOperator(element);

			if (!ObjectUtils.isEmpty(preNativeOperator)) {
				Operator operator = preNativeOperator.getOperator();
				sentence.append(operator.render(stack));
			} else {
				sentence.append(element);
			}

		}
		return sentence.toString().replaceAll("\\s+", " ").trim();
	}

	/**
	 * Reverse stack.
	 *
	 * @param opertaorStack the opertaor stack
	 * @return the stack
	 */
	private Stack<Object> reverseStack(Stack<Object> opertaorStack) {
		Stack<Object> newStack = new Stack<>();
		while (!opertaorStack.isEmpty()) {
			if ("{".equals(opertaorStack.peek()) || "}".equals(opertaorStack.peek())) {
				opertaorStack.pop();
				continue;
			}
			newStack.push(opertaorStack.pop());

		}

		return newStack;
	}
}
