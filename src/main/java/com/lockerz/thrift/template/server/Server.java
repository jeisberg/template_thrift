package com.lockerz.thrift.template.server;

import org.apache.thrift.server.*;
import org.apache.thrift.protocol.*;
import org.apache.thrift.transport.*;

import com.lockerz.thrift.template.gen.TemplateService;
import com.lockerz.thrift.template.services.TemplateServiceImpl;

import org.apache.thrift.protocol.TBinaryProtocol.*;

public class Server {
	
	public static int PORT = 7100;
	
	private void start() {
		// try
		try {
			// create the transport here
			TServerSocket serverTransport = new TServerSocket(PORT);
			// create the processor here
			TemplateService.Processor processor = new TemplateService.Processor(new TemplateServiceImpl());
			// create the protocol factory here
			Factory protFactory = new TBinaryProtocol.Factory(true, true);
			// create the arguments here
			TThreadPoolServer.Args args = new TThreadPoolServer.Args(serverTransport); 
			// set the processor
			args.processor(processor);
			// set the protocol
			args.protocolFactory(protFactory);
			// create the server here
			TServer server = new TThreadPoolServer(args);
			// log to out here
			System.out.println("Starting server on port " + PORT + " ...");
			// serve here
			server.serve();
		// catch the exception here
		} catch(TTransportException e) {
			// and print
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// need this
		Server srv = new Server();
		// start here
		srv.start();
	}
}

