package com.supinfo.notetonsta.DAO;

import com.supinfo.notetonsta.DAO.JPA.*;
import com.supinfo.notetonsta.util.PersistenceManager;

public class DAOFactory {
	private DAOFactory() {}
	
	public static SpeakerDAO getSpeakerDAO() {
		return new JPASpeakerDAO(PersistenceManager.getEntityManagerFactory());
	}
	
	public static CampusDAO getCampusDAO() {
		return new JPACampusDAO(PersistenceManager.getEntityManagerFactory());
	}
	
	public static InterventionDAO getInterventionDAO() {
		return new JPAInterventionDAO(PersistenceManager.getEntityManagerFactory());
	}
	
	public static EvaluationDAO getEvaluationDAO() {
		return new JPAEvaluationDAO(PersistenceManager.getEntityManagerFactory());
	}
}
