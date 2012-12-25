package com.aminpy.phonebook.service.person;

import java.util.List;
import com.aminpy.phonebook.exception.contactnumber.NumberDuplicationException;
import com.aminpy.phonebook.model.person.MarriageStatus;

public interface MarriageStatusServiceLocal {

	public List<MarriageStatus> marriageStatusFindAll();

	public MarriageStatus marriageStatusRemove(MarriageStatus marriageStatus);

	public MarriageStatus marriageStatusAdd(MarriageStatus marriageStatus);

	public MarriageStatus marriageStatusEdit(MarriageStatus marriageStatus);

	public boolean isNumberExist(String marriageStatus)
			throws NumberDuplicationException;
}
