package com.aminpy.phonebook.service.Bean;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.aminpy.phonebook.model.Person;
import com.aminpy.phonebook.service.Interface.PersonEJBLocal;

@Stateless
public class PersonEJB implements PersonEJBLocal {

	@PersistenceContext(unitName = "manager1")
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> findAllPersons() {
		return (List<Person>) em.createNamedQuery("findAllPersons")
				.getResultList();
	}
}
