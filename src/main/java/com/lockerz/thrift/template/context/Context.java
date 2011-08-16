package com.lockerz.thrift.template.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lockerz.thrift.template.utilities.PlaceholderConfigurer;

public class Context {
	
	// need this
	private static final ApplicationContext context;
    
    static {
    	// get the context here and go
        context = new ClassPathXmlApplicationContext(PlaceholderConfigurer.HANDLE + ".xml");
    }
    
    // get the context here
    public static ApplicationContext getContext() {
        // return here
    	return context;
    }
}