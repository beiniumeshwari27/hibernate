package com.codegnan;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.codegnan.entity.Employee;

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
    		//1. Create StandardServiceRegistry
    		registry=new StandardServiceRegistryBuilder()
    				.configure("hibernate.cfg.xml").build();
    		//2. Metadata
    		Metadata metadata=new MetadataSources(registry)
    				.getMetadataBuilder().build();
    		//3. sessionFactory
    		sessionFactory=metadata.getSessionFactoryBuilder().build();
    		try(Session session=sessionFactory.openSession()){
    			Employee emp=session.get(Employee.class,1);
    			if(emp==null) {
    				System.out.println("Employee Not Found");
    				
    			}else {
    				System.out.println("Employee Details");
    				System.out.println("---------------");
    				System.out.println("Employee Id:"+emp.getId());
    				System.out.println("Employee Name:"+emp.getName());
    				System.out.println("Employee Salary:"+emp.getSalary());
    				System.out.println("Employee Department:"+emp.getDepartment());
    			}
    		}
    	}catch(Exception e) {
    		e.printStackTrace();

    	}finally {
    		if(sessionFactory !=null) {
    			sessionFactory.close();
    		}
    		if(registry !=null) {
    			StandardServiceRegistryBuilder.destroy(registry);
    		}
    	}
    }
}