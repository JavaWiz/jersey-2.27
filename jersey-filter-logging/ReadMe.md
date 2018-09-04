http://localhost:9090/service. (Kindly change urls respectively everywhere in below requests and introcduce your context path in between as shown above).

1.) GET Request with http://localhost:9090/service will return the output in text format like 
	Message from Server :Fri Nov 06 15:15:42 IST 2015
	
2.) GET Request with http://localhost:9090/service/Hello will return the output in text format like 
	Message from Server :Hello
		
3.) GET Request with http://localhost:9090/service/json will return the object EmployeeModel in Json format like
	
4.) GET Request with http://localhost:9090/service/xml will return the object EmployeeModel in XML format like
	
	The logs will be more or less will be like request http://localhost:9090/service/json with some difference. 

5.) POST EmployeeModel object to Service using URL http://localhost:9090/service/json/object
    We have used Postman Rest client to send the JSON request to service
	The response will be send back as XML format, in step 3. This is example of consuming JSON as Object.
		
	In Post request we are logging the body of Post request also. Here in this case we are logging the input JSON. 
	The EmployeeModel request is sent as {"name":"hello","age":"24"} json. We are logging it as "Entity Stream : {"name":"hello","age":"24"}"
	
	The logs will be generated as :
	
	DEBUG	2015-11-06 15:22:01,573	org.learn.CustomLoggingFilter	[http-apr-9090-exec-5]	Entering in Resource : /service/json/object 
	DEBUG	2015-11-06 15:22:01,575	org.learn.CustomLoggingFilter	[http-apr-9090-exec-5]	Method Name : postEmployee 
	DEBUG	2015-11-06 15:22:01,575	org.learn.CustomLoggingFilter	[http-apr-9090-exec-5]	Class : org.learn.ServiceResource 
	DEBUG	2015-11-06 15:22:01,575	org.learn.CustomLoggingFilter	[http-apr-9090-exec-5]	----Start Annotations of resource ----
	DEBUG	2015-11-06 15:22:01,575	org.learn.CustomLoggingFilter	[http-apr-9090-exec-5]	@javax.ws.rs.POST()
	DEBUG	2015-11-06 15:22:01,575	org.learn.CustomLoggingFilter	[http-apr-9090-exec-5]	@javax.ws.rs.Path(value=/json/object)
	DEBUG	2015-11-06 15:22:01,575	org.learn.CustomLoggingFilter	[http-apr-9090-exec-5]	@javax.ws.rs.Consumes(value=[application/json])
	DEBUG	2015-11-06 15:22:01,575	org.learn.CustomLoggingFilter	[http-apr-9090-exec-5]	@javax.ws.rs.Produces(value=[application/xml])
	DEBUG	2015-11-06 15:22:01,575	org.learn.CustomLoggingFilter	[http-apr-9090-exec-5]	----End Annotations of resource----
	DEBUG	2015-11-06 15:22:01,575	org.learn.CustomLoggingFilter	[http-apr-9090-exec-5]	----Start Header Section of request ----
	DEBUG	2015-11-06 15:22:01,575	org.learn.CustomLoggingFilter	[http-apr-9090-exec-5]	Method Type : POST
	DEBUG	2015-11-06 15:22:01,575	org.learn.CustomLoggingFilter	[http-apr-9090-exec-5]	Header Name: host, Header Value :localhost:9090 
	DEBUG	2015-11-06 15:22:01,575	org.learn.CustomLoggingFilter	[http-apr-9090-exec-5]	Header Name: connection, Header Value :keep-alive 
	DEBUG	2015-11-06 15:22:01,575	org.learn.CustomLoggingFilter	[http-apr-9090-exec-5]	Header Name: content-length, Header Value :27 
	DEBUG	2015-11-06 15:22:01,575	org.learn.CustomLoggingFilter	[http-apr-9090-exec-5]	Header Name: cache-control, Header Value :no-cache 
	DEBUG	2015-11-06 15:22:01,575	org.learn.CustomLoggingFilter	[http-apr-9090-exec-5]	Header Name: origin, Header Value :chrome-extension://fdmmgilgnpjigdojojpjoooidkmcomcm 
	DEBUG	2015-11-06 15:22:01,575	org.learn.CustomLoggingFilter	[http-apr-9090-exec-5]	Header Name: user-agent, Header Value :Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.80 Safari/537.36 
	DEBUG	2015-11-06 15:22:01,575	org.learn.CustomLoggingFilter	[http-apr-9090-exec-5]	Header Name: content-type, Header Value :application/json 
	DEBUG	2015-11-06 15:22:01,575	org.learn.CustomLoggingFilter	[http-apr-9090-exec-5]	Header Name: accept, Header Value :*/* 
	DEBUG	2015-11-06 15:22:01,575	org.learn.CustomLoggingFilter	[http-apr-9090-exec-5]	Header Name: accept-encoding, Header Value :gzip, deflate 
	DEBUG	2015-11-06 15:22:01,575	org.learn.CustomLoggingFilter	[http-apr-9090-exec-5]	Header Name: accept-language, Header Value :en-US,en;q=0.8 
	DEBUG	2015-11-06 15:22:01,575	org.learn.CustomLoggingFilter	[http-apr-9090-exec-5]	----End Header Section of request ----
	DEBUG	2015-11-06 15:22:01,576	org.learn.CustomLoggingFilter	[http-apr-9090-exec-5]	Entity Stream : {"name":"hello","age":"24"}
	DEBUG	2015-11-06 15:22:01,651	org.learn.CustomLoggingFilter	[http-apr-9090-exec-5]	Total request execution time : 78 milliseconds

6.) POST Request to send String parameter to Service using http://localhost:9090/service/json/anyString
    The service will send the response like 
	Jersey Says :anyString
	
	The logs will be generated as :
	DEBUG	2015-11-06 15:26:48,653	org.learn.CustomLoggingFilter	[http-apr-9090-exec-4]	Entering in Resource : /service/json/anyString 
	DEBUG	2015-11-06 15:26:48,654	org.learn.CustomLoggingFilter	[http-apr-9090-exec-4]	Method Name : postPathParamValue 
	DEBUG	2015-11-06 15:26:48,654	org.learn.CustomLoggingFilter	[http-apr-9090-exec-4]	Class : org.learn.ServiceResource 
	DEBUG	2015-11-06 15:26:48,654	org.learn.CustomLoggingFilter	[http-apr-9090-exec-4]	Query Parameter Name: name, Value :anyString
	DEBUG	2015-11-06 15:26:48,654	org.learn.CustomLoggingFilter	[http-apr-9090-exec-4]	----Start Annotations of resource ----
	DEBUG	2015-11-06 15:26:48,654	org.learn.CustomLoggingFilter	[http-apr-9090-exec-4]	@javax.ws.rs.POST()
	DEBUG	2015-11-06 15:26:48,654	org.learn.CustomLoggingFilter	[http-apr-9090-exec-4]	@javax.ws.rs.Path(value=/json/{name})
	DEBUG	2015-11-06 15:26:48,654	org.learn.CustomLoggingFilter	[http-apr-9090-exec-4]	@javax.ws.rs.Produces(value=[text/plain])
	DEBUG	2015-11-06 15:26:48,654	org.learn.CustomLoggingFilter	[http-apr-9090-exec-4]	----End Annotations of resource----
	DEBUG	2015-11-06 15:26:48,654	org.learn.CustomLoggingFilter	[http-apr-9090-exec-4]	----Start Header Section of request ----
	DEBUG	2015-11-06 15:26:48,654	org.learn.CustomLoggingFilter	[http-apr-9090-exec-4]	Method Type : POST
	DEBUG	2015-11-06 15:26:48,654	org.learn.CustomLoggingFilter	[http-apr-9090-exec-4]	Header Name: host, Header Value :localhost:9090 
	DEBUG	2015-11-06 15:26:48,654	org.learn.CustomLoggingFilter	[http-apr-9090-exec-4]	Header Name: connection, Header Value :keep-alive 
	DEBUG	2015-11-06 15:26:48,654	org.learn.CustomLoggingFilter	[http-apr-9090-exec-4]	Header Name: content-length, Header Value :0 
	DEBUG	2015-11-06 15:26:48,654	org.learn.CustomLoggingFilter	[http-apr-9090-exec-4]	Header Name: cache-control, Header Value :no-cache 
	DEBUG	2015-11-06 15:26:48,654	org.learn.CustomLoggingFilter	[http-apr-9090-exec-4]	Header Name: origin, Header Value :chrome-extension://fdmmgilgnpjigdojojpjoooidkmcomcm 
	DEBUG	2015-11-06 15:26:48,655	org.learn.CustomLoggingFilter	[http-apr-9090-exec-4]	Header Name: user-agent, Header Value :Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.80 Safari/537.36 
	DEBUG	2015-11-06 15:26:48,655	org.learn.CustomLoggingFilter	[http-apr-9090-exec-4]	Header Name: content-type, Header Value :application/json 
	DEBUG	2015-11-06 15:26:48,655	org.learn.CustomLoggingFilter	[http-apr-9090-exec-4]	Header Name: accept, Header Value :*/* 
	DEBUG	2015-11-06 15:26:48,655	org.learn.CustomLoggingFilter	[http-apr-9090-exec-4]	Header Name: accept-encoding, Header Value :gzip, deflate 
	DEBUG	2015-11-06 15:26:48,655	org.learn.CustomLoggingFilter	[http-apr-9090-exec-4]	Header Name: accept-language, Header Value :en-US,en;q=0.8 
	DEBUG	2015-11-06 15:26:48,655	org.learn.CustomLoggingFilter	[http-apr-9090-exec-4]	----End Header Section of request ----
	DEBUG	2015-11-06 15:26:48,655	org.learn.CustomLoggingFilter	[http-apr-9090-exec-4]	Total request execution time : 2 milliseconds
	
	
