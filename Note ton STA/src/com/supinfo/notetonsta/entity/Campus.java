package com.supinfo.notetonsta.entity;

import java.util.List;

import javax.persistence.*;

@Entity
public class Campus {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	@OneToMany(mappedBy="Intervention")
	private List<Intervention> interventions;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
