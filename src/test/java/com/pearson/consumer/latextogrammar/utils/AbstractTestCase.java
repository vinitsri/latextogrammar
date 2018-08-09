package com.pearson.consumer.latextogrammar.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.io.FilenameUtils;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestClientException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pearson.platform.common.dataaccess.util.DataAccessUtil;
import com.pearson.platform.common.utils.RestClient;
import com.pearson.platform.common.utils.client.response.ClientResponse;
import com.pearson.platform.common.utils.exception.PlatformException;
import com.pearson.platform.common.utils.internationalization.Springi18nUtils;
import com.pearson.platform.common.utils.validation.FileReader;

/**
 * The Class AbstractTestCase.
 * 
 * 
 * 
 */
@ActiveProfiles("testing")
@RunWith(PowerMockRunner.class)
@SpringBootTest(classes = { LearnerTestConfiguration.class },
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@PowerMockRunnerDelegate(SpringRunner.class)
@PowerMockIgnore({ "javax.*", "com.sun.*", "ch.*", "org.xml.*", "org.slf4j.*" })
@PrepareForTest({ RestClient.class })
@SuppressWarnings({ "rawtypes", "unchecked" })
public abstract class AbstractTestCase {
	
    /** The test name. */
    @Rule
    public TestName testName = new TestName();

    /** The port. */
    @LocalServerPort
    private int port;

    /** The springi 18 n utils. */
    @Autowired
    private Springi18nUtils springi18nUtils;


    /** The Constant FAIL_TO_PARSE_THE_JSON. */
    protected static final String FAIL_TO_PARSE_THE_JSON = "Fail to Parse the Json";

    /** The Constant OBJECT_MAPPER. */
    protected static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /** The database values. */
    protected Map<String, Object> databaseValues = new HashMap<>();

    /** The expected client response. */
    private Map<String, ClientResponse> expectedClientResponse;


    /** The data access util. */
    @Autowired
    protected DataAccessUtil dataAccessUtil;

    /**
     * Before suite.
     *
     * @throws PlatformException
     *             the platform exception
     */
    @BeforeClass
    public static void beforeSuite() throws PlatformException {
        System.setProperty("config.home", "src/test/resources/META-INF/config");
        System.setProperty("env", "local");

    }

    

    /**
     * Convert json to object.
     *
     * @param jsonFile
     *            the json file
     * @return the t
     */
    protected static
            com.pearson.platform.common.utils.client.response.ClientResponse
            convertJsonToObject(String jsonFile) {
        com.pearson.platform.common.utils.client.response.ClientResponse object = null;
        try {
            object = OBJECT_MAPPER.readValue(new File("src/test/resources/META-INF/",FilenameUtils.getName(jsonFile)),
                    com.pearson.platform.common.utils.client.response.ClientResponse.class);
        } catch (final IOException exception) {
            Assert.fail(FAIL_TO_PARSE_THE_JSON);
        }
        Assert.assertNotNull(object);
        return object;
    }

    
    /**
     * Mock data access find.
     *
     * @throws PlatformException
     *             the platform exception
     */
    protected void mockDataAccessFind() throws PlatformException {
    }
    

   
    /**
     * Convert JSON to map.
     *
     * @param jsonFile
     *            the json file
     * @return the map
     */
    protected static Map<String, ClientResponse>
              convertJsonToMap(String jsonFile) {
        Map<String, ClientResponse> response = null;
        try {
            response = OBJECT_MAPPER.readValue(new File("src/test/resources/META-INF/",FilenameUtils.getName(jsonFile)),
                    OBJECT_MAPPER.getTypeFactory().constructMapType(
                            LinkedHashMap.class, String.class,
                            ClientResponse.class));
        } catch (final IOException exception) {
            Assert.fail(FAIL_TO_PARSE_THE_JSON);
        }
        Assert.assertNotNull(response);
        return response;
    }

    /**
     * Assert client response.
     *
     * @param actualClientResponse
     *            the actual client response
     * @param expectedClientResponse
     *            the expected client response
     * @throws PlatformException
     *             the platform exception
     */
    protected void assertClientResponse(ClientResponse actualClientResponse,
            ClientResponse expectedClientResponse) throws PlatformException {
        Assert.assertNotNull(actualClientResponse);
        Assert.assertEquals(expectedClientResponse.getStatus(),
                actualClientResponse.getStatus());
    }

    /**
     * Gets the expected client response.
     *
     * @return the expected client response
     */
    protected Map<String, ClientResponse> getExpectedClientResponse() {
        return this.expectedClientResponse;
    }

    /**
     * Sets the expected client response.
     *
     * @param expectedClientResponse
     *            the expected client response
     */
    protected void setExpectedClientResponse(
            Map<String, ClientResponse> expectedClientResponse) {
        this.expectedClientResponse = expectedClientResponse;
    }

    /**
     * Gets the property.
     *
     * @param key
     *            the key
     * @param args
     *            the args
     * @return the property
     */
    protected String getProperty(String key, Object[] args) {
        return this.springi18nUtils.getMessage(key + "." + "message", args);
    }

    /**
     * Creates the URL with port.
     *
     * @param uri
     *            the uri
     * @return the string
     */
    public String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

    /**
     * Gets the base url.
     *
     * @return the base url
     */
    public String getBaseUrl() {
        return "http://localhost:" + port;
    }

    /**
     * Gets the entity.
     *
     * @param <T>
     *            the generic type
     * @param requestMappingUrl
     *            should be exactly the same as defined in your RequestMapping
     *            value attribute (including the parameters in {})
     *            RequestMapping(value = yourRestUrl)
     * @param serviceReturnTypeClass
     *            should be the the return type of the service
     * @return the result of the service, or null on error
     */
    protected <T> T getEntity(final String requestMappingUrl,
            final Class<T> serviceReturnTypeClass) {
        // Make a rest template do do the service call
        final TestRestTemplate testRestTemplate = new TestRestTemplate();
        // Add correct headers, none for this example
        final HttpEntity<String> requestEntity = new HttpEntity<>(
                new HttpHeaders());
        try {
            // Do a call the the url
            final ResponseEntity<T> entity = testRestTemplate.exchange(
                    getBaseUrl() + requestMappingUrl, HttpMethod.GET,
                    requestEntity, serviceReturnTypeClass);
            // Return result
            return entity.getBody();
        } catch (final RestClientException ex) {
            // Handle exceptions
        }
        return null;
    }

    /**
     * Gets the json from file.
     *
     * @param filePath
     *            json file path
     * @return the json from file
     * @throws FileNotFoundException
     *             the file not found exception
     */
    protected String getJsonFromFile(String filePath)
            throws FileNotFoundException {
        return FileReader.readSchemaFile(filePath);
    }
}
