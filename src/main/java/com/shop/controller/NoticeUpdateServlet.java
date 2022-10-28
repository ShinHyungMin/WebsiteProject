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
import com.shop.dao.NoticeDao;
import com.shop.dao.TextDao;
import com.shop.dto.MemberVo;
import com.shop.dto.TextVo;

@WebServlet("/noticeUpdate.do")
public class NoticeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 쿼리스트링으로 전달 받은 num 획득
		int num = Integer.parseInt(request.getParameter("num"));
		
		// 공지사항 수정 링크 클릭 시 삭제할 공지사항을 표시
		NoticeDao nDao = NoticeDao.getInstance();
		TextVo tVo = new TextVo();
		
		// DB에서 수정할 데이터 정보 확인
		tVo = nDao.selectNoticeByNum(num);
		
		request.setAttribute("notice", tVo);
		
		// 페이지 이동 : 수정 페이지
//		데이터를 안갖고 넘어갈 시 send, 갖고넘어갈 시 forward
		RequestDispatcher dispatcher = request.getRequestDispatcher("./board/noticeUpdate.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 공지사항 수정 코드 : 데이터베이스에서 상품 수정
		NoticeDao nDao = NoticeDao.getInstance();
		TextVo tVo = new TextVo();
		
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
			
			// 수정된 공지사항을 Vo에 저장
			tVo.setNum(num);
			tVo.setTitle(title);
			tVo.setContent(content);
			tVo.setViewCnt(viewCnt);
			
			System.out.println("1 =" + tVo);

		} catch(Exception e) {
			System.out.println("파일 업로드 예외 발생 : " + e);
		}
		
		// DB의 해당 코드의 정보를 수정
		result = nDao.updateNotice(tVo);		// 입력된 공지사항 삽입
		System.out.println("2 =" + tVo);
		// 정상적인 공지사항 등록 여부를 확인/ 정상 등록 메세지를 브라우저 출력 위해 속성값 저장
		if(result == 1) {
			System.out.println("공지사항이 수정되었습니다.");
//			request.setAttribute("message", "공지사항이 등록되었습니다.");
		} else {
			System.out.println("공지사항 수정이 취소되었습니다.");
//			request.setAttribute("message", "공지사항 등록이 취소되었습니다.");
		}
		response.sendRedirect("noticeList.do");		// 공지사항 등록 후 리스트 확인 위해 페이지 이동
	}

}
