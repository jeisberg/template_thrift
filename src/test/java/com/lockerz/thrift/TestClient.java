package com.lockerz.thrift;

import com.lockerz.thrift.commons.utilities.Utilities;
import com.lockerz.thrift.template.gen.Template;
import com.lockerz.thrift.template.client.TemplateClient;
import com.lockerz.thrift.template.client.ClientException;

public class TestClient {

	private void start(){
		// try
		try {
			// get the instance and go
			Template template = TemplateClient.getInstance().ping("sometoken");
			// out put here
			System.out.println(template);
			// test commons here
			System.out.println(Utilities.isNullOrEmpty(null));
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
