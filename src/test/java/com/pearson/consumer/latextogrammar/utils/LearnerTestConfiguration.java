package com.pearson.consumer.latextogrammar.utils;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

import com.pearson.consumer.latextogrammer.MathPaletteUtilityApp;


/**
 * The Class LearnerTestConfiguration. This class includes all the configuration
 * which are required for testing.
 * 
 * @author akshit.goel
 */
@TestConfiguration
@EnableAutoConfiguration
@ComponentScan("com.pearson")
@Import(value = { MockBeanConfigurator.class, MathPaletteUtilityApp.class})
@Profile("testing")
public class LearnerTestConfiguration {

    /**
     * Instantiates a new learner test configuration.
     */
    LearnerTestConfiguration() {
        super();
    }

}