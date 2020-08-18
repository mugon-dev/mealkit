package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.Order;

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
		String sql="insert into ord('no','mat_no','mat_qty','mat_unt') values(?,?,?,?)";
		try {
			conn=DBConn.getConn();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, order.getNo());
			ps.setString(2, order.getMat_no());
			ps.setInt(3, order.getMat_qty());
			ps.setInt(4, order.getMat_unt());
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
	public List<Order> selectOrder(int no){
		List<Order> list=new ArrayList<Order>();
		Order order=null;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select * from ord where no=?";
		try {
			conn=DBConn.getConn();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, no);
			rs=ps.executeQuery();
			while(rs.next()) {
				order=new Order();
				order.setNo(rs.getInt("no"));
				order.setMat_no(rs.getString("mat_no"));
				order.setMat_qty(rs.getInt("mat_qty"));
				order.setMat_unt(rs.getInt("mat_unt"));
				list.add(order);
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
