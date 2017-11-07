<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Login</title>

</head>
<body>
	<div class="login">
	
	<center>
		<h1>Bem vindo ao Sistema de Agendamento - PetShopCC</h1>
		<hr />

		</br></br>

		<br/><br/>
		<form:form action="/Petshop/login/authClient" method="post" modelAttribute="cliente">

			<div>${message}</div>
			
			<label for="cemail">E-mail</label>
			<form:input type="email" id="cemail" name="cemail" data-error=".errorTxt2" path="email" />
			<label for="password">Senha *</label>
			<form:input id="password" type="password" name="password" data-error=".errorTxt3" path="senha" />
			
			
			
			
			<form:button>Logar</form:button>
		</form:form>
		<pre></pre>
		<button  onclick="window.location.href='/Petshop/cadastrar/">Cadastrar</button>
		<pre></pre>
	</center>

	</div>
	
	
	
	
	
	
<script type="text/javascript"> 	
     $("#formValidate").validate({
        rules: {
            
            cemail: {
                required: true,
                email:true
            },
            password: {
				required: true,
				minlength: 5
			},
			
			
        },
        //For custom messages
        messages: {
            cemail:{
                required: "Entre com um email v?lido",
                minlength: 5
            },
            password:{
            	required: "Voc? precisa de uma senha",
            	minlength: 5
            } 
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




</body>

</html>