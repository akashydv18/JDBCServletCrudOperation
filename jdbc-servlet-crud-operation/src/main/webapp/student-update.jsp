<%@page import="com.ibm.jdbc_servlet_crud_operation.prepared_statement.dto.Student"%>
<%@page import="com.ibm.jdbc_servlet_crud_operation.prepared_statement.dao.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		
		<% 
		     int id = Integer.parseInt(request.getParameter("id"));
				Student student=new StudentDao().getStudentByIdDao(id);
		%>
		
		
		<form action="updateStudent" method="post">
		
		<input type="number"  name="id" value="<%=id%>" readonly="readonly" hidden="true"><br>
		<label>NAME:</label><br>
		<input type="text"  name="name" value="<%=student.getName()%>"><br>
		<label>EMAIL:</label><br>
		<input type="email"  name="email" value="<%=student.getEmail()%>"><br>
		<label>PASSWORD:</label><br>
		<input type="password"  name="password" value="<%=student.getPassword()%>"><br>
		<label>PHONE:</label><br>
		<input type="tel"  name="phone" value="<%=student.getPhone()%>"><br>
		<label>ADDRESS:</label><br>
		<input type="text"  name="address" value="<%=student.getAddress()%>"><br>
		<label>DOB:</label><br>
		<input type="date" name="dob" value="<%=student.getDob()%>"><br><br>
		<input type="submit" value="Update">
	</form>
</body>
</html>