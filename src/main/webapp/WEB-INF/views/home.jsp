<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Agenda - PetShop</title>
</head>
<body>
	<center>
		<h1>Bem Vindo, ${cliente.nome}!</h1>
		<hr />

		<button onclick="window.location.href='/minhaconta/'">Minha Conta</button>
		<button onclick="window.location.href='/meuspets/'">Meus Pets</button>
		<button onclick="window.location.href='/meusservicos/'">Meus Serviços marcados</button>
		<button onclick="window.location.href='/logout/'">Sair</button>

		</br> </br> </br> </br> </br>
		<h2>${message}</h2>
		<c:if test="${agendaOk}">
			<form:form action="/" modelAttribute="horario" method="post">
				Horario: 
				<form:select path="id">
					<form:option value="0" label="--Select horario--" />
					<form:options items="${horarios}" itemValue="id" itemLabel="dataCompleta"/>
				</form:select> 
				<br/><br/>
				<tr>
					<td><input type="submit" value="Submit" /></td>
				</tr>
			</form:form>
		</c:if>
	</center>
</body>
</html>
