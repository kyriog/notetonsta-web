package com.supinfo.notetonsta.resource;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.supinfo.notetonsta.DAO.DAOFactory;
import com.supinfo.notetonsta.DAO.EvaluationDAO;
import com.supinfo.notetonsta.DAO.InterventionDAO;
import com.supinfo.notetonsta.entity.Evaluation;
import com.supinfo.notetonsta.entity.Intervention;
import com.supinfo.notetonsta.entity.xml.EvaluationXml;
import com.supinfo.notetonsta.entity.xml.InterventionComplexXml;

@Path("/evaluation")
public class EvaluationResource {
	private InterventionComplexXml postEvaluation(EvaluationXml evaluationXml) {
		InterventionDAO interventionManager = DAOFactory.getInterventionDAO();
		EvaluationDAO evaluationManager = DAOFactory.getEvaluationDAO();
		
		Intervention intervention = interventionManager.getInterventionById(evaluationXml.getIdIntervention());
		
		Evaluation evaluation = new Evaluation(evaluationXml);
		evaluation.setIntervention(intervention);
		evaluationManager.addEvaluation(evaluation);
		
		intervention = interventionManager.getInterventionById(evaluationXml.getIdIntervention());
		return new InterventionComplexXml(intervention);
	}
	
	@POST @Consumes(MediaType.APPLICATION_JSON) @Produces(MediaType.APPLICATION_JSON)
	public InterventionComplexXml postEvaluationJSON(EvaluationXml evaluation) {
		return postEvaluation(evaluation);
	}
	
	@POST @Consumes(MediaType.APPLICATION_JSON) @Produces(MediaType.APPLICATION_XML)
	public InterventionComplexXml postEvaluationXML(EvaluationXml evaluation) {
		return postEvaluation(evaluation);
	}
}
