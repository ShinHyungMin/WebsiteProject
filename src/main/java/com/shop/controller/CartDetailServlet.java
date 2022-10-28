package com.shop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.dao.ProductDao;
import com.shop.dto.ProductVo;

@WebServlet("/cartDetail.do")
public class CartDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String code = request.getParameter("code");
//		out.print(code);
		
		ProductDao pDao = ProductDao.getInstance();
		ProductVo pVo = new ProductVo();
		
		pVo = pDao.selectProductByCode(code);
		
//		System.out.println(pVo);
		HttpSession session = request.getSession();
		Object obj = request.getAttribute("pVo");
		
		List<ProductVo> cartList = pDao.selectcart();
		request.setAttribute("cartList", cartList);
		
		cartList = null;
		if(obj == null) {	//세션 정보가 없으면 배열을 생성 : 최초 주문한 경우
			cartList = new ArrayList<ProductVo>();	
		} else {			//세션 정보가 있으면 강제로 캐스팅 : 추가 주문
			cartList = (ArrayList<ProductVo>) obj;
		}
		System.out.println("cartList :"+cartList);
		System.out.println("cartListsize :"+cartList.size());
		
		System.out.println("dvo name: "+pVo.getName());
		
		int pos = -1;	//등록된 제품이 없다
		//장바구니 세션에 동일한 제품이 있을 경우 : 수량(cnt) 증가
		for(int i = 0; i < cartList.size(); i++) {
			ProductVo dto = cartList.get(i);
			System.out.println("cnt : " + dto.getCnt());
			System.out.println("get i : " + cartList.get(i));
			
			if(dto.getName().equals(pVo.getName())) {
				System.out.println("dto name: "+dto.getName());
				System.out.println("dvo name: "+pVo.getName());
				pos = 1;
				dto.setCnt(dto.getCnt() + 1);
				break;
				}
			}
			System.out.println("pos: "+pos);
			if(pos == -1) {
	//			System.out.println(pVo.getName());
	//			System.out.println(pVo.getPictureurl());
	//			System.out.println(pVo.getPrice());
				pVo.setCode(pVo.getCode());
				pVo.setName(pVo.getName());
				pVo.setPictureurl(pVo.getPictureurl());
				pVo.setPrice(pVo.getPrice());	
				pVo.setCnt(1);	// 카트 수량 체크
				cartList.add(pVo);	// 상품 정보 카트 리스트에 저장
				pDao.insertCart(pVo);
			}
//		System.out.println(cart);
		
		System.out.println(cartList.size());
		System.out.println(cartList);
//		request.setAttribute("cart", cart);
		
		
		//모든 상품 리스트를 디비로 부터 조회하여 저장
		
		request.setAttribute("cartList", cartList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
