package com.bigcompany.managerEmployee.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class HomeServlet extends HttpServlet {

	 private Date currentDate;
	 private DateFormat dateFormat;
	 
	@Override
	public void init(){
		
		dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		currentDate = new Date();
		
		
	}
	@Override
	public void doGet( HttpServletRequest req , HttpServletResponse pos){
		req.setAttribute( "date" ,dateFormat.format(currentDate) );
		try {
			getServletContext().getRequestDispatcher("/home.jsp").forward(req, pos);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
				
	}
//	public void Servicec(){
//		
//	}
}
