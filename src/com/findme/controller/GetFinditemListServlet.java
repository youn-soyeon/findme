package com.findme.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.findme.model.dao.FinditemDAO;
import com.findme.model.dao.FinditemDAOImpl;
import com.findme.model.vo.Finditem;


@WebServlet("/getfinditem.do")
public class GetFinditemListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	request.setCharacterEncoding("utf-8"); // for
		
		String finditem = request.getParameter("finditem");

		FinditemDAO finditemDao = new FinditemDAOImpl();
		ArrayList<Finditem> finditemList = finditemDao.getFinditemList();
		request.setAttribute("finditemList", finditemList);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
		rd.forward(request, response);
		return;
		
		
		
	}

}
