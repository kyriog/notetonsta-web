package com.supinfo.notetonsta.DAO.JPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

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
	public Intervention getInterventionById(Long id) {
		EntityManager em = emf.createEntityManager();
		
		try {
			Query q = em.createQuery("SELECT i FROM Intervention i LEFT JOIN FETCH i.evaluations WHERE i.id = :id");
			q.setParameter("id", id);
			Intervention intervention = (Intervention) q.getSingleResult();
			return intervention;
		} finally {
			em.close();
		}
	}

}
