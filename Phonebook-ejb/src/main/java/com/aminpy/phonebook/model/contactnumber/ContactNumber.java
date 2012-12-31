package com.aminpy.phonebook.model.contactnumber;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import com.aminpy.phonebook.model.person.Person;

@Entity
@NamedQueries({
		@NamedQuery(name = "ContactNumber.findAll", query = "SELECT cn From ContactNumber cn"),
		@NamedQuery(name = "ContactNumber.findByNumber", query = "SELECT cn FROM ContactNumber cn WHERE cn.number = :number"),
		@NamedQuery(name = "ContactNumber.findByPerson", query = "SELECT cn FROM ContactNumber cn WHERE cn.person = :person") })
public class ContactNumber implements Serializable {
	private static final long serialVersionUID = 2090092013350476183L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long contactNumberID;

	private String number;

	@ManyToOne
	@JoinColumn(name = "personID")
	private Person person;

	public long getContactNumberID() {
		return contactNumberID;
	}

	public void setContactNumberID(long contactNumberID) {
		this.contactNumberID = contactNumberID;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return this.number;
	}
}
