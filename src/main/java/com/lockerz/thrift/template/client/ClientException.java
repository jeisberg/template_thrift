package com.lockerz.thrift.template.client;

import java.util.Map;

public class ClientException extends Exception {

	// need this
	private static final long serialVersionUID = 1L;

	// need this
	private Map<Double,String> errors;

	public ClientException() {
		// call parent
		super();
	}
	
	public ClientException(String message, Map<Double,String> errors) {
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
