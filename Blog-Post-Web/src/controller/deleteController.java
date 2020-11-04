package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.blogDao;


@WebServlet(urlPatterns={"/delete"})
public class deleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public deleteController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside delete controller");
		
		try {
			delete(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		blogDao blogdao=new blogDao();
		blogdao.deleteBlog(id);
		response.sendRedirect("AllBlog");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
