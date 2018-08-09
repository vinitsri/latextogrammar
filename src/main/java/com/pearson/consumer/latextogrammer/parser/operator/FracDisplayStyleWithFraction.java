package com.pearson.consumer.latextogrammer.parser.operator;

import java.util.Stack;

import com.pearson.consumer.latextogrammer.constants.LatexOperatorEnum;

/**
 * The Class FracDisplayStyleWithFraction.
 */
public class FracDisplayStyleWithFraction extends BaseOperator {

	/**
	 * @see com.pearson.consumer.latextogrammer.parser.operator.Operator#render(java.util.Stack)
	 */
	@Override
	public StringBuilder render(Stack<Object> newStack) {
		StringBuilder englishgrammar = new StringBuilder();
		englishgrammar.append(LatexOperatorEnum.FRACTION_NUM_STYLE.getTranslation());
		return englishgrammar;
	}

}
