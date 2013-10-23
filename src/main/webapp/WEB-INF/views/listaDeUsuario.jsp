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
							<th width="5%">Código</th>
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
						<c:forEach var="usuario" items="${usuarios}">
							<tr>
								<td>${usuario.codUsuario}</td>
								<td>${usuario.nome}</td>
								<td>${usuario.login}</td>
								<td>${usuario.senha}</td>
								<td>${usuario.codTipoUsuario}</td>
								<td>${usuario.codEquipe}</td>
								<td>
									<a href="${pageContext.request.contextPath}/usuario/edit/${usuario.codUsuario}.html"><img src="/Cofre/resources/imagens/alterar.png" alt="Editar"/></a>
								</td>
								<td>
								<a href="${pageContext.request.contextPath}/usuario/delete/${usuario.codUsuario}.html"><img src="/Cofre/resources/imagens/excluir.gif" alt="Excluir"/></a><br/>
								</td>							
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<br />				
				<p><a href="${pageContext.request.contextPath}/manutencaoDeUsuario.html">Manutenção de Usuário</a></p>
			</div>
		</div>
	</div>		
</body>
</html>