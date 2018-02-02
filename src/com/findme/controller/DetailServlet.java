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

@WebServlet("/detail.do")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // for
		System.out.println("====== DetailServlet 진입");
		int fId = Integer.parseInt(request.getParameter("fId"));

		FinditemDAO finditemDao = new FinditemDAOImpl();
		Finditem finditem = finditemDao.getFinditemByFId(fId);
		JSONObject tmpJobj = new JSONObject();

		tmpJobj.put("fId", finditem.getfId());
		tmpJobj.put("fDate", finditem.getfDate());
		tmpJobj.put("fAddress", finditem.getfAddress());
		tmpJobj.put("fContent", finditem.getfContent());
		tmpJobj.put("fPicture", finditem.getfPicture());
		tmpJobj.put("fHashtag", finditem.getfHashtag());
		tmpJobj.put("fUpDate", finditem.getfUpDate());
		tmpJobj.put("fDone", finditem.getfDone());
		tmpJobj.put("writer", finditem.getWriter());

		System.out.println("*** finditem : " + finditem);

		// System.out.println("*** list(1) : " + finditemList.get(1));

		request.setAttribute("finditem", tmpJobj);
		request.getRequestDispatcher("detail.jsp").forward(request, response);
	}

}
