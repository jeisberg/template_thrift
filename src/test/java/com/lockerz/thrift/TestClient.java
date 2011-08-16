package com.lockerz.thrift;

import com.lockerz.thrift.template.client.TemplateClient;
import com.lockerz.thrift.template.client.ClientException;

public class TestClient {

	private void start(){
		// try
		try {
			// get the instance and go
			System.out.println(TemplateClient.getInstance().ping("sometoken"));
		// catch here
		} catch (ClientException e) {
			// print here
			System.out.println(e.getMessage());
			// print here
			System.out.println(e.getErrors());
			// print here
			e.printStackTrace();
		}
		// exit here
    	System.exit(0);
	}

	public static void main(String[] args) {
		// create the client here
		TestClient test = new TestClient();
		// start
		test.start();
	}	
}
