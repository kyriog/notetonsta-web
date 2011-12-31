package com.supinfo.notetonsta.DAO.JPA;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import sun.misc.BASE64Encoder;

import com.supinfo.notetonsta.DAO.SpeakerDAO;
import com.supinfo.notetonsta.entity.Intervention;
import com.supinfo.notetonsta.entity.Speaker;

public class JPASpeakerDAO implements SpeakerDAO {
EntityManagerFactory emf;
	
	public JPASpeakerDAO(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public void addSpeaker(Speaker speaker) {
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();
			em.persist(speaker);
			em.getTransaction().commit();
		} finally {
			if(em.getTransaction().isActive()) em.getTransaction().rollback();
			em.close();
		}
	}

	@Override
	public void updateSpeaker(Speaker speaker) {
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();
			em.persist(speaker);
			em.getTransaction().commit();
		} finally {
			if(em.getTransaction().isActive()) em.getTransaction().rollback();
			em.close();
		}
	}

	@Override
	public void deleteSpeaker(Speaker speaker) {
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();
			em.remove(speaker);
			em.getTransaction().commit();
		} finally {
			if(em.getTransaction().isActive()) em.getTransaction().rollback();
			em.close();
		}
	}

	@Override
	public Speaker getSpeakerById(Long id) {
		EntityManager em = emf.createEntityManager();
		
		try {
			Query q = em.createQuery("SELECT s FROM Speaker s LEFT JOIN FETCH s.interventions WHERE s.id = :id");
			q.setParameter("id", id);
			Speaker speaker = (Speaker) q.getSingleResult();
			return speaker;
		} finally {
			em.close();
		}
	}

	@Override
	public Long authenticateSpeaker(String email, String password) {
		EntityManager em = emf.createEntityManager();
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA");
			md.update(password.getBytes("UTF-8"));
			password = (new BASE64Encoder()).encode(md.digest());
			Query query = em.createQuery("SELECT id FROM Speaker WHERE email = :email AND password = :password");
			query.setParameter("email", email);
			query.setParameter("password", password);
			return (Long) query.getSingleResult();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(NoResultException e) {
			return (long) 0;
		} finally {
			em.close();
		}
		return null;
	}

}
