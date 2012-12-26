package com.aminpy.phonebook.dao.person;

import java.util.List;

import com.aminpy.phonebook.model.person.MarriageStatus;

public interface MarriageStatusDAOLocal {
	public MarriageStatus marriageStatusCreate(MarriageStatus marriageStatus);

	public List<MarriageStatus> marriageStatusRead();

	public List<MarriageStatus> marriageStatusRead(String marriageStatus);
	
	public MarriageStatus marriageStatusRead(long marriagesStatusID);

	public MarriageStatus marriageStatusUpdate(MarriageStatus marriageStatus);

	public MarriageStatus marriageStatusDelete(MarriageStatus marriageStatus);
}
