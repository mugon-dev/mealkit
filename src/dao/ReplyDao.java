package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.Reply;

public class ReplyDao {
	private ReplyDao() {}
	private static ReplyDao replyDao=new ReplyDao();
	
	public static ReplyDao getInstance() {
		return replyDao;
	}
	
	public List<Reply> selectReply(int milNo){
		List<Reply> list = new ArrayList<Reply>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = " SELECT * FROM REPLY WHERE MIL_NO = ? ";
		
		try{
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, milNo);
			rs = ps.executeQuery();
			while(rs.next()){
				Reply reply = new Reply();
				reply.setReNo(rs.getInt("re_no"));
				reply.setMilNo(rs.getInt("mil_no"));
				reply.setReply(rs.getString("reply"));
				reply.setRgstDt(rs.getTimestamp("regt_dt"));
				reply.setNo(rs.getInt("no"));
				list.add(reply);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, ps, rs);
		}
		return list;
	}

	
	public boolean insertReply(Reply reply){
		boolean flag = false;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = " INSERT INTO REPLY(MIL_NO, REPLY, NO) VALUES(?, ?, ?) ";
		try{
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, reply.getMilNo());
			ps.setString(2,reply.getReply());
			ps.setInt(3, reply.getNo());
			int n = ps.executeUpdate();
			if(n == 1) {
				flag = true;
				System.out.println("댓글 입력 성공");
			} else {
				System.out.println("댓글 입력 실패");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, ps);
		}
		return flag;
	}
	/*
	public Reply selectOneReply(int reNo) {
		Reply reply = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = " SELECT * FROM REPLY WHERE RE_NO = ? ";
		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, reNo);
			rs = ps.executeQuery();
			if(rs.next()) {
				reply = new Reply();
				reply.setReNo(rs.getInt("re_no"));
				reply.setMilNo(rs.getInt("mil_no"));
				reply.setReply(rs.getString("reply"));
				reply.setRgstDt(rs.getDate("rgst_dt"));
				reply.setNo(rs.getInt("no"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, ps, rs);
		}
		return reply;
	}
	*/
	
	public boolean deleteReply(int reNo) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = " DELETE FROM REPLY WHERE RE_NO =? ";
		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, reNo);
			int n = ps.executeUpdate();
			if(n == 1) {
				flag = true;
				System.out.println("댓글삭제 성공");
			} else {
				System.out.println("댓글 삭제 실패");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, ps);
		}
		return flag;
	}
	
	public boolean updateReply(int reNo) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = " UPDATE REPLY SET RELPY = ? WHERE RE_NO =? ";
		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, rs.getString("reply"));
			ps.setInt(2, reNo);
			int n = ps.executeUpdate();
			if(n == 1) {
				flag = true;
				System.out.println("댓글삭제 성공");
			} else {
				System.out.println("댓글 삭제 실패");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, ps, rs);
		}
		return flag;
	}
}
