<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>ListEmployee</title>
</head>
<body>
	<h1>listEmployee</h1>
	<table>
		<tr>
			<th>id</th>
			<th>name</th>
			<th>salary</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${Employee}" var="emp">
			<tr>
				<td>${emp.id}</td>
				<td>${emp.name}</td>
				<td>${emp.salary}</td>
				<td><a href= "<c:url value= "/Employees?edit=delete&id=${emp.id}"/> ">	delete</a></td>				
				<td><a href= "<c:url value= "/Employees?edit=update&id=${emp.id}"/> ">	update</a></td>			

			</tr>
		</c:forEach>
			
	</table>
	<br/><h3>	
				<a href="<c:url value="/Employees?edit=add"/>">	add</a>	
	</h3>
</body>
</html>