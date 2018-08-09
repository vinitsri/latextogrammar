package com.pearson.consumer.latextogrammer.constants;

/**
 * The Enum LatexOperatorEnum.
 */
public enum LatexOperatorEnum {

	/** The space. */
	SPACE("\\\\", " "),
	
	/** The empty. */
	EMPTY("\\|", ""),
	
	/** The sqrt. */
	SQRT("sqrt", "Square root of"),
	
	/** The math rm. */
	MATH_RM("mathrm", "straight"),
	
	/** The pi. */
	PI("pi", "pi"),
	
	/** The left. */
	LEFT("left", "left"),
	
	/** The right. */
	RIGHT("right", "right"),
	
	/** The not equal. */
	NOT_EQUAL("ne", "Not Equal To"),
	
	/** The not equal char. */
	NOT_EQUAL_CHAR(">", "Not equal to"),
	
	/** The frac close. */
	FRAC_CLOSE("\\}\\{", " over "),
	
	/** The frac disp frac. */
	FRAC_DISP_FRAC("frac\\\\{displaystylefrac", "StartFraction"),
	
	/** The frac disp. */
	FRAC_DISP("frac\\\\{displaystyle", "fraction numerator"),
	
	/** The frac. */
	FRAC("frac", " "),
	
	/** The over disp style. */
	OVER_DISP_STYLE("overdisplaystyle", " "),
	
	/** The open vertical bar. */
	OPEN_VERTICAL_BAR("","Start vertical bar"),
	
	/** The close vertical bar. */
	CLOSE_VERTICAL_BAR("","End vertical bar"),
	
	/** The open parenthesis bar. */
	OPEN_PARENTHESIS_BAR("","open parentheses"),
	
	/** The close parenthesis bar. */
	CLOSE_PARENTHESIS_BAR("","close parentheses"),
	
	/** The infinity. */
	INFINITY("","infinity"),
	
	/** The over. */
	OVER("","over"),
	
	/** The plus. */
	PLUS("+", "plus"),
	
	/** The minuse. */
	MINUSE("-", "minuse"),
	
	/** The percentage. */
	PERCENTAGE("","percent"),
	
	/** The square root of. */
	SQUARE_ROOT_OF("","Square root of"),
	
	/** The fraction num style. */
	FRACTION_NUM_STYLE("","StartFraction"),
	
	/** The denominator style. */
	DENOMINATOR_STYLE("","denominator begin display style"),
	
	/** The subscript. */
	SUBSCRIPT("","subscript"),
	
	/** The power of. */
	POWER_OF("^","to the Power of"),
	
	/** The endroot. */
	ENDROOT("","EndRoot"),
	
	/** The endfraction. */
	ENDFRACTION("","EndFraction"),
	
	/** The endstyle. */
	ENDSTYLE("","EndStyle"),
	
	/** The root index. */
	ROOT_INDEX("","root index"),
	
	/** The startfraction. */
	STARTFRACTION("","StartFraction"),
	
	/** up diagonal strike */
	DIAGONAL_STRIKE("","up diagonal strike"),
	/** Times of */
	TIMES("", "times"),
	
	/** Greater or equal than */
	GREATER_OR_EQUAL_THAN("","greater or equal than"), 
	
	/** almost equal to*/
	APPROX("","almost equal to"),
	
	/** downwards arrow*/
	DOWNWARDSARROW("","downwards arrow"),
	
	/** rightwards  arrow*/
	RIGHTWARDSARROW("rightarrow","rightwards  arrow"),
	
	/** leftwards  arrow*/
	LEFTWARDSARROW("leftarrow","leftwards  arrow"), 
	
	/** Open square bracket */
	LEFTSQBRACKET("","open square brackets"),
	
	/** Close square bracket */
	RIGHTSQBRACKET("","close  square brackets"),
	/** Less than */
	LESSTHAN("","less than"),
	/** greater than */
	GREATERTHAN("","greater than");

	/** The label. */
	private final String label;
	
	/** The translation. */
	private final String translation;

	/**
	 * Instantiates a new latex operator enum.
	 *
	 * @param label the label
	 * @param translation the translation
	 */
	private LatexOperatorEnum(String label, String translation) {
		this.label = label;
		this.translation = translation;
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
	 * Gets the translation.
	 *
	 * @return the translation
	 */
	public String getTranslation() {
		return translation;
	}

	/**
	 * As operator.
	 *
	 * @param label the label
	 * @return the latex operator enum
	 */
	public static LatexOperatorEnum asOperator(String label) {
		for(LatexOperatorEnum operator: LatexOperatorEnum.values()) {
			if(operator.getLabel().equalsIgnoreCase(label)) {
				return operator;
			}
		}

		return null;
	}


}
