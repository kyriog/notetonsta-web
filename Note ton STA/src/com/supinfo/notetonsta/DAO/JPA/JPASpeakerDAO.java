package com.supinfo.notetonsta.DAO.JPA;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.supinfo.notetonsta.DAO.SpeakerDAO;
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
			Speaker speaker = em.find(Speaker.class, id);
			return speaker;
		} finally {
			em.close();
		}
	}

	@Override
	public boolean authenticateSpeaker(String username, String password) {
		EntityManager em = emf.createEntityManager();
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-1");
			password = new String(md.digest(password.getBytes()));
			Query query = em.createQuery("SELECT id FROM Speaker WHERE username = \""+username+"\" AND password = \""+password+"\"");
			if(query.getSingleResult() instanceof Speaker)
				return true;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return false;
	}

}
