package com.codegnan;

import java.util.List;

import com.codegnan.entity.Employee;
import com.codegnan.exception.InvalidEmployeeIdException;
import com.codegnan.service.EmployeeService;
import com.codegnan.service.EmployeeServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       EmployeeService service=new EmployeeServiceImpl();
       //add employee
      /* Employee e1=new Employee("Teju","sales",30000);
       //int id=service.addEmployee(e1);
       System.out.println("Inserted Employee id :"+id);*/
     //search the employee with id
       /* try {
 		Employee emp=service.getEmployeeById(1);
 		System.out.println("Employee details : "+emp);
 	} catch (InvalidEmployeeIdException e) {
 		// TODO Auto-generated catch block
 		e.printStackTrace();
 	}*/
        //List of all Employees
        /*System.out.println("All Employees");
        List<Employee>employees=service.getAllEmployees();
        employees.forEach(System.out::println);*/
        
        /*Employee emp=new Employee(1,"kumar","training ",57300);
        try {
 		service.updateEmployee(emp);
 		System.out.println("Employee updated successfully");
 	} catch (InvalidEmployeeIdException e) {
 		// TODO Auto-generated catch block
 		e.printStackTrace();
 	}*/
        
        
        //delete the employee 4
        try {
 		service.deleteEmployee(4);
 		System.out.println("Employee deleted successfully");
 	} catch (InvalidEmployeeIdException e) {
 		
 		e.printStackTrace();
 	}
    }
       
}