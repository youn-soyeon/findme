package com.findme.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.findme.model.dao.FinditemDAO;
import com.findme.model.dao.FinditemDAOImpl;
import com.findme.model.dao.LostitemDAO;
import com.findme.model.dao.LostitemDAOImpl;
import com.findme.model.vo.Finditem;
import com.findme.model.vo.Lostitem;
import com.findme.model.vo.Member;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/write.do")
public class WriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("===== write.do 진입 =====");
		
		HttpSession session = request.getSession();
		Member member = new Member((String) session.getAttribute("loginId"), request.getParameter("password"));
		
		System.out.println("*************아이디 : " + member.getMemId());
		
		
		String savePath = getServletContext().getRealPath("resources");
		int sizeLimit = 1024*1024*15;
		MultipartRequest multi = new MultipartRequest(request, savePath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());
		
		String type = multi.getParameter("itemType"); 
		String lDate = multi.getParameter("itemDate");
		String lAddress = multi.getParameter("itemAddress");
		String lContent = multi.getParameter("itemContents");
		String lPicture = multi.getFilesystemName("itemPicture");
		String lHashtag = multi.getParameter("itemHashtag");
		String writer = member.getMemId();
		
		
/*		System.out.println("itemType : " + type);
		System.out.println("itemDate : " + lDate);
		System.out.println("itemAddress : " + lAddress);
		System.out.println("itemContents : " + lContent);
		System.out.println("itemPicture : " + lPicture);
		System.out.println("itemhashtag : " + lHashtag);
		System.out.println("itemWriter : " + writer);
*/
		
		if(type.equals("1")){
			FinditemDAO FinditemDao = new FinditemDAOImpl();
			FinditemDao.writeFinditem(new Finditem(lDate, lAddress, lContent,lPicture, lHashtag, writer));
			response.sendRedirect("main.do");
			return;
		}
		if(type.equals("2")){
			LostitemDAO lostitemDao = new LostitemDAOImpl();
			lostitemDao.writeLostitem(new Lostitem(lDate, lAddress, lContent, lPicture, lHashtag, writer));
			response.sendRedirect("main.do");
		
		return;
		}
	}
}
