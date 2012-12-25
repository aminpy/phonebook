package com.aminpy.phonebook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = "ContactNumber.findAll", query = "SELECT cn From ContactNumber cn"),
	@NamedQuery(name = "ContactNumber.findByNumber", query = "SELECT cn FROM ContactNumber cn WHERE cn.number = :number")
})
public class ContactNumber {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String number;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return this.number;
	}
}
