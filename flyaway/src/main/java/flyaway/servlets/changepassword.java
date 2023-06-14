package flyaway.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import flyaway.DaoUtil.HibernateUtil;
import flyaway.DaoUtil.UserDao;
import flyaway.entities.Admin;

/**
 * Servlet implementation class changepassword
 */
@WebServlet("/changepassword")
public class changepassword extends HttpServlet {
	Admin a=new Admin();
	UserDao l=new UserDao();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changepassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int id=Integer.parseInt(request.getParameter("id"));
		String s=request.getParameter("p");
		String o=request.getParameter("c");
		
		l.Update(id,o);
		
		

		
request.getRequestDispatcher("login.html").include(request, response);

}
}
