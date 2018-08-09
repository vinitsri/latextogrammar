package com.pearson.consumer.latextogrammer.parser;

import java.util.Map;

/**
 * The Class AbstractExpressionSanitizer.
 */
public abstract class AbstractExpressionSanitizer implements ExpresssionSanitizer {
	
	/** 
	 * Sanitize to native mapping, Sanitize to GLP mapping
	 * @see com.pearson.consumer.latextogrammer.parser.ExpresssionSanitizer#sanitize(com.pearson.consumer.latextogrammer.parser.Expression)
	 */
	public Expression sanitize(Expression expression) {

		Map<String, String> glpMapping = populatePreNativeMapping();
		Map<String, String> nativeMapping = populateNativeMapping();

		expression = sanitizeToNativeMapping(expression, nativeMapping);
		expression = sanitizeToGLPMapping(expression, glpMapping);

		return expression;
	}

	/**
	 * Sanitize to native mapping. Native keys are  the basic characters which define latex.
	 * Sanitize does the opposite takes up the native characters and replace them with custom ones.
	 *
	 * @param expression the expression
	 * @param glpMapping the glp mapping
	 * @return the expression
	 */
	private Expression sanitizeToNativeMapping(Expression expression, Map<String, String> glpMapping) {
		for (Map.Entry<String, String> entry : glpMapping.entrySet()) {
			expression.setExpression(expression.asString().replaceAll(entry.getKey(), entry.getValue()));
		}
		return expression;
	}

	/**
	 * Sanitize to GLP mapping, this converts to grammer keywords.
	 *
	 * @param expression the expression
	 * @param nativeMapping the native mapping
	 * @return the expression
	 */
	private Expression sanitizeToGLPMapping(Expression expression, Map<String, String> nativeMapping) {
		for (Map.Entry<String, String> entry : nativeMapping.entrySet()) {
			expression.setExpression(expression.asString().replaceAll(entry.getKey(), entry.getValue()));
		}
		return expression;
	}

	/**
	 * Populates the mapping of operators in the input expression 
	 * with pre-native operators/syntax.
	 *
	 * @return the map
	 */
	public abstract Map<String, String> populatePreNativeMapping();

	/**
	 * Populates the mapping of operators in the input expression 
	 * with native operators/syntax.
	 *
	 * @return the map
	 */
	public abstract Map<String, String> populateNativeMapping();

}
