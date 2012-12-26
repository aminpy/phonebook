package com.aminpy.phonebook.dao.person;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.aminpy.phonebook.model.person.MarriageStatus;

@Stateless
public class MarriageStatusDAO implements MarriageStatusDAOLocal {

	@PersistenceContext(unitName = "manager1")
	private EntityManager em;

	@Override
	public MarriageStatus marriageStatusCreate(MarriageStatus marriageStatus) {
		em.persist(marriageStatus);
		return marriageStatus;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MarriageStatus> marriageStatusRead() {
		return (List<MarriageStatus>) em.createNamedQuery(
				"MarriageStatus.findAll").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MarriageStatus> marriageStatusRead(String marriageStatus) {
		return (List<MarriageStatus>) em
				.createNamedQuery("MarriageStatus.findByMarriageStatus")
				.setParameter("marriageStatus", marriageStatus).getResultList();
	}

	@Override
	public MarriageStatus marriageStatusRead(long marriageStatusID) {
		return em.find(MarriageStatus.class, marriageStatusID);
	}

	@Override
	public MarriageStatus marriageStatusUpdate(MarriageStatus marriageStatus) {
		return em.merge(marriageStatus);
	}

	@Override
	public MarriageStatus marriageStatusDelete(MarriageStatus marriageStatus) {
		em.remove(em.find(MarriageStatus.class,
				marriageStatus.getMarriageStatusID()));
		return marriageStatus;
	}
}
