package com.supinfo.notetonsta.DAO.JPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.supinfo.notetonsta.DAO.CampusDAO;
import com.supinfo.notetonsta.entity.Campus;

public class JPACampusDAO implements CampusDAO {
	EntityManagerFactory emf;
	
	public JPACampusDAO(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public void addCampus(Campus campus) {
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();
			em.persist(campus);
			em.getTransaction().commit();
		} finally {
			if(em.getTransaction().isActive()) em.getTransaction().rollback();
			em.close();
		}
	}

	@Override
	public void updateCampus(Campus campus) {
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();
			em.persist(campus);
			em.getTransaction().commit();
		} finally {
			if(em.getTransaction().isActive()) em.getTransaction().rollback();
			em.close();
		}
	}

	@Override
	public void deleteCampus(Campus campus) {
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();
			em.remove(campus);
			em.getTransaction().commit();
		} finally {
			if(em.getTransaction().isActive()) em.getTransaction().rollback();
			em.close();
		}
	}

	@Override
	public List<Campus> listAllCampuses() {
		EntityManager em = emf.createEntityManager();
		try {
			Query query = em.createQuery("SELECT c FROM Campus c");
			
			@SuppressWarnings("unchecked")
			List<Campus> campuses = query.getResultList();
			
			return campuses;
		} finally {
			em.close();
		}
	}

	@Override
	public Campus getCampusById(Long id) {
		EntityManager em = emf.createEntityManager();
		
		try {
			Query q = em.createQuery("SELECT c FROM Campus c LEFT JOIN FETCH c.interventions WHERE c.id = :id");
			q.setParameter("id", id);
			try {
				return (Campus) q.getSingleResult();
			} catch(NoResultException e) {
				return null;
			}
		} finally {
			em.close();
		}
	}

}
