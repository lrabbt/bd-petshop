<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Petshop - Minha Conta</title>
</head>
<body>
	<center>
		<h1>Minha Conta</h1>
		<hr />
		<br/><br/>
		<form:form action="atualizar" method="post" modelAttribute="cliente">
			<div>${message}</div>
			<label for="uname">Nome*
			<form:input id="uname" placeholder="Nome" name="uname" type="text" data-error=".errorTxt1" path="nome" maxlength="50" /></br></br>
			<span class="error" aria-live="polite"></span>
			</label>
			
			<label for="cemail">E-Mail *
            <form:input id="cemail" placeholder="usuario@email.com" type="text" name="cemail" data-error=".errorTxt2" path="email" maxlength="50"/></br></br>
            
			</label>
			
			<label for="cpf">Cpf *
            <form:input id="cpf" placeholder="000.000.000-00"  type="text" name="cpf" data-error="" path="cpf" minlength="14" maxlength="14" /></br></br>
             <span class="error" aria-live="polite"></span>
             </label>
			
			<label for="end">Endereço *</label>
            <form:input id="end" type="text" placeholder="Rua do usuario, 000. apt:000"  name="end" data-error="" path="endereco" maxlength="50" /></br></br>
             <div class=""></div>
			
			<label for="data">Data de Nascimento *</label>
            <form:input id="data" type="text" placeholder="dd-mm-aaaa" name="data" data-error="" path="dataNasc" minlength="10" maxlength="10" /></br></br>
             <div class=""></div>
			
			
			<i class="material-icons prefix"></i>
          <label for="tel1">Telefone 1:</label>
          
          <form:input id="tel1"  placeholder="(00) 00000-0000" type="text" class="validate" path="telefone1" minlength="11" maxlength="14" /></br></br>
			
			<i class="material-icons prefix"></i>
          <label for="tel2">Telefone 2:</label>
			 <form:input id="tel2" placeholder="(00) 00000-0000" type="text" class="validate" path="telefone2" minlength="11" maxlength="14"/></br></br>
			
			<i class="material-icons prefix"></i>
          <label for="tel3">Telefone 3:</label>
			 <form:input id="tel3"  placeholder="(00) 00000-0000" type="text" class="validate" path="telefone3" minlength="11" maxlength="14"/></br></br>
			
			
			<label for="password">Senha *</label>
            <form:input id="password" type="password" name="password" data-error=".errorTxt3" path="senha" /></br></br>
            <div class="errorTxt3"></div>
			
			<label for="cpassword">Confirm Password *</label>
           <form:input id="cpassword" type="password" name="cpassword" data-error=".errorTxt4" path="" /></br></br>
            <div class="errorTxt4"></div>

			<td><form:button>Atualizar</form:button></td>
		</form:form>
		<pre></pre>
		<button  onclick="window.location.href='/Petshop/'">Voltar</button><br/>
	</center>
</body>
</html>