package com.supinfo.notetonsta.entity;

import javax.persistence.*;

@Entity
public class Evaluation {
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
	@JoinColumn(name="intervention_fk")
	private Intervention intervention;
	private int idBooster;
	private int speakerKnowledge;
	private int speakerAbility;
	private int speakerAnswers;
	private int slideContent;
	private int slideFormat;
	private int slideExamples;
	@Lob
	private String comment;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Intervention getIntervention() {
		return intervention;
	}
	public void setIntervention(Intervention intervention) {
		this.intervention = intervention;
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
