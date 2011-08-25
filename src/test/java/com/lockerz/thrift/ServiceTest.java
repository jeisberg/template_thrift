package com.lockerz.thrift;

import junit.framework.TestCase;
import org.apache.thrift.TException;
import com.lockerz.thrift.template.gen.Template;
import org.springframework.context.ApplicationContext;

import com.lockerz.thrift.template.server.Server;
import com.lockerz.thrift.template.services.TemplateServiceImpl;
import com.lockerz.thrift.template.gen.TemplateServiceException;
import com.lockerz.thrift.template.utilities.PlaceholderConfigurer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceTest extends TestCase {

    public void test() {
    	// get the context here
    	ApplicationContext context = new ClassPathXmlApplicationContext(PlaceholderConfigurer.HANDLE + ".xml"); 	
        // get the template service here
        TemplateServiceImpl templateService = (TemplateServiceImpl) context.getBean(PlaceholderConfigurer.HANDLE + "Service");
        // need this
        Template template = null;
        // test the service
        try { 
        	// get the user lookup
        	template = templateService.ping("sometoken");
        	// assert here
        	assertEquals(template.getId(), TemplateServiceImpl.PING);
        	// assert here
        	assertEquals(template.getPort(), Server.PORT);
        // catch here
        } catch(TemplateServiceException e) {
        } catch(TException t) {
        }
    }
}
