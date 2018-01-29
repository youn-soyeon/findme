package com.findme.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.findme.model.dao.FinditemDAO;
import com.findme.model.dao.FinditemDAOImpl;
import com.findme.model.dao.LostitemDAO;
import com.findme.model.dao.LostitemDAOImpl;
import com.findme.model.vo.Finditem;
import com.findme.model.vo.Lostitem;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/write.do")
public class WriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // for 한글
		System.out.println("===== write.do 진입 =====");
		
		//파일 경로
		String savePath = request.getServletContext().getRealPath("resources");
		
		// 파일 크기 15MB로 제한
		int sizeLimit = 1024*1024*15;
		MultipartRequest multi = new MultipartRequest(request, savePath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());
		
		// 전송받은 데이터가 파일일 경우 getFilesystemName()으로 파일 이름을 받아올 수 있다.
		 
		// 업로드한 파일의 전체 경로를 DB에 저장하기 위함
		
		
		String type = multi.getParameter("itemType"); // 저장 위치 달라짐
		String lDate = multi.getParameter("itemDate");
		String lAddress = multi.getParameter("itemAddress");
		String lContent = multi.getParameter("itemContents");
		String lPicture = multi.getFilesystemName("itemPicture");
		String lHashtag = multi.getParameter("itemHashtag");
		String writer = "test";
		
		
		System.out.println("itemType : " + type);
		System.out.println("itemDate : " + lDate);
		System.out.println("itemAddress : " + lAddress);
		System.out.println("itemContents : " + lContent);
		System.out.println("itemPicture : " + lPicture);
		System.out.println("itemhashtag : " + lHashtag);
		System.out.println("itemWriter : " + writer);

		
		//memberDTO.setM_fileFullPath(m_fileFullPath);
		//memberDTO.setM_fileName(fileName);
		
		if(type.equals("1")){
			FinditemDAO FinditemDao = new FinditemDAOImpl();
			FinditemDao.writeFinditem(new Finditem(lDate, lAddress, lContent, savePath + "/" + lPicture, lHashtag, "test"));
			response.sendRedirect("main.jsp");
			return;
		}
		if(type.equals("2")){
			LostitemDAO lostitemDao = new LostitemDAOImpl();
			lostitemDao.writeLostitem(new Lostitem(lDate, lAddress, lContent, lPicture, lHashtag, "test"));
			response.sendRedirect("main.jsp");
		
		return;
		}
	}
}
