package com.shop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.shop.dao.MemberDao;
import com.shop.dao.TextDao;
import com.shop.dto.MemberVo;
import com.shop.dto.TextVo;

@WebServlet("/qnaWrite.do")
public class QnaWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("./board/qnaWrite.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		TextDao tDao = TextDao.getInstance();
		TextVo tVo = new TextVo();
		MemberDao mDao = MemberDao.getInstance();
		MemberVo mVo = new MemberVo();
		
		int result = -1;
		String savePath = "upload";
		ServletContext context = getServletContext();			// 이 서블릿이 실행되고 있는 컨택스트 가져오기
		String uploadFilePath = context.getRealPath(savePath);	// 실제 경로를 리턴
		System.out.println("저장파일 서버경로 : " + uploadFilePath);
		int uploadFileSizeLimit = 5 * 1024 * 1024;
		String encType = "UTF-8";
		
		try {
			MultipartRequest multi = new MultipartRequest(
					request,							// request 객체
					uploadFilePath,						// 서버상의 실제 디렉토리
					uploadFileSizeLimit,				// 최대 업로드 파일 크기
					encType,							// 인코딩 방식
					new DefaultFileRenamePolicy()		// 정책 : 동일 이름 존재 시, 새로운 이름 부여
					);
			System.out.println("HI ");
			// 입력 양식을 통해 정보를 획득
			String title = multi.getParameter("bbsTitle");
			String content = multi.getParameter("bbsContent");
			String fileP = multi.getFilesystemName("fileP");
			
			System.out.println("title: " + title);
			System.out.println("content: " + content);
			
			HttpSession session = request.getSession();
			String userId = (String)session.getAttribute("userId");
			
			System.out.println("userId: " + userId);
			
			// 입력된 게시글을 Vo에 저장
			tVo.setTitle(title);
			tVo.setContent(content);
			tVo.setFileP(fileP);
			mVo.setUserid(userId);
			
			System.out.println(tVo);
			System.out.println(mVo);


		} catch(Exception e) {
			System.out.println("파일 업로드 예외 발생 : " + e);
		} 
		System.out.println(tVo);
		System.out.println(mVo);
		result = tDao.insertText(tVo, mVo);		// 입력된 상품 정보 삽입
		

		
		// 정상적인 상품 등록 여부를 확인/ 정상 등록 메세지를 브라우저 출력 위해 속성값 저장
		if(result == 1) {
			System.out.println("작성글이 게시되었습니다.");
//			request.setAttribute("message", "상품이 등록되었습니다.");
		} else {
			System.out.println("글을 다시 작성해주세요.");
//			request.setAttribute("message", "상품이 등록이 취소되었습니다.");
		}
		response.sendRedirect("qnaList.do");		// 상품 등록 후 리스트 확인 위해 페이지 이동
		
	}

}
