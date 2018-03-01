package dao;

import bean.bean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//import com.mysql.jdbc.PreparedStatement;
//import com.mysql.jdbc.Statement;


public class DAO {

	// 数据库连接
	
		public Connection getCon(){
			Connection conn = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydata", "root", "123456");
//				System.out.println("connect...");
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}catch(SQLException e){
				e.printStackTrace();
			}
			return conn;
		}
		
		
	//登录   检查用户名和密码是否存在
		
		public boolean checkUserName(String name,String pwd){
			boolean result = false;
			Connection con = null;
			try {
				System.out.println("checkusername");
				
				con = getCon();
				String sql = "select iduser from nb_user where name = ? and pwd = ?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, name);
				ps.setString(2, pwd);
				ResultSet rs = ps.executeQuery();
				if(rs.next()){
					result = true;
				}
				con.close();
				ps.close();
				rs.close();
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return result;
}
		
		// 注册    1. 检查用户名是否存在
		//	   2. 保存
		
		public boolean checkUser(String name){
			Connection con = getCon();
			boolean result = false;
			
			try {
				String sql = "select iduser from nb_user where name = ? ";
				PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
				ps.setString(1, name);
				ResultSet rs = ps.executeQuery();
				if(rs.next()){result = true;}
				rs.close();
				ps.close();
				con.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
			return result;
		}
		
		public boolean saveUser (bean user){
			boolean result= false;
			Connection con = getCon();
			try {
				String sql = "insert into nb_user (name,pwd,email) values (?,?,?)";
				PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
				ps.setString(1, user.getName());
				ps.setString(2, user.getPwd());
				ps.setString(3, user.getEmail());
				int count = ps.executeUpdate();
				if(count==1){result = true;}
				
				ps.close();
				con.close();
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
			return result;
		}
		
		//密码修改
		public boolean pwdChange(String name,String pwd){
			Connection con = getCon();
			boolean result = false;
			try {
				String sql = "update nb_user set pwd = ? where name = ?";
				PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
				ps.setString(1, pwd);
				ps.setString(2, name);
				int count = ps.executeUpdate();
				if(count ==1){result = true;}
				ps.close();
				con.close();
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return result;
		}
		
		
		
		// 查询  日记内容（全部）
		
		public int findUser(String name){
			int iduser = 0;
			Connection con = getCon();
			String sql = "select iduser from nb_user where name = ? ";
			try {
				PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
				ps.setString(1, name);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					iduser = rs.getInt(1);
				}
				rs.close();
				ps.close();
				con.close();
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			return iduser;
			
		}
		
		public List<bean> findNote(int iduser){
			Connection con = getCon();
			List<bean> list = new ArrayList<>();
			String sql = "select idnote,note,date from nb_note where iduser = ? order by idnote desc limit  0,3  ";
			
			try {
				PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
				ps.setInt(1, iduser);
				ResultSet rs =ps.executeQuery();
				
				while(rs.next()){
					bean bean = new bean();
					bean.setIdnote(rs.getInt(1));
					bean.setNote(rs.getString(2));
					bean.setDate(rs.getString(3));
					
					list.add(bean);
				}
				rs.close();
				ps.close();
				con.close();
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
			return list;
			
		}
		
		// 删除 note  （依据  idnote 删除）
		
		public void delete(int idnote){
			Connection con = getCon();
			
//			System.out.println("dao delete");			
			
			try {
				String sql = "DELETE from nb_note WHERE idnote = ?";
				PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
				ps.setInt(1,idnote);
				ps.executeUpdate();
				
//				System.out.println("con");
				
				ps.close();
				con.close();
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
		
		
		//插入  （把日记内容 写入数据库）
		public boolean add(int iduser,String note,String date){
			boolean result = false;
			
			Connection con = getCon();
			String sql = "insert into  nb_note (iduser,note,date) values (?,?,?) ";
			
			try {
				PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
				ps.setInt(1, iduser);
				ps.setString(2, note);
				ps.setString(3, date);
				int count = ps.executeUpdate();
				if(count == 1){
					result = true;
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			return result;
		}
		
		
		
		//更多查询
		
		public List<bean> findMore(int iduser,int sum){
			Connection con = getCon();
			List<bean> list = new ArrayList<>();
			String sql = "select idnote,note,date from nb_note where iduser = ? order by idnote desc limit  ?,?  ";
			
			
			
			try {
				PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
				ps.setInt(1, iduser);
				ps.setInt(2, 3*sum);
				ps.setInt(3, 3*(sum+1));
				ResultSet rs =ps.executeQuery();
				
				
				
				while(rs.next()){
					bean bean = new bean();
					bean.setIdnote(rs.getInt(1));
					bean.setNote(rs.getString(2));
					bean.setDate(rs.getString(3));
					
//					System.out.println("findMore_"+rs.getInt(1));
					
					list.add(bean);
				}
				rs.close();
				ps.close();
				con.close();
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
			return list;
			
		}
		
}













