package com.shop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.dao.MemberDao;
import com.shop.dto.MemberVo;


@WebServlet("/updateMember.do")
public class UpdateMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	      String userid = request.getParameter("userid");
//	      System.out.println("userId: "+ userId);
	      
	      MemberDao mDao = MemberDao.getInstance();      //데이터베이스 연동
	      MemberVo mVo = mDao.getMember(userid);   //데이터베이스로부터 회원정보 로딩
	      
	      
//	      request.setAttribute("name", mVo.getName());
	      request.setAttribute("mVo", mVo);
	      
	      System.out.println("dhoqwkernknknfmakf");
	      
		  RequestDispatcher dispatcher;
		  dispatcher = request.getRequestDispatcher("manager/member/updateMember.jsp");
		  dispatcher.forward(request,response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		  String userid = request.getParameter("userid");
	      String pwd = request.getParameter("pwd");
	      String email = request.getParameter("email");
	      String phone = request.getParameter("phone");
	      
	      
	      MemberDao mDao = MemberDao.getInstance();
	      MemberVo mVo = new MemberVo();
	      
	      mVo.setPwd(pwd);
	      mVo.setEmail(email);
	      mVo.setPhone(phone);
	      mVo.setUserid(userid);
	      System.out.println("mVo 확인1 : " + mVo);
	      mDao.updateMember(mVo);
	      
	      response.sendRedirect("memberList.do");
	}

}
