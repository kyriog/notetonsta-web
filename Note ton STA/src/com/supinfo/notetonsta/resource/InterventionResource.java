package com.supinfo.notetonsta.resource;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.supinfo.notetonsta.DAO.DAOFactory;
import com.supinfo.notetonsta.DAO.InterventionDAO;
import com.supinfo.notetonsta.entity.xml.InterventionComplexXml;

@Path("/intervention")
public class InterventionResource {
	private InterventionDAO interventionManager;
	
	public InterventionResource() {
		interventionManager = DAOFactory.getInterventionDAO();
	}
	
	private InterventionComplexXml getIntervention(Long id) {
		return new InterventionComplexXml(interventionManager.getInterventionById(id));
	}
	
	@GET @Path("/{idIntervention}") @Produces(MediaType.APPLICATION_JSON)
	public InterventionComplexXml getInterventionJSON(@PathParam("idIntervention") Long id) {
		return getIntervention(id);
	}

	@GET @Path("/{idIntervention}") @Produces(MediaType.APPLICATION_XML)
	public InterventionComplexXml getInterventionXML(@PathParam("idIntervention") Long id) {
		return getIntervention(id);
	}
}
