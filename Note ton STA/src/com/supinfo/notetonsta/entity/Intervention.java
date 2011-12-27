package com.supinfo.notetonsta.entity;

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
	@OneToMany(mappedBy="intervention")
	private List<Evaluation> evaluations;
	
	
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
	public Date getDateStart() {
		return dateStart;
	}
	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}
	public Date getDateEnd() {
		return dateEnd;
	}
	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public List<Evaluation> listEvaluations() {
		return evaluations;
	}
}
