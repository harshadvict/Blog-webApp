package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.blog;
import utility.ConnectionManager;

public class blogDao implements BlogDaoInterface {

	private static final String stmt1="Insert into blog (blogtitle,blogdescription,postedon) values(?,?,?)";
	@Override
	public void insertBlog(blog blog) throws SQLException {
		// TODO Auto-generated method stub
		try {
		ConnectionManager con = new ConnectionManager();
		Connection conn=con.getConnection();
		PreparedStatement stmt=conn.prepareStatement(stmt1);
		stmt.setString(1,blog.getBlogTitle());
		stmt.setString(2,blog.getBlogDescription());
		stmt.setDate(3,java.sql.Date.valueOf(blog.getPostedOn()));
		stmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public blog selectBlog(int blogId) {
		
		return null;
	}

	@Override
	public List<blog> selectAllBlogs() {
		String stmt1="select * from blog";
		blog blog=null;
		List<blog> blogList=new ArrayList<>();
		try {
			ConnectionManager con = new ConnectionManager();
			Connection conn=con.getConnection();
			PreparedStatement stmt=conn.prepareStatement(stmt1);
			System.out.println(stmt);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				int id=rs.getInt("blogid");
				String title=rs.getString("blogtitle");
				String desc=rs.getString("blogdescription");
				LocalDate date =rs.getDate("postedon").toLocalDate();
				blog=new blog();
				blog.setBlogDescription(desc);
				blog.setBlogId(id);
				blog.setBlogTitle(title);
				blog.setPostedOn(date);
				blogList.add(blog);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return blogList;
	}

	@Override
	public boolean deleteBlog(int id) throws SQLException {
		String stmt3="delete from blog where blogid=?";
		System.out.println(id);
		boolean rowdeleted;
		try {
			ConnectionManager con = new ConnectionManager();
			Connection conn=con.getConnection();
			PreparedStatement stmt=conn.prepareStatement(stmt3);
			stmt.setInt(1,id);
			rowdeleted=stmt.executeUpdate()>0;
			return rowdeleted;
			
			}
		
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
}

	@Override
	public boolean updateBlog(blog blog) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
