namespace java com.lockerz.thrift.template.gen

struct Template {
	1:i64 id,
	2:i64 port
}

exception TemplateServiceException {
	1:string message
	2:map<double,string> errors
}
	 
service TemplateService {
	Template ping(1:string token) throws (1:TemplateServiceException e)
	Template pong(1:string token) throws (1:TemplateServiceException e)
}
