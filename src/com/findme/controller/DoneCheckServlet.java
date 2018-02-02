package com.findme.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.findme.model.dao.FinditemDAO;
import com.findme.model.dao.FinditemDAOImpl;
import com.findme.model.vo.Finditem;

@WebServlet("/donecheck.do")
public class DoneCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("====== DoneCheckServlet 진입");
		int fId = Integer.parseInt(request.getParameter("doneCheck"));
		System.out.println("******* fId : " + fId);
		
		
		FinditemDAO finditemDao = new FinditemDAOImpl();
		boolean result= finditemDao.doneCheck(fId);
		
		if (result != false) {
			System.out.println("수정 성공");
			response.sendRedirect("mypage.do");

			return;
		} else {
			System.out.println("수정 실패");
			request.setAttribute("errorMessage", "에러메시지 출력");
			request.getRequestDispatcher("mypage.do").forward(request, response);
			return;
		}
	}

}
