package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.Order;
import vo.OrderPrice;

public class OrderDao {
	private OrderDao() {};
	private static OrderDao instance=new OrderDao() {};
	public static OrderDao getInstance() {
		return instance;
	}
	public boolean insert(Order order) {
		boolean flag=false;
		Connection conn=null;
		PreparedStatement ps=null;
		String sql="insert into ord(no,mat_no,mat_nm,mat_image,mat_qty,mat_unit) values(?,?,?,?,?,?)";
		try {
			conn=DBConn.getConn();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, order.getNo());
			ps.setInt(2, order.getMat_no());
			ps.setNString(3, order.getMat_nm());
			ps.setString(4, order.getMat_image());
			ps.setInt(5, order.getMat_qty());
			ps.setInt(6, order.getMat_unit());
			int n=ps.executeUpdate();
			if(n==1) {
				flag=true;
				System.out.println("장바구니 입력 성공");
			}else {
				System.out.println("장바구니 입력 실패");
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
	}
	public List<OrderPrice> selectOrder(int no){
		List<OrderPrice> list=new ArrayList<OrderPrice>();
		OrderPrice ord_p=null;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select * from ord,mat where ord.mat_no=mat.mat_no and no=? and ord_flag=0";
		try {
			conn=DBConn.getConn();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, no);
			rs=ps.executeQuery();
			while(rs.next()) {
				ord_p=new OrderPrice();
				ord_p.setOrder_no(rs.getInt("ord_no"));
				ord_p.setNo(rs.getInt("no"));
				ord_p.setMat_no(rs.getInt("mat_no"));
				ord_p.setMat_nm(rs.getString("mat_nm"));
				ord_p.setMat_image(rs.getString("mat_image"));
				ord_p.setMat_qty(rs.getInt("mat_qty"));
				ord_p.setMat_unt(rs.getInt("mat_unit"));
				ord_p.setPrice(rs.getInt("mat_price"));
				//가격
				list.add(ord_p);
			}
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			try {
				DBConn.close(conn, ps,rs);
			}catch(Exception e) {
				e.getStackTrace();
			}
		}
		return list;
	}
	public boolean delete(int no, String mat_no) {
		boolean flag=false;
		Connection conn=null;
		PreparedStatement ps=null;
		String sql="delete from ord where (no=? && mat_no=?)";
		try {
			conn=DBConn.getConn();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, no);
			ps.setString(2, mat_no);
			int n=ps.executeUpdate();
			if(n==1) {
				flag=true;
				System.out.println("재료 삭제 성공");
			}else {
				System.out.println("재료 삭제 실패");
				
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
	}
	public boolean update(int ord_no, int ord_qty) {
		boolean flag=false;
		Connection conn=null;
		PreparedStatement ps=null;
		String sql="update ord set mat_qty=?, ord_flag=1 where ord_no=?";
		try {
			conn=DBConn.getConn();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, ord_qty);
			ps.setInt(2, ord_no);
			int n=ps.executeUpdate();
			if(n==1) {
				flag=true;
				System.out.println("주문 업데이트 성공");
			}else {
				System.out.println("주문 업데이트 실패");
				
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
	}
}
