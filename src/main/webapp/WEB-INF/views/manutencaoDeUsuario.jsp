<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<%@ include file = "header1.jsp" %>
	<title>Manutenção de Usuários</title>
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
						<legend>Manutenção de Usuários</legend>						
						${message}
						<br />
						<br />
						<a href="${pageContext.request.contextPath}/usuario/add.html">Adiciona novo usuário</a>
						<br />
						<a href="${pageContext.request.contextPath}/usuario/list.html">Lista usuários</a>						
					</fieldset>
				</form>
			</div>
		</div>				
	</div>
</body>
</html>