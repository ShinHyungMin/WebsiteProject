package com.shop.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.dao.TextDao;
import com.shop.dto.TextVo;

@WebServlet("/qnaDetail.do")
public class QnaDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		int num = Integer.parseInt(request.getParameter("num"));
		out.print(num);
		
		TextDao tDao = TextDao.getInstance();
		tDao.increaseViewCnt(num);
		TextVo tVo = new TextVo();
	
		tVo = tDao.selectTextByNum(num);
		System.out.println("t1 : " + tVo);
		request.setAttribute("text", tVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("./board/qnaDetail.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
