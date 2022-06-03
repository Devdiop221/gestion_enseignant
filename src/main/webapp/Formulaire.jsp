<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inscription Enseignant</title>
</head>
<body>
<form method="post" action="Reception.jsp">
		<table>
		<tr>
				<td>Numero Enseignat:</td>
				<td><input type="text" name="numero_enseignant"  required/></td>
			</tr>
			<tr>
				<td>Nom:</td>
				<td><input type="text" name="nom"  required/></td>
			</tr>
			<tr>
				<td>Prenom</td>
				<td><input type="text" name="prenom"  required/></td>
			</tr>
			<tr>
				<td>Grade</td>
				<td><input type="text" name="grade" required/></td>
			</tr>
			<tr>
				<td>ID User:</td>
				<td><input type="text" name="user_id"  required/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Valider"/></td>
		
				<td><input type="reset" value="Annuler"/></td>
			</tr>
		</table>
	</form>

</body>
</html>