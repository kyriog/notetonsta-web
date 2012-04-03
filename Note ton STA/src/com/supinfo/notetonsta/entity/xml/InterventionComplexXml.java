package com.supinfo.notetonsta.entity.xml;

import javax.xml.bind.annotation.XmlRootElement;

import com.supinfo.notetonsta.entity.Intervention;

@XmlRootElement(name="intervention")
public class InterventionComplexXml {
	private Long id;
	private String name;
	private String description;
	private String dateStart;
	private String dateEnd;
	private int status;
	private int evaluationNumber;
	private float speakerNote;
	private float slideNote;
	private float globalNote;
	
	public InterventionComplexXml() {}
	public InterventionComplexXml(Intervention i) {
		id = i.getId();
		name = i.getName();
		dateStart = i.getDateStart();
		dateEnd = i.getDateEnd();
		status = i.getRawStatus();
		description = i.getDescription();
		evaluationNumber = i.listEvaluations().size();
		speakerNote = i.getSpeakerNote();
		slideNote = i.getSlideNote();
		globalNote = i.getGlobalNote();
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public int getEvaluationNumber() {
		return evaluationNumber;
	}
	public void setEvaluationNumber(int evaluationNumber) {
		this.evaluationNumber = evaluationNumber;
	}
	public float getSpeakerNote() {
		return speakerNote;
	}
	public void setSpeakerNote(float speakerNote) {
		this.speakerNote = speakerNote;
	}
	public float getSlideNote() {
		return slideNote;
	}
	public void setSlideNote(float slideNote) {
		this.slideNote = slideNote;
	}
	public float getGlobalNote() {
		return globalNote;
	}
	public void setGlobalNote(float globalNote) {
		this.globalNote = globalNote;
	}
}
