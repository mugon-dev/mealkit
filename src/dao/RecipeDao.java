package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.Recipe;

public class RecipeDao {
	private RecipeDao() {}
	private static RecipeDao instance=new RecipeDao();
	public static RecipeDao getInstance() {
		return instance;
	}
	public List<Recipe> selectList(String cook_idx, int mat_no1, String cook_type, String rec_idx){
		List<Recipe> list=new ArrayList<Recipe>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		//original
		String sql="select * from recipe where cook_idx=? && mat_no1=? && cook_type=? && rec_idx=? order by mat_no1 desc limit 3";
		
		//temp
		//String sql="select * from recipe";
		try {
			conn=DBConn.getConn();
			ps=conn.prepareStatement(sql);
			ps.setString(1, cook_idx);
			ps.setInt(2, mat_no1);
			ps.setString(3, cook_type);
			ps.setString(4, rec_idx);
			rs=ps.executeQuery();
			while(rs.next()) {
				Recipe recipe=new Recipe();
				recipe.setMil_no(rs.getInt("mil_no"));
				recipe.setRec_idx(rs.getString("rec_idx"));
				recipe.setTitle(rs.getString("title"));
				recipe.setContent(rs.getString("content"));
				recipe.setImage(rs.getString("image"));
				recipe.setRead_count(rs.getInt("read_count"));
				recipe.setReply_count(rs.getInt("reply_count"));
				recipe.setCook_idx(rs.getString("cook_idx"));
				recipe.setCook_type(rs.getString("cook_type"));
				recipe.setMat_no1(rs.getInt("mat_no1"));
				recipe.setMat_qty1(rs.getInt("mat_qty1"));
				recipe.setMat_no2(rs.getInt("mat_no2"));
				recipe.setMat_qty2(rs.getInt("mat_qty2"));
				recipe.setMat_no3(rs.getInt("mat_no3"));
				recipe.setMat_qty3(rs.getInt("mat_qty3"));
				recipe.setMat_etc(rs.getString("mat_etc"));
				recipe.setNo(rs.getInt("no"));
				recipe.setRgst_dt(rs.getDate("rgst_dt"));
				recipe.setPlate(rs.getString("plate"));
				recipe.setHour(rs.getString("hour"));
				recipe.setLevel(rs.getString("level"));
				System.out.println(recipe);
				list.add(recipe);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConn.close(conn, ps, rs);
		}
		return list;
	}
	public List<Recipe> selectAll(){
		List<Recipe> list=new ArrayList<Recipe>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select * from recipe";
		try {
			conn=DBConn.getConn();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Recipe recipe=new Recipe();
				recipe.setMil_no(rs.getInt("mil_no"));
				recipe.setRec_idx(rs.getString("rec_idx"));
				recipe.setTitle(rs.getString("title"));
				recipe.setContent(rs.getString("content"));
				recipe.setImage(rs.getString("image"));
				recipe.setRead_count(rs.getInt("read_count"));
				recipe.setReply_count(rs.getInt("reply_count"));
				recipe.setCook_idx(rs.getString("cook_idx"));
				recipe.setCook_type(rs.getString("cook_type"));
				recipe.setMat_no1(rs.getInt("mat_no1"));
				recipe.setMat_qty1(rs.getInt("mat_qty1"));
				recipe.setMat_no2(rs.getInt("mat_no2"));
				recipe.setMat_qty2(rs.getInt("mat_qty2"));
				recipe.setMat_no3(rs.getInt("mat_no3"));
				recipe.setMat_qty3(rs.getInt("mat_qty3"));
				recipe.setMat_etc(rs.getString("mat_etc"));
				recipe.setNo(rs.getInt("no"));
				recipe.setRgst_dt(rs.getDate("rgst_dt"));
				recipe.setPlate(rs.getString("plate"));
				recipe.setHour(rs.getString("hour"));
				recipe.setLevel(rs.getString("level"));
				System.out.println(recipe);
				list.add(recipe);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConn.close(conn, ps, rs);
		}
		return list;
	}
	public List<Recipe> selectLatest(String idx){
		List<Recipe> list=new ArrayList<Recipe>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select * from recipe where rec_idx=? order by rgst_dt limit 4";
		try {
			conn=DBConn.getConn();
			ps=conn.prepareStatement(sql);
			ps.setString(1, idx);
			rs=ps.executeQuery();
			while(rs.next()) {
				Recipe recipe=new Recipe();
				recipe.setMil_no(rs.getInt("mil_no"));
				recipe.setRec_idx(rs.getString("rec_idx"));
				recipe.setTitle(rs.getString("title"));
				recipe.setContent(rs.getString("content"));
				recipe.setImage(rs.getString("image"));
				recipe.setRead_count(rs.getInt("read_count"));
				recipe.setReply_count(rs.getInt("reply_count"));
				recipe.setCook_idx(rs.getString("cook_idx"));
				recipe.setCook_type(rs.getString("cook_type"));
				recipe.setMat_no1(rs.getInt("mat_no1"));
				recipe.setMat_qty1(rs.getInt("mat_qty1"));
				recipe.setMat_no2(rs.getInt("mat_no2"));
				recipe.setMat_qty2(rs.getInt("mat_qty2"));
				recipe.setMat_no3(rs.getInt("mat_no3"));
				recipe.setMat_qty3(rs.getInt("mat_qty3"));
				recipe.setMat_etc(rs.getString("mat_etc"));
				recipe.setNo(rs.getInt("no"));
				recipe.setRgst_dt(rs.getDate("rgst_dt"));
				recipe.setPlate(rs.getString("plate"));
				recipe.setHour(rs.getString("hour"));
				recipe.setLevel(rs.getString("level"));
				System.out.println(recipe);
				list.add(recipe);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConn.close(conn, ps, rs);
		}
		return list;
	}
	public List<Recipe> selectReadCount(String idx){
		List<Recipe> list=new ArrayList<Recipe>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select * from recipe where rec_idx=? order by rgst_dt limit 4";
		try {
			conn=DBConn.getConn();
			ps=conn.prepareStatement(sql);
			ps.setString(1, idx);
			rs=ps.executeQuery();
			while(rs.next()) {
				Recipe recipe=new Recipe();
				recipe.setMil_no(rs.getInt("mil_no"));
				recipe.setRec_idx(rs.getString("rec_idx"));
				recipe.setTitle(rs.getString("title"));
				recipe.setContent(rs.getString("content"));
				recipe.setImage(rs.getString("image"));
				recipe.setRead_count(rs.getInt("read_count"));
				recipe.setReply_count(rs.getInt("reply_count"));
				recipe.setCook_idx(rs.getString("cook_idx"));
				recipe.setCook_type(rs.getString("cook_type"));
				recipe.setMat_no1(rs.getInt("mat_no1"));
				recipe.setMat_qty1(rs.getInt("mat_qty1"));
				recipe.setMat_no2(rs.getInt("mat_no2"));
				recipe.setMat_qty2(rs.getInt("mat_qty2"));
				recipe.setMat_no3(rs.getInt("mat_no3"));
				recipe.setMat_qty3(rs.getInt("mat_qty3"));
				recipe.setMat_etc(rs.getString("mat_etc"));
				recipe.setNo(rs.getInt("no"));
				recipe.setRgst_dt(rs.getDate("rgst_dt"));
				recipe.setPlate(rs.getString("plate"));
				recipe.setHour(rs.getString("hour"));
				recipe.setLevel(rs.getString("level"));
				System.out.println(recipe);
				list.add(recipe);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConn.close(conn, ps, rs);
		}
		return list;
	}
	public Recipe selectOne(int no) {
		Recipe recipe=new Recipe();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select * from recipe where mil_no=?";
		try {
			conn=DBConn.getConn();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, no);
			rs=ps.executeQuery();
			while(rs.next()) {
				recipe.setMil_no(rs.getInt("mil_no"));
				recipe.setRec_idx(rs.getString("rec_idx"));
				recipe.setTitle(rs.getString("title"));
				recipe.setContent(rs.getString("content"));
				recipe.setImage(rs.getString("image"));
				recipe.setRead_count(rs.getInt("read_count"));
				recipe.setReply_count(rs.getInt("reply_count"));
				recipe.setCook_idx(rs.getString("cook_idx"));
				recipe.setCook_type(rs.getString("cook_type"));
				recipe.setMat_no1(rs.getInt("mat_no1"));
				recipe.setMat_qty1(rs.getInt("mat_qty1"));
				recipe.setMat_no2(rs.getInt("mat_no2"));
				recipe.setMat_qty2(rs.getInt("mat_qty2"));
				recipe.setMat_no3(rs.getInt("mat_no3"));
				recipe.setMat_qty3(rs.getInt("mat_qty3"));
				recipe.setMat_etc(rs.getString("mat_etc"));
				recipe.setNo(rs.getInt("no"));
				recipe.setRgst_dt(rs.getDate("rgst_dt"));
				recipe.setPlate(rs.getString("plate"));
				recipe.setHour(rs.getString("hour"));
				recipe.setLevel(rs.getString("level"));
				System.out.println(recipe);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConn.close(conn, ps, rs);
		}
		return recipe;
	}
	public List<Recipe> selectShopDiv(String cook_idx,String mat_no1, String cook_type){
		List<Recipe> list=new ArrayList<Recipe>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String index="0";
		String sql="select * from recipe";
		if(!cook_idx.equals("0")) {
			index="1";
			sql+=" where cook_idx=?";
			if(!mat_no1.equals("0")){
				index+="1";
				sql+=" && mat_no1=?";
				if(!cook_type.equals("0")) {
					index+="1";
					sql+=" && cook_type=?";
				}else {
					index+="0";
				}
			}else {
				index+="0";
				if(!cook_type.equals("0")) {
					index+="1";
					sql+=" && cook_type=?";
				}
				else {
					index+="0";
				}
			}
		}else {
			index="0";
			if(!mat_no1.equals("0")){
				index+="1";
				sql+=" where mat_no1=?";
				if(!cook_type.equals("0")) {
					index+="1";
					sql+=" && cook_type=?";
				}else {
					index+="0";
				}
			}else {
				index+="0";
				if(!cook_type.equals("0")) {
					index+="1";
					sql+=" where cook_type=?";
				}
				else {
					index+="0";
				}
			}
		}
		System.out.println(index);
		
		try {
			conn=DBConn.getConn();
			ps=conn.prepareStatement(sql);
			switch(index) {
			case "111":{
				ps.setString(1, cook_idx);
				ps.setInt(2, Integer.parseInt(mat_no1));
				ps.setString(3, cook_type);
				break;
			}
			case "110":{
				ps.setString(1, cook_idx);
				ps.setInt(2, Integer.parseInt(mat_no1));
				break;
			}
			case "101":{
				ps.setString(1, cook_idx);
				ps.setString(2, cook_type);
				break;
			}
			case "100":{
				ps.setString(1, cook_idx);;
				break;
			}
			case "011":{
				ps.setInt(1, Integer.parseInt(mat_no1));
				ps.setString(2, cook_type);
				break;
			}
			case "010":{
				ps.setInt(1, Integer.parseInt(mat_no1));
				break;
			}
			case "001":{
				ps.setString(1, cook_type);
				break;
			}
			case "000":{
				break;
			}
			
			}
			
			rs=ps.executeQuery();
			while(rs.next()) {
				Recipe recipe=new Recipe();
				recipe.setMil_no(rs.getInt("mil_no"));
				recipe.setRec_idx(rs.getString("rec_idx"));
				recipe.setTitle(rs.getString("title"));
				recipe.setContent(rs.getString("content"));
				recipe.setImage(rs.getString("image"));
				recipe.setRead_count(rs.getInt("read_count"));
				recipe.setReply_count(rs.getInt("reply_count"));
				recipe.setCook_idx(rs.getString("cook_idx"));
				recipe.setCook_type(rs.getString("cook_type"));
				recipe.setMat_no1(rs.getInt("mat_no1"));
				recipe.setMat_qty1(rs.getInt("mat_qty1"));
				recipe.setMat_no2(rs.getInt("mat_no2"));
				recipe.setMat_qty2(rs.getInt("mat_qty2"));
				recipe.setMat_no3(rs.getInt("mat_no3"));
				recipe.setMat_qty3(rs.getInt("mat_qty3"));
				recipe.setMat_etc(rs.getString("mat_etc"));
				recipe.setNo(rs.getInt("no"));
				recipe.setRgst_dt(rs.getDate("rgst_dt"));
				recipe.setPlate(rs.getString("plate"));
				recipe.setHour(rs.getString("hour"));
				recipe.setLevel(rs.getString("level"));
				System.out.println(recipe);
				list.add(recipe);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConn.close(conn, ps, rs);
		}
		return list;
	}
	public List<Recipe> selectShopDiv(int start, int end, String cook_idx,String mat_no1, String cook_type){
		List<Recipe> list=new ArrayList<Recipe>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String index="0";
		String sql="select * from recipe";
		if(!cook_idx.equals("0")) {
			index="1";
			sql+=" where cook_idx=?";
			if(!mat_no1.equals("0")){
				index+="1";
				sql+=" && mat_no1=?";
				if(!cook_type.equals("0")) {
					index+="1";
					sql+=" && cook_type=?";
				}else {
					index+="0";
				}
			}else {
				index+="0";
				if(!cook_type.equals("0")) {
					index+="1";
					sql+=" && cook_type=?";
				}
				else {
					index+="0";
				}
			}
		}else {
			index="0";
			if(!mat_no1.equals("0")){
				index+="1";
				sql+=" where mat_no1=?";
				if(!cook_type.equals("0")) {
					index+="1";
					sql+=" && cook_type=?";
				}else {
					index+="0";
				}
			}else {
				index+="0";
				if(!cook_type.equals("0")) {
					index+="1";
					sql+=" where cook_type=?";
				}
				else {
					index+="0";
				}
			}
		}
		sql += " ORDER BY READ_COUNT DESC LIMIT ?, 6 ";
		System.out.println(index);
		
		try {
			conn=DBConn.getConn();
			ps=conn.prepareStatement(sql);
			switch(index) {
			case "111":{
				ps.setString(1, cook_idx);
				ps.setInt(2, Integer.parseInt(mat_no1));
				ps.setString(3, cook_type);
				ps.setInt(4, start);
				break;
			}
			case "110":{
				ps.setString(1, cook_idx);
				ps.setInt(2, Integer.parseInt(mat_no1));
				ps.setInt(3, start);
				break;
			}
			case "101":{
				ps.setString(1, cook_idx);
				ps.setString(2, cook_type);
				ps.setInt(3, start);
				break;
			}
			case "100":{
				ps.setString(1, cook_idx);;
				ps.setInt(2, start);
				break;
			}
			case "011":{
				ps.setInt(1, Integer.parseInt(mat_no1));
				ps.setString(2, cook_type);
				ps.setInt(3, start);
				break;
			}
			case "010":{
				ps.setInt(1, Integer.parseInt(mat_no1));
				ps.setInt(2, start);
				break;
			}
			case "001":{
				ps.setString(1, cook_type);
				ps.setInt(2, start);
				break;
			}
			case "000":{
				ps.setInt(1, start);
				break;
			}
			
			}
			
			rs=ps.executeQuery();
			while(rs.next()) {
				Recipe recipe=new Recipe();
				recipe.setMil_no(rs.getInt("mil_no"));
				recipe.setRec_idx(rs.getString("rec_idx"));
				recipe.setTitle(rs.getString("title"));
				recipe.setContent(rs.getString("content"));
				recipe.setImage(rs.getString("image"));
				recipe.setRead_count(rs.getInt("read_count"));
				recipe.setReply_count(rs.getInt("reply_count"));
				recipe.setCook_idx(rs.getString("cook_idx"));
				recipe.setCook_type(rs.getString("cook_type"));
				recipe.setMat_no1(rs.getInt("mat_no1"));
				recipe.setMat_qty1(rs.getInt("mat_qty1"));
				recipe.setMat_no2(rs.getInt("mat_no2"));
				recipe.setMat_qty2(rs.getInt("mat_qty2"));
				recipe.setMat_no3(rs.getInt("mat_no3"));
				recipe.setMat_qty3(rs.getInt("mat_qty3"));
				recipe.setMat_etc(rs.getString("mat_etc"));
				recipe.setNo(rs.getInt("no"));
				recipe.setRgst_dt(rs.getDate("rgst_dt"));
				recipe.setPlate(rs.getString("plate"));
				recipe.setHour(rs.getString("hour"));
				recipe.setLevel(rs.getString("level"));
				System.out.println(recipe);
				list.add(recipe);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConn.close(conn, ps, rs);
		}
		return list;
	}
}
