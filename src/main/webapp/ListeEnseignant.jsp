<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="Formulaire.jsp">cliquer ici pour ajouter des enseignants </a> <br>

<table border="2">
		<tr>
			<td>Numero Enseignant</td>
			<td>Nom</td>
			<td>Prenom</td>
			<td>Grade</td>
			<td>Id User</td>
		</tr>



<%
	try {
		String strClassName="com.mysql.jdbc.Driver";
		Class.forName(strClassName);
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/bd_enseignant?useSSL=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
		Statement state = connect.createStatement();
		String res = "select * from bd_enseignant.enseignant";
		ResultSet rs1 = state.executeQuery(res);
		
		while(rs1.next()){
			%>
			<tr>
				<td> <%= rs1.getString("numero_enseignant") %></td>
				<td> <%= rs1.getString("nom") %></td>
				<td> <%= rs1.getString("prenom") %></td>
				<td> <%= rs1.getString("grad") %></td>
				<td> <%= rs1.getString("id_user") %></td>
				
				
			</tr>
			
			  
			<% 
		}
		rs1.close();
		connect.close();
		state.close();
	}

	catch (Exception e) {
		
	out.print(e.getMessage());	
	
	}
%>

</table>
</body>
</html>