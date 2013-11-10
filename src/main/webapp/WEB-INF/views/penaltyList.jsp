<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="header.jsp" flush="true">
	<jsp:param name="title" value="Lista de Multas" />
</jsp:include>
<p>${message}</p>
<table class="table table-striped">
	<thead>
		<tr>
			<th>Usuário</th>
			<th>Tipo de multa</th>
			<th>Time do usuário</th>
			<th>Valor da multa</th>
			<th>Data de vencimento</th>
			<th colspan="2">&nbsp;</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${penaltys}" var="penalty">
			<tr>
				<td style="width: 250px">${penalty.user.name}</td>
				<td style="width: 250px">${penalty.typePenalty.description}</td>
				<td style="width: 250px">${penalty.user.team.name}</td>
				<td style="width: 250px">R$ ${penalty.typePenalty.value}</td>
				<td style="width: 250px">
					<fmt:formatDate value="${penalty.expirationDate}" type="both" pattern="dd/MM/yyyy" /></td>
				
<%-- 				<td style="width: 250px">${penalty.expirationDate}</td> --%>
				
				<td><a href="${pageContext.request.contextPath}/penalty/edit/${penalty.penaltyId}.html">
					<img src="/Cofre/resources/imagens/alterar.png" alt="Alterar" /></a></td>
				<td><a href="${pageContext.request.contextPath}/penalty/delete/${penalty.penaltyId}.html">
					<img src="/Cofre/resources/imagens/excluir.gif" alt="Remover" /></a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<jsp:include page="footer.jsp" flush="true"></jsp:include>