package com.supinfo.notetonsta.entity.xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.supinfo.notetonsta.entity.Intervention;

@XmlRootElement(name="interventions")
public class InterventionListXml {
	@XmlElement(name="intervention")
	private ArrayList<InterventionSimpleXml> interventions = new ArrayList<InterventionSimpleXml>();
	
	public InterventionListXml() {}
	
	public List<InterventionSimpleXml> getInterventions() {
		return interventions;
	}
	public void setInterventions(ArrayList<InterventionSimpleXml> interventions) {
		this.interventions = interventions;
	}
	
	public void addIntervention(Intervention intervention) {
		addIntervention(new InterventionSimpleXml(intervention));
	}
	public void addIntervention(InterventionSimpleXml intervention) {
		interventions.add(intervention);
	}
}
