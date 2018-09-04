package com.javawiz.service;

import java.io.IOException;

import javax.annotation.security.DenyAll;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.javawiz.dao.UserDao;
import com.javawiz.model.ResponseStatus;
import com.javawiz.model.User;

@Path("/UserService")
public class UserService {

	UserDao userDao = new UserDao();
	
	@GET
	@Path("/users")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response getUsers() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return Response.status(200).entity(userDao.getAllUsers()).build();
	}

	@GET
	@Path("/users/{userid}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response getUser(@PathParam("userid") int userid) {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		User user = userDao.getUser(userid);
		if(user == null) {
	        return Response.status(Response.Status.NOT_FOUND).entity("Entity not found for ID: " + userid).build();
	    }
		return Response.status(200).entity(user).build();
	}

	@PUT
	@Path("/users")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response createUser(@FormParam("id") int id, @FormParam("name") String name,
			@FormParam("profession") String profession, @Context HttpServletResponse servletResponse)
			throws IOException {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		User user = new User(id, name, profession);
		int result = userDao.updateUser(user);
		if (result == 1) {
			return Response.status(200).entity(new ResponseStatus("Success", "200")).build();
		}
		return Response.status(Response.Status.NOT_FOUND).entity(new ResponseStatus("Entity not found for UUID: " + id, "404")).build();
	}

	@POST
	@Path("/users")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response updateUser(User user)
			throws IOException {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(user.getId()+", "+user.getName()+", "+user.getProfession());
		//User user = new User(id, name, profession);
		int result = userDao.addUser(user);
		if (result == 1) {
			return Response.status(201).entity(new ResponseStatus("Success", "201")).build();
		}
		return Response.status(Status.CONFLICT).entity(new ResponseStatus("Resource already exists with id: " + user.getId(), "409")).build();
	}
	
	@DELETE
	@Path("/users/{userid}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response deleteUser(@PathParam("userid") int userid) {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int result = userDao.deleteUser(userid);
		if (result == 1) {
			return Response.status(200).entity(new ResponseStatus("Success", "200")).build();
		}
		return Response.status(Response.Status.NOT_FOUND).entity(new ResponseStatus("Entity not found for ID: " + userid, "404")).build();
	}
	
	@OPTIONS
	@Path("/users")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public String getSupportedOperations() {
		return "<operations>GET, PUT, POST, DELETE</operations>";
	}
}