package com.supinfo.notetonsta.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.notetonsta.DAO.DAOFactory;
import com.supinfo.notetonsta.DAO.EvaluationDAO;
import com.supinfo.notetonsta.DAO.InterventionDAO;
import com.supinfo.notetonsta.entity.Evaluation;
import com.supinfo.notetonsta.entity.Intervention;

@WebServlet("/intervention/evaluate/")
public class EvaluateInterventionServlet extends BaseServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String interventionParam = req.getParameter("id");
		if(interventionParam == null)
			resp.sendRedirect(getServletContext().getContextPath() + "/");
		else {
			Long interventionId = "".equals(interventionParam) ? 0 : Long.valueOf(interventionParam);
			InterventionDAO interventionManager = DAOFactory.getInterventionDAO();
			Intervention intervention = interventionManager.getInterventionById(interventionId);
			if(intervention == null) {
				resp.sendRedirect(getServletContext().getContextPath() + "/");
			} else {
				request = req;
				response = resp;
				setDefaultAttributes();
				request.setAttribute("intervention", intervention);
				request.getRequestDispatcher("/evaluateIntervention.jsp").forward(request, response);
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String interventionParam = (String) req.getParameter("id");
		if(interventionParam == null)
			resp.sendRedirect(getServletContext().getContextPath() + "/");
		else {
			Long interventionId = "".equals(interventionParam) ? 0 : Long.valueOf(interventionParam);
			InterventionDAO interventionManager = DAOFactory.getInterventionDAO();
			Intervention intervention = interventionManager.getInterventionById(interventionId);
			if(intervention == null) {
				resp.sendRedirect(getServletContext().getContextPath() + "/");
			} else {
				String idBoosterParam = (String) req.getParameter("idBooster");
				String speakerKnowledgeParam = (String) req.getParameter("speakerKnowledge");
				String speakerAbilityParam = (String) req.getParameter("speakerAbility");
				String speakerAnswersParam = (String) req.getParameter("speakerAnswers");
				String slideContentParam = (String) req.getParameter("slideContent");
				String slideFormatParam = (String) req.getParameter("slideFormat");
				String slideExamplesParam = (String) req.getParameter("slideExamples");
				String commentParam = (String) req.getParameter("comment");
				int errorCount = 0;
				if("".equals(idBoosterParam)) {
					req.setAttribute("idBoosterError", "Ce champ est nécessaire !");
					errorCount++;
				}
				if(speakerKnowledgeParam == null) {
					req.setAttribute("speakerKnowledgeError", "Ce champ est nécessaire !");
					errorCount++;
				}
				if(speakerAbilityParam == null) {
					req.setAttribute("speakerAbilityError", "Ce champ est nécessaire !");
					errorCount++;
				}
				if(speakerAnswersParam == null) {
					req.setAttribute("speakerAnswersError", "Ce champ est nécessaire !");
					errorCount++;
				}
				if(slideContentParam == null) {
					req.setAttribute("slideContentError", "Ce champ est nécessaire !");
					errorCount++;
				}
				if(slideFormatParam == null) {
					req.setAttribute("slideFormatError", "Ce champ est nécessaire !");
					errorCount++;
				}
				if(slideExamplesParam == null) {
					req.setAttribute("slideExamplesError", "Ce champ est nécessaire !");
					errorCount++;
				}
				if(errorCount > 0) {
					req.setAttribute("errorCount", errorCount);
					req.setAttribute("idBoosterValue", idBoosterParam);
					req.setAttribute("speakerKnowledgeValue", speakerKnowledgeParam);
					req.setAttribute("speakerAbilityValue", speakerAbilityParam);
					req.setAttribute("speakerAnswersValue", speakerAnswersParam);
					req.setAttribute("slideContentValue", slideContentParam);
					req.setAttribute("slideFormatValue", slideFormatParam);
					req.setAttribute("slideExamplesValue", slideExamplesParam);
					req.setAttribute("commentValue", commentParam);
					doGet(req,resp);
				} else {
					int idBooster = Integer.parseInt(idBoosterParam);
					int speakerKnowledge = Integer.parseInt(speakerKnowledgeParam);
					int speakerAbility = Integer.parseInt(speakerAbilityParam);
					int speakerAnswers = Integer.parseInt(speakerAnswersParam);
					int slideContent = Integer.parseInt(slideContentParam);
					int slideFormat = Integer.parseInt(slideFormatParam);
					int slideExamples = Integer.parseInt(slideExamplesParam);
					
					Evaluation evaluation = new Evaluation();
					evaluation.setIntervention(intervention);
					evaluation.setIdBooster(idBooster);
					evaluation.setSpeakerKnowledge(speakerKnowledge);
					evaluation.setSpeakerAbility(speakerAbility);
					evaluation.setSpeakerAnswers(speakerAnswers);
					evaluation.setSlideContent(slideContent);
					evaluation.setSlideFormat(slideFormat);
					evaluation.setSlideExamples(slideExamples);
					if(!"".equals(commentParam))
						evaluation.setComment(commentParam);
					
					EvaluationDAO evaluationManager = DAOFactory.getEvaluationDAO();
					evaluationManager.addEvaluation(evaluation);
					resp.sendRedirect(getServletContext().getContextPath() + "/intervention/view/?id="+intervention.getId());
				}
			}
		}
	}

}
