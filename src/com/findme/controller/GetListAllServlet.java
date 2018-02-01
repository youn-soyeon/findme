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
import com.findme.model.dao.LostitemDAO;
import com.findme.model.dao.LostitemDAOImpl;
import com.findme.model.vo.Finditem;
import com.findme.model.vo.Lostitem;

@WebServlet("/listall.do")
public class GetListAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("======= GetListAllServlet() 진입");

		FinditemDAO finditemDao = new FinditemDAOImpl();
		LostitemDAO lostitemDao = new LostitemDAOImpl();
		ArrayList<Finditem> finditemList = finditemDao.getFinditemList();
		ArrayList<Lostitem> lostitemList = lostitemDao.getLostitemList();


		for (int i = 0; i < finditemList.size(); i++) {
			System.out.println(finditemList.get(i).getfPicture());
		}
		for (int j = 0; j < lostitemList.size(); j++) {
			System.out.println(lostitemList.get(j).getlPicture());
		}

		request.setAttribute("findList", finditemList);
		request.setAttribute("lostList", lostitemList);
		request.getRequestDispatcher("listAll.jsp").forward(request, response);

	}

}