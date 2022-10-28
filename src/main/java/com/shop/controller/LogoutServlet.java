package com.shop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout.do")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("logout.do");
//		RequestDispatcher dispatcher = request.getRequestDispatcher("member/sign_up.jsp");
//		dispatcher.forward(request, response);	
		HttpSession session = request.getSession();		// 세션 객체 생성
		session.invalidate(); 	//세션 종료(삭제)
		

		// 페이지 이동 -> login.jsp
//		response.sendRedirect("member/login.jsp"); // 리다이렉트 방식
		
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);		// 포워드 방식
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
