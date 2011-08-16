package com.lockerz.thrift.template.models;

public class TemplateModelImpl extends ModelImpl {

	private long id;
	private long port;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getPort() {
		return port;
	}
	
	public void setPort(long port) {
		this.port = port;
	}

	@Override
	public String toString() {
		return "TemplateModelImpl [id=" + id + ", port=" + port + "]";
	}
}
