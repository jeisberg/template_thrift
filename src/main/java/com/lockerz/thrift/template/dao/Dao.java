package com.lockerz.thrift.template.dao;

import com.lockerz.thrift.template.models.TemplateModelImpl;

public interface Dao {
	
	public TemplateModelImpl ping() throws DaoException;
}