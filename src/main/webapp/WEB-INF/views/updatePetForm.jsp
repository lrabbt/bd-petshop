<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<style type="text/css">
		.remove-button {
			color: red;
		}
	</style>
	<title>Cadastro Animal</title>
</head>
<body>
	<center>
		<h1>Cadastro Animal</h1>
		<hr />
		<br/><br/>
		<div>${message}</div>
		<form:form action="/meuspets/${nomeAntigoAnimal}" method="post" modelAttribute="animal">
			<p>Nome:<form:input path="nome"/></p>
			<p>Especie:
				<form:select path="especie">
					<form:option value="NONE" label="--- Escolha ---"/>
					<form:options items="${especies}" itemValue="nome" itemLabel="nome"/>
				</form:select>
			</p>
			<p>Ra�a:<form:input path="raca" /></p>
			<p>Sexo:
				<form:select path="sexo">
				    <form:option value="NONE" label="--- Escolha ---" />
				    <form:options items="${sexos}" />
				</form:select>
			</p>
			<p>Idade:<form:input path="idade" /></p>
			<p>Maturidade:<form:input path="maturidade" /></p>
			<p>Saude:<form:input path="saude" /></p>
		<p><form:button>Atualizar</form:button></p>
		</form:form>
		<pre></pre>
		<form:form action="/meuspets/${nomeAntigoAnimal}" method="delete" modelAttribute="animal">
			<form:button class="remove-button">Desregistrar</form:button>
		</form:form>
		<hr/>
		<button onclick="window.location.href='/meuspets/'">Voltar</button><br/>
	</center>
</body>
</html>