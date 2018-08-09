package com.pearson.consumer.latextogrammer.parser.operator;

import java.util.Stack;

import com.pearson.consumer.latextogrammer.constants.LatexOperatorEnum;

/**
 * The Class SuperScript.
 */
public class SuperScript extends BaseOperator {

    /**
     * 
     * @see
     * com.pearson.consumer.latextogrammer.parser.operator.Operator#render(java.
     * util.Stack)
     */
    @Override
    public StringBuilder render(Stack<Object> newStack) {
        StringBuilder englishgrammar = new StringBuilder();
        englishgrammar.append(" ")
                .append(LatexOperatorEnum.POWER_OF.getTranslation())
                .append(" ");
        return englishgrammar;
    }

}
