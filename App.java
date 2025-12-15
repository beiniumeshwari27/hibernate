package com.codegnan;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        StandardServiceRegistry registry=null;
        SessionFactory sessionFactory=null;
        try {
        	registry=new StandardServiceRegistryBuilder()
        			.configure("hibernate.cfg.xml")
        			.build();
        	Metadata metadata=new MetadataSources(registry).buildMetadata();
        	sessionFactory=metadata.getSessionFactoryBuilder().build();
        	try(Session session=sessionFactory.openSession()){
        		Transaction transaction=session.beginTransaction();
        		String hql="INSERT INTO Employee(eno,ename,esal,eaddr)"
        		+"values(:id,:name,:salary,:addr)";
        		Query<?>query=session.createNativeQuery(hql);
        		query.setParameter("id",444);
        		query.setParameter("name","ArjunSarkar");
        		query.setParameter("salary",52650.00);
        		query.setParameter("addr","Hyderabad");
        		/*String hql="update Employee set esal=:salary where eno=:id";
        		Query<?>query=session.createNativeQuery(hql);
        		query.setParameter("salary",62650.00);
        		query.setParameter("id",111);*/
        		/*String hql="delete from Employee where eno=:id";
        		Query<?>query=session.createNativeQuery(hql);
        		query.setParameter("id",111);*/
        		
        		int result=query.executeUpdate();
        		transaction.commit();
        		System.out.println("Records inserted :"+result);
        	}catch(Exception e) {
        		e.printStackTrace();
        	}
        }catch(Exception e) {
    		e.printStackTrace();
    	}finally {
    		if(sessionFactory!=null) {
    			sessionFactory.close();
    		}if(registry!=null) {
    			StandardServiceRegistryBuilder.destroy(registry);
    		}
    	}
    }
}