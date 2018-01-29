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
		request.setCharacterEncoding("utf-8"); // for �ѱ�
		System.out.println("===== write.do ���� =====");
		
		//���� ���
		String savePath = request.getServletContext().getRealPath("resources");
		
		// ���� ũ�� 15MB�� ����
		int sizeLimit = 1024*1024*15;
		MultipartRequest multi = new MultipartRequest(request, savePath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());
		
		// ���۹��� �����Ͱ� ������ ��� getFilesystemName()���� ���� �̸��� �޾ƿ� �� �ִ�.
		 
		// ���ε��� ������ ��ü ��θ� DB�� �����ϱ� ����
		
		
		String type = multi.getParameter("itemType"); // ���� ��ġ �޶���
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
