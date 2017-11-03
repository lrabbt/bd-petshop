<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login</title>
</head>
<body>
	<center>
		<h1>Bem vindo ao Sistema de Agendamento - PetShopCC</h1>
		<hr />
		</br></br>
		<form:form action="/Petshop/login/authClient" method="post" modelAttribute="cliente">
			<div>${message}</div>
			Email:<form:input path="email" />
			Senha:<form:input path="senha" />
			<form:button>Logar</form:button>
		</form:form>
		<pre></pre>
		<button  onclick="window.location.href='/Petshop/cadastrar/'">Cadastrar</button>
		<pre></pre>
	</center>
</html>