package com.pearson.consumer.latextogrammer.constants;

import com.pearson.consumer.latextogrammer.parser.operator.ClosingBrace;
import com.pearson.consumer.latextogrammer.parser.operator.FracDisplayStyleWithFraction;
import com.pearson.consumer.latextogrammer.parser.operator.Fraction;
import com.pearson.consumer.latextogrammer.parser.operator.FractionDisplayStyle;
import com.pearson.consumer.latextogrammer.parser.operator.Operator;
import com.pearson.consumer.latextogrammer.parser.operator.OverDisplayStyle;
import com.pearson.consumer.latextogrammer.parser.operator.SquareRoot;
import com.pearson.consumer.latextogrammer.parser.operator.SuperScript;

/**
 * The enumerator for all the pre-native operators/syntax that are used 
 * internally for expression parsing.
 *
 * @author vinit.srivastava1
 */
public enum PreNativeOperatorEnum {
	
	/** The fraction display style with fraction. */
	FRACTION_DISPLAY_STYLE_WITH_FRACTION("|", new FracDisplayStyleWithFraction()), 
	
	/** The square root of. */
	SQUARE_ROOT_OF("@", new SquareRoot()), 
	
	/** The fraction display style. */
	FRACTION_DISPLAY_STYLE("?", new FractionDisplayStyle()), 
	
	/** The fraction. */
	FRACTION("*", new Fraction()), 
	
	/** The over display style. */
	OVER_DISPLAY_STYLE("\\\\", new OverDisplayStyle()),
	
	/** The closing brace. */
	CLOSING_BRACE("}", new ClosingBrace()),
	
	/** The power of. */
	POWER_OF("^", new SuperScript());

	/** The label. */
	private final String label;
	
	/** The operator. */
	private final Operator operator;

	/**
	 * Instantiates a new pre native operator enum.
	 *
	 * @param label the label
	 * @param operator the operator
	 */
	private PreNativeOperatorEnum(String label, Operator operator) {
		this.label = label;
		this.operator = operator;
	}

	/**
	 * Gets the label.
	 *
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Gets the operator.
	 *
	 * @return the operator
	 */
	public Operator getOperator() {
		return operator;
	}

	/**
	 * As operator.
	 *
	 * @param label the label
	 * @return the pre native operator enum
	 */
	public static PreNativeOperatorEnum asOperator(String label) {
		for (PreNativeOperatorEnum operator : PreNativeOperatorEnum.values()) {
			if (operator.getLabel().equalsIgnoreCase(label)) {
				return operator;
			}
		}

		return null;
	}

}
