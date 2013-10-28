<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<%@ include file = "header1.jsp" %>
	<title>Edição de Usuários</title>
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
						<legend>Edição de Usuários</legend>
					</fieldset>
				</form>					
				<p>${message}</p>
				<form:form method="POST" commandName="user" action="${pageContext.request.contextPath}/user/edit/${user.userId}.html" class="form-horizontal">
					<table>
						<tbody>
							<tr>
								<td>Nome:</td>
								<td><form:input path="name" /></td>
							</tr>
							<tr>
								<td>Login:</td>
								<td><form:input path="login" /></td>
							</tr>
							<tr>
								<td>Senha:</td>
								<td><form:input path="password" /></td>
							</tr>
						    <tr>
								<td>Tipo de usuário:</td>
								<td><form:input path="userTypeId" /></td>
							</tr>
							
							<tr>
								<td>Equipe:</td>
								<td><form:input path="teamId" /></td>
							</tr>
							<tr>
								<td><input type="submit" value="Alterar" class="btn btn-default" /></td>
								<td></td>
							</tr>
						</tbody>
					</table>
				</form:form>
				<p><a href="${pageContext.request.contextPath}/userMaintenance.html">Manutenção de Usuários</a></p>
			</div>
		</div>
	</div>	
</body>
</html>