7.) GET Request with http://localhost:9090/service/exception will return the below exception message 
	Exception thrown by getPathParamValue resource
	
	The logs will be generated as : Exception message is logged with error priority.(Second last line in below log message)


	DEBUG	2015-11-06 19:54:59,264	org.learn.CustomLoggingFilter	[http-bio-9095-exec-6]	Entering in Resource : /service/exception 
	DEBUG	2015-11-06 19:54:59,265	org.learn.CustomLoggingFilter	[http-bio-9095-exec-6]	Method Name : throwException 
	DEBUG	2015-11-06 19:54:59,265	org.learn.CustomLoggingFilter	[http-bio-9095-exec-6]	Class : org.learn.ServiceResource 
	DEBUG	2015-11-06 19:54:59,265	org.learn.CustomLoggingFilter	[http-bio-9095-exec-6]	----Start Annotations of resource ----
	DEBUG	2015-11-06 19:54:59,265	org.learn.CustomLoggingFilter	[http-bio-9095-exec-6]	@javax.ws.rs.GET()
	DEBUG	2015-11-06 19:54:59,265	org.learn.CustomLoggingFilter	[http-bio-9095-exec-6]	@javax.ws.rs.Path(value=/exception)
	DEBUG	2015-11-06 19:54:59,265	org.learn.CustomLoggingFilter	[http-bio-9095-exec-6]	@javax.ws.rs.Produces(value=[text/plain])
	DEBUG	2015-11-06 19:54:59,265	org.learn.CustomLoggingFilter	[http-bio-9095-exec-6]	----End Annotations of resource----
	DEBUG	2015-11-06 19:54:59,265	org.learn.CustomLoggingFilter	[http-bio-9095-exec-6]	----Start Header Section of request ----
	DEBUG	2015-11-06 19:54:59,266	org.learn.CustomLoggingFilter	[http-bio-9095-exec-6]	Method Type : GET
	DEBUG	2015-11-06 19:54:59,266	org.learn.CustomLoggingFilter	[http-bio-9095-exec-6]	Header Name: host, Header Value :localhost:9095 
	DEBUG	2015-11-06 19:54:59,266	org.learn.CustomLoggingFilter	[http-bio-9095-exec-6]	Header Name: connection, Header Value :keep-alive 
	DEBUG	2015-11-06 19:54:59,266	org.learn.CustomLoggingFilter	[http-bio-9095-exec-6]	Header Name: cache-control, Header Value :max-age=0 
	DEBUG	2015-11-06 19:54:59,266	org.learn.CustomLoggingFilter	[http-bio-9095-exec-6]	Header Name: accept, Header Value :text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8 
	DEBUG	2015-11-06 19:54:59,266	org.learn.CustomLoggingFilter	[http-bio-9095-exec-6]	Header Name: upgrade-insecure-requests, Header Value :1 
	DEBUG	2015-11-06 19:54:59,266	org.learn.CustomLoggingFilter	[http-bio-9095-exec-6]	Header Name: user-agent, Header Value :Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.80 Safari/537.36 
	DEBUG	2015-11-06 19:54:59,266	org.learn.CustomLoggingFilter	[http-bio-9095-exec-6]	Header Name: accept-encoding, Header Value :gzip, deflate, sdch 
	DEBUG	2015-11-06 19:54:59,266	org.learn.CustomLoggingFilter	[http-bio-9095-exec-6]	Header Name: accept-language, Header Value :en-GB,en-US;q=0.8,en;q=0.6 
	DEBUG	2015-11-06 19:54:59,266	org.learn.CustomLoggingFilter	[http-bio-9095-exec-6]	----End Header Section of request ----
	ERROR	2015-11-06 19:54:59,267	org.learn.AppExceptionHandler	[http-bio-9095-exec-6]	Exception occurred in application : Exception thrown by getPathParamValue resource
	DEBUG	2015-11-06 19:54:59,267	org.learn.CustomLoggingFilter	[http-bio-9095-exec-6]	Total request execution time : 3 milliseconds

	