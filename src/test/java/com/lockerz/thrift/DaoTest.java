package com.lockerz.thrift;

import junit.framework.TestCase;
import com.lockerz.thrift.template.dao.DaoException;
import org.springframework.context.ApplicationContext;
import com.lockerz.thrift.template.dao.TemplateDaoImpl;
import com.lockerz.thrift.template.models.TemplateModelImpl;
import com.lockerz.thrift.template.server.Server;
import com.lockerz.thrift.template.services.TemplateServiceImpl;
import com.lockerz.thrift.template.utilities.PlaceholderConfigurer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DaoTest extends TestCase {

	public void test() {
    	
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
        	// assert here
        	assertEquals(template.getId(), TemplateServiceImpl.PING);
        	// assert here
        	assertEquals(template.getPort(), Server.PORT);
        // output here
        } catch(DaoException e) {
        }
    }
}
