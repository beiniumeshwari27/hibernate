package com.codegnan;

//import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.codegnan.entity.Address;
import com.codegnan.entity.Employee;


public class App 
{
    public static void main( String[] args )
    {
        StandardServiceRegistry registry=null;
        SessionFactory sessionFactory=null;
        try {
        	//step-1 load configuration and build session factory
        	registry=new StandardServiceRegistryBuilder()
        			.configure("hibernate.cfg.xml").build();
        	Metadata metadata=new MetadataSources(registry)
        			.getMetadataBuilder().build();
        	sessionFactory=metadata.getSessionFactoryBuilder().build();
        	try (Session session=sessionFactory.openSession()){
        		/*Transaction tx=session.beginTransaction();
        		Address address=new  Address("Hyderabad","telangana","500001");
        		Employee employee=new Employee("ravikumar",65000);
        		address.setEmployee(employee);
        		employee.setAddress(address);
        		session.save(employee);
        		tx.commit();
        		System.out.println("record inserted successfully");
        		System.out.println(employee);*/
        		System.out.println("Retriving Employee and address");
        		Employee emp=session.get(Employee.class,1);
        		if(emp!=null) {
        			System.out.println("Employee Found");
        			System.out.println("Employee Id:"+emp.getEmpId());
        			System.out.println("Employee Name:"+emp.getEmpName());
        			System.out.println("Employee Salary:"+emp.getEmpSalary());
        			Address addr=emp.getAddress();
        			if(addr!=null) {
        				System.out.println("Address Details");
        				System.out.println("City:"+addr.getCity());
        				System.out.println("State:"+addr.getState());
        				System.out.println("Pin Code:"+addr.getPincode());
        			}else {
        				System.out.println("No Address Found For This Employee");
        			}	
        		}else {
        			System.out.println("Employee Not Found");
        		}
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