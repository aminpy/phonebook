package com.aminpy.phonebook.service.person;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.aminpy.phonebook.dao.contactnumber.ContactNumberDAOLocal;
import com.aminpy.phonebook.dao.person.PersonDAOLocal;
import com.aminpy.phonebook.exception.person.NationalCodeDuplicationException;
import com.aminpy.phonebook.exception.person.RemovingRelationException;
import com.aminpy.phonebook.model.contactnumber.ContactNumber;
import com.aminpy.phonebook.model.person.Person;

@Stateless
public class PersonService implements PersonServiceLocal {

	@EJB
	private PersonDAOLocal personDAO;
	@EJB
	private ContactNumberDAOLocal contactNumberDAO;

	@Override
	public void isNationalCodeExist(String nationalCode, Long personID)
			throws NationalCodeDuplicationException {
		if (!personDAO.personRead(nationalCode).isEmpty()) {
			Person person = personDAO.personRead(nationalCode).get(0);

			if (personID == null || person.getPersonID() != personID) {
				throw new NationalCodeDuplicationException(
						"National Code already exist!");
			}
		}
	}

	@Override
	public void doesPersonHaveContactNumber(Person person)
			throws RemovingRelationException {
		if (!contactNumberDAO.readByPerson(person).isEmpty()) {
			throw new RemovingRelationException(
					"You must first remove contact number");
		}
	}

	@Override
	public Person personAdd(Person person) {
		return personDAO.personCreate(person);
	}

	@Override
	public List<Person> personFindAll() {
		return personDAO.personRead();
	}

	@Override
	public Person personRemove(Person person) {
		return personDAO.personDelete(person);
	}

	@Override
	public Person personEdit(Person person) {
		return personDAO.personUpdate(person);
	}

	@Override
	public Person addContactNumber(Person person, ContactNumber contactNumber) {
		contactNumber.setPerson(person);
		contactNumberDAO.contactNumberCreate(contactNumber);

		if (person.getContactNumberList() == null)
			person.setContactNumberList(new ArrayList<ContactNumber>());

		person.getContactNumberList().add(contactNumber);
		return personDAO.personUpdate(person);
	}

	@Override
	public Person deleteContactNumber(Person person, ContactNumber contactNumber) {
		contactNumberDAO.contactNumberDelete(contactNumber);
		person.getContactNumberList().remove(contactNumber);
		return personDAO.personUpdate(person);
	}
}
