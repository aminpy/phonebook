package com.aminpy.phonebook;

import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;
import com.aminpy.phonebook.service.Interface.PersonEJBLocal;
import java.io.Serializable;
import com.aminpy.phonebook.model.Person;

@Named
@ConversationScoped
public class PersonMB implements Serializable {
	private static final long serialVersionUID = -6974288473265844933L;
	private List<Person> PersonList;
	private List<Person> filteredPersonList;
	@EJB
	private PersonEJBLocal PersonEJB;
	private Person Person;
	private Person selectedPerson;

	public List<Person> getPersonList() {
		return PersonList;
	}

	public void setPersonList(List<Person> PersonList) {
		this.PersonList = PersonList;
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
		return Person;
	}

	public void setPerson(Person Person) {
		this.Person = Person;
	}

	public String personMng() {
		this.setPersonList(this.PersonEJB.findAllPersons());
		return "personList.xhtml";
	}
}
