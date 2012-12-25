package com.aminpy.phonebook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
		@NamedQuery(name = "ContactNumber.findAll", query = "SELECT cn From ContactNumber cn"),
		@NamedQuery(name = "ContactNumber.findByNumber", query = "SELECT cn FROM ContactNumber cn WHERE cn.number = :number") })
public class ContactNumber {
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
