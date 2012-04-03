package com.supinfo.notetonsta.entity.xml;

import javax.xml.bind.annotation.XmlRootElement;

import com.supinfo.notetonsta.entity.Intervention;

@XmlRootElement
public class InterventionSimpleXml {
	private Long id;
	private String name;
	private String dateStart;
	private String dateEnd;
	private int status;
	
	public InterventionSimpleXml() {}
	public InterventionSimpleXml(Intervention i) {
		id = i.getId();
		name = i.getName();
		dateStart = i.getDateStart();
		dateEnd = i.getDateEnd();
		status = i.getRawStatus();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDateStart() {
		return dateStart;
	}
	public void setDateStart(String dateStart) {
		this.dateStart = dateStart;
	}
	public String getDateEnd() {
		return dateEnd;
	}
	public void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
