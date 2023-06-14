package flyaway.servlets;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Date;

import flyaway.entities.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import flyaway.DaoUtil.*;

/**
 * Servlet implementation class addflight
 */
@WebServlet("/addflight")
public class addflight extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Flight f=new Flight();
	Airline a=new Airline();
	FlightDao g=new FlightDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addflight() {
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
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		int  flightid=Integer.parseInt(request.getParameter("fid"));
		int airlineid=Integer.parseInt(request.getParameter("airline"));
		int numberofseats=Integer.parseInt(request.getParameter("seats"));
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		Double price =Double.parseDouble(request.getParameter("price"));
		String dateofarrival = request.getParameter("datea");
		String dateofdeparture = request.getParameter("dated");
		Date dateSql = null;
		try {
			dateSql = Date.valueOf(dateofarrival);
		} catch (Exception e1) {
			out.print("<a href = \"addflight.html\"> Re-Enter Information </a><br/>");
			out.print("Invalid Date: Make sure you are entering your date code in correctly (yyyy-MM-dd)");
		}
		Date datel = null;
		try {
			datel = Date.valueOf(dateofdeparture);
		} catch (Exception e1) {
			out.print("<a href = \"addflight.html\"> Re-Enter Information </a><br/>");
			out.print("Invalid Date: Make sure you are entering your date code in correctly (yyyy-MM-dd)");
		}
		a.setId(airlineid);
		f.setAirline(a);
		f.setId(flightid);
		f.setDateOfArrival(dateSql);
		f.setDateOfDeparture(datel);
		f.setNumberOfSeats(numberofseats);
		f.setSource(source);
		f.setDestination(destination);
		f.setPrice(price);
		g.addFlight(f);
		
		out.print("<h1>flight added successfully</h2>");
		
	}

}
