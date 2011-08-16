package com.lockerz.thrift.template.utilities;

import java.util.HashMap;

import com.lockerz.thrift.template.auth.AuthorizerException;
import com.lockerz.thrift.template.gen.TemplateServiceException;

public class ExceptionHelper {
	
	public static TemplateServiceException fatal(double code, String message) {
		// create the error
		HashMap<Double, String> errors = new HashMap<Double, String>(1);
		// put the error
		errors.put(new Double(code), message);
		// throw the error here
		return new TemplateServiceException(message, errors);
	}
	
	public static AuthorizerException fatal(double code, String message, boolean signature) {
		// create the error
		HashMap<Double, String> errors = new HashMap<Double, String>(1);
		// put the error
		errors.put(new Double(code), message);
		// throw the error here
		return new AuthorizerException(message, errors);
	}
}