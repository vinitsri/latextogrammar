package com.pearson.consumer.latextogrammer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The Class LearningExperienceComposerApp. Responsible for initializing the
 * application context and starting the application on the specified port. The
 * information about the port, context path , database context and other
 * information is defined in the application.properties.
 * 
 * 
 */
@SpringBootApplication(scanBasePackages = "com.pearson")
public class MathPaletteUtilityApp {

	/**
	 * Instantiates a new learning course delivery app.
	 */
	public MathPaletteUtilityApp() {
		super();
	}

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(final String[] args) {
		SpringApplication.run(MathPaletteUtilityApp.class, args);
	}
}
