package com.lockerz.thrift.template.services;

import com.lockerz.thrift.template.auth.AuthorizerException;
import com.lockerz.thrift.template.auth.AuthorizerImpl;
import com.lockerz.thrift.template.context.Context;
import com.lockerz.thrift.template.dao.DaoImpl;
import com.lockerz.thrift.template.gen.TemplateService;
import com.lockerz.thrift.template.gen.TemplateServiceException;
import com.lockerz.thrift.template.utilities.PlaceholderConfigurer;

abstract class ServiceImpl implements TemplateService.Iface {
	
	// need this
	private  AuthorizerImpl authorizer;
	
	// need these
	protected DaoImpl dao;

	public void setDao(DaoImpl dao) {
		// set the access here
		this.dao = dao;
	}
	
	public DaoImpl getDao() {
		// return here
		return dao;
	}
	
	public void setAuthorizer(AuthorizerImpl authorizer) {
		// set the access here
		this.authorizer = authorizer;
	}
	
	public void init(String token, int serviceId) throws TemplateServiceException {
		// try
		try {
			// set the data here
			setAuthorizer( (AuthorizerImpl) Context.getContext().getBean(PlaceholderConfigurer.HANDLE + "Authorizer") );
			// authenticate here
			authorizer.authorize(token, serviceId);
			// set the data here
			setDao( (DaoImpl) Context.getContext().getBean(PlaceholderConfigurer.HANDLE + "Dao") );
		// catch here
		} catch(AuthorizerException e) {
			// need this
			throw new TemplateServiceException(e.getMessage(), e.getErrors());
		}
	}
}
