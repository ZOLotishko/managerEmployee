package com.bigcompany.managerEmployee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.bigcompany.managerEmployee.dto.Employee;
import com.bigcompany.managerEmployee.util.MYSQLConnection;




public class ImplDAO { 
	
	
	public List<Employee> getEmployee() {

		Connection connection = MYSQLConnection.getConnection();
		
		String sql = "SELECT id, name, salary FROM stuff ";
				
		ResultSet resultSet = null;
		
		List<Employee> employees = new ArrayList<Employee>();
		
		PreparedStatement preparedStatement = null;
		
		try {
			
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery(sql);
			
			while(resultSet.next()){
				
				Employee employee = new Employee();
				
				employee.setId(resultSet.getInt("id"));
				employee.setName(resultSet.getString("name"));
				employee.setSalary(resultSet.getDouble("salary"));
				employees.add(employee);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if (connection != null){
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return employees;
	
	}
	
	public void deleteEmployee(int id){

		Connection connection = MYSQLConnection.getConnection();
		
		String sql = "DELETE FROM stuff WHERE id = ?";
		
		try {
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
public void createEmployee(Employee employee) {
    	
        Connection connection = MYSQLConnection.getConnection();

        final String sql = "INSERT into stuff ( name, salary) VALUES (?,?)";
        
        PreparedStatement preparedStatement = null;
        
//        ResultSet resultSet = null;
       
        try {
            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setInt(1, employee.getId());
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setDouble(2, employee.getSalary());
            preparedStatement.executeUpdate();
//            resultSet = preparedStatement.getGeneratedKeys();
            
//            if (resultSet.next()) {
//            	employee.setId(resultSet.getInt(1));
//            }
        } catch (SQLException e) {
             e.printStackTrace();
        }
        finally {
            try {
                if(!connection.isClosed()){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

public Employee readEmployByID(int id) {
	    
    Connection connection = MYSQLConnection.getConnection();

    final String sql = "SELECT id, name, salary FROM stuff WHERE id = ?";

    ResultSet resultSet = null;

    PreparedStatement prepStatement = null;
    
    Employee employee = new Employee();

    try  {
        prepStatement = connection.prepareStatement(sql);
        prepStatement.setInt(1, id);
        resultSet = prepStatement.executeQuery();
        resultSet.next();
        	employee.setId(resultSet.getInt("id"));
        	employee.setName(resultSet.getString("name"));
        	employee.setSalary(resultSet.getDouble("salary"));
        	
        
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if(!connection.isClosed()){
                connection.close();
            }
        } catch (SQLException e) {
             e.printStackTrace();
        }
    }
        
    return employee;
}
public void updateEmployee(Employee employee) {	
   
    Connection connection = MYSQLConnection.getConnection();
    
    PreparedStatement statement = null;
    
    final String sql = "UPDATE stuff SET Name = ?, salary = ? WHERE id=?";

    try {
        statement = connection.prepareStatement(sql);
        statement.setString(1, employee.getName());
        statement.setDouble(2, employee.getSalary());
        statement.setInt(3, employee.getId());
        statement.executeUpdate();
    } catch (SQLException e) {
       e.printStackTrace();
    }
    finally {
        try {
            if (connection != null) connection.close();
            if (statement != null) statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }   
}

}
