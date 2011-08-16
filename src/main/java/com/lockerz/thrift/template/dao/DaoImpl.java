package com.lockerz.thrift.template.dao;

import com.lockerz.thrift.template.dao.Dao;

import org.springframework.orm.hibernate3.HibernateTemplate;

public abstract class DaoImpl implements Dao {

	protected HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        // set the template here
    	this.hibernateTemplate = hibernateTemplate;
    }

    public HibernateTemplate getHibernateTemplate() {
    	// return the template here
        return hibernateTemplate;
    }
}
