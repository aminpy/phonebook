package com.aminpy.phonebook.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import com.aminpy.phonebook.model.person.MarriageStatus;
import com.aminpy.phonebook.service.person.MarriageStatusServiceLocal;

@FacesConverter(value = "marriageStatusConverter")
public class MarriageStatusConverter implements Converter {

	@Inject
	private MarriageStatusServiceLocal marriageStatusService;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		if (value.isEmpty())
			return null;
		else {
			MarriageStatus marriageStatus = marriageStatusService.findByID(Long
					.parseLong(value));
			return marriageStatus;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value.equals(""))
			return "";
		else
			return String.valueOf(((MarriageStatus) value)
					.getMarriageStatusID());
	}
}
