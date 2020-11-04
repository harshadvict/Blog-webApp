package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.blogDao;
import model.blog;

/**
 * Servlet implementation class BlogController
 */
@WebServlet(urlPatterns={"/new"})
public class BlogController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BlogController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("getting into add new blog");
		RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/BlogListView.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("entering do post");
		String blogTitle=request.getParameter("title");
		String blogDescription=request.getParameter("message");
		LocalDate postedOn=LocalDate.now();
		blog blog=new blog();
		blog.setBlogTitle(blogTitle);
		blog.setBlogDescription(blogDescription);
		blog.setPostedOn(postedOn);
		blogDao blogdao=new blogDao();
		try {
			blogdao.insertBlog(blog);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("AllBlog");
//		RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/LoginView.jsp");
//		rd.forward(request, response);
	}

}
