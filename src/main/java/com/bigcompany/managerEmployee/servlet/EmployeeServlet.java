package com.bigcompany.managerEmployee.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bigcompany.managerEmployee.dao.ImplDAO;
import com.bigcompany.managerEmployee.dto.Employee;



@SuppressWarnings("serial")
public class EmployeeServlet extends HttpServlet{
	//idimpotentnûé
	
	private ImplDAO dao = new ImplDAO();
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			 
		if(request.getParameter("edit") == null && request.getParameter("id") == null){
			
			List<Employee> employees = new ArrayList<Employee>();
			employees = dao.getEmployee();			
			request.setAttribute("Employee", employees);			
			getServletContext().getRequestDispatcher("/listEmployee.jsp").forward(request, response);
			
		
		}	
		if(request.getParameter("edit").equals("delete") ){
			int id = Integer.parseInt(request.getParameter("id"));
			dao.deleteEmployee(id);
			response.sendRedirect("/managerEmployee/Employees");
						
		}
      
        if (request.getParameter("edit").equals("add")){
        	
        	request.setAttribute("employee", new Employee());        	        	
        	getServletContext().getRequestDispatcher("/add.jsp").forward(request, response);
        	
        } 
        
        if (request.getParameter("edit").equals("update")){      	
        	
        	int id = Integer.parseInt(request.getParameter("id"));
        	        	
        	Employee employee = dao.readEmployByID(id);
        	request.setAttribute("Employee", employee);
        	getServletContext().getRequestDispatcher("/add.jsp").forward(request, response);
        }
        
		
    }
	
//	 @Override
	    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 Employee employee = new Employee();
		 employee.setName(request.getParameter("name"));
		 employee.setSalary(Double.parseDouble(request.getParameter("salary")));		 
//		 String id = request.getParameter("id");
		 
		 if(Integer.parseInt(request.getParameter("id")) == 0){
			 dao.createEmployee(employee);
		 }
		 else {
			 employee.setId(Integer.parseInt(request.getParameter("id")));
			 dao.updateEmployee(employee);
		 }
		 response.sendRedirect("/managerEmployee/Employees");
		 
//		 RequestDispatcher view = request.getRequestDispatcher( "/add.jsp");
//			request.setAttribute("Employee", dao.getEmployee());
//			view.forward(request, response);
		 
	 }
	
	
}
