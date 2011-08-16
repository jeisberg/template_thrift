package com.lockerz.thrift;

import org.apache.thrift.TException;
import com.lockerz.thrift.template.gen.Template;
import org.springframework.context.ApplicationContext;
import com.lockerz.thrift.template.services.TemplateServiceImpl;
import com.lockerz.thrift.template.gen.TemplateServiceException;
import com.lockerz.thrift.template.utilities.PlaceholderConfigurer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceTest {

    public static void main(String[] args) {
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
        	// output here
        	System.out.println(template);
        // catch here
        } catch(TemplateServiceException e) {
        	// output here
        	System.out.println(e.getMessage());
        	// output here
        	System.out.println(e.getErrors());
        	// print the stack
        	e.printStackTrace();
        } catch(TException t) {
        	// output here
        	System.out.println(t.getMessage());
        	// print the stack
        	t.printStackTrace();
        }
        // exit here
    	System.exit(0);
    }
}
