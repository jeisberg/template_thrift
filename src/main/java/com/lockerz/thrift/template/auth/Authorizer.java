package com.lockerz.thrift.template.auth;

public interface Authorizer {
	
	public void authorize(String token, int serviceId) throws AuthorizerException;
}
