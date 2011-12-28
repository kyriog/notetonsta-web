package com.supinfo.notetonsta.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.notetonsta.DAO.CampusDAO;
import com.supinfo.notetonsta.DAO.DAOFactory;
import com.supinfo.notetonsta.entity.Campus;

@WebServlet("/campus/")
public class CampusServlet extends BaseServlet {
	@Override
	public void init() throws ServletException {}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		request = req;
		response = resp;
		setDefaultAttributes();
		String campusParam = request.getParameter("id"); 
		CampusDAO campusManager = DAOFactory.getCampusDAO();
		if(campusParam == null) {
			request.setAttribute("pageTitle","Liste des campus");
			request.setAttribute("campuses", campusManager.listAllCampuses());
			request.getRequestDispatcher("/listCampuses.jsp").forward(request, response);
		} else {
			Long campusId = "".equals(campusParam) ? 0 : Long.valueOf(campusParam);
			Campus campus = campusManager.getCampusById(campusId); 
			if(campus == null) {
				response.sendRedirect(getServletContext().getContextPath() + "/");
			} else {
				request.getRequestDispatcher("/listInterventions.jsp").forward(request, response);
			}
		}
	}
}
