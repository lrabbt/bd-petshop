<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
<<<<<<< HEAD
		</br></br>
		<form:form action="/Petshop/cadastrar/cadastraCliente" class="formValidate" id="formValidate" method="post"  novalidate="novalidate" modelAttribute="cliente">
<br/><br/>

>>>>>>> branch 'desenvolvimento' of https://github.com/lrabbt/bd-petshop.git
			<div>${message}</div>
<<<<<<< HEAD
			
			<label for="uname">Nome*</label>
			<form:input id="uname" name="uname" type="text" data-error=".errorTxt1" path="nome"/></br></br>
			<div class="errorTxt1"></div>
			
			<label for="cemail">E-Mail *</label>
            <form:input id="cemail" type="email" name="cemail" data-error=".errorTxt2" path="email"/></br></br>
             <div class="errorTxt2"></div>
			
			
			<label for="cpf">Cpf *</label>
            <form:input id="cpf" type="cpf" name="cpf" data-error="" path="cpf" /></br></br>
             <div class=""></div>
			
			<label for="end">Endereço *</label>
            <form:input id="end" type="end" name="end" data-error="" path="endereco" /></br></br>
             <div class=""></div>
			
			<label for="data">Data de Nascimento *</label>
            <form:input id="data" type="data" name="data" data-error="" path="dataNasc" /></br></br>
             <div class=""></div>
			
			
			<i class="material-icons prefix"></i>
          <label for="tel1">Telefone 1:</label>
          
          <form:input id="tel1" type="tel" class="validate" path="telefone1" /></br></br>
			
			<i class="material-icons prefix"></i>
          <label for="tel2">Telefone 2:</label>
			 <form:input id="tel2" type="tel" class="validate" path="telefone2" /></br></br>
			
			<i class="material-icons prefix"></i>
          <label for="tel3">Telefone 3:</label>
			 <form:input id="tel3" type="tel" class="validate" path="telefone3" /></br></br>
			
			
			<label for="password">Senha *</label>
            <form:input id="password" type="password" name="password" data-error=".errorTxt3" path="senha" /></br></br>
            <div class="errorTxt3"></div>
			
			<label for="cpassword">Confirm Password *</label>
           <form:input id="cpassword" type="password" name="cpassword" data-error=".errorTxt4" path="" /></br></br>
            <div class="errorTxt4"></div>
			
			
			<td><form:button>Cadastrar</form:button></td>
>>>>>>> branch 'desenvolvimento' of https://github.com/lrabbt/bd-petshop.git
		</form:form>
		
		
		<pre></pre>
		<button  onclick="window.location.href='/Petshop/login/'">Voltar</button><br/>
	</center>
<<<<<<< HEAD
	
	<script type="text/javascript"> 	
     $("#formValidate").validate({
        rules: {
            uname: {
                required: true,
                minlength: 5
            },
            cemail: {
                required: true,
                email:true
            },
            password: {
				required: true,
				minlength: 5
			},
			cpassword: {
				required: true,
				minlength: 5,
				equalTo: "#password"
			},
			cpf: {
                required: true,
                minlength: 11
            },
            end: {
                required: true,
                minlength: 15
            },
            data: {
                required: true,
                minlength: 10
            },
            tel1: {
                required: true,
                minlength: 11
            },
            tel2: {
                required: false,
                minlength: 11
            },
            tel3: {
                required: false,
                minlength: 11
            },
            
        },
        //For custom messages
        messages: {
            uname:{
                required: "Enter a username",
                minlength: "Enter at least 5 characters"
            },
            curl: "Enter your website",
        },
        errorElement : 'div',
        errorPlacement: function(error, element) {
          var placement = $(element).data('error');
          if (placement) {
            $(placement).append(error)
          } else {
            error.insertAfter(element);
          }
        }
     });
 </script>
=======
</body>
>>>>>>> branch 'desenvolvimento' of https://github.com/lrabbt/bd-petshop.git
</html>