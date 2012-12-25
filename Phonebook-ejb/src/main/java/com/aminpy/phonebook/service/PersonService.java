package com.aminpy.phonebook.service;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.aminpy.phonebook.dao.PersonDAOLocal;
import com.aminpy.phonebook.model.Person;

@Stateless
public class PersonService implements PersonServiceLocal {

	@EJB
	private PersonDAOLocal personDAO;

	@Override
	public Person createPerson(Person person) {
		return personDAO.createPerson(person);
	}

	@Override
	public List<Person> findAllPersons() {
		return personDAO.readPerson();
	}

	@Override
	public Person removePerson(Person person) {
		return personDAO.deletePerson(person);
	}

	@Override
	public Person personEdit(Person person) {
		return personDAO.personUpdate(person);
	}
}
