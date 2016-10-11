package com.example.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import com.example.java.Employee;

public class EmployeeUtilityStream {
	

	
	List<Employee> list = new ArrayList<Employee>();
	
	public EmployeeUtilityStream()
	{
		init();
		
	}
	
	private void init()
	{
		Employee emp = new Employee();
		emp.setName("Shamik Mitra");
		emp.setManager(false);
		emp.setSex("Male");
		emp.setSalary(20000);
		emp.setDept("Java");
		
		Employee emp1 = new Employee();
		emp1.setName("Aman Verma");
		emp1.setManager(true);
		emp1.setSex("Male");
		emp1.setSalary(50000);
		emp1.setDept("IOT");
		
		Employee emp2 = new Employee();
		emp2.setName("Priti Dey");
		emp2.setManager(true);
		emp2.setSex("FeMale");
		emp2.setSalary(40000);
		emp2.setDept("Mainframe");
		
		Employee emp3 = new Employee();
		emp3.setName("Ajay Ghosh");
		emp3.setManager(false);
		emp3.setSex("Male");
		emp3.setSalary(30000);
		emp3.setDept("Java");
		
		list.add(emp);
		list.add(emp1);
		list.add(emp2);
		list.add(emp3);
	}
	
	public void filterList(Predicate<Employee> predicate) {
		 
		Stream<Employee> employeeStream = list.parallelStream();
		
		Stream<Employee> filteredEmployeeStream = employeeStream.filter(predicate);
		
		filteredEmployeeStream.forEach(employee->System.out.println(employee));
		
	}
	
	
	
	public static void main(String[] args) {
		
		EmployeeUtilityStream employeeUtiltyStream = new EmployeeUtilityStream();
		
		employeeUtiltyStream.filterList(employee->employee.getSalary()<=40000);
		System.out.println("****************************************");
		employeeUtiltyStream.filterList( employee->employee.getSex().equalsIgnoreCase("FeMale"));
		System.out.println("****************************************");
		employeeUtiltyStream.filterList( employee->employee.isManager());
		System.out.println("****************************************");
		employeeUtiltyStream.filterList( employee->employee.getDept().equalsIgnoreCase("Java"));
		
		
		
	}

}
