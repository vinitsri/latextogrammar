package com.pearson.consumer.latextogrammer.parser;

import org.springframework.stereotype.Component;

/**
 * The Class Expression.
 * Model class to set and retrieve expression.
 */
@Component
public class Expression {

	/** The expression. */
	private String expression;
	
	/**
	 * Instantiates a new expression.
	 */
	public Expression(){
		/*Default Constructor*/
	}

	/**
	 * As string.
	 *
	 * @return the string
	 */
	public String asString() {
		return expression;
	}

	/**
	 * Sets the expression.
	 *
	 * @param expression the new expression
	 */
	public void setExpression(String expression) {
		this.expression = expression;
	}

}