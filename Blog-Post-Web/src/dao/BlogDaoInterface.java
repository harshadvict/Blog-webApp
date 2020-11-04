package dao;

import java.sql.SQLException;
import java.util.List;

import model.blog;

public interface BlogDaoInterface {
	void insertBlog(blog blog) throws SQLException;
	blog selectBlog(int blogId);
	List<blog> selectAllBlogs();
	boolean deleteBlog(int id) throws SQLException;
	boolean updateBlog(blog blog) throws SQLException,Exception;
	
	
}
