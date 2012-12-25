package com.aminpy.phonebook.service.contactnumber;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.aminpy.phonebook.dao.contactnumber.ContactNumberDAOLocal;
import com.aminpy.phonebook.exception.contactnumber.NumberDuplicationException;
import com.aminpy.phonebook.model.ContactNumber;

@Stateless
public class ContactNumberService implements ContactNumberServiceLocal {

	@EJB
	private ContactNumberDAOLocal contactNumberDAO;

	@Override
	public boolean isNumberExist(String number)
			throws NumberDuplicationException {
		if (contactNumberDAO.contactNumberRead(number).isEmpty()) {
			return false;
		}
		throw new NumberDuplicationException("Number already exist!");
	}

	@Override
	public ContactNumber contactNumberAdd(ContactNumber contactNumber) {
		return contactNumberDAO.contactNumberCreate(contactNumber);
	}

	@Override
	public List<ContactNumber> contactNumberFindAll() {
		return contactNumberDAO.contactNumberRead();
	}

	@Override
	public ContactNumber contactNumberRemove(ContactNumber contactNumber) {
		return contactNumberDAO.contactNumberDelete(contactNumber);
	}

	@Override
	public ContactNumber contactNumberEdit(ContactNumber contactNumber) {
		return contactNumberDAO.contactNumberUpdate(contactNumber);
	}
}
