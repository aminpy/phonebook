package com.aminpy.phonebook.dao.person;

import java.util.List;
import com.aminpy.phonebook.model.person.Person;

public interface PersonDAOLocal {
	public Person personCreate(Person person);

	public List<Person> personRead();

	public List<Person> personRead(String nationalCode);

	public Person personUpdate(Person person);

	public Person personDelete(Person person);
}
