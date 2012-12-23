package com.aminpy.phonebook.service;

import java.util.List;

import com.aminpy.phonebook.model.Person;

public interface PersonServiceLocal {

	public List<Person> findAllPersons();

	public Person removePerson(Person person);
}
