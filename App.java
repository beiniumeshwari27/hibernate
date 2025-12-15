package com.codegnan;

import java.util.HashSet;
import java.util.Set;

//import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.codegnan.beans.Course;
import com.codegnan.beans.Student;


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
        		/*System.out.println("Retriving Employee and address");
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
        		}*/
        		/*Transaction tx=session.beginTransaction();
        		Department dept=new Department("Human resources");
        		Employee e1=new Employee("Ravi Kumar",50000);
        		Employee e2=new Employee("Sita Devi",55000);
        		Employee e3=new Employee("Akhil",60000);
        		dept.addEmployee(e1);
        		dept.addEmployee(e2);
        		dept.addEmployee(e3);
        		session.save(dept);
        		tx.commit();
        		System.out.println("One-To-Many records inserted sucessfully");
        		Department savedDepartment=session.get(Department.class,dept.getDeptId());
        		System.out.println("Employees under this Department");
        		savedDepartment.getEmployees().forEach(
        				emp->System.out.println("-"+emp.getEmpName()+
        						"(salary:"+emp.getEmpSalary()+")"));*/
        		/*Transaction tx=session.beginTransaction();
        		Branch cse=new Branch("CSE","Hyderabad");
        		Branch ece=new Branch("ECE","Chennai");
        		session.save(cse);
        		session.save(ece);
        		//create Students Many-To-One Relationship
        		Student s1=new Student("Ravi","Vijayawada",450,cse);
        		Student s2=new Student("Anil","Guntur",470,cse);
        		Student s3=new Student("Kiran","Chennai",440,ece);
        		Student s4=new Student("Lakshmi","Vijayawada",480,cse);
        		session.save(s1);
        		session.save(s2);
        		session.save(s3);
        		session.save(s4);
        		tx.commit();
        		System.out.println("Data inserted sucessfully");*/
        		/*List<Student>students=session.
        				createQuery("FROM Student",Student.class).list();
        		System.out.println("Student Details with branch information");
        		for(Student s:students) {
        			System.out.println("Student Id"+s.getSid());
        			System.out.println("Name:"+s.getSname());
        			System.out.println("City:"+s.getCity());
        			System.out.println("Marks:"+s.getMarks());
        			System.out.println("Branch Name:"+s.getBranch().getBname());
        			System.out.println("Branch Location:"+s.getBranch().getLocation());
        			System.out.println("----------------------------");
        			
        		}*/
        		Transaction transaction=session.beginTransaction();
        		Course c1=new Course("c-111","c",5000);
        		Course c2=new Course("c-222","java",50000);
        		Course c3=new Course("c-333","c++",15000);
        		Set<Course>courses=new HashSet<>();
        		courses.add(c1);
        		courses.add(c2);
        		courses.add(c3);
        		Student s1=new Student("s-111","malli","hyd",courses);
        		Student s2=new Student("s-222","arjun","bng",courses);
        		Student s3=new Student("s-333","sunny","vjy",courses);
        		session.save(s1);
        		session.save(s2);
        		session.save(s3);
        		System.out.println("Students inserted sucessfully");
        		
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