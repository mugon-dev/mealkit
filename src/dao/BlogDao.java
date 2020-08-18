package dao;

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
	
	public List<Blog> selectAll(int start, int end, String idx, String no){
		String sql = " SELECT * FROM RECIPE ";
		if(idx.equals("1")) { // 한식
			sql += " WHERE COOK_IDX = " + idx + " ";
		} else if(idx.equals("2")) { // 중식
			sql += " WHERE COOK_IDX = " + idx + " ";
		} else if(idx.equals("3")) { // 일식
			sql += " WHERE COOK_IDX = " + idx + " ";
		} else if(idx.equals("4")) { // 양식
			sql += " WHERE COOK_IDX = " + idx + " ";
		} else if(idx.equals("5")) { // 전체보기
		} else if(idx.equals("6")) { // 내글보기
			sql += " WHERE NO = " + no + " ";
		}
		
		sql += " ORDER BY MIL_NO DESC LIMIT ?, 3 ";
		
		List<Blog> list = new ArrayList<Blog>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, start);
			rs = ps.executeQuery();
			System.out.println(sql);
			
			while (rs.next()) {
				Blog blog = new Blog();
				
				blog.setMilNo(rs.getInt("mil_no"));
				blog.setRecIdx(rs.getString("rec_idx"));
				blog.setTitle(rs.getString("title"));
				blog.setContent(rs.getString("content"));
				blog.setImage(rs.getString("image"));
				blog.setReadCount(rs.getInt("read_count"));
				blog.setReplyCount(rs.getInt("reply_count"));
				blog.setCookIdx(rs.getString("cook_idx"));
				blog.setCookType(rs.getString("cook_type"));
				blog.setMatNo1(rs.getString("mat_no1"));
				blog.setMatQty1(rs.getInt("mat_qty1"));
				blog.setMatNo2(rs.getString("mat_no2"));
				blog.setMatQty2(rs.getInt("mat_qty2"));
				blog.setMatNo3(rs.getString("mat_no3"));
				blog.setMatQty3(rs.getInt("mat_qty3"));
				blog.setMatEtc(rs.getString("mat_etc"));
				blog.setNo(rs.getInt("no"));
				blog.setRgstDt(rs.getDate("rgst_dt"));
				blog.setPlate(rs.getString("plate"));
				blog.setHour(rs.getNString("hour"));
				blog.setLevel(rs.getNString("level"));
				
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
	
	// 글 작성
	public boolean insert(Blog blog) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = " INSERT INTO RECIPE(MAT_QTY1, MAT_QTY2, MAT_QTY3, NO, REC_IDX, TITLE, CONTENT, " 
				+ " IMAGE, COOK_IDX, COOK_TYPE, MAT_NO1, MAT_NO2, MAT_NO3, MAT_ETC, PLATE, HOUR, LEVEL) " 
				+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
		
		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			System.out.println(sql);
			
			ps.setInt(1, blog.getMatQty1());
			ps.setInt(2, blog.getMatQty2());
			ps.setInt(3, blog.getMatQty3());
			ps.setInt(4,  blog.getNo());
			ps.setNString(5, blog.getRecIdx());
			ps.setNString(6, blog.getTitle());
			ps.setNString(7, blog.getContent());
			ps.setNString(8, blog.getImage());
			ps.setNString(9, blog.getCookIdx());
			ps.setNString(10, blog.getCookType());
			ps.setNString(11, blog.getMatNo1());
			ps.setNString(12, blog.getMatNo2());
			ps.setNString(13, blog.getMatNo3());
			ps.setNString(14, blog.getMatEtc());
			ps.setNString(15, blog.getPlate());
			ps.setNString(16, blog.getHour());
			ps.setNString(17, blog.getLevel());
			
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
				blog.setRecIdx(rs.getString("rec_idx"));
				blog.setTitle(rs.getString("title"));
				blog.setContent(rs.getString("content"));
				blog.setImage(rs.getString("image"));
				blog.setReadCount(rs.getInt("read_count"));
				blog.setReplyCount(rs.getInt("reply_count"));
				blog.setCookIdx(rs.getString("cook_idx"));
				blog.setCookType(rs.getString("cook_type"));
				blog.setMatNo1(rs.getString("mat_no1"));
				blog.setMatQty1(rs.getInt("mat_qty1"));
				blog.setMatNo2(rs.getString("mat_no2"));
				blog.setMatQty2(rs.getInt("mat_qty2"));
				blog.setMatNo3(rs.getString("mat_no3"));
				blog.setMatQty3(rs.getInt("mat_qty3"));
				blog.setMatEtc(rs.getString("mat_etc"));
				blog.setNo(rs.getInt("no"));
				blog.setRgstDt(rs.getDate("rgst_dt"));
				blog.setPlate(rs.getString("plate"));
				blog.setHour(rs.getNString("hour"));
				blog.setLevel(rs.getNString("level"));
				
				System.out.println(blog);
				
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
		String sql = " UPDATE RECIPE SET MAT_QTY1=?, MAT_QTY2=?, MAT_QTY3=?, NO=?, REC_IDX=?, TITLE=?, CONTENT=?, "
				+ " IMAGE=?, COOK_IDX=?, COOK_TYPE=?, MAT_NO1=?, MAT_NO2=?, MAT_NO3=?, MAT_ETC=?, PLATE=?, HOUR=?, LEVEL=? "
				+ " WHERE MIL_NO = ? ";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBConn.getConn();
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, blog.getMatQty1());
			ps.setInt(2, blog.getMatQty2());
			ps.setInt(3, blog.getMatQty3());
			ps.setInt(4,  blog.getNo());
			ps.setNString(5, blog.getRecIdx());
			ps.setNString(6, blog.getTitle());
			ps.setNString(7, blog.getContent());
			ps.setNString(8, blog.getImage());
			ps.setNString(9, blog.getCookIdx());
			ps.setNString(10, blog.getCookType());
			ps.setNString(11, blog.getMatNo1());
			ps.setNString(12, blog.getMatNo2());
			ps.setNString(13, blog.getMatNo3());
			ps.setNString(14, blog.getMatEtc());
			ps.setNString(15, blog.getPlate());
			ps.setNString(16, blog.getHour());
			ps.setNString(17, blog.getLevel());
			
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
	
	// 블로그 글 조회수
	public boolean updateReadCount(int milNo) {
		boolean flag=false;
		String sql = " UPDATE RECIPE SET READ_COUNT = READ_COUNT+1 WHERE MIL_NO = ? ";
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
	
	// 페이징에 쓸 개수 
	public int getBlogCount(String idx, String no){
		int count = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = " SELECT COUNT(*) FROM RECIPE "; 
		
		if(idx.equals("1")) { // 한식
			sql += " WHERE COOK_IDX = " + idx + " ";
		} else if(idx.equals("2")) { // 중식
			sql += " WHERE COOK_IDX = " + idx + " ";
		} else if(idx.equals("3")) { // 일식
			sql += " WHERE COOK_IDX = " + idx + " ";
		} else if(idx.equals("4")) { // 양식
			sql += " WHERE COOK_IDX = " + idx + " ";
		} else if(idx.equals("5")) { // 전체보기
		} else if(idx.equals("6")) { // 내글보기
			if(no == null || no.equals("")) {
				//sql += " WHERE NO = 1 "; // 테스트용
			} else {
				sql += " WHERE NO = " + no + " ";
			}
		}
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
