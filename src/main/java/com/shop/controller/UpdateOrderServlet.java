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

@WebServlet("/updateOrder.do")
public class UpdateOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 쿼리스트링으로 전달 받은 code를 획득
		String code = request.getParameter("code");
		
		// 상품 수정 링크 클릭시 삭제할 상품 정보를 표시
		ProductDao pDao = ProductDao.getInstance();
		ProductVo pVo = new ProductVo();
				
		// 데이터베이스에서 수정할 데이터 정보 확인		
		pVo = pDao.selectProductByCode(code);
		
		request.setAttribute("product", pVo);
		
		// 페이지 이동 : 수정 페이지
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("manager/order/updateOrder.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 상품 수정 코드 : 데이터베이스에서 상품 수정
		ProductDao pDao = ProductDao.getInstance();
		ProductVo pVo = new ProductVo();
		
		// 파일 업로드 코드 작성
		int result = -1;
		String savePath = "upload";
		ServletContext context = getServletContext();			// 실행 서블릿의 컨택스트 가져오기
		String uploadFilePath = context.getRealPath(savePath);	// 실제 경로를 리턴
		System.out.println("저장파일 서버경로:"+ uploadFilePath);
		int uploadFileSizeLimit = 5 * 1024 * 1024;
		String encType = "UTF-8";
		
		try {
			MultipartRequest multi = new MultipartRequest(
					request,							// request 객체 
					uploadFilePath, 					// 서버상의 실제 디렉토리
					uploadFileSizeLimit,				// 최대 업로드 파일 크기
					encType,							// 인코딩 방식
					new DefaultFileRenamePolicy()		// 정책: 동일 이름 존재시, 새로운 이름 부여
					);
			// 입력 양식을 통해 정보를 획득 
			int code = Integer.parseInt(multi.getParameter("code"));
			String name = multi.getParameter("name");
			int price = Integer.parseInt(multi.getParameter("price"));
			String description = multi.getParameter("description");
			String pictureurl = multi.getFilesystemName("pictureurl");
			Date reg_date = Date.valueOf(multi.getParameter("reg_date"));
			String arrivalAdd = multi.getParameter("arrivalAdd");

			pVo.setCode(code);		// 수정된 상품 정보 Vo에 저장
			pVo.setName(name);			
			pVo.setPrice(price);
			pVo.setDescription(description);
			pVo.setPictureurl(pictureurl);
			pVo.setReg_date(reg_date);
			pVo.setArrivalAdd(arrivalAdd);

		} catch(Exception e) {
			System.out.println("파일 업로드간 예외 발생: " + e);			
		}
		// 데이터베이스의 해당 코드의 정보를 수정
		result = pDao.updateProduct(pVo);
		
		// 정상적인 상품 수정 여부를 확인 
		if(result == 1) {
			System.out.println("상품 수정에 성공했습니다.");
		} else {
			System.out.println("상품 수정에 실패했습니다.");
		}
		
		// 수정 후 목록 페이지로 이동
		response.sendRedirect("orderList.do");
	}
}
