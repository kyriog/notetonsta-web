package com.supinfo.notetonsta.servlet;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.notetonsta.DAO.DAOFactory;
import com.supinfo.notetonsta.DAO.SpeakerDAO;
import com.supinfo.notetonsta.entity.Speaker;

@WebServlet("/register")
public class RegisterServlet extends BaseServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		request = req;
		response = resp;
		setDefaultAttributes();
		request.setAttribute("pageTitle","Création de compte");
		request.getRequestDispatcher("/register.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String firstname = (String) req.getParameter("firstname");
		String lastname = (String) req.getParameter("lastname");
		String email = (String) req.getParameter("email");
		String password = (String) req.getParameter("password");
		String password2 = (String) req.getParameter("password2");
		int errorCount = 0;
		if("".equals(firstname)) {
			req.setAttribute("firstnameError", "Ce champ est nécessaire !");
			errorCount++;
		}
		if("".equals(lastname)) {
			req.setAttribute("lastnameError", "Ce champ est nécessaire !");
			errorCount++;
		}
		if("".equals(email)) {
			req.setAttribute("emailError", "Ce champ est nécessaire !");
			errorCount++;
		} else {
			Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}$");
			Matcher m = p.matcher(email.toUpperCase());
			if(!m.matches()) {
				req.setAttribute("emailError", "Ce champ est invalide !");
				errorCount++;
			}
		}
		if("".equals(password)) {
			req.setAttribute("passwordError", "Ce champ est nécessaire !");
			errorCount++;
		}
		if("".equals(password2)) {
			req.setAttribute("password2Error", "Ce champ est nécessaire !");
			errorCount++;
		} else if (!password.equals(password2)) {
				req.setAttribute("passwordError", "Les deux mots de passe ne sont pas identiques !");
				req.setAttribute("password2Error", "Les deux mots de passe ne sont pas identiques !");
				errorCount++;
		}
		
		if(errorCount > 0) {
			req.setAttribute("errorCount", errorCount);
			req.setAttribute("firstnameValue", firstname);
			req.setAttribute("lastnameValue", lastname);
			req.setAttribute("emailValue", email);
			doGet(req, resp);
		} else {
			Speaker speaker = new Speaker();
			speaker.setFirstName(firstname);
			speaker.setLastName(lastname);
			speaker.setEmail(email);
			speaker.setPassword(password);
			SpeakerDAO speakerManager = DAOFactory.getSpeakerDAO();
			speakerManager.addSpeaker(speaker);
			resp.sendRedirect(getServletContext().getContextPath() + "/");
		}
	}

}
