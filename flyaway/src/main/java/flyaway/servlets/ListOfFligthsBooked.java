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
import flyaway.entities.Admin;
import flyaway.entities.Airline;
import flyaway.entities.Flight;
import flyaway.entities.Person;

/**
 * Servlet implementation class ListOfFligthsBooked
 */
@WebServlet("/ListOfFligthsBooked")
public class ListOfFligthsBooked extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListOfFligthsBooked() {
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
		Query<Person> query= session.createQuery("select s from Person s");
		List<Person> all=query.list();
		
		
			out.println("<h1>List of all bookedflights: </h1>");
			out.println("<style> table,th,td { border : 1px solid black ; padding :15px;} </style>");
			out.println("<table>");
			out.println("<tr>");
				out.println("<th>"); out.println("person_id"); out.println("</th>");
				out.println("<th>"); out.println("LastName"); out.println("</th>");
				out.println("<th>"); out.println("Firstname"); out.println("</th>");
				out.println("<th>"); out.println("email"); out.println("</th>");
				out.println("<th>"); out.println("time_booked"); out.println("</th>");
				out.println("<th>"); out.println("flightDetails"); out.println("</th>");
				out.println("<th>"); out.println("PaymentDetails"); out.println("</th>");
				
			out.println("</tr>");
			for(Person i: all) {
					out.println("<tr>");
						out.println("<td>"); out.println(i.getId()); out.println("</td>");
						out.println("<td>"); out.println(i.getLastName()); out.println("</td>");
						out.println("<td>"); out.println(i.getFirstName()); out.println("</td>");
						out.println("<td>"); out.println(i.getEmail()); out.println("</td>");
						out.println("<td>"); out.println(i.getTimeBooked()); out.println("</td>");
						out.println("<td>"); out.println(i.getFlights().toString()); out.println("</td>");
						out.println("<td>"); out.println(i.getPayments().toString()); out.println("</td>");
					
					
				
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
