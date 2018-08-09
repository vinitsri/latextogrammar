package com.pearson.consumer.latextogrammer.parser.operator;

import java.util.Stack;

import org.springframework.util.ObjectUtils;

import com.pearson.consumer.latextogrammer.constants.LatexOperatorEnum;
import com.pearson.consumer.latextogrammer.constants.PreNativeOperatorEnum;

/**
 * The Class ClosingBrace.
 */
public class ClosingBrace extends BaseOperator {

	/** 
	 ** @see com.pearson.consumer.latextogrammer.parser.operator.Operator#prepare(java.util.Stack)
	 */
	@Override
	public void prepare(Stack<Object> stack) {

		Stack<Object> newStack = new Stack<>();
		stack.pop();
		while (!stack.isEmpty() && !stack.peek().equals("{")) {
			newStack.push(stack.pop());
		}
		
		if (!stack.isEmpty())
			stack.pop();
		String style = "";
		if(!stack.isEmpty()) {
			String stackValue = String.valueOf(stack.peek()).trim();
		if ((stackValue.equals(PreNativeOperatorEnum.SQUARE_ROOT_OF.getLabel())
				|| stack.peek().equals("]")))
			style = " " + LatexOperatorEnum.ENDROOT.getTranslation() + " ";
		if (((stackValue.startsWith(PreNativeOperatorEnum.FRACTION.getLabel()))||stackValue.startsWith(PreNativeOperatorEnum.FRACTION_DISPLAY_STYLE.getLabel())))
			style = " " + LatexOperatorEnum.ENDFRACTION.getTranslation() + " ";
		}
		else if (stack.isEmpty()) {
			String stackValue = String.valueOf(newStack.peek()).trim();
			if(stackValue.startsWith(PreNativeOperatorEnum.FRACTION.getLabel()) ||stackValue.startsWith(PreNativeOperatorEnum.FRACTION_DISPLAY_STYLE.getLabel()))
				style = " " + LatexOperatorEnum.ENDFRACTION.getTranslation() + " ";
		}
		
		while (!newStack.isEmpty()) {
			stack.push(newStack.pop());
		} 
		if(!ObjectUtils.isEmpty(style.trim()))
			stack.push(" " + style);
	}

}
