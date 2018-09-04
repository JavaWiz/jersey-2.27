package com.javawiz.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provider
public class AppExceptionHandler implements ExceptionMapper<AppException> {
	private static final Logger log = LoggerFactory.getLogger(AppExceptionHandler.class);
	public Response toResponse(AppException ex) {
		 log.error("AppExceptionMapper - Exception occurred in application : {}", ex.getMessage());
		return Response.status(ex.getStatus())
					   .entity(new ErrorMessage(ex))
					   .type(MediaType.APPLICATION_JSON)
					   .build();
	}
}