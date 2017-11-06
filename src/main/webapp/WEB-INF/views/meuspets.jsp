<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>My Boards</title>
</head>
<body>
	<center>
		<h1>${message}</h1>
		<h1>Pets</h1>
		<table border="1" cellpadding="5">
			<caption>
				<h2>Meus Pets</h2>
			</caption>
			<tr>
				<th>Espécie</th>
				<th>Nome</th>
				<th>Raça</th>
				<th>Sexo</th>
				<th>Idade</th>
				<th>Maturidade</th>
			</tr>
			<tr>
				<c:forEach var="pet" items="${pets}">
					<tr>
						<td><c:out value="${pet.especie.nome}" /></td>
						<td><c:out value="${pet.nome}" /></td>
						<td><c:out value="${pet.raca}" /></td>
						<td><c:out value="${pet.sexo}" /></td>
						<td><c:out value="${pet.idade}" /></td>
						<td><c:out value="${pet.maturidade}" /></td>
					</tr>
				</c:forEach>
			</tr>
		</table>
	</center>
</body>
</html>