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
public class CampusServlet extends HttpServlet {
	@Override
	public void init() throws ServletException {}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String campusParam = req.getParameter("id"); 
		CampusDAO campusManager = DAOFactory.getCampusDAO();
		if(campusParam == null) {
			req.setAttribute("campuses", campusManager.listAllCampuses());
			req.getRequestDispatcher("/listCampuses.jsp").forward(req, resp);
		} else {
			Long campusId = "".equals(campusParam) ? 0 : Long.valueOf(campusParam);
			Campus campus = campusManager.getCampusById(campusId); 
			if(campus == null) {
				resp.sendRedirect(getServletContext().getContextPath() + "/");
			} else {
				req.getRequestDispatcher("/listInterventions.jsp").forward(req, resp);
			}
		}
	}
}
