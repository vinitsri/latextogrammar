package com.pearson.consumer.latextogrammer.parser.operator;

import java.util.Stack;

import com.pearson.consumer.latextogrammer.constants.LatexOperatorEnum;

/**
 * The Class Fraction.
 */
public class Fraction extends BaseOperator {

	/**
	 * @see com.pearson.consumer.latextogrammer.parser.operator.Operator#render(java.util.Stack)
	 */
	@Override
	public StringBuilder render(Stack<Object> newStack) {
		StringBuilder englishgrammar = new StringBuilder();
		englishgrammar.append(" ").append(LatexOperatorEnum.STARTFRACTION.getTranslation()).append(" ");
		return englishgrammar;
	}


}
