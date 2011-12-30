package com.supinfo.notetonsta.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.notetonsta.DAO.DAOFactory;
import com.supinfo.notetonsta.DAO.InterventionDAO;
import com.supinfo.notetonsta.entity.Intervention;

@WebServlet("/intervention/view/")
public class ViewInterventionServlet extends BaseServlet {

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
				request.getRequestDispatcher("/viewIntervention.jsp").forward(request, response);
			}
		}
	}
}
