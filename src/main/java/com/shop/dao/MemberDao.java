package com.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shop.dto.MemberVo;
import com.shop.util.DBManager;

public class MemberDao {
	
	//싱글톤 생성 및 사용
	// private, static 이용
	// 
	//필드
	private static MemberDao instance = new MemberDao();
	
	//생성자
	private MemberDao(){
		
	}
	
	//메소드
	public static MemberDao getInstance() {
		return instance;
	}
	
	
	// 로그인(사용자 인증)
		// 입력값: 로그인 페이지에서 입력받은 사용자아이디와 암호
		// 반환값: result (1:암호일치), (0:암호불일치), (-1:사용자아이디없음)
		public int checkUser(String userid, String pwd) {
			int result = -1;		
			Connection conn = null;
//			Statement stmt = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;		
			String sql = "select pwd from member1 where userid=?";	

			
			try {
				conn = DBManager.getConnection();
				// (3 단계) Statement 객체 생성
//				stmt = conn.createStatement();
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, userid);
				
				// (4 단계) SQL문 실행 및 결과 처리 => executeQuery : 조회(select)
//				rs = stmt.executeQuery(sql);
				rs = pstmt.executeQuery();
				// rs.next() : 다음 행(row)을 확인, rs.getString("컬럼명")
				if(rs.next()){
//					System.out.println(rs.getString("pwd"));	
					// 아이디/ 암호 비교 후 페이지 이동
					if(rs.getString("pwd")!=null &&
							rs.getString("pwd").equals(pwd)) {
						result = 1;		// 암호 일치
					} else {
						result = 0;		// 암호 불일치
					}
				} else {
					result = -1;		// 디비에 userid 없음
				}
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			
			return result;
		}
		
		// 회원 가입: DB에 회원 정보를 삽입
//		public int insertMember(String name, String id, String pwd, String email, String phone, int admin) {
		public int insertMember(MemberVo mVo) {
			int result = -1;
			Connection conn = null;
//			Statement stmt = null;				// 정적 쿼리
			// 동일한 쿼리문을 특정 값만 바꿔서 여러번 실행해야 할때, 매개변수가 많아서 쿼리문 정리 필요
			PreparedStatement pstmt = null;		// 동적 쿼리
			
//			String sql_insert = "insert into member values('"+name+"', '"+id+"', '"+pwd+"', '"+email+"', '"+phone+"', "+admin+")";
			String sql_insert = "insert into member1 values(?, ?, ?, ?, ?)";
			
//			System.out.println(sql_insert);
			
			try {
				conn = DBManager.getConnection();
		
				// (3 단계) Statement 객체 생성
//				stmt = conn.createStatement();
				pstmt = conn.prepareStatement(sql_insert);
//				pstmt.setString(1, name);
//				pstmt.setString(2, id);
//				pstmt.setString(3, pwd);
//				pstmt.setString(4, email);
//				pstmt.setString(5, phone);
//				pstmt.setInt(6, admin);
				
				pstmt.setString(1, mVo.getName());
				pstmt.setString(2, mVo.getUserid());
				pstmt.setString(3, mVo.getPwd());
				pstmt.setString(4, mVo.getEmail());
				pstmt.setString(5, mVo.getPhone());			// 문자형
//				pstmt.setInt(6, mVo.getAdmin());			// 정수형
//				pstmt.setFloat(int idx, float x);			// 실수형
//				pstmt.setDate(int idx, Date x);				// 날짜형
//				pstmt.setTimestamp(int idx, Timestamp x);	// 시간형
				
				// (4 단계) SQL문 실행 및 결과 처리
				// executeUpdate : 삽입(insert/update/delete)
//				result = stmt.executeUpdate(sql_insert);
				result = pstmt.executeUpdate();				// 쿼리 수행
			} catch(Exception e) {
				e.printStackTrace();			
			} finally {
				DBManager.close(conn, pstmt);
			
				try {
					//(5 단계) 사용한 리소스 해제
//					stmt.close();
					pstmt.close();
					conn.close();
				} catch(SQLException e) {
					System.out.println(e.getMessage());
				}
			}
			return result;
		}

