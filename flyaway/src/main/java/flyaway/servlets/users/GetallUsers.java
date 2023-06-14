package flyaway.servlets.users;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import flyaway.DaoUtil.HibernateUtil;
import flyaway.entities.Admin;

/**
 * Servlet implementation class GetallUsers
 */
@WebServlet("/GetallUsers")
public class GetallUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetallUsers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		SessionFactory sFactory = HibernateUtil.buildSessionFactory();
		Session session = sFactory.openSession();
		Query<Admin> query= session.createQuery("select s from Admin s");
		List<Admin> all=query.list();
		
		
			out.println("<h1>List of all AdminUsers: </h1>");
			out.println("<style> table,th,td { border : 1px solid black ; padding :15px;} </style>");
			out.println("<table>");
			out.println("<tr>");
				out.println("<th>"); out.println("admin_id"); out.println("</th>");
				out.println("<th>"); out.println("LastName"); out.println("</th>");
				out.println("<th>"); out.println("Firstname"); out.println("</th>");
				out.println("<th>"); out.println("email"); out.println("</th>");
			out.println("</tr>");
			for(Admin i: all) {
					out.println("<tr>");
						out.println("<td>"); out.println(i.getId()); out.println("</td>");
						out.println("<td>"); out.println(i.getLastName()); out.println("</td>");
						out.println("<td>"); out.println(i.getFirstName()); out.println("</td>");
						out.println("<td>"); out.println(i.getEmail()); out.println("</td>");
					out.println("</tr>");
				}
			
			out.println("</table>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
