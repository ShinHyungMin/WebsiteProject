package com.shop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.dao.TextDao;
import com.shop.dto.TextVo;

@WebServlet("/searchText.do")
public class SearchTextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TextDao tDao = TextDao.getInstance();
		// 기본 값 설정
		String column = "num";	
		String keyword = "";
		int page = 1;
		
		System.out.println("col : " + column);
		System.out.println("key : " + keyword);		
		
		// 컬럼과 키워드를 사용하여 DB로부터 검색한 결과 리스트를 반환하고 전달
		List<TextVo> textList = tDao.getTextList(column, keyword, page);
		request.setAttribute("textList", textList);
		
		// 포워드 방식으로 페이지 이동
		request.getRequestDispatcher("qna.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
