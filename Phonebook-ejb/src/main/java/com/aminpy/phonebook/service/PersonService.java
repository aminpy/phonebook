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
	public List<Person> findAllPersons() {
		return personDAO.readPerson();
	}
}
