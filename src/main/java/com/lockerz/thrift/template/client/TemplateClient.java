package com.lockerz.thrift.template.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.thrift.TException;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TTransport;
import com.lockerz.thrift.template.gen.Template;
import com.lockerz.thrift.template.server.Server;
import org.apache.thrift.protocol.TBinaryProtocol;
import com.lockerz.thrift.template.gen.TemplateService.Client;
import com.lockerz.thrift.template.gen.TemplateServiceException;

public class TemplateClient extends ClientImpl {
	
	// create the logger here
	@SuppressWarnings("unused")
	private static Logger LOG = LoggerFactory.getLogger(TemplateClient.class);

	// need this
	private static TemplateClient instance = null;
	
	// constructor
	protected TemplateClient() {
	}
	  
	// get the instance here
	public static TemplateClient getInstance() {
		// sanity check
		if(instance == null) {
			// create the instance
	        instance = new TemplateClient();
	    }
	    // return here
		return instance;
	}

	@Override
	public Template ping(String token) throws ClientException {
		// need this
		TTransport transport = null;
		// try
		try {
			// create the transport here
			transport = new TSocket("localhost", Server.PORT);
			// create the protocol here
			TProtocol protocol = new TBinaryProtocol(transport);
			// get the client here
			Client client = new Client(protocol);
			// open the transport here
			transport.open();
			// do something here
			Template template = client.ping(token);
			// close the transport here
			transport.close();
			// return here
			return template;
		// catch here
		} catch (TemplateServiceException e) {
			// throw a client exception
			throw new ClientException(e.getMessage(), e.getErrors());
		// close here
		} catch (TException t) {
			// create message
			String message = this.getClass().getName() + " -> " + t.getMessage();
			// throw a client exception
			throw new ClientException(message, null);
		// close here
		} finally {
			// sanity check
			if(transport != null && transport.isOpen()) {
				// close here
				transport.close();
			}
		}
	}
}
