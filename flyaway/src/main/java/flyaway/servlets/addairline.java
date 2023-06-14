package flyaway.servlets;

import java.io.IOException;


import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import flyaway.DaoUtil.HibernateUtil;
import flyaway.entities.Airline;

/**
 * Servlet implementation class addairline
 */
@WebServlet("/addairline")
public class addairline extends HttpServlet {
	Airline a=new Airline();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addairline() {
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
		
		int  id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		a.setId(id);
		a.setAirline(name);
		SessionFactory sFactory = HibernateUtil.buildSessionFactory();
		Session session = sFactory.openSession();
		Transaction tx=session.beginTransaction();
	session.save(a);
	tx.commit();
	request.getRequestDispatcher("admindashboard.html");
	}

}
