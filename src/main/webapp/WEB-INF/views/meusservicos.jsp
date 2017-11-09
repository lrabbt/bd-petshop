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

		<h1>Servicos</h1>
		<h2>${messageServicos}</h2>
		<h2>${message}</h2>
		<c:if test="${temServicos}">
			<table border="1" cellpadding="5">
				<caption>
					<h2>Meus Pets</h2>
				</caption>
				<tr>
					<th>Nome Animal</th>
					<th>Tipo Servico</th>
					<th>Preco</th>
					<th>Funcionario</th>
					<th>Horario</th>
				</tr>
				<tr>
					<c:forEach var="servico" items="${servicos}">
						<tr>
							<td><c:out value="${servico.animalAtendido.nome}" /></td>
							<td><c:out value="${servico.tipoDeServico.nome}" /></td>
							<td><c:out value="${servico.tipoDeServico.preco}" /></td>
							<td><c:out value="${servico.horarioDeTrabalho.funcionario.nome}" /></td>
							<td><c:out value="${servico.horarioDeTrabalho.horarioCompleto.dataCompleta}" /></td>
						</tr>
					</c:forEach>
				</tr>
			</table>
		</c:if>
		<br />
		<br />
		<div>
			<button onclick="window.location.href='/'">Voltar</button>
		</div>
	</center>
</body>
</html>