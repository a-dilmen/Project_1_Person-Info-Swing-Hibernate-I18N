package com.dilmen.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(unique =  true)
	private String email;
	private String name;
	private String surname;
	@Enumerated (EnumType.STRING)
	private EGender gender;
	private String phone1;
	private String phone2;
	private String address1;
	private String address2;
	private String url;
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(String email, String name, String surname, EGender gender, String phone1, String phone2,
			String address1, String address2, String url) {
		super();
		this.email = email;
		this.name = name;
		this.surname = surname;
		this.gender = gender;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.address1 = address1;
		this.address2 = address2;
		this.url = url;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public EGender getGender() {
		return gender;
	}
	public void setGender(EGender gender) {
		this.gender = gender;
	}
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
}
