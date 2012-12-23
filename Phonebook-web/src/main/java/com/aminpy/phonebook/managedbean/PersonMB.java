package com.aminpy.phonebook.managedbean;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import com.aminpy.phonebook.model.Person;
import com.aminpy.phonebook.service.PersonServiceLocal;

@Named
@SessionScoped
public class PersonMB implements Serializable {
	private static final long serialVersionUID = -6974288473265844933L;
	private List<Person> personList;
	private List<Person> filteredPersonList;
	@EJB
	private PersonServiceLocal personService;;
	private Person person;
	private Person selectedPerson;

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

	public String personMng() {
		this.setPersonList(this.personService.findAllPersons());
		return "personList.xhtml";
	}

	public void personDelete() {
		this.personService.removePerson(this.selectedPerson);
		this.personList.remove(this.personList.indexOf(this.selectedPerson));
	}

	public String personCreateLink() {
		this.person = new Person();
		return "personCreate.xhtml";
	}

	public String personCreate() {
		this.personService.createPerson(this.person);
		this.personList.add(this.person);
		return "personList.xhtml";
	}
}
