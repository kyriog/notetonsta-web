package com.supinfo.notetonsta.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.notetonsta.DAO.DAOFactory;
import com.supinfo.notetonsta.DAO.SpeakerDAO;
import com.supinfo.notetonsta.entity.Speaker;

public abstract class BaseServlet extends HttpServlet {
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	
	protected void setDefaultAttributes() {
		request.setAttribute("baseUrl", getServletContext().getContextPath());
		Long speakerId = (Long) request.getSession().getAttribute("speakerId");
		if(speakerId == null) {
			request.setAttribute("logged", false);
		} else {
			request.setAttribute("logged", true);
			SpeakerDAO speakerManager = DAOFactory.getSpeakerDAO();
			Speaker speakerLogged = speakerManager.getSpeakerById(speakerId);
			request.setAttribute("speakerName",speakerLogged.getFullName());
		}
	}
}
