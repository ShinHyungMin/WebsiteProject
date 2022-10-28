package com.shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.dao.TextDao;
import com.shop.dto.TextVo;

@WebServlet("/qnaDelete.do")
public class QnaDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 게시글 삭제 코드 : 데이터베이스에서 게시글 삭제
		
		TextDao tDao = TextDao.getInstance();
		TextVo tVo = new TextVo();
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		// DB로부터 해당 코드의 정보를 삭제
		tDao.deleteText(num);
		
		// 삭제 후 목록 페이지로 이동
		response.sendRedirect("qnaList.do");
	}

}
