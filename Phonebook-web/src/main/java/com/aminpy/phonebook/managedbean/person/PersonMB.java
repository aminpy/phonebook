package com.aminpy.phonebook.managedbean.person;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import java.io.Serializable;

import com.aminpy.phonebook.common.MessageProvider;
import com.aminpy.phonebook.exception.person.RemovingRelationException;
import com.aminpy.phonebook.model.contactnumber.ContactNumber;
import com.aminpy.phonebook.model.person.MarriageStatus;
import com.aminpy.phonebook.model.person.Person;
import com.aminpy.phonebook.service.person.MarriageStatusServiceLocal;
import com.aminpy.phonebook.service.person.PersonServiceLocal;

@Named
@SessionScoped
public class PersonMB implements Serializable {
	private static final long serialVersionUID = -6974288473265844933L;
	private List<Person> personList;
	private List<Person> filteredPersonList;
	@EJB
	private PersonServiceLocal personService;
	@EJB
	private MarriageStatusServiceLocal marriageStatusService;
	private Person person;
	private Person selectedPerson;
	private List<MarriageStatus> marriageStatusList;
	private ContactNumber contactNumber;
	private ContactNumber selectedContactNumber;
	private Map<String, String> breadCrumb;

	public List<Person> getPersonList() {
		return personList;
	}

	public void setPersonList(List<Person> personList) {
		this.personList = personList;
	}

	public Person getSelectedPerson() {
		return selectedPerson;
	}

	public void setSelectedPerson(Person selectedPerson) {
		this.selectedPerson = selectedPerson;
	}

	public List<Person> getFilteredPersonList() {
		return filteredPersonList;
	}

	public void setFilteredPersonList(List<Person> filteredPersonList) {
		this.filteredPersonList = filteredPersonList;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public List<MarriageStatus> getMarriageStatusList() {
		return marriageStatusList;
	}

	public void setMarriageStatusList(List<MarriageStatus> marriageStatusList) {
		this.marriageStatusList = marriageStatusList;
	}

	public ContactNumber getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(ContactNumber contactNumber) {
		this.contactNumber = contactNumber;
	}

	public ContactNumber getSelectedContactNumber() {
		return selectedContactNumber;
	}

	public void setSelectedContactNumber(ContactNumber selectedContactNumber) {
		this.selectedContactNumber = selectedContactNumber;
	}

	public Map<String, String> getBreadCrumb() {
		return breadCrumb;
	}

	public void setBreadCrumb(Map<String, String> breadCrumb) {
		this.breadCrumb = breadCrumb;
	}

	public String personMng() {
		this.setPersonList(this.personService.personFindAll());

		// breadcrumb
		this.breadCrumb = new LinkedHashMap<String, String>();
		this.breadCrumb.put("صفحه اصلی", "/index.xhtml");

		return "/pages/person/personList.xhtml";
	}

	public void personDelete() {
		try {
			this.personService.doesPersonHaveContactNumber(this.selectedPerson);
			this.personService.personRemove(this.selectedPerson);
			this.personList
					.remove(this.personList.indexOf(this.selectedPerson));
		} catch (RemovingRelationException e) {
			FacesContext context = FacesContext.getCurrentInstance();
			String msg = new MessageProvider().getValue(e.getMessage());
			context.addMessage(null, new FacesMessage(msg));
		}
	}

	public String personCreateLink() {
		this.marriageStatusList = marriageStatusService.marriageStatusFindAll();
		this.person = new Person();

		// breadcrumb
		this.breadCrumb = new LinkedHashMap<String, String>();
		this.breadCrumb.put("صفحه اصلی", "/index.xhtml");
		this.breadCrumb.put("لیست افراد", "/pages/person/personList.xhtml");

		return "/pages/person/personCreate.xhtml";
	}

	public String personCreate() {
		this.personService.personAdd(this.person);
		this.personList.add(this.person);

		return "/pages/person/personList.xhtml";
	}

	public String personUpdateLink() {
		this.setPerson(this.selectedPerson);
		this.contactNumber = new ContactNumber();

		// breadcrumb
		this.breadCrumb = new LinkedHashMap<String, String>();
		this.breadCrumb.put("صفحه اصلی", "/index.xhtml");
		this.breadCrumb.put("لیست افراد", "/pages/person/personList.xhtml");

		return "/pages/person/personUpdate.xhtml";
	}

	public String personUpdate() {
		this.personService.personEdit(this.selectedPerson);
		this.personList = this.personService.personFindAll();
		return "/pages/person/personList.xhtml";
	}

	public void addContactNumber(ActionEvent actionEvent) {
		this.selectedPerson = this.personService.addContactNumber(
				this.selectedPerson, this.contactNumber);
		this.contactNumber = new ContactNumber();
	}

	public void deleteContactNumber() {
		this.selectedPerson = this.personService.deleteContactNumber(
				this.selectedPerson, this.selectedContactNumber);
	}
}
