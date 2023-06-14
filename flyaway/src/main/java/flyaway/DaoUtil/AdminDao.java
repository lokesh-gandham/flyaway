package flyaway.DaoUtil;

import java.util.List;


import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import flyaway.entities.Admin;
import jakarta.persistence.NoResultException;




public class AdminDao{
	
	
	public Admin getUser (String username, String password) throws NoResultException {

		SessionFactory sFactory = HibernateUtil.buildSessionFactory();
		Session session = sFactory.openSession();
		Query<Admin> query = session.createQuery("select u from Admin u  where u.firstName='"+username+"' and u.password='"+password+"'");
		return query.getSingleResultOrNull();
	}
	

	public void addUSer(Admin admin) {
		SessionFactory sFactory = HibernateUtil.buildSessionFactory();
		Session session = sFactory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.save(admin);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
}
	public void DeleteUser(Admin admin) {
		SessionFactory sFactory = HibernateUtil.buildSessionFactory();
		Session session = sFactory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.remove(admin);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
}


}