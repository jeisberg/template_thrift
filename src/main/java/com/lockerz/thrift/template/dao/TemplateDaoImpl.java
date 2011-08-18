package com.lockerz.thrift.template.dao;

import org.slf4j.Logger;
import org.hibernate.Session;
import org.slf4j.LoggerFactory;
import com.lockerz.thrift.template.server.Server;
import com.lockerz.thrift.template.services.TemplateServiceImpl;
import com.lockerz.thrift.template.dao.DaoException;
import com.lockerz.thrift.template.models.TemplateModelImpl;

public class TemplateDaoImpl extends DaoImpl {
	
	// create the logger here
	@SuppressWarnings("unused")
	private static Logger LOG = LoggerFactory.getLogger(TemplateDaoImpl.class);
	
	@Override
	public TemplateModelImpl ping() throws DaoException {
		// need this
		Session session = null;
		// try
		try {
			// slug for now
			TemplateModelImpl template = new TemplateModelImpl();
			// set the template
			template.setId(TemplateServiceImpl.PING);
			// set the port
			template.setPort(Server.PORT);
			// return here
			return template;
		// catch here
		} catch(Exception e) {
			// create message
			String message = this.getClass().getName() + " -> " + e.getMessage();
			// throw an exception here
			throw new DaoException(message);
		// close the session
		} finally {
			// sanity check
			if(session !=  null && session.isConnected()) {
				// close here
				session.close();
			}
		}
	}
}