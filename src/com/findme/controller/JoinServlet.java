package com.findme.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.findme.model.dao.MemberDAOImpl;
import com.findme.model.dao.MemberDAO;
import com.findme.model.vo.Member;

@WebServlet("/join.do")
public class JoinServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String memid = request.getParameter("memid");
		String password = request.getParameter("password");
		String password_check = request.getParameter("password_check");

		if (memid == null || memid.trim().length() == 0 || password == null || password.trim().length() == 0
				|| password_check == null || password_check.trim().length() == 0
				|| !(password.equals(password_check))) {
			System.out.println("유효성 체크 진입");

			request.setAttribute("errorMessage", "로그인 실패");
			request.getRequestDispatcher("join.jsp").forward(request, response);

			return;
		}

		MemberDAO memberDao = new MemberDAOImpl();
		boolean joinResult = memberDao.join(new Member(memid, password));

		if (joinResult != false) {
			System.out.println("로그인성공");
			// request.getRequestDispatcher("main.do");
			response.sendRedirect("main.do");
			return;
		} else {
			System.out.println("로그인실패");
			request.setAttribute("errorMessage", "로그인 실패");
			request.getRequestDispatcher("join.jsp").forward(request, response);
			return;
		}
	}
}
