<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro</title>
</head>
<body>
	<center>
		<h1>Cadastro</h1>
		<hr />
		</br></br>
		<form:form action="/cadastrar/cadastraCliente" method="post" modelAttribute="cliente">
			<div>${message}</div>
			Nome:<form:input path="nome"/></br></br>
			Email:<form:input path="email" /></br></br>
			Cpf:<form:input path="cpf" /></br></br>
			Endereço:<form:input path="endereco" /></br></br>
			Data de Nascimento:<form:input path="dataNasc" /></br></br>
			Telefone 1:<form:input path="telefone1" /></br></br>
			Telefone 2:<form:input path="telefone2" /></br></br>
			Telefone 3:<form:input path="telefone3" /></br></br>
			Senha:<form:input path="senha" /></br></br>
			<td><form:button>Cadastrar</form:button></td>
		</form:form>
		<pre></pre>
		<button  onclick="window.location.href='/login/'">Voltar</button></br>
	</center>
</html>