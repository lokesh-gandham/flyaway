package flyaway.servlets;

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
import flyaway.entities.Airline;
/**
 * Servlet implementation class airlineslist
 */
@WebServlet("/airlineslist")
public class airlineslist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public airlineslist() {
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
		Query<Airline> query= session.createQuery("select s from Airline s");
		List<Airline> all=query.list();
		
			
			out.println("<h1>List of all Airlines: </h1>");
			out.println("<style> table,th,td { border : 1px solid black ; padding :15px;} </style>");
			out.println("<table>");
			out.println("<tr>");
				out.println("<th>"); out.println("Airline_id"); out.println("</th>");
				out.println("<th>"); out.println("AirlineName"); out.println("</th>");
				
			out.println("</tr>");
			for(Airline i: all) {
					out.println("<tr>");
						out.println("<td>"); out.println(i.getId()); out.println("</td>");
						out.println("<td>"); out.println(i.getAirline()); out.println("</td>");
					out.println("</tr>");
				}
			
			out.println("</table>");
			request.getRequestDispatcher("index.html").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
