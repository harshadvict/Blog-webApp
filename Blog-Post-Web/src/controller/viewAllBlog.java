package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.blogDao;
import model.blog;

/**
 * Servlet implementation class viewAllBlog
 */
@WebServlet("/AllBlog")
public class viewAllBlog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewAllBlog() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.print("view all blog");
	System.out.print("getting all blog post");
	blogDao blogdao=new blogDao();
	List<blog> listblog=blogdao.selectAllBlogs();
	for(blog bloglist:listblog) {
		System.out.println(bloglist.getBlogId());
		System.out.println(bloglist.getBlogTitle());
		System.out.println(bloglist.getBlogDescription());
		System.out.println(bloglist.getPostedOn());
		
	}
	request.setAttribute("listBlog", listblog);
	RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/blogView.jsp");
	rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
