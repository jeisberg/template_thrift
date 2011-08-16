package com.lockerz.thrift.template.auth;

import java.util.Map;

public class AuthorizerException extends Exception {

	// need this
	private static final long serialVersionUID = 1L;

	// need this
	private Map<Double,String> errors;

	public AuthorizerException() {
		// call parent
		super();
	}
	
	public AuthorizerException(String message, Map<Double,String> errors) {
		// call parent
		super(message);
		// set the errors
		this.errors = errors;
	}
	
	public Map<Double,String> getErrors() {
		// return here
		return errors;
	}

	public void setErrors(Map<Double,String> errors) {
		// set here
		this.errors = errors;
	}
}
