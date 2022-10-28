package com.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shop.dto.MemberVo;
import com.shop.dto.TextVo;
import com.shop.util.DBManager;

public class TextDao {
	private TextDao() {
		
	}
	
	private static TextDao instance = new TextDao();
	
	public static TextDao getInstance() {
		return instance;
	}
	
	// 게시글 작성
	public int insertText(TextVo tVo, MemberVo mVo) {
		int result = -1;
		Connection conn = null;
		// 동일한 쿼리문을 특정 값만 바꿔서 여러번 실행해야 할 때, 매개변수가 많아서 
		PreparedStatement pstmt = null;		// 동적 쿼리
		
		String sql_insert = "insert into text values(text_seq.nextval, ?, ?, ?, sysdate, ?, ?)";
		
		try {
			conn = DBManager.getConnection();
			// (3단계) Statement 객체 생성
			pstmt = conn.prepareStatement(sql_insert);

			System.out.println(tVo.getTitle());
			System.out.println(tVo.getContent());
			System.out.println(mVo.getUserid());
			System.out.println(tVo.getViewCnt());
			System.out.println(tVo.getFileP());
			
			pstmt.setString(1, tVo.getTitle());
			pstmt.setString(2, tVo.getContent());
			pstmt.setString(3, mVo.getUserid());		
			pstmt.setInt(4, tVo.getViewCnt());	
			pstmt.setString(5, tVo.getFileP());
			
			// (4단계) SQL문 실행 및 결과 처리
			// executeUpdate : 삽입(insert/update/delete)
//			result = stmt.executeUpdate(sql_insert);
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}	
		return result;
	}
	
