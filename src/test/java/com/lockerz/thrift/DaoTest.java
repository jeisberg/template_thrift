package com.lockerz.thrift;

import com.lockerz.thrift.template.dao.DaoException;
import org.springframework.context.ApplicationContext;
import com.lockerz.thrift.template.dao.TemplateDaoImpl;
import com.lockerz.thrift.template.models.TemplateModelImpl;
import com.lockerz.thrift.template.services.TemplateServiceImpl;
import com.lockerz.thrift.template.utilities.PlaceholderConfigurer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DaoTest {

    public static void main(String[] args) {
    	
    	// get the context here
    	ApplicationContext context = new ClassPathXmlApplicationContext(PlaceholderConfigurer.HANDLE + ".xml"); 	
        // get the template service here
        TemplateServiceImpl templateService = (TemplateServiceImpl) context.getBean(PlaceholderConfigurer.HANDLE + "Service");
        // get the template data here
        TemplateDaoImpl templateDao = (TemplateDaoImpl) templateService.getDao();
        // slug
        TemplateModelImpl template = null;
        // try
        try {
        	// get the template
        	template = templateDao.ping();
        	// out put here
        	System.out.println(PlaceholderConfigurer.HANDLE + ": " + template);
        	// exit here
        	System.exit(0);
        // output here
        } catch(DaoException e) {
        	// output here
        	System.out.println(e.getMessage());
        	// print the stack
        	e.printStackTrace();
        }
    }
}
