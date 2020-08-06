package dao;
/*
 * 2020.08.05 
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import vo.Blog;

public class BlogDao {
	private BlogDao() {}
	private static BlogDao instance = new BlogDao();
	public static BlogDao getInstance() {
		return instance;
	}
	public List<Blog> selectAll(){
		String sql = " SELECT * FROM RECIPE ORDER BY MIL_NO ";
		
		List<Blog> list = new ArrayList<Blog>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			System.out.println(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Blog blog = new Blog();
				blog.setMilNo(rs.getInt("mil_no"));
				blog.setDivision(rs.getString("division"));
				blog.setTitle(rs.getString("title"));
				blog.setContent(rs.getString("content"));
				blog.setImage(rs.getString("image"));
				blog.setReadCount(rs.getInt("read_count"));
				blog.setReplyCount(rs.getInt("reply_count"));
				blog.setCookIndex(rs.getString("cook_index"));
				blog.setCookType(rs.getString("cook_type"));
				blog.setMain(rs.getString("main"));
				blog.setSub(rs.getString("sub"));
				blog.setSauce(rs.getString("sauce"));
				blog.setNo(rs.getInt("no"));
				blog.setRgstDt(rs.getTimestamp("rgst_dt"));
				System.out.println(blog);
				list.add(blog);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, ps, rs);
		}
		return list;
	}
	public List<Blog> selectAll(int start, int end, String idx, int no){
		String sql = " SELECT * FROM RECIPE ";
		
		if(idx.equals("1")) { //한식
			sql += " WHERE COOK_INDEX = '1' ";
		} else if(idx.equals("2")) { //중식
			sql += " WHERE COOK_INDEX = '2' ";
		} else if(idx.equals("3")) { //양식
			sql += " WHERE COOK_INDEX = '3' ";
		} else if(idx.equals("4")) { //일식
			sql += " WHERE COOK_INDEX = '4' ";
		} else if(idx.equals("5")) { // 내글보기
			sql += " WHERE NO = " + no + " ";
		}
		
		sql += " ORDER BY NUM DESC LIMIT ?, ? ";
		
		List<Blog> list = new ArrayList<Blog>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, end);
			ps.setInt(2, start);
			System.out.println(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Blog blog = new Blog();
				blog.setMilNo(rs.getInt("mil_no"));
				blog.setDivision(rs.getString("division"));
				blog.setTitle(rs.getString("title"));
				blog.setContent(rs.getString("content"));
				blog.setImage(rs.getString("image"));
				blog.setReadCount(rs.getInt("read_count"));
				blog.setReplyCount(rs.getInt("reply_count"));
				blog.setCookIndex(rs.getString("cook_index"));
				blog.setCookType(rs.getString("cook_type"));
				blog.setMain(rs.getString("main"));
				blog.setSub(rs.getString("sub"));
				blog.setSauce(rs.getString("sauce"));
				blog.setNo(rs.getInt("no"));
				blog.setRgstDt(rs.getTimestamp("rgst_dt"));
				
				list.add(blog);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, ps, rs);
		}
		return list;
	}
	
	// 글 작성
	public boolean insert(Blog blog) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = " INSERT INTO RECIPE(DIVISION, TITLE, CONTENT, IMAGE, COOK_INDEX, COOK_TYPE, MAIN, SUB, SAUCE, NO) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, blog.getDivision());
			ps.setString(2, blog.getTitle());
			ps.setString(3, blog.getContent());
			ps.setString(4, blog.getImage());
			ps.setString(5, blog.getCookIndex());
			ps.setString(6, blog.getCookType());
			ps.setString(7, blog.getMain());
			ps.setString(8, blog.getSub());
			ps.setString(9, blog.getSauce());
			ps.setInt(10, blog.getNo());
			System.out.println(sql);
			int n = ps.executeUpdate();
			if(n == 1) {
				flag = true;
				System.out.println("글 작성 성공");
			} else {
				System.out.println("글 작성 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, ps);
		}
		return flag;
	}
	
	//
	public Blog selectOne(int milNo) {
		Blog blog = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = " SELECT * FROM RECIPE WHERE MIL_NO = ? ";
		
		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, milNo);
			System.out.println(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				blog = new Blog();
				blog.setMilNo(rs.getInt("mil_no"));
				blog.setDivision(rs.getString("division"));
				blog.setTitle(rs.getString("title"));
				blog.setContent(rs.getString("content"));
				blog.setImage(rs.getString("image"));
				blog.setReadCount(rs.getInt("read_count"));
				blog.setReplyCount(rs.getInt("reply_count"));
				blog.setCookIndex(rs.getString("cook_index"));
				blog.setCookType(rs.getString("cook_type"));
				blog.setMain(rs.getString("main"));
				blog.setSub(rs.getString("sub"));
				blog.setSauce(rs.getString("sauce"));
				blog.setNo(rs.getInt("no"));
				blog.setRgstDt(rs.getTimestamp("rgst_dt"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, ps, rs);
		}
		return blog;
	}
	// 글 수정
	public boolean update(Blog blog) {
		boolean flag=false;
		String sql = " UPDATE RECIPE SET DIVISION=?, TITLE=?, CONTENT=?, IMAGE=?, COOK_INDEX=?, COOK_TYPE=?, MAIN=?, SUB=?, SAUCE=? WHERE MIL_NO = ? ";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, blog.getDivision());
			ps.setString(2, blog.getTitle());
			ps.setString(3, blog.getContent());
			ps.setString(4, blog.getImage());
			ps.setString(5, blog.getCookIndex());
			ps.setString(6, blog.getCookType());
			ps.setString(7, blog.getMain());
			ps.setString(8, blog.getSub());
			ps.setString(9, blog.getSauce());
			
			System.out.println(sql);
			int n=ps.executeUpdate();
			if(n==1) {
				flag=true;
				System.out.println("글 수정 성공");
			}else {
				System.out.println("글 수정 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, ps);
		}
		return flag;
	}
	
	//글 삭제
	public boolean delete(int milNo) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "DELETE FROM RECIPE WHERE MIL_NO=?";
		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, milNo);
			System.out.println(sql);
			int n = ps.executeUpdate();
			if(n == 1) {
				flag = true;
				System.out.println("게시글 삭제 성공!");
			} else {
				System.out.println("게시글 삭제 실패!");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, ps);
		}
		return flag;
	}
	
	// 조회수
	public boolean updateReadCount(int milNo) {
		boolean flag=false;
		String sql = " UPDATE RECIPE SET READCOUNT = READCOUNT+1 WHERE MIL_NO = ? ";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			System.out.println(sql);
			ps.setInt(1, milNo);
			int n=ps.executeUpdate();
			if(n==1) {
				flag=true;
				System.out.println("조회수 업데이터 성공");
			}else {
				System.out.println("조회수 업데이터 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, ps);
		}
		return flag;
	}
	
	//페이징
	public int getBlogCount(){
		int count = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = " SELECT COUNT(*) FROM RECIPE "; 
		
		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			System.out.println(sql);
			rs = ps.executeQuery();
			if(rs.next()){
				count = rs.getInt(1);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, ps, rs);
		}
		return count;
	}
}
