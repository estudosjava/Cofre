<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" flush="true">  
	<jsp:param name="title" value="Manutenção de Usuários"/>  
</jsp:include> 
		${message}
		<br />
		<br />
		<a href="${pageContext.request.contextPath}/user/add.html">Adiciona novo usuário</a>
		<br />
		<a href="${pageContext.request.contextPath}/user/list.html">Lista usuários</a>						
<jsp:include page="footer.jsp" flush="true"/>