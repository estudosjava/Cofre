<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<%@ include file = "header1.jsp" %>
	<title>Lista de Times</title>
</head>
<body>
	<div class="container-fluid">	
		<%@ include file = "header2.jsp" %>		
		<div class="row-fluid">
			<div class="span2">
				<%@ include file = "menu.jsp" %>
			</div>
			<div class="span10">
			<table class="table table-striped" style="width: 700px">
					  <tr>
					    <th>Times</th>
					    <th></th>
					    <th></th>
					  </tr>
					  <tbody>
					  <c:forEach items="${teams}" var="team">
					    <tr>
					      <td style="width: 500px">${team.name}</td>
					      <td><a href="${pageContext.request.contextPath}/team/edit/${team.teamId}.html"><img src="/Cofre/resources/imagens/alterar.png" alt="Alterar"/></a></td>
					      <td><a href="${pageContext.request.contextPath}/team/delete/${team.teamId}.html"><img src="/Cofre/resources/imagens/excluir.gif" alt="Remover"/></a></td>
					    </tr>
					  </c:forEach>
					  </tbody>
					  </table>
					  </div>
		</div>
	</div>		
</body>
</html>
