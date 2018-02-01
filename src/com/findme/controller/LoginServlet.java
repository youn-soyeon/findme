package com.findme.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.findme.model.dao.MemberDAO;
import com.findme.model.dao.MemberDAOImpl;
import com.findme.model.vo.Member;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String loginId = request.getParameter("loginId");
		String loginPassword = request.getParameter("loginPassword");

		if (loginId == null || loginId.trim().length() == 0 || loginPassword == null
				|| loginPassword.trim().length() == 0) {
			System.out.println("유효성 검사 실패");
			request.setAttribute("errorMessage", "에러메시지 출력");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}

		MemberDAO memberDao = new MemberDAOImpl();
		Member loginMember = memberDao.login(loginId, loginPassword);
		System.out.println(loginMember.getMemId());
		if (loginMember.getMemId() != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginId", loginId);
			session.setAttribute("loginMember", loginMember);
			response.sendRedirect("main.do");

			return;
		} else {
			System.out.println("로그인 실패");
			request.setAttribute("errorMessage", "에러메시지 출력");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
	}
}