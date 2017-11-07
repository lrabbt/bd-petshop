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

		<button  onclick="window.location.href='/Petshop/minhaconta/'">Minha Conta</button>
		<button  onclick="window.location.href='/Petshop/meuspets/'">Meus Pets</button>
		<button  onclick="window.location.href='/Petshop/meusservicos/'">Meus Serviços marcados</button>
		<button  onclick="window.location.href='/Petshop/logout/'">Sair</button>
		
		</br></br></br></br></br>
		<form action="/Petshop/meusservicos/"  method="post" modelAttribute="cliente"> 
			Pet:
		    <select name="Pet" onchange="this.form.submit();">
		    	<c:forEach var="pet" items="${pets}">
		        	<option value="${pet.nome}">${pet.nome}</option>
		       </c:forEach>
		    </select> </br></br>
		    Servico:
		    <select name="Servico" onchange="this.form.submit();">
		    	<c:forEach var="servico" items="${servicos}">
		        	<option value="${servico.nome}">${servico.nome}</option>
		       </c:forEach>
		    </select> </br></br>
		    Horario:
		    <select name="Horario" onchange="this.form.submit();">
		    	<c:forEach var="horario" items="${horarios}">
		        	<option value="${horario.dataCompleta}">${pet.dataCompleta}</option>
		       </c:forEach>
		    </select> </br></br>
		    Funcionario:
		    <select name="Funcionario" onchange="this.form.submit();">
		    	<c:forEach var="func" items="${funcionarios}">
		        	<option value="${func.nome}">${func.nome}</option>
		       </c:forEach>
		    </select>
		</form>
	</center>
</body>
</html>
