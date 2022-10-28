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

@WebServlet("/searchQna.do")
public class SearchQnaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TextDao tDao = TextDao.getInstance();
		TextVo tVo = new TextVo();
		
		// 기본 값 설정
		String column = "제목";	
		String keyword = "";
		int page = 1;
		// 키워드가 비어 있는 경우를 대비하여 컬럼과 키워드 값 임시 저장
		String t_column = request.getParameter("column"); 
		String t_keyword = request.getParameter("keyword");
		String t_page = request.getParameter("p");
		// null 값이 아닌 경우
		if(t_column != null && !t_column.equals(""))
			column = t_column;
		if(t_keyword != null && !t_column.equals(""))
			keyword = t_keyword;
		if(t_page != null && !t_page.equals("")) 
			page = Integer.parseInt(t_page);
		
		
		System.out.println("col : " + column);
		System.out.println("key : " + keyword);		
		
		// 컬럼과 키워드를 사용하여 DB로부터 검색한 결과 리스트를 반환하고 전달
		List<TextVo> textList = tDao.getTextList(column, keyword, page);
		int count = tDao.getTextCount(column, keyword);
		request.setAttribute("textList", textList);
		request.setAttribute("count", count);
		System.out.println(count);
		// 포워드 방식으로 페이지 이동
		request.getRequestDispatcher("./board/qna.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
