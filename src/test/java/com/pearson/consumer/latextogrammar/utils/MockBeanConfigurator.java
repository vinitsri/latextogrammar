package com.pearson.consumer.latextogrammar.utils;

import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.pearson.platform.common.dataaccess.util.DataAccessUtil;
import com.pearson.platform.common.utils.RestClient;
import com.pearson.platform.common.utils.property.PropertyHolderUtil;

/**
 * The Class MockBeanConfigurator.Used for Mocking the beans required.
 * 
 */
@Profile("testing")
@TestConfiguration
public class MockBeanConfigurator {

    /**
     * Instantiates a new mock bean configurator.
     */
    public MockBeanConfigurator() {
        super();
    }

    /**
     * Gets the data accessutil.
     *
     * @return the data accessutil
     */
    @Bean
    @Primary
    public DataAccessUtil getDataAccessutil() {
        return Mockito.mock(DataAccessUtil.class);
    }

   
    /**
     * Gets the rest template.
     *
     * @return the rest template
     */
    @Bean
    @Primary
    public RestClient getRestTemplate() {
        return PowerMockito.mock(RestClient.class);
    }

    
    /**
     * Gets the lad ready endpoint.
     *
     * @return the lad ready endpoint
     */
    @Bean
    @Primary
    public String getLadReadyEndpoint() {
        String ladReadyUrl = PropertyHolderUtil
                .getStringProperty("LAD_READY_URL");
        return ladReadyUrl;

    }

    /**
     * Gets the idam ready endpoint.
     *
     * @return the idam ready endpoint
     */
    @Bean
    @Primary
    public String getIdamReadyEndpoint() {
        String idamReadyUrl = PropertyHolderUtil
                .getStringProperty("IDAM_READY_URL");
        return idamReadyUrl;

    }

    /**
     * Gets the idam service endpoint.
     *
     * @return the idam service endpoint
     */
    @Bean
    @Primary
    public String getIdamServiceEndpoint() {
        String idamReadyUrl = PropertyHolderUtil
                .getStringProperty("IDAM_SERVICE_URL");
        return idamReadyUrl;

    }

}
