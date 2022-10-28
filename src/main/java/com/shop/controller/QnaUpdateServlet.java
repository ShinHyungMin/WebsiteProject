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

@WebServlet("/qnaUpdate.do")
public class QnaUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 쿼리스트링으로 전달 받은 num 획득
		int num = Integer.parseInt(request.getParameter("num"));
		
		// 게시글 수정 링크 클릭 시 삭제할 게시글 정보를 표시
		TextDao tDao = TextDao.getInstance();
		TextVo tVo = new TextVo();
		
		// DB에서 수정할 데이터 정보 확인
		tVo = tDao.selectTextByNum(num);
		
		request.setAttribute("text", tVo);
		
		// 페이지 이동 : 수정 페이지
//		데이터를 안갖고 넘어갈 시 send, 갖고넘어갈 시 forward
		RequestDispatcher dispatcher = request.getRequestDispatcher("./board/qnaUpdate.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 게시글 수정 코드 : 데이터베이스에서 게시글 수정
		TextDao tDao = TextDao.getInstance();
		TextVo tVo = new TextVo();
		MemberDao mDao = MemberDao.getInstance();
		MemberVo mVo = new MemberVo();
		
		// 파일 업로드 코드 작성
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
			// 입력 양식을 통해 정보를 획득
			int num = Integer.parseInt(multi.getParameter("num"));
			String title = multi.getParameter("bbsTitle");
			String content = multi.getParameter("bbsContent");
			int viewCnt = Integer.parseInt(multi.getParameter("viewCnt"));
			HttpSession session = request.getSession();
			String userId = (String)session.getAttribute("userId");
			
			// 수정된 게시글 Vo에 저장
			tVo.setNum(num);
			tVo.setTitle(title);
			tVo.setContent(content);
			mVo.setUserid(userId);
			tVo.setViewCnt(viewCnt);
			
			System.out.println("1 =" + tVo);

		} catch(Exception e) {
			System.out.println("파일 업로드 예외 발생 : " + e);
		}
		
		// DB의 해당 코드의 정보를 수정
		result = tDao.updateText(tVo, mVo);		// 입력된 게시글 정보 삽입
		System.out.println("2 =" + tVo);
		// 정상적인 게시글 등록 여부를 확인/ 정상 등록 메세지를 브라우저 출력 위해 속성값 저장
		if(result == 1) {
			System.out.println("상품이 수정되었습니다.");
//			request.setAttribute("message", "게시글이 등록되었습니다.");
		} else {
			System.out.println("상품 수정이 취소되었습니다.");
//			request.setAttribute("message", "게시글 등록이 취소되었습니다.");
		}
		response.sendRedirect("qnaList.do");		// 게시글 등록 후 리스트 확인 위해 페이지 이동
		
	}

}
