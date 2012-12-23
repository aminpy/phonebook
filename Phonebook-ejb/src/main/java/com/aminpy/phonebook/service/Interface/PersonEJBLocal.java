package com.aminpy.phonebook.service.Interface;

import java.util.List;

import com.aminpy.phonebook.model.Person;

public interface PersonEJBLocal {

	public List<Person> findAllPersons();

}
