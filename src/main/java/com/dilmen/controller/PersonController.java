package com.dilmen.controller;

import java.util.List;

import com.dilmen.entity.Person;
import com.dilmen.service.PersonService;

public class PersonController {
	private PersonService personService;

	public PersonController() {
		super();
		personService = new PersonService();
	}

	
	public Person finbByEmail(String email) {
		 return personService.finbByEmail(email);
	}
	public List<Person> finbByName(String name) {
		return personService.finbByName(name);
	}
	public List<Person> findByLastName(String lastName) {
		return personService.findByLastName(lastName);		
	}
	public List<Person> getAll() {
		return personService.getAll();
	}
	
	public void create(Person person) {
		personService.create(person);
	}
	public void update(Person person, long id) {
		personService.update(person,id);
	}
	public void delete(long id) {
		personService.delete(id);
	}

	public Person finbByID(long i) {
		return personService.findByID(i);
	}
}
