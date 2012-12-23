package com.aminpy.phonebook.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.aminpy.phonebook.model.Person;

@Stateless
public class PersonDAO implements PersonDAOLocal {

	@PersistenceContext(unitName = "manager1")
	private EntityManager em;

	@Override
	public Person createPerson(Person person) {
		em.persist(person);
		return person;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> readPerson() {
		return (List<Person>) em.createNamedQuery("findAllPersons")
				.getResultList();
	}

	@Override
	public Person deletePerson(Person person) {
		em.remove(em.find(Person.class, person.getId()));
		return person;
	}
}
