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

	private static final long serialVersionUID = 1L; // 직렬화

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // for 한글

		String memid = request.getParameter("memid"); // 아이디
		String password = request.getParameter("password"); // 비밀번호
		String password_check = request.getParameter("password_check"); // 비밀번호
																		// 확인

		if (memid == null || memid.trim().length() == 0 || password == null || password.trim().length() == 0
				|| password_check == null || password_check.trim().length() == 0 || !(password.equals(password_check))) {
			System.out.println("유효성 검사 실패"); // 유효성 검사 확인

			request.setAttribute("errorMessage", "유효성 검사 실패");
			request.getRequestDispatcher("join.jsp").forward(request, response);

			return; // 페이지 이동 구문할 때는 return 꼭!
		}

		MemberDAO memberDao = new MemberDAOImpl();
		boolean joinResult = memberDao.join(new Member(memid, password));

		if (joinResult != false) { // 로그인 성공
			System.out.println("가입 성공");
			// request.getRequestDispatcher("main.jsp");
			response.sendRedirect("main.jsp");
			return;
		} else { // 로그인 실패
			System.out.println("가입 실패");
			request.setAttribute("errorMessage", "로그인 실패");
			request.getRequestDispatcher("join.jsp").forward(request, response);
			return;
		}
	}
}
