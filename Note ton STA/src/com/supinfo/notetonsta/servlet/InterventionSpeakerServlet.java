package com.supinfo.notetonsta.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.notetonsta.DAO.DAOFactory;
import com.supinfo.notetonsta.DAO.SpeakerDAO;
import com.supinfo.notetonsta.entity.Speaker;

@WebServlet("/speaker/intervention/")
public class InterventionSpeakerServlet extends BaseServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		request = req;
		response = resp;
		setDefaultAttributes();
		Long speakerId = (Long) request.getSession().getAttribute("speakerId");
		SpeakerDAO speakerManager = DAOFactory.getSpeakerDAO();
		Speaker speaker = speakerManager.getSpeakerById(speakerId);
		request.setAttribute("interventions", speaker.listInterventions());
		request.getRequestDispatcher("/interventionSpeaker.jsp").forward(request, response);
	}
	
}
