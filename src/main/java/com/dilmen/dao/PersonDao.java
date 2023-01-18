package com.dilmen.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.dilmen.entity.Person;
import com.dilmen.util.HibernateUtils;

public class PersonDao {

	public PersonDao() {
		super();
	}

	public Person findByEmail(String email) {
		String hql = "select person from Person as person where lower(person.email) = '"+email+"'";
		Session session = HibernateUtils.getSessionFactory().openSession();
		TypedQuery<Person> typedQuery = session.createQuery(hql,Person.class);
		Person users = typedQuery.getResultList().get(0);
//		Person users = typedQuery.getSingleResult();
		return users;
	}

	public List<Person> findByName(String name) {
		String hql = "select person from Person as person where lower(person.name) like '"+name+"'";
		Session session = HibernateUtils.getSessionFactory().openSession();
		TypedQuery<Person> typedQuery = session.createQuery(hql,Person.class);
		List<Person> users = typedQuery.getResultList();
		return users;
	}

	public List<Person> findByLastName(String lastName) {
		String hql = "select person from Person as person where lower(person.surname) like '"+lastName+"'";
		Session session = HibernateUtils.getSessionFactory().openSession();
		TypedQuery<Person> typedQuery = session.createQuery(hql,Person.class);
		List<Person> users = typedQuery.getResultList();
		return users;
	}

	public List<Person> getAll() {
		Session session = null;
		session = dataBaseConnectionHibernate();
		String query = "select person from Person as person";
		TypedQuery<Person> typedQuery = session.createQuery(query, Person.class);
		List<Person> bookList = typedQuery.getResultList();
		bookList.forEach(System.out::println);
		return bookList;
	}
	
	public void create(Person person) {
		Session session = null;
		try {
			session = dataBaseConnectionHibernate();
			session.getTransaction().begin();
			session.persist(person);
			session.getTransaction().commit();
			System.out.println("Book data is added to DB");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while adding Book to DB");
		} finally {
			session.close();
		}
	}

	public void update(Person person, long id) {
		Session session = null;
		try {
			Person person1 = findById(id);
			
			if (person != null) {
				person.setId(id);
				person1 = person;
				session = dataBaseConnectionHibernate();
				session.getTransaction().begin();
				//update merge
				session.merge(person);
				session.getTransaction().commit();
				System.out.println("Person data is added to DB");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while adding Person to DB");
		} finally {
			session.close();
		}
	}

	public void delete(long id) {
		Session session = null;
		try {
			Person person = findById(id);
			if (person != null) {
				session = dataBaseConnectionHibernate();
				session.getTransaction().begin();
				session.remove(person);
				session.getTransaction().commit();
				System.out.println("Book data is added to DB");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while deleting person to DB");
		} finally {
			session.close();
		}
	}
	
	private Session dataBaseConnectionHibernate() {
		return HibernateUtils.getSessionFactory().openSession();
	}

	public Person findById(long id) {
		Session session = dataBaseConnectionHibernate();
		Person person;
		try {
			person = session.find(Person.class, id);
			if (person != null) {
				System.out.println("Person Found--> " + person);
				return person;
			} else {
				System.out.println("Person not found");
				return null;
			}
		} catch (Exception e) {
			System.out.println("Some problem occured while adding Person to DB");
		} finally {
			session.close();
		}
		return null;
	}
}
