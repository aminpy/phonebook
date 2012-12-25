package com.aminpy.phonebook.managedbean.person;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

import com.aminpy.phonebook.model.person.MarriageStatus;
import com.aminpy.phonebook.service.person.MarriageStatusServiceLocal;

@Named
@SessionScoped
public class MarriageStatusMB implements Serializable {
	private static final long serialVersionUID = -6974288473265844933L;
	private List<MarriageStatus> marriageStatusList;
	private List<MarriageStatus> filteredMarriageStatusList;
	@EJB
	private MarriageStatusServiceLocal marriageStatusService;;
	private MarriageStatus marriageStatus;
	private MarriageStatus selectedMarriageStatus;

	public List<MarriageStatus> getMarriageStatusList() {
		return marriageStatusList;
	}

	public void setMarriageStatusList(List<MarriageStatus> marriageStatusList) {
		this.marriageStatusList = marriageStatusList;
	}

	public MarriageStatus getSelectedMarriageStatus() {
		return selectedMarriageStatus;
	}

	public void setSelectedMarriageStatus(MarriageStatus selectedMarriageStatus) {
		this.selectedMarriageStatus = selectedMarriageStatus;
	}

	public List<MarriageStatus> getFilteredMarriageStatusList() {
		return filteredMarriageStatusList;
	}

	public void setFilteredMarriageStatusList(
			List<MarriageStatus> filteredMarriageStatusList) {
		this.filteredMarriageStatusList = filteredMarriageStatusList;
	}

	public MarriageStatus getMarriageStatus() {
		return marriageStatus;
	}

	public void setMarriageStatus(MarriageStatus marriageStatus) {
		this.marriageStatus = marriageStatus;
	}

	public String marriageStatusMng() {
		this.setMarriageStatusList(this.marriageStatusService
				.marriageStatusFindAll());
		return "/pages/person/marriageStatusList.xhtml";
	}

	public void marriageStatusDelete() {
		this.marriageStatusService
				.marriageStatusRemove(this.selectedMarriageStatus);
		this.marriageStatusList.remove(this.marriageStatusList
				.indexOf(this.selectedMarriageStatus));
	}

	public String marriageStatusCreateLink() {
		this.marriageStatus = new MarriageStatus();
		return "/pages/person/marriageStatusCreate.xhtml";
	}

	public String marriageStatusCreate() {
		this.marriageStatusService.marriageStatusAdd(this.marriageStatus);
		this.marriageStatusList.add(this.marriageStatus);

		return "/pages/person/marriageStatusList.xhtml";
	}

	public String marriageStatusUpdateLink() {
		this.setMarriageStatus(this.selectedMarriageStatus);
		return "/pages/person/marriageStatusUpdate.xhtml";
	}

	public String marriageStatusUpdate() {
		this.marriageStatusService
				.marriageStatusEdit(this.selectedMarriageStatus);
		return "/pages/person/marriageStatusList.xhtml";
	}
}
