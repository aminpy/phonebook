package com.aminpy.phonebook.service;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.aminpy.phonebook.dao.ContactNumberDAOLocal;
import com.aminpy.phonebook.exception.NumberDuplicateException;
import com.aminpy.phonebook.model.ContactNumber;

@Stateless
public class ContactNumberService implements ContactNumberServiceLocal {

	@EJB
	private ContactNumberDAOLocal contactNumberDAO;

	@Override
	public boolean isNumberExist(String number) throws NumberDuplicateException {
		if (contactNumberDAO.contactNumberRead(number).isEmpty()) {
			return false;
		}
		throw new NumberDuplicateException("Number already exist!");
	}

	@Override
	public ContactNumber createContactNumber(ContactNumber contactNumber) {
		return contactNumberDAO.contactNumberCreate(contactNumber);
	}

	@Override
	public List<ContactNumber> findAllContactNumbers() {
		return contactNumberDAO.contactNumberRead();
	}

	@Override
	public ContactNumber removeContactNumber(ContactNumber contactNumber) {
		return contactNumberDAO.contactNumberDelete(contactNumber);
	}

	@Override
	public ContactNumber contactNumberEdit(ContactNumber contactNumber) {
		return contactNumberDAO.contactNumberUpdate(contactNumber);
	}
}
