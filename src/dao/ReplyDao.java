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
		String sql = " SELECT R.RE_NO, R.MIL_NO, R.REPLYS, R.NO, R.RGST_DT, M.ID " 
					+ " FROM REPLY R, MEMBER M "
					+ " WHERE R.NO = M.NO " 
					+ "  AND R.MIL_NO = ? ";
		
		try{
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, milNo);
			rs = ps.executeQuery();
			while(rs.next()){
				Reply reply = new Reply();
				reply.setReNo(rs.getInt("re_no"));
				reply.setMilNo(rs.getInt("mil_no"));
				reply.setReplys(rs.getString("replys"));
				reply.setRgstDt(rs.getTimestamp("rgst_dt"));
				reply.setNo(rs.getInt("no"));
				reply.setId(rs.getNString("id"));
				list.add(reply);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, ps, rs);
		}
		return list;
	}

	//댓글 입력
	public boolean insertReply(Reply reply){
		boolean flag = false;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = " INSERT INTO REPLY(MIL_NO, REPLYS, NO) VALUES(?, ?, ?) ";
		try{
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql); 
			ps.setInt(1, reply.getMilNo());
			ps.setString(2,reply.getReplys());
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
	
	// 댓글삭제
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
	
	// 댓글 업데이트 
	public boolean updateReply(int reNo) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = " UPDATE REPLY SET RELPYS = ? WHERE RE_NO = ? ";
		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, rs.getString("replys"));
			ps.setInt(2, reNo);
			int n = ps.executeUpdate();
			if(n == 1) {
				flag = true;
				System.out.println("댓글 수정 성공");
			} else {
				System.out.println("댓글 수정 실패");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, ps, rs);
		}
		return flag;
	}
	
	// 댓글 작성 후 레시피 테이블에 댓글카운팅 컬럼 업데이트 
	public boolean updateBlogReplyCount(int milNo) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = " UPDATE RECIPE SET REPLY_COUNT = REPLY_COUNT + 1 WHERE MIL_NO = ? ";
		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, milNo);
			int n = ps.executeUpdate();
			if(n == 1) {
				flag = true;
				System.out.println("블로그 댓글 카운팅 성공");
			} else {
				System.out.println("블로그 댓글 카운팅 실패");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, ps, rs);
		}
		return flag;
	}

	// 댓글 작성 후 레시피 테이블에 댓글카운팅 컬럼 업데이트 
	public boolean deleteBlogReplyCount(int milNo) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = " UPDATE RECIPE SET REPLY_COUNT = REPLY_COUNT - 1 WHERE MIL_NO = ? ";
		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, milNo);
			int n = ps.executeUpdate();
			if(n == 1) {
				flag = true;
				System.out.println("블로그 댓글 카운팅 삭제 성공");
			} else {
				System.out.println("블로그 댓글 카운팅 삭제 실패");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, ps, rs);
		}
		return flag;
	}
}
