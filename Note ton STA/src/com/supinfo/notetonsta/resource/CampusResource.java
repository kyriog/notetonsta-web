package com.supinfo.notetonsta.resource;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.supinfo.notetonsta.DAO.CampusDAO;
import com.supinfo.notetonsta.DAO.DAOFactory;
import com.supinfo.notetonsta.entity.Campus;
import com.supinfo.notetonsta.entity.Intervention;
import com.supinfo.notetonsta.entity.xml.InterventionListXml;

@Path("/campus")
public class CampusResource {
	private CampusDAO campusManager;
	
	public CampusResource() {
		campusManager = DAOFactory.getCampusDAO();
	}
	
	private List<Campus> getAllCampuses() {
		return campusManager.listAllCampuses();
	}
	
	@GET @Produces(MediaType.APPLICATION_JSON)
	public List<Campus> getAllCampusesJSON() {
		return getAllCampuses();
	}
	
	@GET @Produces(MediaType.APPLICATION_XML)
	public List<Campus> getAllCampusesXML() {
		return getAllCampuses();
	}
	
	private InterventionListXml getInterventionsByCampusId(Long id) {
		InterventionListXml interventionsList = new InterventionListXml();
		Campus campus = campusManager.getCampusById(id);
		for(Intervention i : campus.listInterventions()) {
			interventionsList.addIntervention(i);
		}
		return interventionsList;
	}
	
	@GET @Path("/{id}") @Produces(MediaType.APPLICATION_JSON)
	public InterventionListXml getInterventionsByCampusIdJSON(@PathParam("id") Long id) {
		return getInterventionsByCampusId(id);
	}
	
	@GET @Path("/{id}") @Produces(MediaType.APPLICATION_XML)
	public InterventionListXml getInterventionsByCampusIdXML(@PathParam("id") Long id) {
		return getInterventionsByCampusId(id);
	}
}