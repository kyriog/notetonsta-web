package com.supinfo.notetonsta.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.notetonsta.DAO.CampusDAO;
import com.supinfo.notetonsta.DAO.DAOFactory;
import com.supinfo.notetonsta.DAO.InterventionDAO;
import com.supinfo.notetonsta.DAO.SpeakerDAO;
import com.supinfo.notetonsta.entity.Campus;
import com.supinfo.notetonsta.entity.Intervention;
import com.supinfo.notetonsta.entity.Speaker;

@WebServlet("/speaker/intervention/edit/")
public class EditInterventionSpeakerServlet extends BaseServlet {

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String interventionParam = req.getParameter("id");
		if(interventionParam != null) {
			Long interventionId = "".equals(interventionParam) ? 0 : Long.valueOf(interventionParam);
			InterventionDAO interventionManager = DAOFactory.getInterventionDAO();
			Intervention intervention = interventionManager.getInterventionById(interventionId);
			if(intervention == null) {
				resp.sendRedirect(getServletContext().getContextPath() + "/");
			} else {
				interventionManager.deleteIntervention(intervention);
				resp.sendRedirect(getServletContext().getContextPath() + "/");
			}
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		request = req;
		response = resp;
		String interventionParam = req.getParameter("id");
		if(interventionParam != null) {
			Long interventionId = "".equals(interventionParam) ? 0 : Long.valueOf(interventionParam);
			InterventionDAO interventionManager = DAOFactory.getInterventionDAO();
			Intervention intervention = interventionManager.getInterventionById(interventionId);
			if(intervention == null) {
				resp.sendRedirect(getServletContext().getContextPath() + "/");
			} else {
				request.setAttribute("editIntervention", true);
				if(request.getAttribute("intevention") == null)
					request.setAttribute("intervention", intervention);
			}
		}
		setDefaultAttributes();
		CampusDAO campusManager = DAOFactory.getCampusDAO();
		List<Campus> campuses = campusManager.listAllCampuses();
		request.setAttribute("campuses", campuses);
		request.getRequestDispatcher("/editInterventionSpeaker.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String idParam = (String) req.getParameter("id");
		if(idParam != null) {
			doPut(req, resp);
			return;
		}
		String subjectParam = (String) req.getParameter("subject");
		String campusParam = (String) req.getParameter("campus");
		String dateStartParam = (String) req.getParameter("dateStart");
		String dateEndParam = (String) req.getParameter("dateEnd");
		String descriptionParam = (String) req.getParameter("description");
		int errorCount = 0;
		if("".equals(subjectParam)) {
			req.setAttribute("subjectError", "Ce champ est nécessaire !");
			errorCount++;
		}
		Long campusId = Long.valueOf(campusParam);
		CampusDAO campusManager = DAOFactory.getCampusDAO();
		Campus campus = campusManager.getCampusById(campusId);
		if(campus == null) {
			req.setAttribute("campusError", "Ce campus est inconnu");
			errorCount++;
		}
		Date dateStart = new Date();
		Date dateEnd = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);
		if("".equals(dateStartParam)) {
			req.setAttribute("dateStartError", "Ce champ est nécessaire !");
			errorCount++;
		} else {
			try {
				dateStart = sdf.parse(dateStartParam);
			} catch (ParseException e) {
				req.setAttribute("dateStartError", "La date n'est pas valide. Elle doit être du format AAAA-MM-JJ");
				errorCount++;
			}
		}
		if("".equals(dateEndParam)) {
			req.setAttribute("dateEndError", "Ce champ est nécessaire !");
			errorCount++;
		} else {
			try {
				dateEnd = sdf.parse(dateEndParam);
			} catch (ParseException e) {
				req.setAttribute("dateEndError", "La date n'est pas valide. Elle doit être du format AAAA-MM-JJ");
				errorCount++;
			}
		}
		if("".equals(descriptionParam)) {
			req.setAttribute("descriptionError","Ce champ est nécessaire !");
			errorCount++;
		}
		
		Intervention intervention = new Intervention();
		intervention.setName(subjectParam);
		intervention.setCampus(campus);
		intervention.setDateStart(dateStart);
		intervention.setDateEnd(dateEnd);
		intervention.setDescription(descriptionParam);
		if(errorCount > 0) {
			req.setAttribute("errorCount", errorCount);
			req.setAttribute("intervention", intervention);
			doGet(req,resp);
		} else {
			Long speakerId = (Long) req.getSession().getAttribute("speakerId");
			SpeakerDAO speakerManager = DAOFactory.getSpeakerDAO();
			Speaker speaker = speakerManager.getSpeakerById(speakerId);
			intervention.setSpeaker(speaker);
			InterventionDAO interventionManager = DAOFactory.getInterventionDAO();
			interventionManager.addIntervention(intervention);
			resp.sendRedirect(getServletContext().getContextPath() + "/");
		}
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String interventionParam = (String) req.getParameter("id");
		if(interventionParam != null) {
			Long interventionId = "".equals(interventionParam) ? 0 : Long.valueOf(interventionParam);
			InterventionDAO interventionManager = DAOFactory.getInterventionDAO();
			Intervention intervention = interventionManager.getInterventionById(interventionId);
			if(intervention == null) {
				resp.sendRedirect(getServletContext().getContextPath() + "/speaker/intervention/edit/");
			} else {
				String subjectParam = (String) req.getParameter("subject");
				String campusParam = (String) req.getParameter("campus");
				String dateStartParam = (String) req.getParameter("dateStart");
				String dateEndParam = (String) req.getParameter("dateEnd");
				String descriptionParam = (String) req.getParameter("description");
				int errorCount = 0;
				if("".equals(subjectParam)) {
					req.setAttribute("subjectError", "Ce champ est nécessaire !");
					errorCount++;
				}
				Long campusId = Long.valueOf(campusParam);
				CampusDAO campusManager = DAOFactory.getCampusDAO();
				Campus campus = campusManager.getCampusById(campusId);
				if(campus == null) {
					req.setAttribute("campusError", "Ce campus est inconnu");
					errorCount++;
				}
				Date dateStart = new Date();
				Date dateEnd = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				sdf.setLenient(false);
				if("".equals(dateStartParam)) {
					req.setAttribute("dateStartError", "Ce champ est nécessaire !");
					errorCount++;
				} else {
					try {
						dateStart = sdf.parse(dateStartParam);
					} catch (ParseException e) {
						req.setAttribute("dateStartError", "La date n'est pas valide. Elle doit être du format AAAA-MM-JJ");
						errorCount++;
					}
				}
				if("".equals(dateEndParam)) {
					req.setAttribute("dateEndError", "Ce champ est nécessaire !");
					errorCount++;
				} else {
					try {
						dateEnd = sdf.parse(dateEndParam);
					} catch (ParseException e) {
						req.setAttribute("dateEndError", "La date n'est pas valide. Elle doit être du format AAAA-MM-JJ");
						errorCount++;
					}
				}
				if("".equals(descriptionParam)) {
					req.setAttribute("descriptionError","Ce champ est nécessaire !");
					errorCount++;
				}
				intervention.setName(subjectParam);
				intervention.setCampus(campus);
				intervention.setDateStart(dateStart);
				intervention.setDateEnd(dateEnd);
				intervention.setDescription(descriptionParam);
				if(errorCount > 0) {
					req.setAttribute("errorCount", errorCount);
					req.setAttribute("intervention", intervention);
					doGet(req,resp);
				} else {
					interventionManager.updateIntervention(intervention);
					resp.sendRedirect(getServletContext().getContextPath() + "/");
				}
			}
		}
	}

}
