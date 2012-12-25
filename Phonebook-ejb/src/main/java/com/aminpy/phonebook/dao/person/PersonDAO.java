package com.aminpy.phonebook.dao.person;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.aminpy.phonebook.model.person.Person;

@Stateless
public class PersonDAO implements PersonDAOLocal {

	@PersistenceContext(unitName = "manager1")
	private EntityManager em;

	@Override
	public Person personCreate(Person person) {
		em.persist(person);
		return person;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> personRead() {
		return (List<Person>) em.createNamedQuery("Person.findAll")
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> personRead(String nationalCode) {
		return (List<Person>) em.createNamedQuery("Person.findByNationalCode")
				.setParameter("nationalCode", nationalCode).getResultList();
	}

	@Override
	public Person personUpdate(Person person) {
		return em.merge(person);
	}

	@Override
	public Person personDelete(Person person) {
		em.remove(em.find(Person.class, person.getPersonID()));
		return person;
	}
}