	// 게시글 조회
	public List<TextVo> selectAllText() {
		String sql = "select * from text order by num desc";
		
		List<TextVo> list = new ArrayList<TextVo>();		// List 컬랙션 객체 생성
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			
			// (3단계) Statement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// (4단계) SQL문 실행 및 결과 처리
			// executeQuery : 조회(select)
			rs = pstmt.executeQuery();

			//1.rs.next() : 다음 행(row)을 확인  -  2.rs.getString("컬럼명")
			while(rs.next()) {
				// rs.getInt(컬럼명);
				TextVo tVo = new TextVo();
				// 디비로부터 회원 정보 획득
//				System.out.println(tVo);
				tVo.setNum(rs.getInt("num"));		// 컬럼명 code인 정보를 가져옴
				tVo.setTitle(rs.getString("title"));
				tVo.setContent(rs.getString("content"));
				tVo.setUserId(rs.getString("userId"));
				tVo.setReg_date(rs.getDate("reg_date"));
				tVo.setViewCnt(rs.getInt("viewCnt"));
				
//				System.out.println(tVo);
				
				list.add(tVo);		// list 객체에 데이터 추가
			}
		} catch(Exception e) {	
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	// 단일 게시글 조회
	public TextVo selectTextByNum(int num) {
		
		String sql = "select * from text where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		TextVo tVo = null;
		
		try {
			conn = DBManager.getConnection();
			
			// (3단계) Statement 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			// (4단계) SQL문 실행 및 결과 처리
			// executeQuery : 조회(select)
			rs = pstmt.executeQuery();

			//1.rs.next() : 다음 행(row)을 확인  -  2.rs.getString("컬럼명")
			while(rs.next()) {
				// rs.getInt(컬럼명);
				tVo = new TextVo();
				// 디비로부터 회원 정보 획득
				tVo.setNum(rs.getInt("num"));		// 컬럼명 code인 정보를 가져옴
				tVo.setTitle(rs.getString("title"));
				tVo.setContent(rs.getString("content"));
				tVo.setUserId(rs.getString("userId"));
				tVo.setReg_date(rs.getDate("reg_date"));
				tVo.setViewCnt(rs.getInt("viewCnt"));
				tVo.setFileP(rs.getString("fileP"));
			}
		} catch(Exception e) {	
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return tVo;
	}	
	
	// 게시글 수정 (
	public int updateText(TextVo tVo, MemberVo mVo) {
		int result = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update text set title=?, content=?, userId=?, reg_date=sysdate, viewCnt=?, fileP=? where num=?";
		
		System.out.println("3 =" + tVo);
		System.out.println("4 =" + mVo);
		try {
			conn = DBManager.getConnection();
			
			// (3단계) Statement 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tVo.getTitle());
			pstmt.setString(2, tVo.getContent());
			pstmt.setString(3, mVo.getUserid());
			pstmt.setInt(4, tVo.getViewCnt());
			pstmt.setString(5, tVo.getFileP());
			pstmt.setInt(6, tVo.getNum());
			
			
			// (4단계) SQL문 실행 및 결과 처리
			// executeQuery : 조회(select)
			result = pstmt.executeUpdate();		// 쿼리 수행		
			System.out.println(result);
		} catch(Exception e) {	
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}	
		return result;
		
	}
	
	// 게시글 삭제
	public void deleteText(int num) {
		
		int result = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "delete from text where num=?";
		
		try {
			conn = DBManager.getConnection();
			
			// (3단계) Statement 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			// (4단계) SQL문 실행 및 결과 처리
			// executeQuery : 조회(select)
			result = pstmt.executeUpdate();		// 쿼리 수행
		} catch(Exception e) {	
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

	}	
	
	// 조회수 증가
	public void increaseViewCnt(int num) {
		
		int result = -1;
		String sql = "UPDATE text SET viewCnt = viewCnt+1 WHERE num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			result = pstmt.executeUpdate();
			System.out.println("조회수 1 증가");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	/*
	 * // 게시판 검색 public List<TextVo> searchText(String column, String keyword) { //
	 * 안되는 예시 sql = "select * from product where ? like ? order by code"; // 안되는 예시
	 * sql = "select * from product where 'code' like '%사과%' order by code"; String
	 * sql = "select * from text where "+ column +" like ? order by num";
	 * 
	 * List<TextVo> list = new ArrayList<TextVo>();
	 * 
	 * Connection conn = null; PreparedStatement pstmt = null; ResultSet rs = null;
	 * try { conn = DBManager.getConnection();
	 * 
	 * // (3단계) Statement 객체 생성 pstmt = conn.prepareStatement(sql);
	 * pstmt.setString(1, "%" + keyword + "%");
	 * 
	 * // (4단계) SQL문 실행 및 결과 처리 // executeQuery : 조회(select) rs =
	 * pstmt.executeQuery();
	 * 
	 * //1.rs.next() : 다음 행(row)을 확인 - 2.rs.getString("컬럼명") while(rs.next()) { //
	 * rs.getInt(컬럼명); TextVo tVo = new TextVo(); // 디비로부터 회원 정보 획득
	 * tVo.setNum(rs.getInt("num")); // 컬럼명 num인 정보를 가져옴
	 * tVo.setTitle(rs.getString("title")); tVo.setContent(rs.getString("content"));
	 * tVo.setUserId(rs.getString("userId"));
	 * tVo.setReg_date(rs.getDate("reg_date"));
	 * tVo.setViewCnt(rs.getInt("viewCnt")); tVo.setFileP("fileP");
	 * 
	 * 
	 * // System.out.println(rs.getInt("code"));
	 * 
	 * list.add(tVo); // list 객체에 데이터 추가 } } catch(Exception e) {
	 * e.printStackTrace(); } finally { DBManager.close(conn, pstmt, rs); } return
	 * list; }
	 */

	// 페이징 처리
	// 한페이지에 10개의 게시물 표시
	// 게시판 하단에 페이지 표시
	public List<TextVo> getTextList(){
		return getTextList("title", "", 1);
	}
	public List<TextVo> getTextList(int page){
		return getTextList("title", "", page);
	}	
	public List<TextVo> getTextList(String column, String keyword, int page){
		String sql = "SELECT * FROM ("
				+ "SELECT  ROWNUM N, b.* "
				+ "FROM    (SELECT * FROM text where "+column+" like ? order by num desc) b"
				+ ") "
				+ "WHERE   N BETWEEN ? AND ?";
		
//		첫쨰 ? => 1, 11, 21, 31, 41 : 1+10(page-1)
//		둘쨰 ? =>10, 20, 30, 40, 50 : 10*page
		
		TextVo tVo = null;
		List<TextVo> list = new ArrayList<TextVo>();		// List 컬랙션 객체 생성
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			
			// (3단계) Statement 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+ keyword +"%");
			pstmt.setInt(2, 1+10*(page-1));
			pstmt.setInt(3, 10*page);
			// (4단계) SQL문 실행 및 결과 처리
			// executeQuery : 조회(select)
			rs = pstmt.executeQuery();

			//1.rs.next() : 다음 행(row)을 확인  -  2.rs.getString("컬럼명")
			while(rs.next()) {
				// rs.getInt(컬럼명);
				tVo = new TextVo();
				// 디비로부터 회원 정보 획득
//				System.out.println(tVo);
				tVo.setNum(rs.getInt("num"));		// 컬럼명 num인 정보를 가져옴
				tVo.setTitle(rs.getString("title"));
				tVo.setContent(rs.getString("content"));
				tVo.setUserId(rs.getString("userId"));
				tVo.setReg_date(rs.getDate("reg_date"));
				tVo.setViewCnt(rs.getInt("viewCnt"));
				tVo.setFileP(rs.getString("fileP"));
				
				list.add(tVo);		// list 객체에 데이터 추가
			}
		} catch(Exception e) {	
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}	

	// 게시물 수 조회
	public int getTextCount() {
		return getTextCount("title", "");
	}
	// 특정 컬럼의 키워드를 통해 게시물 수 조회
	public int getTextCount(String column, String keyword) {
		int count = 0;
		System.out.println("column2 : " + column);
		System.out.println("keyword2 : " + keyword);
//		String sql = "SELECT COUNT(num) count FROM ("
//				+ "SELECT ROWNUM N, b.* "
//				+ "FROM (SELECT * FROM text where "+column+" like ? order by num desc) b"
//				+ ") ";
		String sql = "SELECT COUNT(num) count FROM (SELECT ROWNUM N, b.* FROM (SELECT * FROM text where "+column+" like ? order by num desc) b"
				+ ")";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			
			// (3단계) Statement 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+ keyword +"%");
			
			// (4단계) SQL문 실행 및 결과 처리
			// executeQuery : 조회(select)
			rs = pstmt.executeQuery();
			//1.rs.next() : 다음 행(row)을 확인  -  2.rs.getString("컬럼명")
			if(rs.next()) {
				count = rs.getInt("count");
			}
		} catch(Exception e) {	
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}		
		System.out.println("c3 : " + count);
		return count;
	}
		
	// 게시물 번호로 특정 게시물 다음 게시물 데이터 조회
	public TextVo getNextText(int num) {
		TextVo tVo = null;
		return tVo;
	}
	// 게시물 번호로 특정 게시물 이전 게시물 데이터 조회
	public TextVo getPrevText(int num) {
		TextVo tVo = null;
		return tVo;		
	}	
}


