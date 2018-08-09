package com.pearson.consumer.latextogrammer.parser;

import java.util.Stack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * The Class AbstractParser.
 *
 * @author vinit.srivastava1
 */
public abstract class AbstractParser implements Parser {

	/** The sanitizer. */
	@Autowired
	@Qualifier("LatexExpressionSanitizer")
	private ExpresssionSanitizer sanitizer;

	/**
	 * @see com.pearson.consumer.latextogrammer.parser.Parser#parse(com.pearson.consumer.latextogrammer.parser.Expression)
	 */
	public String parse(Expression expression) {
		expression = sanitizer.sanitize(expression);

		Stack<Object> expressionStack = expressionToCollection(expression);
		return expressionToNative(expressionStack);
	}

	/**
	 * Expression to collection.
	 *
	 * @param expression the expression
	 * @return the stack
	 */
	public abstract Stack<Object> expressionToCollection(Expression expression);

	/**
	 * Expression to native.
	 *
	 * @param stack the stack
	 * @return the string
	 */
	public abstract String expressionToNative(Stack<Object> stack);
}
