package com.aminpy.phonebook.service.person;

import java.util.List;
import com.aminpy.phonebook.exception.person.NationalCodeDuplicationException;
import com.aminpy.phonebook.model.contactnumber.ContactNumber;
import com.aminpy.phonebook.model.person.Person;

public interface PersonServiceLocal {

	public List<Person> personFindAll();

	public Person personRemove(Person person);

	public Person personAdd(Person person);

	public Person personEdit(Person person);

	public void isNationalCodeExist(String nationalCode, Long personID)
			throws NationalCodeDuplicationException;

	public Person addContactNumber(Person person, ContactNumber contactNumber);

	public Person deleteContactNumber(Person person, ContactNumber contactNumber);
}
