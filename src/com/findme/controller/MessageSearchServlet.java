package com.findme.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.findme.model.dao.MessageDAO;
import com.findme.model.dao.MessageDAOImpl;
import com.findme.model.vo.Member;
import com.findme.model.vo.Message;

@WebServlet("/msgSearch.do")
public class MessageSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // for
		System.out.println("======MessageSearchServlet 진입");

		HttpSession session = request.getSession();
		Member member = new Member((String) session.getAttribute("loginId"), request.getParameter("password"));
		// 보낸쪽지함
		System.out.println(member.getMemId());
		MessageDAO messageDao = new MessageDAOImpl();
		ArrayList<Message> sendList = messageDao.getMsgListBySender(member.getMemId());
		/*for (Message message : sendList) {
			System.out.println("$$$$$$$$$$$$$$$$$$$ s num : " + message.getMsgId());
			System.out.println(member.getMemId());
			// message.getMsgId();
		}*/
		// 받은쪽지함
		ArrayList<Message> receiveList = messageDao.getMsgListByReceiver(member.getMemId());
		/*for (Message message : receiveList) {
			System.out.println("$$$$$$$$$$$$$$$$$$$ r num : " + message.getMsgId());

		}*/

		request.setAttribute("receiveList", receiveList);
		request.setAttribute("sendList", sendList);
		request.getRequestDispatcher("message.jsp").forward(request, response);
	}

}
