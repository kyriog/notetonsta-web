package com.supinfo.notetonsta.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Intervention {
	@Id
	@GeneratedValue
	private Long Id;
	private String name;
	@ManyToOne
	@JoinColumn(name="speaker_fk")
	private Speaker speaker;
	private String description;
	@ManyToOne
	@JoinColumn(name="campus_fk")
	private Campus campus;
	@Temporal(value = TemporalType.DATE)
	private Date dateStart;
	@Temporal(value = TemporalType.DATE)
	private Date dateEnd;
	private int status;
	@OneToMany(mappedBy="intervention", fetch=FetchType.EAGER)
	private List<Evaluation> evaluations;
	@Transient
	private float speakerNote = (float) 0;
	@Transient
	private float slideNote = (float) 0;
	@Transient
	private float globalNote = (float) 0;
	
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Speaker getSpeaker() {
		return speaker;
	}
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Campus getCampus() {
		return campus;
	}
	public void setCampus(Campus campus) {
		this.campus = campus;
	}
	public String getDateStart() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(dateStart);
	}
	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}
	public String getDateEnd() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(dateEnd);
	}
	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}
	
	public String getStatus() {
		switch(status) {
		case 0:
			return "A commencé";
		case 1:
			return "En cours";
		case 2:
			return "Est terminé";
		}
		return null;
	}
	public int getRawStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public List<Evaluation> listEvaluations() {
		return evaluations;
	}
	public int getNoteCount() {
		return evaluations.size();
	}
	
	public float getSpeakerNote() {
		if(speakerNote == 0) {
			float cumulative = 0;
			int counter = 0;
			for(Evaluation e : evaluations) {
				cumulative += e.getSpeakerAbility();
				cumulative += e.getSpeakerAnswers();
				cumulative += e.getSpeakerKnowledge();
				counter++;
			}
			speakerNote = (cumulative/(counter*3));
		}
		return speakerNote;
	}
	
	public float getSlideNote() {
		if(slideNote == 0) {
			float cumulative = 0;
			int counter = 0;
			for(Evaluation e : evaluations) {
				cumulative += e.getSlideContent();
				cumulative += e.getSlideExamples();
				cumulative += e.getSlideFormat();
				counter++;
			}
			slideNote = (cumulative/(counter*3));
		}
		return slideNote;
	}
	
	public float getGlobalNote() {
		if(globalNote == 0) {
			globalNote = (getSpeakerNote()+getSlideNote())/2;
		}
		return globalNote;
	}
}
