package com.aminpy.phonebook.service;

import java.util.List;
import com.aminpy.phonebook.exception.NumberDuplicateException;
import com.aminpy.phonebook.model.ContactNumber;

public interface ContactNumberServiceLocal {

	public List<ContactNumber> findAllContactNumbers();

	public ContactNumber removeContactNumber(ContactNumber contactNumber);

	public ContactNumber createContactNumber(ContactNumber contactNumber);

	public ContactNumber contactNumberEdit(ContactNumber contactNumber);

	public boolean isNumberExist(String number) throws NumberDuplicateException;
}
