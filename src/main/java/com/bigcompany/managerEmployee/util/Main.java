package com.bigcompany.managerEmployee.util;

import com.bigcompany.managerEmployee.dao.ImplDAO;
import com.bigcompany.managerEmployee.dto.Employee;

public class Main {
	public static void main (String[] args){
		
		ImplDAO dao = new ImplDAO();
//		System.out.println(dao.readEmployByID(3
//				));
//		dao.updateEmployee(employee);
		Employee employee = new Employee(" Anna", 7000);
//		dao.updateEmployee(employee);
//		dao.createEmployee(employee);
		System.out.println(" Fin");
		
		
	}

}
