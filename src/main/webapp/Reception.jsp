<%@page import="model.Enseignant"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
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

<a href="ListeEnseignant.jsp"> La Liste des Enseignants</a> <br>

<%
Enseignant enseignant =  new Enseignant();
enseignant.setNumero_enseignant(request.getParameter("numero_enseignant"));
enseignant.setNom(request.getParameter("nom"));
enseignant.setPrenom(request.getParameter("prenom"));
enseignant.setGrade(request.getParameter("grade"));
enseignant.setId_user(request.getParameter("user_id"));

%>

Le numero  de l'enseigant  est : <%= enseignant.getNumero_enseignant() %> <br>
Le nom  de l'enseigant  est : <%= enseignant.getNom() %> <br>
Le prenom de l'enseigant est : <%= enseignant.getPrenom() %> <br>
Le grade de l'enseigant est : <%= enseignant.getGrade() %> <br>
L'Id User de l'enseigant  est : <%= enseignant.getId_user() %> <br>


<%
	try {
		String strClassName="com.mysql.jdbc.Driver";
		Class.forName(strClassName);
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/bd_enseignant?useSSL=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
		Statement state = connect.createStatement();
		String res = "insert into bd_enseignant.enseignant(numero_enseignant,nom,prenom,grad,id_user)VALUES('"+ enseignant.getNumero_enseignant()+"','"+enseignant.getNom()+"','"+enseignant.getPrenom()+"','"+enseignant.getGrade()+"', '"+enseignant.getId_user()+"')";
		state.executeUpdate(res);
	}

	catch (Exception e) {
		
		e.getMessage();
		
	}
%>

 

</body>
</html>