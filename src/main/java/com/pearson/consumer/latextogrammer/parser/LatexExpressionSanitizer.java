package com.pearson.consumer.latextogrammer.parser;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.pearson.consumer.latextogrammer.constants.LatexOperatorEnum;
import com.pearson.consumer.latextogrammer.constants.MathPaletteConstants;
import com.pearson.consumer.latextogrammer.constants.PreNativeOperatorEnum;


/**
 * The Class LatexExpressionSanitizer.
 */
@Component("LatexExpressionSanitizer")
public class LatexExpressionSanitizer extends AbstractExpressionSanitizer {

	/**
	 * latexOpToGLPOpMapping map for native char
	 * @see com.pearson.consumer.latextogrammer.parser.AbstractExpressionSanitizer#populatePreNativeMapping()
	 */
	@Override
	public Map<String, String> populatePreNativeMapping() {
		Map<String, String> latexOpToGLPOpMapping = new HashMap<>();

		latexOpToGLPOpMapping.put(MathPaletteConstants.FRACTION_DISPLAY_STYLE_WITH_FRACTION, PreNativeOperatorEnum.FRACTION_DISPLAY_STYLE_WITH_FRACTION.getLabel());
		latexOpToGLPOpMapping.put(MathPaletteConstants.SQUARE_ROOT_OF, PreNativeOperatorEnum.SQUARE_ROOT_OF.getLabel());
		latexOpToGLPOpMapping.put(MathPaletteConstants.FRACTION_DISPLAY_STYLE, PreNativeOperatorEnum.FRACTION_DISPLAY_STYLE.getLabel());
		latexOpToGLPOpMapping.put(MathPaletteConstants.FRACTION_DISPLAY_STYLE2, PreNativeOperatorEnum.FRACTION_DISPLAY_STYLE.getLabel());
		latexOpToGLPOpMapping.put(MathPaletteConstants.FRACTION, PreNativeOperatorEnum.FRACTION.getLabel());
		//latexOpToGLPOpMapping.put(MathPaletteConstants.OVER_DISPLAY_STYLE, PreNativeOperatorEnum.OVER_DISPLAY_STYLE.getLabel());

		return latexOpToGLPOpMapping;
	}

	/**
	 *  latexOpToGLPOpMapping map for native grammar
	 * @see com.pearson.consumer.latextogrammer.parser.AbstractExpressionSanitizer#populateNativeMapping()
	 */
	@Override
	public Map<String, String> populateNativeMapping() {
		Map<String, String> latexOpToNativeMapping = new HashMap<>();
		latexOpToNativeMapping.put("\\\\", "");
		latexOpToNativeMapping.put("\\|", "");
		latexOpToNativeMapping.put(MathPaletteConstants.PLUSSIGN, LatexOperatorEnum.PLUS.getTranslation());
		latexOpToNativeMapping.put(MathPaletteConstants.MINUSSIGN, LatexOperatorEnum.MINUSE.getTranslation());
		latexOpToNativeMapping.put(MathPaletteConstants.LEFTPERANSIGN, LatexOperatorEnum.OPEN_PARENTHESIS_BAR.getTranslation());
		latexOpToNativeMapping.put(MathPaletteConstants.RIGHTPERANSIGN,
				LatexOperatorEnum.CLOSE_PARENTHESIS_BAR.getTranslation());
		latexOpToNativeMapping.put(MathPaletteConstants.MATHRM, " " + LatexOperatorEnum.MATH_RM.getTranslation() + " ");
		latexOpToNativeMapping.put(MathPaletteConstants.LEFT, " " + LatexOperatorEnum.OPEN_VERTICAL_BAR.getTranslation() + " ");
		latexOpToNativeMapping.put(MathPaletteConstants.RIGHT,
				" " + LatexOperatorEnum.CLOSE_VERTICAL_BAR.getTranslation() + " ");
		latexOpToNativeMapping.put(MathPaletteConstants.INFINITY, LatexOperatorEnum.INFINITY.getTranslation());
		latexOpToNativeMapping.put(MathPaletteConstants.NOTEQUALSIGNQ, "ne");
		latexOpToNativeMapping.put(MathPaletteConstants.NOTEQUALSIGN, LatexOperatorEnum.NOT_EQUAL.getTranslation());
		latexOpToNativeMapping.put(MathPaletteConstants.OVERSIGN, " " + LatexOperatorEnum.OVER.getTranslation() + " ");
		latexOpToNativeMapping.put(MathPaletteConstants.OVER_DISPLAY_STYLE, " " + LatexOperatorEnum.OVER.getTranslation() + " ");
		latexOpToNativeMapping.put(MathPaletteConstants.PERCENTAGESIGN,
				" " + LatexOperatorEnum.PERCENTAGE.getTranslation() + " ");
		
		
		latexOpToNativeMapping.put(MathPaletteConstants.SUBSCRIPT_SIGN,
				" " + LatexOperatorEnum.SUBSCRIPT.getTranslation() + " ");
		latexOpToNativeMapping.put(MathPaletteConstants.DIAGONAL_STRIKE_SIGN,
				" " + LatexOperatorEnum.DIAGONAL_STRIKE.getTranslation() + " ");
		latexOpToNativeMapping.put(MathPaletteConstants.TIMES_SIGN,
				" " + LatexOperatorEnum.TIMES.getTranslation() + " ");
		latexOpToNativeMapping.put(MathPaletteConstants.GREATER_OR_EQUAL_THAN_SIGN,
				" " + LatexOperatorEnum.GREATER_OR_EQUAL_THAN.getTranslation() + " ");
		latexOpToNativeMapping.put(MathPaletteConstants.APPROX_SIGN,
				" " + LatexOperatorEnum.APPROX.getTranslation() + " ");
		latexOpToNativeMapping.put(MathPaletteConstants.DOWNARROW_SIGN,
				" " + LatexOperatorEnum.DOWNWARDSARROW.getTranslation() + " ");
		/*latexOpToNativeMapping.put(MathPaletteConstants.RIGHTARROW_SIGN,
				" " + LatexOperatorEnum.RIGHTWARDSARROW.getTranslation() + " ");
		latexOpToNativeMapping.put(MathPaletteConstants.LEFTARROW_SIGN,
				" " + LatexOperatorEnum.LEFTWARDSARROW.getTranslation() + " ");
		latexOpToNativeMapping.put(MathPaletteConstants.LEFTSQBRACKET_SIGN,
				" " + LatexOperatorEnum.LEFTSQBRACKET.getTranslation() + " ");
		latexOpToNativeMapping.put(MathPaletteConstants.RIGHTSQBRACKET_SIGN,
				" " + LatexOperatorEnum.RIGHTSQBRACKET.getTranslation() + " ");*/
		latexOpToNativeMapping.put(MathPaletteConstants.LESSTHAN_SIGN,
				" " + LatexOperatorEnum.LESSTHAN.getTranslation() + " ");
		latexOpToNativeMapping.put(MathPaletteConstants.GREATERTHAN_SIGN,
				" " + LatexOperatorEnum.GREATERTHAN.getTranslation() + " ");
		
		
		return latexOpToNativeMapping;
	}

}
