package com.aminpy.phonebook.service;

import java.util.List;

import com.aminpy.phonebook.exception.ExpNationalCodeExist;
import com.aminpy.phonebook.model.Person;

public interface PersonServiceLocal {

	public List<Person> findAllPersons();

	public Person removePerson(Person person);

	public Person createPerson(Person person) throws ExpNationalCodeExist;

	public Person personEdit(Person person);
}
