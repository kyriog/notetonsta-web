package com.supinfo.notetonsta.DAO.JPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.supinfo.notetonsta.DAO.EvaluationDAO;
import com.supinfo.notetonsta.entity.Evaluation;

public class JPAEvaluationDAO implements EvaluationDAO {
	
EntityManagerFactory emf;
	
	public JPAEvaluationDAO(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public void addEvaluation(Evaluation evaluation) {
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();
			em.persist(evaluation);
			em.getTransaction().commit();
		} finally {
			if(em.getTransaction().isActive()) em.getTransaction().rollback();
			em.close();
		}
	}

}
