package com.shop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.dao.TextDao;
import com.shop.dto.TextVo;

@WebServlet("/qnaList.do")
public class QnaListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		TextDao tDao = TextDao.getInstance();
		int page = 1;
		String t_page = request.getParameter("p");
		if(t_page != null && !t_page.equals("")) {
			page = Integer.parseInt(t_page);
		}
		// 모든 상품 리스트를 디비로부터 조회하여 저장
//		List<TextVo> textList = tDao.selectAllText();
		List<TextVo> textList = tDao.getTextList(page);
		int count = tDao.getTextCount();
		
		request.setAttribute("textList", textList);
		request.setAttribute("count", count);
		
		// 리스트 페이지 이동
		RequestDispatcher dispatcher = request.getRequestDispatcher("./board/qna.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
