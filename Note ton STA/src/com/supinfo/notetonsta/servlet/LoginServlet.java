package com.supinfo.notetonsta.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.notetonsta.DAO.DAOFactory;
import com.supinfo.notetonsta.DAO.SpeakerDAO;

@WebServlet("/login")
public class LoginServlet extends BaseServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.sendRedirect(getServletContext().getContextPath() + "/");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		SpeakerDAO speakerManager = DAOFactory.getSpeakerDAO();
		Long speakerId = speakerManager.authenticateSpeaker(username, password);
		if(speakerId != 0) {
			req.getSession().setAttribute("speakerId", speakerId);
		}
		doGet(req, resp);
	}
}
