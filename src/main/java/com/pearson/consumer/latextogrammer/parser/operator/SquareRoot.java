package com.pearson.consumer.latextogrammer.parser.operator;

import java.util.Stack;

import com.pearson.consumer.latextogrammer.constants.LatexOperatorEnum;
import com.pearson.consumer.latextogrammer.constants.MathPaletteConstants;
import com.pearson.consumer.latextogrammer.constants.PreNativeOperatorEnum;

/**
 * The Class SquareRoot.
 */
public class SquareRoot extends BaseOperator {

    /**
     * 
     * @see
     * com.pearson.consumer.latextogrammer.parser.operator.Operator#render(java.
     * util.Stack)
     */
    @Override
    public StringBuilder render(Stack<Object> newStack) {
        StringBuilder sentence = new StringBuilder();
        if ("[".equals(newStack.peek())) {
            StringBuilder sentence2 = new StringBuilder(
                    LatexOperatorEnum.ROOT_INDEX.getTranslation());
            newStack.pop();
            sentence2.append(" ");
            while (!"]".equals(newStack.peek())) {
                String value = String.valueOf(newStack.pop());
                if (PreNativeOperatorEnum.SQUARE_ROOT_OF.getLabel()
                        .equals(value)) {
                    sentence2.append(PreNativeOperatorEnum.SQUARE_ROOT_OF
                            .getOperator().render(newStack));
                } else if (PreNativeOperatorEnum.FRACTION.getLabel()
                        .equals(value)) {
                    sentence2.append(PreNativeOperatorEnum.FRACTION
                            .getOperator().render(newStack));
                } else {
                    sentence2.append(value);
                }
            }
            newStack.pop();
            sentence.append(" ").append(sentence2).append(" ")
                    .append(MathPaletteConstants.OF).append(" ");
        } else {
            if (" ".equals(sentence.toString())) {
                sentence.append(
                        LatexOperatorEnum.SQUARE_ROOT_OF.getTranslation())
                        .append(" ").append(sentence.toString());
            } else {
                sentence.append(" ").append(
                        LatexOperatorEnum.SQUARE_ROOT_OF.getTranslation())
                        .append(" ");
            }
        }
        return sentence;
    }

}
