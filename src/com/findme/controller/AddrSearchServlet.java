package com.findme.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.findme.model.dao.FinditemDAO;
import com.findme.model.dao.FinditemDAOImpl;
import com.findme.model.vo.Finditem;

@WebServlet("/addrSearch.do")
public class AddrSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("====== AddrSearchServlet ����");
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
		request.setAttribute("finditemList", finditemList); //��Ŀ����Ʈ
		request.getRequestDispatcher("map.jsp").forward(request, response);
	}*/

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // for
		System.out.println("====== AddrSearchServlet ����");
		String address = request.getParameter("addrInput");
		String bname = request.getParameter("searchBname");
		System.out.println("*** address : " + address + " / bname : " + bname);
		System.out.println();
		
		JSONArray finditemList = new JSONArray();
		ArrayList<Finditem> tmpList = new ArrayList<Finditem>();
		FinditemDAO finditemDao = new FinditemDAOImpl();
		
		System.out.println("*** count : " + finditemDao.finditemCountAll());
		tmpList = finditemDao.getFinditemByAddress(bname);
		
		for (int i = 0; i < tmpList.size(); i++) {
			JSONObject tmpJobj = new JSONObject();
			tmpJobj.put("fId", tmpList.get(i).getfId());
			tmpJobj.put("fDate", tmpList.get(i).getfDate());
			tmpJobj.put("fAddress", tmpList.get(i).getfAddress());
			tmpJobj.put("fContent", tmpList.get(i).getfContent());
			tmpJobj.put("fPicture", tmpList.get(i).getfPicture());
			tmpJobj.put("fHashtag", tmpList.get(i).getfHashtag());
			tmpJobj.put("fUpDate", tmpList.get(i).getfUpDate());
			tmpJobj.put("fDone", tmpList.get(i).getfDone());
			tmpJobj.put("writer", tmpList.get(i).getWriter());
			finditemList.add(tmpJobj);
		}
		
		

		for (int i = 0; i < finditemList.size(); i++) {
			System.out.println("** finditemList : " + finditemList.get(i).toString());
			
		}

		//System.out.println("*** list(1) : " + finditemList.get(1));
		
		request.setAttribute("address", address);
		request.setAttribute("markerList", finditemList.toString());
		request.getRequestDispatcher("map.jsp").forward(request, response);
	}

}
