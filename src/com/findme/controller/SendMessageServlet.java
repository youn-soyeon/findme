package com.findme.controller;

import java.io.IOException;

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

@WebServlet("/sendmessage.do")
public class SendMessageServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      request.setCharacterEncoding("utf-8"); // for 한글
      System.out.println("===== sendmessage.do 진입 =====");
      
      HttpSession session = request.getSession();
      Member member = new Member((String)session.getAttribute("loginId"), request.getParameter("password"));;
      
      String mReceiver = request.getParameter("msgReceiver");;
      String mContents = request.getParameter("msgContents");
      String mSender = member.getMemId();
      String mTitle = request.getParameter("msgTitle");

      System.out.println("msgReceiver : " + mReceiver);
      System.out.println("msgContents : " + mContents);
      System.out.println("msgSender : " + mSender);
      System.out.println("msgTitle : " + mTitle);

      
      MessageDAO messageDao = new MessageDAOImpl();
      messageDao.sendMessmage(new Message(mReceiver, mContents, mSender, mTitle));

      response.sendRedirect("main.jsp");
      
   }
}