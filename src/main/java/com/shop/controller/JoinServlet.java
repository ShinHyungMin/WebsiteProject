package com.shop.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.dao.MemberDao;
import com.shop.dto.MemberVo;

@WebServlet("/join.do")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("회원가입");
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/sign_up.jsp");
		dispatcher.forward(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");		// post 방식 한글 설정
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();	
		
		// 회원 가입에서 작성한 데이터를 데이터 베이스에 삽입(insert)
		
		String name = request.getParameter("name");		// 입력양식으로부터 이름 획득
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
//		String admin = request.getParameter("admin");
//		int admin = Integer.parseInt(request.getParameter("admin"));
		
		
//		System.out.println(admin);
		
		MemberDao mDao = MemberDao.getInstance();		// DB 연동
		
		MemberVo mVo =  new MemberVo();
		mVo.setName(name);				// MemberVo 클래스에 정보 저장 
		mVo.setUserid(userid);
		mVo.setPwd(pwd);
		mVo.setEmail(email);
		mVo.setPhone(phone);
//		mVo.setAdmin(admin);
		System.out.println(mVo.getName());
		System.out.println(mVo.getAdmin());
		
//		mDao.insertMember(name, userid, pwd, email, phone, admin);
		int result = mDao.insertMember(mVo);
		if (result == 1) {
			System.out.println("회원가입 성공");
		} else {
			System.out.println("회원가입 실패");
		}
		System.out.println("회원가입 성공");
//		System.out.println(admin);
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/login.jsp");
		dispatcher.forward(request, response);	
		
		
	}

}
