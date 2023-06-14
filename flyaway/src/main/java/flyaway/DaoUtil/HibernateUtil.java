package flyaway.DaoUtil;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
private static SessionFactory factory;
	
	public static SessionFactory buildSessionFactory() {

    	StandardServiceRegistry  sService = new StandardServiceRegistryBuilder()
    			.configure("hibernate.annotations.cfg.xml").build();
    	Metadata meta = new MetadataSources(sService).getMetadataBuilder().build();
    	
    	factory = meta.getSessionFactoryBuilder().build();
    	
    	return factory;

	}

}
