package com.supinfo.notetonsta.entity;

import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Campus {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	@OneToMany(mappedBy="campus")
	private List<Intervention> interventions;
	
	
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
	public List<Intervention> listInterventions() {
		return interventions;
	}
}
