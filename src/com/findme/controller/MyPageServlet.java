package com.findme.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.findme.model.dao.FinditemDAO;
import com.findme.model.dao.FinditemDAOImpl;
import com.findme.model.dao.MemberDAO;
import com.findme.model.dao.MemberDAOImpl;
import com.findme.model.vo.Finditem;
import com.findme.model.vo.Member;

@WebServlet("/mypage.do")
public class MyPageServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      request.setCharacterEncoding("utf-8");
      
      System.out.println("========= MyPageServlet 진입");
      HttpSession session = request.getSession();
      MemberDAO memberDao = new MemberDAOImpl();
      Member member = memberDao.searchMember((String)session.getAttribute("loginId"));
      System.out.println("** memid : " + member.getMemId());
      
      FinditemDAO finditemDao = new FinditemDAOImpl();
      ArrayList<Finditem> finditemList = finditemDao.getFinditemById(member.getMemId());
      
      for(int i = 0 ; i < finditemList.size() ; i++){
    	  System.out.println(finditemList.get(i));
      }

      request.setAttribute("finditemList",finditemList);
      request.getRequestDispatcher("mypage.jsp").forward(request, response);

      
   }
}