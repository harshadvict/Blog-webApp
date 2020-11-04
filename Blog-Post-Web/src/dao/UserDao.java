package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;
import utility.ConnectionManager;

public class UserDao implements userDaoInterface{

	@Override
	public int signup(User user) {
		String sql1="insert into buser(email,password)values(?,?)";
		int result =0;
		
		ConnectionManager conn=new ConnectionManager();
		
		try {
			Connection con =conn.getConnection();
			if(con!=null) {
				System.out.println("connection established");
				}
			else {
			System.out.println("connection not eastablished");
			}
	
			PreparedStatement pstmt=con.prepareStatement(sql1);
			pstmt.setString(1, user.getEmail());
			pstmt.setString(2, user.getPassword());
			System.out.println(pstmt);
			result =pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean loginUser(User user) {
		boolean status=false;
		
		System.out.println(user.getEmail());
		System.out.println(user.getPassword());
		String sql1="select * from Buser where email=? and password=?";
		ConnectionManager conn=new ConnectionManager();
		try {
			Connection con =conn.getConnection();
			PreparedStatement pstmt=con.prepareStatement(sql1);
			pstmt.setString(1, user.getEmail());
			pstmt.setString(2, user.getPassword());
			System.out.println(pstmt);
			ResultSet rs =pstmt.executeQuery();
			status =rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}

}
