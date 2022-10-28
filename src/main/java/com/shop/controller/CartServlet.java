package com.shop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.dao.ProductDao;
import com.shop.dto.ProductVo;

@WebServlet("/cart.do")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			ProductDao pDao = ProductDao.getInstance();
			ProductVo cVo = new ProductVo();
			//모든 상품 리스트를 디비로 부터 조회하야 저장
			List<ProductVo> cartList = pDao.selectcart();
			request.setAttribute("cartList", cartList);
			String name = request.getParameter("name");
			
			
			System.out.println(cartList);
			System.out.println(cartList.size());
			System.out.println(cVo.getName());
			System.out.println(name);
			
			
			if(cVo.getName() == name ) {
				
			}
			
			//리스트 페이지로 이동
			RequestDispatcher dispatcgher = request.getRequestDispatcher("html/cart.jsp");
			dispatcgher.forward(request, response);

		}


	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		 

		
		


	}

}
