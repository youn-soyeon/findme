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

	private static final long serialVersionUID = 1L; // ����ȭ

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // for �ѱ�

		String memid = request.getParameter("memid"); // ���̵�
		String password = request.getParameter("password"); // ��й�ȣ
		String password_check = request.getParameter("password_check"); // ��й�ȣ
																		// Ȯ��

		if (memid == null || memid.trim().length() == 0 || password == null || password.trim().length() == 0
				|| password_check == null || password_check.trim().length() == 0 || !(password.equals(password_check))) {
			System.out.println("��ȿ�� �˻� ����"); // ��ȿ�� �˻� Ȯ��

			request.setAttribute("errorMessage", "��ȿ�� �˻� ����");
			request.getRequestDispatcher("join.jsp").forward(request, response);

			return; // ������ �̵� ������ ���� return ��!
		}

		MemberDAO memberDao = new MemberDAOImpl();
		boolean joinResult = memberDao.join(new Member(memid, password));

		if (joinResult != false) { // �α��� ����
			System.out.println("���� ����");
			// request.getRequestDispatcher("main.jsp");
			response.sendRedirect("main.jsp");
			return;
		} else { // �α��� ����
			System.out.println("���� ����");
			request.setAttribute("errorMessage", "�α��� ����");
			request.getRequestDispatcher("join.jsp").forward(request, response);
			return;
		}
	}
}
