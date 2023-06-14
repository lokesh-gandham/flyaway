package UsedToCreateAdmin;

import org.hibernate.Session;


import org.hibernate.SessionFactory;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import flyaway.entities.*;

public class lokesh {

	

		public static void main(String[] args) {
			StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.annotations.cfg.xml").build();  
	        
			   Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
			  
			SessionFactory factory = meta.getSessionFactoryBuilder().build();  
			Session session = factory.openSession();  
			session.beginTransaction();
			
            Admin admin=new Admin();
		admin.setId(1);
		admin.setFirstName("lokesh");
		admin.setLastName("aditya");
		admin.setEmail("lokeshgandhamshr@gmail.com");
		admin.setPassword("Lokesh@2721");
		session.save(admin);
	    session.getTransaction().commit();  
		    
		    System.out.println("table created");   
		    System.out.println("username is lokesh");
		    System.out.println("password:Lokesh@2721");
		    factory.close();  
		    session.close();

	

		}

	}