
package com.javawiz.service;

import java.util.ArrayList;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.javawiz.model.Employee;
import com.javawiz.model.Employees;


@Path("/service")
public class ServiceResource {

	private static final String text = "Message from Server :%s ";

	@GET
	@Consumes(MediaType.TEXT_PLAIN)
	public Response getText() {
		String response = String.format(text, new Date());
		return Response.status(Response.Status.OK).entity(response).type(MediaType.TEXT_PLAIN).build();
	}

	@GET
	@Path("{name}")
	@Consumes(MediaType.TEXT_PLAIN)
	public Response getMsg(@PathParam("name") String name) {
		String response = String.format(text, name);
		return Response.status(Response.Status.OK).entity(response).type(MediaType.TEXT_PLAIN).build();
	}

	@GET
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Employees getJson() {
		Employees list = new Employees();
		list.setEmployees(new ArrayList<Employee>());
		
		list.getEmployees().add(new Employee(1, "Ranjan Sai"));
		list.getEmployees().add(new Employee(2, "Rejina Patel"));
		list.getEmployees().add(new Employee(3, "Rehanshi Sai"));
		return list;
	}

	@GET
	@Path("/xml")
	@Produces(MediaType.APPLICATION_XML)
	public Employees getXml() {
		Employees list = new Employees();
		list.setEmployees(new ArrayList<Employee>());
		
		list.getEmployees().add(new Employee(1, "Ranjan Sai"));
		list.getEmployees().add(new Employee(2, "Rejina Patel"));
		list.getEmployees().add(new Employee(3, "Rehanshi Sai"));
		return list;
	}

	@POST
	@Path("/json/object")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_XML)
	public Employee postEmployee(Employee employee) {
		//We receive the object from client
		//Client might have send the json string as {"name":"hello","age":"24"}
		//do some processing ..save in database
		//return the output in xml format....
		return employee;
	}

	@POST
	@Path("/json/{name}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response postPathParamValue(@PathParam("name") String name) {
		//Return what ever received from client
		String output = "Jersey Says :" + name;
		return Response.status(200).entity(output).build();
	}

	@GET
	@Path("/exception")
	@Produces(MediaType.TEXT_PLAIN)
	public Response throwException() {
		throw new RuntimeException("Exception thrown by getPathParamValue resource");
	}
}
