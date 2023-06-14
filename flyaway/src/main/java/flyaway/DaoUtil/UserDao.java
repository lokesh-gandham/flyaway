package flyaway.DaoUtil;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import flyaway.entities.Admin;



public class UserDao {
	
	public void Update(Integer  id,String pass) {
		SessionFactory sFactory = HibernateUtil.buildSessionFactory();
		Session session = sFactory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			Admin a=(Admin)session.get(Admin.class, id);
			a.setPassword(pass);
			session.update(a);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

}
