package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vo.Member;

public class MemberDao {
	private MemberDao() {}

	private static MemberDao instance = new MemberDao();

	public static MemberDao getInstance() {
		return instance;
	}
	
	public boolean insert(Member member){
		boolean flag=false;
		Connection conn=null;
		PreparedStatement ps=null;
		String sql="insert into member(id,pw,name,addr,tel) values(?,?,?,?,?)";
		try {
			conn=DBConn.getConn();
			ps=conn.prepareStatement(sql);
			ps.setNString(1, member.getId());
			ps.setNString(2, member.getPw());
			ps.setNString(3, member.getName());
			ps.setNString(4, member.getAddr());
			ps.setNString(5, member.getTel());
			int n=ps.executeUpdate();
			if(n==1) {
				flag=true;
				System.out.println("데이터 입력 성공");
			}else {
				System.out.println("데이터 입력 실패");
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			try {
				DBConn.close(conn, ps);
			}catch(Exception e) {
				e.getStackTrace();
			}
		}
		return flag;
	}//수정완료
	
	public boolean overappedId(String id) {
		boolean flag=false;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from member where id=?";
		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				flag=true;
				System.out.println("아이디 중복");
			}else {
				System.out.println("중복 아이디 없음");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				DBConn.close(conn, ps, rs);
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
		return flag;
	}//수정완료
	
	public int login(String id, String pw) {
		int n= -1;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select pw from member where id=?";
		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				if(pw.equals(rs.getString(1))) {
					n=1;
					System.out.println("로그인 성공");
				}else {
					n=0;
					System.out.println("패스워드 다름");
				}
			}else {
				System.out.println("아이디 없음");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				DBConn.close(conn, ps, rs);
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
		return n;
	}//수정완료
	
	public boolean update(Member member) {
		boolean flag=false;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update member set pw=?, name=? where id=?";
		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, member.getPw());
			ps.setString(2, member.getName());
			ps.setString(3, member.getId());
			int n=ps.executeUpdate();
			if(n==1) {
				flag=true;
				System.out.println("업데이트 성공");
			}else {
				System.out.println("업데이트 실패");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				DBConn.close(conn, ps);
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
		return flag;
	}//수정완료
	
	public boolean delete(String id) {
		boolean flag=false;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "delete from member where id=?";
		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			int n=ps.executeUpdate();
			if(n==1) {
				flag=true;
				System.out.println("삭제 성공");
			}else {
				System.out.println("삭제 실패");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				DBConn.close(conn, ps);
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
		return flag;
	}//수정완료
	
	public int getMemberNo(String id) {
		int no = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		String sql="select no from member where id=?";
		try {
			conn= DBConn.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1,id);
			rs=ps.executeQuery();
			if(rs.next()) {
				no=rs.getInt("no");
				System.out.println("session_no 획득");
			}else {
				System.out.println("세션 획득 실패");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				DBConn.close(conn, ps,rs);
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
		return no;
	}

}
