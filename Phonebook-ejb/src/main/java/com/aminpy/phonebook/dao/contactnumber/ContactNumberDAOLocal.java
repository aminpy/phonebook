package com.aminpy.phonebook.dao.contactnumber;

import java.util.List;
import com.aminpy.phonebook.model.contactnumber.ContactNumber;
import com.aminpy.phonebook.model.person.Person;

public interface ContactNumberDAOLocal {
	public ContactNumber contactNumberCreate(ContactNumber contactNumber);

	public List<ContactNumber> contactNumberRead();

	public List<ContactNumber> contactNumberRead(String number);

	public ContactNumber contactNumberUpdate(ContactNumber contactNumber);

	public ContactNumber contactNumberDelete(ContactNumber contactNumber);

	public List<ContactNumber> readByPerson(Person person);
}
