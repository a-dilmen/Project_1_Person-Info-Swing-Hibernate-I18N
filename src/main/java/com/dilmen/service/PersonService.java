package com.dilmen.service;

import java.util.List;

import com.dilmen.dao.PersonDao;
import com.dilmen.entity.Person;

public class PersonService {
	private PersonDao personDao;

	public PersonService() {
		super();
		personDao = new PersonDao();
	}

	public void create(Person person) {
		personDao.create(person);
	}
	
	public Person finbByEmail(String email) {
		return personDao.findByEmail(email);
	}
	
	public List<Person> finbByName(String name) {
		return personDao.findByName(name);
		
	}

	public List<Person> findByLastName(String lastName) {
		return personDao.findByLastName(lastName);
	}

	public void update(Person person, long id) {
		personDao.update(person,id);
		
	}

	public void delete(long id) {
		personDao.delete(id);
	}

	public List<Person> getAll() {
		return personDao.getAll();
	}

	public Person findByID(long i) {
		return personDao.findById(i);
	}

	
}
