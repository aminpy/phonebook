package com.aminpy.phonebook;

import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import com.aminpy.phonebook.model.Person;
import com.aminpy.phonebook.service.PersonServiceLocal;

@Named
@SessionScoped
public class PersonMB implements Serializable {
	private static final long serialVersionUID = -6974288473265844933L;
	private List<Person> PersonList;
	private List<Person> filteredPersonList;
	@EJB
	private PersonServiceLocal personService;;
	private Person Person;
	private Person selectedPerson;
	@Inject
	private Conversation conversation;

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
		if (conversation.isTransient())
			conversation.begin();
		this.setPersonList(this.personService.findAllPersons());
		return "personList.xhtml";
	}
}
