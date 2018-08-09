package com.pearson.consumer.latextogrammer.parser.operator;

import java.util.Stack;

/**
 * The Class BaseOperator.
 *
 * @author vinit.srivastava1
 */
public class BaseOperator implements Operator {

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.pearson.consumer.mathpalette.parser.operator.Operator#prepare(java.
     * util.Stack)
     */
    @Override
    public void prepare(Stack<Object> stack) {

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.pearson.consumer.mathpalette.parser.operator.Operator#render(java.
     * util.Stack)
     */
    @Override
    public StringBuilder render(Stack<Object> newStack) {
        return null;
    }

}
