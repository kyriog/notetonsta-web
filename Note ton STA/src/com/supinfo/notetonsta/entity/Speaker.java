package com.supinfo.notetonsta.entity;

import java.util.List;

import javax.persistence.*;

@Entity
public class Speaker {
	@Id
	@GeneratedValue
	private Long id;
	private String firstName;
	private String lastName;
	@Transient
	private String fullName;
	private String email;
	private String password;
	@OneToMany(mappedBy="speaker")
	private List<Intervention> interventions;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFullName() {
		if(fullName == null)
			fullName = firstName+" "+lastName;
		return fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Intervention> listInterventions() {
		return interventions;
	}
}
