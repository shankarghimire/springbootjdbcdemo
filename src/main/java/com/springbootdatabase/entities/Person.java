package com.springbootdatabase.entities;

import java.util.Date;

public class Person {
	private long id;
	private String name;
	private String location;
	private Date birthDate;
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(long id, String name, String location, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.birthDate = birthDate;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	@Override
	public String toString() {
		//return "Person [id=" + id + ", name=" + name + ", location=" + location + ", birthDate=" + birthDate + "]";
		return String.format("\nPerson [id=%s, name=%s, location=%s, BirthDate=%s]", id, name, location, birthDate);
	}
	
	

}
