<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agenda - PetShop</title>
</head>
<body>
	<center>
		<h1>Bem Vindo,${client.nome}!</h1>
		<hr />
			
		<button  onclick="window.location.href='/Petshop/minhaconta/'">Minha Conta</button>
		<button  onclick="window.location.href='/Petshop/meuspets/'">Meus Pets</button>
		<button  onclick="window.location.href='/Petshop/meusservicos/'">Meus Serviços marcados</button>
		<button  onclick="window.location.href='/Petshop/logout/'">Sair</button>
	</center>
</body>
</html>
