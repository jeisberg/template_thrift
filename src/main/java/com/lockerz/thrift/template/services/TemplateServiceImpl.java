package com.lockerz.thrift.template.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.thrift.TException;
import com.lockerz.thrift.template.gen.Template;
import com.lockerz.thrift.template.dao.DaoException;
import com.lockerz.thrift.template.models.TemplateModelImpl;
import com.lockerz.thrift.template.server.Server;
import com.lockerz.thrift.template.utilities.ExceptionHelper;
import com.lockerz.thrift.template.gen.TemplateServiceException;

public class TemplateServiceImpl extends ServiceImpl {
	
	// create the logger here
	@SuppressWarnings("unused")
	private static Logger LOG = LoggerFactory.getLogger(TemplateServiceImpl.class);

	// need these
	public static final int PING = 100;
	
	// need these
	public static final double FATAL = 100.01;
	
	@Override
	public Template ping(String token) throws TemplateServiceException, TException {
		// initialize tokens
		super.init(token, PING);
		// try
		try {
			// need this
			Template template = null;
			// slug here
			TemplateModelImpl row = dao.ping();
			// sanity check
			if(row != null) {
				// set the template here
				template = new Template(row.getId(), row.getPort());
			}
			// return here
			return template;
		// catch and throw here
		} catch(DaoException e) {
			// throw here
			throw ExceptionHelper.fatal(FATAL, e.getMessage());
		}
	}

	@Override
	public String echo(String token, String target) throws TemplateServiceException, TException {
		// return here
		return target;
	}

	@Override
	public long getPort(String token) throws TemplateServiceException, TException {
		// return here
		return Server.PORT;
	}
}