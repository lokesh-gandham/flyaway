package flyaway.DaoUtil;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import flyaway.entities.Flight;

public class FlightDao {

	public void addFlight(Flight flight) {
		SessionFactory sFactory = HibernateUtil.buildSessionFactory();
		Session session = sFactory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.save(flight);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
}
	public void DeleteFlight(Flight flight) {
		SessionFactory sFactory = HibernateUtil.buildSessionFactory();
		Session session = sFactory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.remove(flight);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
}
	
}
