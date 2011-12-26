package com.supinfo.notetonsta.DAO.JPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.supinfo.notetonsta.DAO.InterventionDAO;
import com.supinfo.notetonsta.entity.Intervention;

public class JPAInterventionDAO implements InterventionDAO {
	EntityManagerFactory emf;
	
	public JPAInterventionDAO(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public void addIntervention(Intervention intervention) {
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();
			em.persist(intervention);
			em.getTransaction().commit();
		} finally {
			if(em.getTransaction().isActive()) em.getTransaction().rollback();
			em.close();
		}
	}

	@Override
	public void updateIntervention(Intervention intervention) {
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();
			em.persist(intervention);
			em.getTransaction().commit();
		} finally {
			if(em.getTransaction().isActive()) em.getTransaction().rollback();
			em.close();
		}
	}

	@Override
	public void deleteIntervention(Intervention intervention) {
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();
			em.remove(intervention);
			em.getTransaction().commit();
		} finally {
			if(em.getTransaction().isActive()) em.getTransaction().rollback();
			em.close();
		}
	}

	@Override
	public Intervention getInterventionById(int id) {
		EntityManager em = emf.createEntityManager();
		
		try {
			Intervention intervention = em.find(Intervention.class, id);
			return intervention;
		} finally {
			em.close();
		}
	}

}
