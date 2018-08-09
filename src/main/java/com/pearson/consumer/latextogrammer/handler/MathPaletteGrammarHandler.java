package com.pearson.consumer.latextogrammer.handler;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pearson.consumer.latextogrammer.constants.MathPaletteConstants;
import com.pearson.consumer.latextogrammer.constants.SwaggerTagsConstants;
import com.pearson.consumer.latextogrammer.parser.Expression;
import com.pearson.consumer.latextogrammer.parser.Parser;
import com.pearson.glp.crosscutting.logger.factory.LoggerFactory;
import com.pearson.glp.crosscutting.logger.service.Logger;
import com.pearson.platform.common.servicehandler.AbstractServiceHandler;
import com.pearson.platform.common.utils.client.response.AbstractResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
/**
 * The Class MathPaletteGrammarHandler.
 *
 * @author shambhavi.kashyap
 */

@RestController
@RequestMapping(value = "/v1/grammar",
produces = { MediaType.APPLICATION_JSON_VALUE })
@Api(tags = SwaggerTagsConstants.SWAGGER_TAG_GET_GRAMMAR)
public class MathPaletteGrammarHandler  extends AbstractServiceHandler{

	/** The parser. */
	@Autowired
	@Qualifier("LatexParser")
	private Parser parser;

	/** The expression. */
	@Autowired
	private Expression expression;

	/**
	 * Instantiates new MathPaletteGrammarHandler.
	 */
	public MathPaletteGrammarHandler(){
		super();
	}


	/**
	 * Handle post.
	 *
	 * @param expressionMap the expression map
	 * @param httpHeaders the http headers
	 * @return the abstract response
	 */
	@ApiOperation(value = "Get Latex Grammar")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
		      @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		      @ApiResponse(code = 400, message = "Invalid Request"),
		      @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
		      @ApiResponse(code = 500, message = "Internal server error")})
	@PostMapping
	@ApiImplicitParams({ @ApiImplicitParam(
			name = MathPaletteConstants.AUTHORIZATION_TYPE, required = true,
			dataType = "String", paramType = "header") })
	public final AbstractResponse handlePost(@RequestBody
			@ApiParam(value = "JSON format input, allowed key is expression:latex. Example : {\"expression\":\"a_b\"}",
			required = true)
			Map<String,String>  expressionMap,
			@RequestHeader HttpHeaders httpHeaders  ){

		expression.setExpression(expressionMap.get("expression"));
		return handleResponse(parser.parse(expression));

	}
}
