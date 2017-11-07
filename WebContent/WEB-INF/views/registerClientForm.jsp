<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Cadastro</title>
	
	<script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
	
</head>
<body>
	<center>
		<h1>Cadastro</h1>
		<hr />
	</br></br>
		<form:form action="/Petshop/cadastrar/cadastraCliente" name="meuForm" class="formValidate" id="formValidate" method="post"  novalidate="novalidate" modelAttribute="cliente">
<br/><br/>

			<div>${message}</div>

			<label for="uname">Nome*</label>
			<form:input id="uname" placeholder="Nome" name="uname" type="text" data-error=".errorTxt1" path="nome" maxlength="50" /></br></br>
			<div class="errorTxt1"></div>
			
			<label for="cemail">E-Mail *</label>
            <form:input id="cemail" placeholder="usuario@email.com" type="text" name="cemail" data-error=".errorTxt2" path="email" maxlength="50"/></br></br>
             <div class="errorTxt2"></div>
			
			
			<label for="cpf">Cpf *</label>
            <form:input id="cpf" placeholder="000.000.000-00"  type="text" name="cpf" data-error="" path="cpf" maxlength="14" /></br></br>
             <div class=""></div>
			
			<label for="end">Endereço *</label>
            <form:input id="end" type="text" placeholder="Rua do usuario, 000. apt:000"  name="end" data-error="" path="endereco" maxlength="50" /></br></br>
             <div class=""></div>
			
			<label for="data">Data de Nascimento *</label>
            <form:input id="data" type="text" placeholder="dd-mm-aaaa" name="data" data-error="" path="dataNasc" maxlength="10" /></br></br>
             <div class=""></div>
			
			
			<i class="material-icons prefix"></i>
          <label for="tel1">Telefone 1:</label>
          
          <form:input id="tel1"  placeholder="(00) 00000-0000" type="text" class="validate" path="telefone1" maxlength="14" /></br></br>
			
			<i class="material-icons prefix"></i>
          <label for="tel2">Telefone 2:</label>
			 <form:input id="tel2" placeholder="(00) 00000-0000" type="text" class="validate" path="telefone2" maxlength="14"/></br></br>
			
			<i class="material-icons prefix"></i>
          <label for="tel3">Telefone 3:</label>
			 <form:input id="tel3"  placeholder="(00) 00000-0000" type="text" class="validate" path="telefone3" maxlength="14"/></br></br>
			
			
			<label for="password">Senha *</label>
            <form:input id="password" type="password" name="password" data-error=".errorTxt3" path="senha" /></br></br>
            <div class="errorTxt3"></div>
			
			<label for="cpassword">Confirm Password *</label>
           <form:input id="cpassword" type="password" name="cpassword" data-error=".errorTxt4" path="" /></br></br>
            <div class="errorTxt4"></div>
			
			
			<td><form:button id="contato" name="cadastro" value="cadastro">Cadastrar</form:button></td>

		</form:form>
		
		
		<pre></pre>
		<button  onclick="window.location.href='/Petshop/login/'">Voltar</button><br/>
	</center>

	
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
                
            },
            end: {
                required: true,
                
            },
            data: {
                required: true,
               
            },
            tel1: {
                required: true,
                
            },
            tel2: {
                required: false,
                
            },
            tel3: {
                required: false,
                
            },
            
        },
        //For custom messages
        messages: {
            cemail:{
                required: "Entre com um email válido",
                minlength: 5
            },
            password:{
            	required: "Você precisa de uma senha",
            	minlength: 5
            }, 
            uname: {
                required: true,
                minlength: 5
            },
           
	
			cpassword: {
				required: "Este campo precisa ser igual sua senha digitada",
				minlength: 5,
				equalTo: "#password"
			},
			cpf: {
                required: "Você precisa cadastrar seu CPF",
                
            },
            end: {
                required: "Preencha um endereço",
               
            },
            data: {
                required: "Informe sua data de nascimento",
               
            },
            tel1: {
                required: "Você precisa de pelo menos um telefone",
               
            },
            tel2: {
                required: false,
                
            },
            tel3: {
                required: false,
                
            },
            
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
<script type="text/javascript">

$(document).ready(function(){
	
	$("#contato").click(function(){
		
		if ($("#unome").val()==''){
			$("#mensagem").html("Campo obrigatório");
			$("#unome").focus(); // foco no campo
			}else{
				$("#meuForm").submit();
		}
		if ($("#cmail").val()==''){
			$("#mensagem").html("Campo obrigatório");
			$("#cmail").focus(); // foco no campo
			}else{
				$("#meuForm").submit();
		}
	
	});
	
});
</script>
</body>

</html>