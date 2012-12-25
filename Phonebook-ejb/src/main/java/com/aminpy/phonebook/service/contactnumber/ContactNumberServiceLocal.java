package com.aminpy.phonebook.service.contactnumber;

import java.util.List;
import com.aminpy.phonebook.exception.contactnumber.NumberDuplicationException;
import com.aminpy.phonebook.model.ContactNumber;

public interface ContactNumberServiceLocal {

	public List<ContactNumber> contactNumberFindAll();

	public ContactNumber contactNumberRemove(ContactNumber contactNumber);

	public ContactNumber contactNumberAdd(ContactNumber contactNumber);

	public ContactNumber contactNumberEdit(ContactNumber contactNumber);

	public boolean isNumberExist(String number)
			throws NumberDuplicationException;
}
