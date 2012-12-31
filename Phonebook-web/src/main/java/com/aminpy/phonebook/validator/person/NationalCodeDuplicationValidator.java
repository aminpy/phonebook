package com.aminpy.phonebook.validator.person;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import com.aminpy.phonebook.common.MessageProvider;
import com.aminpy.phonebook.exception.person.NationalCodeDuplicationException;
import com.aminpy.phonebook.service.person.PersonServiceLocal;

@FacesValidator("nationalCodeDuplicationValidator")
public class NationalCodeDuplicationValidator implements Validator {

	@EJB
	private PersonServiceLocal personService;

	@Override
	public void validate(FacesContext context, UIComponent component, Object obj)
			throws ValidatorException {
		try {
			UIInput otherInput = (UIInput) context.getViewRoot().findComponent(
					"editPerson:personID");

			this.personService.isNationalCodeExist(obj.toString(),
					otherInput == null ? null : (Long) otherInput.getValue());

		} catch (NationalCodeDuplicationException e) {
			FacesMessage msg = new FacesMessage(
					new MessageProvider().getValue(e.getMessage()));
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
	}
}
