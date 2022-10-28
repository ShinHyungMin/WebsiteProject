package com.shop.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.dao.MemberDao;
import com.shop.dto.MemberVo;


@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 페이지 이동(forward 방식)
		RequestDispatcher dispatcher;
		dispatcher = request.getRequestDispatcher("member/login.jsp");
		dispatcher.forward(request,response);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");		// post 방식 한글 설정
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();		// 웹페이지 출력 처리
		
		String url = "../index.jsp";
		
		MemberDao mDao = MemberDao.getInstance();			// 데이터 베이스 연동
		
		String userId = request.getParameter("userId");		// 입력양식으로 부터 가져온 아이디
		String userPwd = request.getParameter("userPwd");
		String name = request.getParameter("name");
		
		// 디비 연동 후, 가져올 아이디/암호
//		String id = "kenneth";
		int result = mDao.checkUser(userId, userPwd);		// DB 사용자 확인
		System.out.println("result1 : " + result);
		if(result == 1) {
			System.out.println("암호 일치");
			url = "index.jsp";
			HttpSession session = request.getSession();
			
			MemberVo mVo = mDao.getMember(userId);
			System.out.println("회원 이름:" + mVo.getName());
			session.setAttribute("userId", mVo.getUserid());
			request.setAttribute("name", mVo.getName());
			request.setAttribute("id", mVo.getUserid());
			
			System.out.println("result2 : " + result);
			request.setAttribute("loginUser", mVo);
			System.out.println("로그인 확인 : " + mVo.getUserid());
			if(mVo.getUserid().equals("realhm")) {
				url = "manager/main/mainList.jsp";
			} else {
				url = "./index.jsp";
			}
			
			
		} else if(result == 0) {
			System.out.println("암호 불일치");
			url = "/member/login.jsp";
		} else {
			System.out.println("존재하지 않는 회원");
			url = "/member/login.jsp";
		}
		
		RequestDispatcher dispatcher;
		dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request,response);

	}

}
