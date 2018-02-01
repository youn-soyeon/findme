package com.findme.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.findme.model.dao.FinditemDAO;
import com.findme.model.dao.FinditemDAOImpl;
import com.findme.model.vo.Finditem;

@WebServlet("/main.do")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("======MainServlet 진입");

		// String todayFinditem;
		FinditemDAO finditemDao = new FinditemDAOImpl();
		ArrayList<Finditem> findItemList = finditemDao.getTop3FinditemList();

		for (int i = 0; i < findItemList.size(); i++) {
			System.out.println(findItemList.get(i).getfPicture());
			System.out.println(findItemList.get(i).getfAddress());
		}

		request.setAttribute("findItemList", findItemList);
		request.getRequestDispatcher("main.jsp").forward(request, response);

	}
}