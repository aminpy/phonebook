package com.aminpy.phonebook.service.person;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.aminpy.phonebook.dao.person.MarriageStatusDAOLocal;
import com.aminpy.phonebook.exception.contactnumber.NumberDuplicationException;
import com.aminpy.phonebook.model.person.MarriageStatus;

@Stateless
public class MarriageStatusService implements MarriageStatusServiceLocal {

	@EJB
	private MarriageStatusDAOLocal marriageStatusDAO;

	@Override
	public boolean isNumberExist(String marriageStatus)
			throws NumberDuplicationException {
		if (marriageStatusDAO.marriageStatusRead(marriageStatus).isEmpty()) {
			return false;
		}
		throw new NumberDuplicationException("Marriage Status already exist!");
	}

	@Override
	public MarriageStatus marriageStatusAdd(MarriageStatus marriageStatus) {
		return marriageStatusDAO.marriageStatusCreate(marriageStatus);
	}

	@Override
	public List<MarriageStatus> marriageStatusFindAll() {
		return marriageStatusDAO.marriageStatusRead();
	}

	@Override
	public MarriageStatus marriageStatusRemove(MarriageStatus marriageStatus) {
		return marriageStatusDAO.marriageStatusDelete(marriageStatus);
	}

	@Override
	public MarriageStatus marriageStatusEdit(MarriageStatus marriageStatus) {
		return marriageStatusDAO.marriageStatusUpdate(marriageStatus);
	}

	@Override
	public MarriageStatus findByID(long marriageStatusID) {
		return marriageStatusDAO.marriageStatusRead(marriageStatusID);
	}
}
