package com.aminpy.phonebook.model.person;

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
		@NamedQuery(name = "MarriageStatus.findAll", query = "SELECT ms From MarriageStatus ms"),
		@NamedQuery(name = "MarriageStatus.findByMarriageStatus", query = "SELECT ms FROM MarriageStatus ms WHERE ms.marriageStatus = :marriageStatus") })
public class MarriageStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long marriageStatusID;

	private String marriageStatus;

	@ManyToOne
	@JoinColumn(name = "personID")
	private Person person;

	public long getMarriageStatusID() {
		return marriageStatusID;
	}

	public void setMarriageStatusID(long marriageStatusID) {
		this.marriageStatusID = marriageStatusID;
	}

	public String getMarriageStatus() {
		return marriageStatus;
	}

	public void setMarriageStatus(String marriageStatus) {
		this.marriageStatus = marriageStatus;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return this.marriageStatus;
	}
}
