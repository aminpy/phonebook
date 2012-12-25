package com.aminpy.phonebook.managedbean.contactnumber;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import com.aminpy.phonebook.model.contactnumber.ContactNumber;
import com.aminpy.phonebook.service.contactnumber.ContactNumberServiceLocal;

@Named
@SessionScoped
public class ContactNumberMB implements Serializable {
	private static final long serialVersionUID = -6974288473265844933L;
	private List<ContactNumber> contactNumberList;
	private List<ContactNumber> filteredContactNumberList;
	@EJB
	private ContactNumberServiceLocal contactNumberService;;
	private ContactNumber contactNumber;
	private ContactNumber selectedContactNumber;

	public List<ContactNumber> getContactNumberList() {
		return contactNumberList;
	}

	public void setContactNumberList(List<ContactNumber> contactNumberList) {
		this.contactNumberList = contactNumberList;
	}

	public ContactNumber getSelectedContactNumber() {
		return selectedContactNumber;
	}

	public void setSelectedContactNumber(ContactNumber selectedContactNumber) {
		this.selectedContactNumber = selectedContactNumber;
	}

	public List<ContactNumber> getFilteredContactNumberList() {
		return filteredContactNumberList;
	}

	public void setFilteredContactNumberList(
			List<ContactNumber> filteredContactNumberList) {
		this.filteredContactNumberList = filteredContactNumberList;
	}

	public ContactNumber getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(ContactNumber contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String contactNumberMng() {
		this.setContactNumberList(this.contactNumberService
				.contactNumberFindAll());
		return "/pages/contactNumber/contactNumberList.xhtml";
	}

	public void contactNumberDelete() {
		this.contactNumberService
				.contactNumberRemove(this.selectedContactNumber);
		this.contactNumberList.remove(this.contactNumberList
				.indexOf(this.selectedContactNumber));
	}

	public String contactNumberCreateLink() {
		this.contactNumber = new ContactNumber();
		return "/pages/contactNumber/contactNumberCreate.xhtml";
	}

	public String contactNumberCreate() {
		this.contactNumberService.contactNumberAdd(this.contactNumber);
		this.contactNumberList.add(this.contactNumber);

		return "/pages/contactNumber/contactNumberList.xhtml";
	}

	public String contactNumberUpdateLink() {
		this.setContactNumber(this.selectedContactNumber);
		return "/pages/contactNumber/contactNumberUpdate.xhtml";
	}

	public String contactNumberUpdate() {
		this.contactNumberService.contactNumberEdit(this.selectedContactNumber);
		return "/pages/contactNumber/contactNumberList.xhtml";
	}
}
