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

@WebServlet("/hashtagsearch.do")
public class HashtagSearchServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      request.setCharacterEncoding("utf-8");
      //해쉬태그 
      String fhashtag = request.getParameter("hashtagSearch");
      FinditemDAO finditemDao = new FinditemDAOImpl();
      ArrayList<Finditem> list = finditemDao.getAllHashtags(fhashtag);
      System.out.println(list.size());
      
      for(int i = 0 ; i < list.size() ; i++){
      System.out.println(list.get(i).getfPicture());
      }

      request.setAttribute("hashtagSearch", fhashtag);
      request.setAttribute("hashList",list);
      request.getRequestDispatcher("list.jsp").forward(request, response);
      
      
      
      
      
   }
}