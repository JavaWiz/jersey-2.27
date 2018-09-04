package com.javawiz.service;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import com.javawiz.model.Book;
import com.javawiz.model.Customer;

@Path("/bookstore")
public class BookStoreResource {

	@Context
	UriInfo uriInfo;

	@GET
	@Path("/book")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response getBooks() {
		Book book = new Book();
		book.setAUTHOR("F. Scott Fitzgerald");
		book.setISBN("9781597226769");
		book.setTITLE("The Great Gatsby");
		book.setSelf(Link.fromUri(uriInfo.getAbsolutePath().resolve(book.getISBN())).rel("self").type("GET").build());
		GenericEntity<List<Book>> entity = new GenericEntity<List<Book>>(Arrays.asList(book)) {
		};
		return Response.accepted(entity).links(book.getSelf()).status(Status.FOUND).build();
	}

	@GET
	@Path("/book/{isbn}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response retrieveBook(@PathParam("isbn") String isbn) {

		if (isbn.equalsIgnoreCase("9781597226769")) {
			Book book = new Book();
			book.setAUTHOR("F. Scott Fitzgerald");
			book.setISBN("9781597226769");
			book.setTITLE("The Great Gatsby");
			book.setSelf(
					Link.fromUri(uriInfo.getAbsolutePath().resolve(book.getISBN())).rel("self").type("GET").build());
			return Response.accepted(book).links(book.getSelf()).build();

		} else if (isbn.equalsIgnoreCase("9780143105022")) {
			Book book = new Book();
			book.setAUTHOR("Ken Kesey");
			book.setISBN("9780143105022");
			book.setTITLE("One Flew Over the Cuckoo's Nest");
			book.setSelf(
					Link.fromUri(uriInfo.getAbsolutePath().resolve(book.getISBN())).rel("self").type("GET").build());
			return Response.accepted(book).links(book.getSelf()).build();
		} else {
			return Response.status(300).build();
		}
	}

    @GET

    @Path("/customer/{id}")
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Response queryCustomer(@PathParam("id") Integer id) {
        if ( id == 1 ) {
        	Customer customer = new Customer();
            customer.setID(1);
            customer.setFirstName("Sam");
            customer.setLastName("Sepassi");
            customer.setSelf(Link.fromUri(uriInfo.getAbsolutePath()).rel("self").type("GET").build());
            Book book1 = new Book();
            book1.setAUTHOR("F. Scott Fitzgerald");
            book1.setISBN("9781597226769");
            book1.setTITLE("The Great Gatsby");
            book1.setSelf(Link.fromUri(uriInfo.getBaseUriBuilder()
                            .path(getClass()).path(getClass(), "retrieveBook")
                            .build(book1.getISBN())).rel("book1").type("GET").build());
            Book book2 = new Book();
            book2.setAUTHOR("Ken Kesey");
            book2.setISBN("9780143105022");
            book2.setTITLE("One Flew Over the Cuckoo's Nest");
            book2.setSelf(Link.fromUri(uriInfo.getBaseUriBuilder()
                            .path(getClass()).path(getClass(), "retrieveBook")
                            .build(book2.getISBN())).rel("book2").type("GET").build());
            customer.addBook(book1);
            customer.addBook(book2);
            return Response.accepted(customer).
                    links(customer.getSelf()).
                    links(book1.getSelf()).
                    links(book2.getSelf()).
                    build();
        } else {
            return Response.status(300).build();
        }
    }
}