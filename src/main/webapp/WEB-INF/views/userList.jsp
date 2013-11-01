<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<jsp:include page="header.jsp" flush="true">  
	<jsp:param name="title" value="Lista de Usuários"/>  
</jsp:include> 		
<p>${message}</p>		
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
<jsp:include page="footer.jsp" flush="true"/>