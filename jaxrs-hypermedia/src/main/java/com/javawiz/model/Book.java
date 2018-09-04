package com.javawiz.model;

import javax.ws.rs.core.Link;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Book {

    private String TITLE, AUTHOR, YEAR, ISBN;
    
    @XmlJavaTypeAdapter(Link.JaxbAdapter.class)
    private Link self;

    public String getTITLE() {
        return TITLE;
    }

    public void setTITLE(String TITLE) {
        this.TITLE = TITLE;
    }

    public String getAUTHOR() {
        return AUTHOR;
    }

    public void setAUTHOR(String AUTHOR) {
        this.AUTHOR = AUTHOR;
    }

    public String getYEAR() {
        return YEAR;
    }

    public void setYEAR(String YEAR) {
        this.YEAR = YEAR;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

	public Link getSelf() {
		return self;
	}

	public void setSelf(Link self) {
		this.self = self;
	}
}