package com.shop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.dao.ProductDao;
import com.shop.dto.ProductVo;

@WebServlet("/searchProduct.do")
public class SearchProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDao pDao = ProductDao.getInstance();
		System.out.println("t_keyword");
		String column = "content";
		String keyword = "2";
		
		String t_column = request.getParameter("column");
		String t_keyword = request.getParameter("keyword");
		
		if(t_column != null) {
			column = t_column;
		}
		if(t_keyword != null) {
			System.out.println("t_keyword" + t_keyword);
			System.out.println("keyword" + keyword);
			keyword = t_keyword;
		}
		
		
		List<ProductVo> productList = pDao.searchProduct(column, keyword);
		request.setAttribute("productList", productList);
		
		request.getRequestDispatcher("productList.do").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
