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

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> personRead(Person person) {
		return (List<Person>) em.createNamedQuery("findByNationalCode")
				.setParameter("nationalCode", person.getNationalCode())
				.getResultList();
	}

	@Override
	public Person personUpdate(Person person) {
		return em.merge(person);
	}

	@Override
	public Person deletePerson(Person person) {
		em.remove(em.find(Person.class, person.getId()));
		return person;
	}
}
