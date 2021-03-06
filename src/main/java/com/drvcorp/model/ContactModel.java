package com.drvcorp.model;

public class ContactModel {

	private String firstName;
	private String lastName;
	private String telephone;
	private String city;
	private int id;
	public ContactModel() {
		// TODO Auto-generated constructor stub
	}

	public ContactModel(String firstName, String lastName, String telephone, String city) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.telephone = telephone;
		this.city = city;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	@Override
	public String toString() {
		return "Id "+getId()+"? firstName "+getFirstName()+"? lastName "+getLastName()+"? telephone "+getTelephone()+"? city "+getCity()+"?";
	}

}
