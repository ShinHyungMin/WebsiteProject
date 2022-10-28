package com.shop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.dao.NoticeDao;
import com.shop.dto.TextVo;

@WebServlet("/searchNotice.do")
public class SearchNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeDao nDao = NoticeDao.getInstance();
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
		if(t_keyword != null && !t_keyword.equals(""))
			keyword = t_keyword;
		if(t_page != null && !t_page.equals("")) 
			page = Integer.parseInt(t_page);
		
		System.out.println("col : " + column);
		System.out.println("key : " + keyword);		
		
		// 컬럼과 키워드를 사용하여 DB로부터 검색한 결과 리스트를 반환하고 전달
		List<TextVo> noticeList = nDao.getNoticeList(column, keyword, page);
		int count = nDao.getNoticeCount(column, keyword);
		request.setAttribute("noticeList", noticeList);
		request.setAttribute("count", count);
		
		// 포워드 방식으로 페이지 이동
		request.getRequestDispatcher("./board/notice.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
