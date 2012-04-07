package com.supinfo.notetonsta.entity.xml;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="evaluation")
public class EvaluationXml {
	private Long idIntervention;
	private int idBooster;
	private int speakerKnowledge;
	private int speakerAbility;
	private int speakerAnswers;
	private int slideContent;
	private int slideFormat;
	private int slideExamples;
	private String comment;
	
	public Long getIdIntervention() {
		return idIntervention;
	}
	public void setIdIntervention(Long idIntervention) {
		this.idIntervention = idIntervention;
	}
	public int getIdBooster() {
		return idBooster;
	}
	public void setIdBooster(int idBooster) {
		this.idBooster = idBooster;
	}
	public int getSpeakerKnowledge() {
		return speakerKnowledge;
	}
	public void setSpeakerKnowledge(int speakerKnowledge) {
		this.speakerKnowledge = speakerKnowledge;
	}
	public int getSpeakerAbility() {
		return speakerAbility;
	}
	public void setSpeakerAbility(int speakerAbility) {
		this.speakerAbility = speakerAbility;
	}
	public int getSpeakerAnswers() {
		return speakerAnswers;
	}
	public void setSpeakerAnswers(int speakerAnswers) {
		this.speakerAnswers = speakerAnswers;
	}
	public int getSlideContent() {
		return slideContent;
	}
	public void setSlideContent(int slideContent) {
		this.slideContent = slideContent;
	}
	public int getSlideFormat() {
		return slideFormat;
	}
	public void setSlideFormat(int slideFormat) {
		this.slideFormat = slideFormat;
	}
	public int getSlideExamples() {
		return slideExamples;
	}
	public void setSlideExamples(int slideExamples) {
		this.slideExamples = slideExamples;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
