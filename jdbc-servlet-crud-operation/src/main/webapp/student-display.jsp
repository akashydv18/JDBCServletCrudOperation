<%@page import="jakarta.servlet.RequestDispatcher"%>
<%@page import="jakarta.servlet.http.HttpSession"%>
<%@page import="java.util.List"%>
<%@page import="com.ibm.jdbc_servlet_crud_operation.prepared_statement.dto.Student"%>
<%@page import="com.ibm.jdbc_servlet_crud_operation.prepared_statement.dao.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<%
			StudentDao dao = new StudentDao();
		
			List<Student> students=dao.getAllStudentDao();
			
			HttpSession httpSession = request.getSession();
			
			String emaildb=(String)httpSession.getAttribute("userSession");
		%>

		<%if(students!=null&&!students.isEmpty()){ 
			
			if(emaildb!=null){
		
		%>
	
			<h5>student-display</h5>
		
		<table border="2">
			<tr>
				<th>ID:</th>
				<th>NAME:</th>
				<th>EMAIL:</th>
				<th>PHONE:</th>
				<th>ADDRESS:</th>
				<th>DOB:</th>
				<th colspan="2">Action</th>
			</tr>
			
			<%for(Student student:students) {%>
			
			<tr>
				<td><%=student.getId()%></td>
				<td><%=student.getName()%></td>
				<td><%=student.getEmail()%></td>
				<td><%=student.getPhone()%></td>
				<td><%=student.getAddress()%></td>
				<td><%=student.getDob()%></td>
				<td><a href="deletestudent?id=<%=student.getId()%>">DELETE</a></td>
				<td><a href="student-update.jsp?id=<%=student.getId()%>">EDIT</a></td>
			</tr>
			
			<%}%>
		
		</table>
		
		<a href="logout">logout</a>
		
		<%}else{%>
		
		<%
		out.write(
				"<html><body><script>alert('your session is expired please login and proceed further');</script></body></html>");
		RequestDispatcher dispatcher = request.getRequestDispatcher("student-login.jsp");
		dispatcher.include(request, response);
		%>
		
		<%}%>
		
		<%} else{%>
		
			<h5>table is empty</h5>
		
		<%}%>
</body>
</html>