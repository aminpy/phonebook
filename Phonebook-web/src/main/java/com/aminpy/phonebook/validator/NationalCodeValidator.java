package com.aminpy.phonebook.validator;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.aminpy.phonebook.common.MessageProvider;
import com.aminpy.phonebook.exception.ExpNationalCodeExist;
import com.aminpy.phonebook.service.PersonServiceLocal;

@FacesValidator("natinalCodeValidator")
public class NationalCodeValidator implements Validator {

	@EJB
	private PersonServiceLocal personService;

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ValidatorException {
		try {
			this.personService.isNationalCodeExist(arg2.toString());

		} catch (ExpNationalCodeExist e) {
			FacesMessage msg = new FacesMessage(
					new MessageProvider().getValue(e.getMessage()));
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
	}
}
