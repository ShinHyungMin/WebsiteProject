package com.shop.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.dao.ProductDao;
import com.shop.dto.ProductVo;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/updateProduct.do")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
//		out.print(code);
		
		ProductDao pDao = ProductDao.getInstance();
		ProductVo pVo = new ProductVo();
		
		pVo = pDao.selectProductByCode(code);
		
		System.out.println(pVo);
		
		request.setAttribute("product", pVo);
	
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/manager/product/updateProduct.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 ProductDao pDao = ProductDao.getInstance();
	      ProductVo pVo = new ProductVo();

	      int result = -1;
	      String savePath = "upload";
	      ServletContext context = getServletContext();         // 이 서블릿이 실행되고 있는 컨택스트 가져오기
	      String uploadFilePath = context.getRealPath(savePath);   // 실제 경로를 리턴
	      System.out.println("저장파일 서버경로: " + uploadFilePath);
	      int uploadFileSizeLimit = 5 * 1024 * 1024;
	      String encType = "UTF-8";
	      
	      try {
	         MultipartRequest multi = new MultipartRequest(
	               request,                  // request 객체
	               uploadFilePath,             // 서버상의 실제 디렉토리
	               uploadFileSizeLimit,          // 최대 업로드 파일 크기
	               encType,                  // 인코딩 방식
	               new DefaultFileRenamePolicy());   // 정책 : 동일한 이름이 존재하면 새로운 이름이 부여됨
	         
	         // 입력 양식을 통해 정보를 획득
	         int code = Integer.parseInt(multi.getParameter("code"));
	         String name = multi.getParameter("name");
	         int price = Integer.parseInt(multi.getParameter("price"));
	         String description = multi.getParameter("description");
	         String pictureurl = multi.getFilesystemName("pictureurl");
	         Date reg_date = Date.valueOf(multi.getParameter("reg_date"));
	         
	         pVo.setCode(code);   // 수정된 상품 정보 Vo에 저장
	         pVo.setName(name);
	         pVo.setPrice(price);
	         pVo.setDescription(description);
	         pVo.setPictureurl(pictureurl);
	         pVo.setReg_date(reg_date);
	         
	      } catch(Exception e) {
	         System.out.println("파일 업로드 예외 발생: "+ e);
	      }
	      
	      // DB로부터 해당 코드의 정보 삭제
	      pDao.updateProduct(pVo);
	      
	      // 정상적인 상품 등록 여부 확인 / 정상 등록 메세지를 브라우저에 출력을 위해 속성값 저장
	      if (result == 1) {
	         // 상품 등록 완료시, 상품 코드 저장
	         System.out.println("상품 수정 성공");
	         //request.setAttribute("message", "상품 등록 성공");
	      } else {
	         System.out.println("상품 수정 실패");
	         //request.setAttribute("message", "상품 등록 실패");
	      }

	      // 수정 후 목록 페이지로 이동
	      response.sendRedirect("productList.do");
	}

}
