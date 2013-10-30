<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<jsp:include page="header.jsp" flush="true">  
	<jsp:param name="title" value="Lista de Times"/>  
</jsp:include> 				
<table class="table table-striped" style="width: 700px">	
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
<jsp:include page="footer.jsp" flush="true"></jsp:include>
