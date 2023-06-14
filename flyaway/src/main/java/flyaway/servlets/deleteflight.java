package flyaway.servlets;

import java.io.IOException;
import flyaway.entities.*;
import flyaway.DaoUtil.*;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class deleteflight
 */
@WebServlet("/deleteflight")
public class deleteflight extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Flight f=new Flight();
	FlightDao g=new FlightDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteflight() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int id=Integer.parseInt(request.getParameter("did"));
		f.setId(id);
		g.DeleteFlight(f);
		PrintWriter out=response.getWriter();
		out.print("FLight Deleted Succesfully");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
