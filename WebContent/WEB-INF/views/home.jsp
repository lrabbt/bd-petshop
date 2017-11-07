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

		<button onclick="window.location.href='/Petshop/minhaconta/'">Minha Conta</button>
		<button onclick="window.location.href='/Petshop/meuspets/'">Meus Pets</button>
		<button onclick="window.location.href='/Petshop/meusservicos/'">Meus Serviços marcados</button>
		<button onclick="window.location.href='/Petshop/logout/'">Sair</button>

		</br> </br> </br> </br> </br>
		<h2>${message}</h2>
		<form:form action="/Petshop/agendaservico/" modelAttribute="marcarServ" method="post">
			Pet: 
			<form:select path="animalAtendido.nome">
				<form:option value="-" label="--Select pet" />
				<form:options items="${petsMap}" />
			</form:select> 
			</br> </br> 
			Servico: 
			<form:select path="tipoDeServico.nome">
				<form:option value="-" label="--Select servico" />
				<form:options items="${servsMap}" />
			</form:select> 
			</br> </br> 
			Horario: 
			<form:select path="horarioDeTrabalho.horarioCompleto.dataCompleta">
				<form:option value="-" label="--Select horario" />
				<form:options items="${horasMap}" />
			</form:select> 
			</br> </br> 
			Funcionario: 
			<form:select path="horarioDeTrabalho.funcionario.nome">
				<form:option value="-" label="--Select funcionario" />
				<form:options items="${funcsMap}" />
			</form:select></br></br>
			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</form:form>
	</center>
</body>
</html>
