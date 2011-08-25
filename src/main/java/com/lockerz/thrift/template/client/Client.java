package com.lockerz.thrift.template.client;

import com.lockerz.thrift.template.gen.Template;

public interface Client {
	
	public Template ping(String token) throws ClientException;
	public String echo(String token, String target) throws ClientException;
	public long getPort(String token) throws ClientException;
}