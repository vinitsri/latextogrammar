package com.pearson.consumer.latextogrammar.handler;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pearson.consumer.latextogrammar.utils.AbstractTestCase;
import com.pearson.consumer.latextogrammer.parser.Expression;
import com.pearson.consumer.latextogrammer.parser.Parser;
import com.pearson.platform.common.utils.client.response.ClientResponse;
import com.pearson.platform.common.utils.exception.PlatformException;

/**
 * The Class MathPaletteHandlerTest.
 * 
 * @author prashant.jain1
 */

public class MathPaletteGrammarHandlerTest extends AbstractTestCase {
    /** The Constant MPU_V1_ANSWER. */
    private static final String MPU_V1_ANSWER = "/mpu/v1/grammar";

    /** The Constant OBJECT_MAPPER. */
    protected static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    
    /** The Constant FAIL_TO_PARSE_THE_JSON. */
    protected static final String FAIL_TO_PARSE_THE_JSON = "Fail to Parse the Json";

    /** The Constant ANSWER1. */
    private static final String ANSWER1 = "{\"expression\" : \"\\\\sqrt[8]{\\\\sqrt6}\\\\left\\\\{\\\\sqrt[6]{\\\\frac46}\\\\right\\\\}\\\\frac{\\\\left|\\\\sqrt{45}^\\\\sqrt{\\\\sqrt[7]5}\\\\right|}{67\\\\neq68}\\\\infty\\\\frac{\\\\displaystyle\\\\frac{56}8}{7\\\\mathrm\\\\pi{\\\\displaystyle\\\\frac{\\\\sqrt{45}}7}}\\\\sqrt[9]{\\\\sqrt6}\\\\frac{4}{5}\\\\sqrt{56\\\\left|2\\\\right|5\\\\frac{76}{45}}^3\"}";
    
    /** The rest template. */
    private TestRestTemplate restTemplate = new TestRestTemplate();

    /** The headers. */
    private HttpHeaders headers = new HttpHeaders();

    /** The parser. */
    @Autowired
    @Qualifier("LatexParser")
    private Parser parser;

    /** The expression. */
    @Autowired
    private Expression expression;

    /**
     * Instantiates a new MathPalatteHandler test.
     */
    public MathPaletteGrammarHandlerTest() {
        super();
    }

    /**
     * Before class.
     *
     * @throws PlatformException
     *             the platform exception
     */
    @Before
    public void beforeClass() throws PlatformException {
        this.mockDataAccessFind();
        this.setExpectedClientResponse(convertJsonToMap("grammer.json"));
    }

    /**
     * Convert json to object.
     *
     * @param <T>
     *            the generic type
     * @param jsonFile
     *            the json file
     * @param classType
     *            the class type
     * @return the t
     */
    protected static <T> T convertJsonToObject(String jsonFile,
            Class<T> classType) {
        T object = null;
        try {
            object = OBJECT_MAPPER.readValue(new File(jsonFile), classType);
        } catch (final IOException exception) {
            Assert.fail(FAIL_TO_PARSE_THE_JSON);
        }
        Assert.assertNotNull(object);
        return object;
    }

    /**
     * Gets the outcome grammer.
     *
     * @return the outcome grammer
     */
    protected static HashMap getOutcomeMap() {
        return convertJsonToObject("src/test/resources/META-INF/grammer.json",
                HashMap.class);
    }

    /**
     * Test grammer expression.
     *
     * @throws JSONException the JSON exception
     * @throws PlatformException the platform exception
     */
    @Test
    public void testGrammerExpression()
            throws JSONException, PlatformException {
        Map<String, String> expressionMap = new HashMap<>();
        expressionMap.put("expression",
                "\\sqrt[8]{\\sqrt6}\\left\\{\\sqrt[6]{\\frac46}\\right\\}\\frac{\\left|\\sqrt{45}^\\sqrt{\\sqrt[7]5}\\right|}{67\\neq68}\\infty\\frac{\\displaystyle\\frac{56}8}{7\\mathrm\\pi{\\displaystyle\\frac{\\sqrt{45}}7}}\\sqrt[9]{\\sqrt6}\\frac{4}{5}\\sqrt{56\\left|2\\right|5\\frac{76}{45}}^3");
        expression.setExpression(expressionMap.get("expression"));
        String reponse = parser.parse(expression);
        Assert.assertNotNull(reponse);
    }

    /**
     * Test pre native empty stack.
     *
     * @throws JSONException the JSON exception
     * @throws PlatformException the platform exception
     */
    @Test
    public void testPreNativeEmptyStack()
            throws JSONException, PlatformException {

        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(createURLWithPort(MPU_V1_ANSWER));

        headers.setContentType(MediaType.APPLICATION_JSON);
        String fracRoot = "{\"expression\" : \"\\\\frac4}\"}";
        HttpEntity<String> entity = new HttpEntity<>(fracRoot, headers);
        Map<String, String> uriParams = new HashMap<>();

        ResponseEntity<ClientResponse> response = restTemplate.postForEntity(
                builder.buildAndExpand(uriParams).toUri(), entity,
                ClientResponse.class);

        final ClientResponse actualClientResponse = (ClientResponse) response
                .getBody();
        this.assertClientResponse(actualClientResponse, actualClientResponse);
    }

    /**
     * Test pre native empty stack power of.
     *
     * @throws JSONException the JSON exception
     * @throws PlatformException the platform exception
     */
    @Test
    public void testPreNativeEmptyStackPowerOf()
            throws JSONException, PlatformException {

        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(createURLWithPort(MPU_V1_ANSWER));

        headers.setContentType(MediaType.APPLICATION_JSON);
        String fracRoot = "{\"expression\" : \"\\\\frac{x^{45}}{45}\"}";
        HttpEntity<String> entity = new HttpEntity<>(fracRoot, headers);
        Map<String, String> uriParams = new HashMap<>();

        ResponseEntity<ClientResponse> response = restTemplate.postForEntity(
                builder.buildAndExpand(uriParams).toUri(), entity,
                ClientResponse.class);

        final ClientResponse actualClientResponse = (ClientResponse) response
                .getBody();
        this.assertClientResponse(actualClientResponse, actualClientResponse);
    }

    /**
     * Test square root index fraction.
     *
     * @throws JSONException the JSON exception
     * @throws PlatformException the platform exception
     */
    @Test
    public void testSquareRootIndexFraction()
            throws JSONException, PlatformException {

        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(createURLWithPort(MPU_V1_ANSWER));

        headers.setContentType(MediaType.APPLICATION_JSON);
        String fracRoot = "{\"expression\" : \"\\\\sqrt[\\\\sqrt[4]{\\\\frac{5}{7}}]{\\\\sqrt{\\\\frac{5}{8}}}\"}";
        HttpEntity<String> entity = new HttpEntity<>(fracRoot, headers);
        Map<String, String> uriParams = new HashMap<>();

        ResponseEntity<ClientResponse> response = restTemplate.postForEntity(
                builder.buildAndExpand(uriParams).toUri(), entity,
                ClientResponse.class);

        final ClientResponse actualClientResponse = (ClientResponse) response
                .getBody();
        this.assertClientResponse(actualClientResponse, actualClientResponse);
    }

}