		// 회원 정보 가져오기: select
		// 입력값: 사용자id(userid) 
		// 반환값: 해당 회원 정보
		public MemberVo getMember(String userid) {
			int result = -1;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "select * from member1 where userid = ?";
			MemberVo mVo = null;		
			
			try {
				conn = DBManager.getConnection();
				
				// (3 단계) Statement 객체 생성
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, userid);
				
				// (4 단계) SQL문 실행 및 결과 처리 => executeQuery : 조회(select)
				rs = pstmt.executeQuery();
				// rs.next() : 다음 행(row)을 확인, rs.getString("컬럼명")
				if(rs.next()){
					// 디비로부터 회원 정보 획득
					mVo = new MemberVo();
					String name = rs.getString("name");		// 컬럼명 name인 정보를 가져옴
					mVo.setName(name); 						// DB에서 가져온 정보를 mVo객체에 저장				
					mVo.setUserid(rs.getString("userid")); 
					mVo.setPwd(rs.getString("pwd"));
					mVo.setEmail(rs.getString("email"));
					mVo.setPhone(rs.getString("phone"));
//					mVo.setAdmin(rs.getInt("admin"));
				} else {
					result = -1;		// 디비에 userid 없음
				}
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				try {
					//(5 단계) 사용한 리소스 해제
					rs.close();
					pstmt.close();
					conn.close();
				} catch(SQLException e) {	
					System.out.println(e.getMessage());
				}
			}
			return mVo;
		}
		
		// 회원 정보 업데이트 : update
		// 입력값: 회원 테이블 정보
		// 반환값: 성공여부
		public int updateMember(MemberVo mVo) {
			int result = -1;		
			String sql = "update member1 set pwd=?, email=?, phone=? where userid=?";
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			System.out.println("mVo 확인2 : " + mVo);
			try {
				conn = DBManager.getConnection();
				
				
				// (3 단계) Statement 객체 생성
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, mVo.getPwd());
				pstmt.setString(2, mVo.getEmail());
				pstmt.setString(3, mVo.getPhone());
//				pstmt.setInt(4, mVo.getAdmin());
				pstmt.setString(4, mVo.getUserid());
				
				// (4 단계) SQL문 실행 및 결과 처리 => executeQuery : 수정(update)
				result = pstmt.executeUpdate();
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				try {
					//(5 단계) 사용한 리소스 해제
					pstmt.close();
					conn.close();
				} catch(SQLException e) {	
					System.out.println(e.getMessage());
				}
			}
			return result;
		}
		
		//아이디를 확인
		// 입력값: 중복 체크하려는 userid
		// 반환값: 체크한 아이디가 DB에 존재 여부 : 존재(1),존재안함(-1) 
		public int confirmID(String userid) {
			int result = -1;
			String sql = "select userid from member1 where userid=?";
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;		
			
			try {
				conn = DBManager.getConnection();
				
				// (3 단계) Statement 객체 생성
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, userid);
				
				// (4 단계) SQL문 실행 및 결과 처리 => executeQuery : 조회(select)
				rs = pstmt.executeQuery();
				
				// rs.next() : 다음 행(row)을 확인, rs.getString("컬럼명")
				if(rs.next()){
					// 디비로부터 회원 정보 획득
					result =  1;		// 디비에 userid 있음
				} else {
					result = -1;		// 디비에 userid 없음
				}
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			
			return result; 
		}
		
		public List<MemberVo> selectAllMembers() {
			String sql = "select * from member1 order by userid desc";
			

			List<MemberVo> list = new ArrayList<MemberVo>();	// List 컬렉션 객체 생성
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = DBManager.getConnection();
				
				// (3 단계) Statement 객체 생성
				pstmt = conn.prepareStatement(sql);
				
				// (4 단계) SQL문 실행 및 결과 처리 => executeQuery : 조회(select)
				rs = pstmt.executeQuery();
				// rs.next() : 다음 행(row)을 확인, rs.getString("컬럼명")
				while(rs.next()){
					// rs.getInt("컬럼명");
					MemberVo mVo = new MemberVo();
					// 디비로부터 회원 정보 획득
					
					mVo = new MemberVo();
					mVo.setUserid(rs.getString("userid"));
					String name = rs.getString("name");		// 컬럼명 name인 정보를 가져옴
					mVo.setName(name); 						// DB에서 가져온 정보를 mVo객체에 저장					
					mVo.setPwd(rs.getString("pwd"));
					mVo.setEmail(rs.getString("email"));
					mVo.setPhone(rs.getString("phone"));
					

					list.add(mVo);		// list 객체에 데이터 추가
				}	
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			return list;
		}
		
		public void deleteMember(String userid) {
			int result = -1;
			Connection conn = null;
			// 동일한 쿼리문을 특정 값만 바꿔서 여러번 실행해야 할때, 매개변수가 많아서 쿼리문 정리 필요
			PreparedStatement pstmt = null;		// 동적 쿼리
			
			String sql = "delete from member1 where userid=?";
			
			try {
				conn = DBManager.getConnection();
				
				// (3 단계) Statement 객체 생성
				pstmt = conn.prepareStatement(sql);			
				pstmt.setString(1, userid);
				
				// (4 단계) SQL문 실행 및 결과 처리
				// executeUpdate : 삽입(insert/update/delete)
				result = pstmt.executeUpdate();				// 쿼리 수행
			} catch(Exception e) {
				e.printStackTrace();			
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
		
		public MemberVo selectMemberByUserid(String userid) {		
			String sql = "select * from member1 where userid=?";		
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			MemberVo mVo = null;
			
			try {
				conn = DBManager.getConnection();
				
				// (3 단계) Statement 객체 생성
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, userid);
				
				// (4 단계) SQL문 실행 및 결과 처리 => executeQuery : 조회(select)
				rs = pstmt.executeQuery();
				// rs.next() : 다음 행(row)을 확인, rs.getString("컬럼명")
				while(rs.next()){
					// rs.getInt("컬럼명");
					//MemberVo mVo = new MemberVo();
					// 디비로부터 회원 정보 획득
					
					mVo = new MemberVo();
					
					String name = rs.getString("name");		// 컬럼명 name인 정보를 가져옴
					mVo.setUserid(rs.getString("userid"));
					mVo.setName(name); 						// DB에서 가져온 정보를 mVo객체에 저장				
					 
					mVo.setPwd(rs.getString("pwd"));
					mVo.setEmail(rs.getString("email"));
					mVo.setPhone(rs.getString("phone"));
					mVo.setAdmin(rs.getInt("admin"));
				}	
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			return mVo;
		}
}
