<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>	
	<%@ include file = "header1.jsp" %>	
    <title>Cadastro de usuários</title>    
</head>
<body>
	<div class="container-fluid">	
		<%@ include file = "header2.jsp" %>		
		<div class="row-fluid">
			<div class="span2">
				<%@ include file = "menu.jsp" %>
			</div>
			<div class="span10">
				<form class="form-horizontal">
					<fieldset>
						<legend>Cadastro de Usuários</legend>
					</fieldset>
				</form>									 
		  		<p>Cadastre o novo usuário nos campos abaixo:</p>
				<form:form method="POST" commandName="usuario" action="${pageContext.request.contextPath}/usuario/add.html" class="form-horizontal">
					<table>
						<tbody>
						    <tr>
								<td>Nome:</td>
								<td><form:input path="nome" /></td>
							</tr>
							<tr>
								<td>Login:</td>
								<td><form:input path="login" /></td>
							</tr>
							<tr>
								<td>Senha:</td>
								<td><form:input path="senha" /></td>
							</tr>
						    <tr>
								<td>Tipo de usuário:</td>
								<td><form:input path="codTipoUsuario" /></td>
							</tr>
							
							<tr>
								<td>Equipe:</td>
								<td><form:input path="codEquipe" /></td>
							</tr>																				
							<tr>
								<td><input type="submit" value="Cadastrar" class="btn btn-default" /></td>
								<td></td>
							</tr>
						</tbody>
					</table>
				</form:form>				
				<p><a href="${pageContext.request.contextPath}/manutencaoDeUsuario.html">Manutenção de Usuários</a></p>
			</div>
		</div>
	</div>		
</body>
</html>