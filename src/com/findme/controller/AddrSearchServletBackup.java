package com.findme.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import com.findme.model.dao.FinditemDAO;
import com.findme.model.dao.FinditemDAOImpl;
import com.findme.model.vo.Finditem;

@WebServlet("/addrSearch2.do")
public class AddrSearchServletBackup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("====== AddrSearchServlet 진입");
		String address = request.getParameter("addrInput");
		String bname = request.getParameter("searchBname");
		System.out.println("*** address : " + address + " / bname : " + bname);
		System.out.println();
		
		ArrayList<Finditem> finditemList = new ArrayList<Finditem>();
		FinditemDAO finditemDao = new FinditemDAOImpl();
		
		int markerLen = finditemDao.finditemCountAll();
		System.out.println("*** count : " + finditemDao.finditemCountAll());
		finditemList = finditemDao.getFinditemByAddress(bname);
		System.out.println("*** list(1) : " + finditemList.get(1));
		
		
		
		request.setAttribute("address", address);
		request.setAttribute("markerLen", markerLen);
		request.setAttribute("finditemList", finditemList); //마커리스트
		request.getRequestDispatcher("map.jsp").forward(request, response);
	}*/

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // for
		System.out.println("====== AddrSearchServlet 진입");
		String address = request.getParameter("addrInput");
		String bname = request.getParameter("searchBname");
		System.out.println("*** address : " + address + " / bname : " + bname);
		System.out.println();
		
		ArrayList<Finditem> finditemList = new ArrayList<Finditem>();
		FinditemDAO finditemDao = new FinditemDAOImpl();
		System.out.println("*** count : " + finditemDao.finditemCountAll());
		finditemList = finditemDao.getFinditemByAddress(bname);
		
		for (int i = 0; i < finditemList.size(); i++) {
			System.out.println("*** list : " + finditemList.get(i));
		}
		//System.out.println("*** list(1) : " + finditemList.get(1));
		
		request.setAttribute("address", address);
		request.setAttribute("markerList", finditemList); //마커리스트
		request.getRequestDispatcher("map.jsp").forward(request, response);
	}

}
