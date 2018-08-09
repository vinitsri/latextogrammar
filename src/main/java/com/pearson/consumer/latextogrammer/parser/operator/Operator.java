package com.pearson.consumer.latextogrammer.parser.operator;

import java.util.Stack;

/**
 * The Interface Operator.
 */
public interface Operator {
	
	/**
	 * Prepare.
	 *
	 * @param stack the stack
	 */
	public void prepare(Stack<Object> stack);
	
	/**
	 * Render.
	 *
	 * @param newStack the new stack
	 * @return the string builder
	 */
	public StringBuilder render(Stack<Object> newStack);
}
