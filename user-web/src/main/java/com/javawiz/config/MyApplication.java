package com.javawiz.config;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/api")
public class MyApplication extends ResourceConfig {

	public MyApplication() {
		packages("com.javawiz");
		register(register(new LoggingFeature(Logger.getLogger(LoggingFeature.DEFAULT_LOGGER_NAME), Level.SEVERE, LoggingFeature.Verbosity.PAYLOAD_ANY, Integer.MAX_VALUE)));
		//register(JacksonJsonProvider.class);
	}
}