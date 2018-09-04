package com.javawiz.model;

import java.util.ArrayList;

import javax.ws.rs.core.Link;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Customer {
	
	private Integer ID;
    private String FirstName, LastName;
    
    @XmlTransient
    private final ArrayList<Book> books = new ArrayList<>();
    @XmlJavaTypeAdapter(Link.JaxbAdapter.class)
    private Link self;

	@XmlElementWrapper(name = "self")
	@XmlElement(name = "book")
	public ArrayList<Book> getBooks() {
		return books;
	}

	public void addBook(Book book) {
		books.add(book);
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String LastName) {
		this.LastName = LastName;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer ID) {
		this.ID = ID;
	}

	public Link getSelf() {
		return self;
	}

	public void setSelf(Link self) {
		this.self = self;
	}
}