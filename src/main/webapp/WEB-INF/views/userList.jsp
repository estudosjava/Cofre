<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<%@ include file = "header1.jsp" %>
	<title>Lista de Usuários</title>
</head>
<body>
	<div class="container-fluid">	
		<%@ include file = "header2.jsp" %>		
		<div class="row-fluid">
			<div class="span2">
				<%@ include file = "menu.jsp" %>
			</div>
			<div class="span10">
<!-- 				<h4>Lista de Usuários</h4>	 -->
				<legend>Lista de Usuários</legend>
				<table class="table table-striped" >
					<thead>
						<tr>							
							<th width="15%">Nome</th>
							<th width="10%">Login</th>
							<th width="10%">Senha</th>
							<th width="10%">Tipo de Usuário</th>
							<th width="10%">Equipe</th>		
							<th width="2%"></th>
							<th width="2%"></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="user" items="${users}">
							<tr>							
								<td>${user.name}</td>
								<td>${user.login}</td>
								<td>${user.password}</td>
								<td>${user.userTypeId}</td>
								<td>${user.teamId}</td>
								<td>
									<a href="${pageContext.request.contextPath}/user/edit/${user.userId}.html"><img src="/Cofre/resources/imagens/alterar.png" alt="Editar"/></a>
								</td>
								<td>
								<a href="${pageContext.request.contextPath}/user/delete/${user.userId}.html"><img src="/Cofre/resources/imagens/excluir.gif" alt="Excluir"/></a><br/>
								</td>							
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<br />				
				<p><a href="${pageContext.request.contextPath}/userMaintenance.html">Manutenção de Usuário</a></p>
			</div>
		</div>
	</div>		
</body>
</html>