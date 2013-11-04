<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="header.jsp" flush="true">
	<jsp:param name="title" value="Lista de Multas" />
</jsp:include>
<p>${message}</p>
<table class="table table-striped" style="width:700px">
	<thead>
		<tr>
			<th>Usuário</th>
			<th>Tipo de multa</th>
			<th>Time do usuário</th>
			<th>Valor da multa</th>
			<th>Data limite de pagamento</th>
			<th colspan="2">&nbsp;</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${penaltys}" var="penalty">
			<tr>
				<td style="width: 250px">${penalty.user.name}</td>
				<td style="width: 250px">${penalty.codTypePenalty}</td>
				<td style="width: 250px">tp_usu</td>
				<td style="width: 250px">vlr_mul</td>
				<td style="width: 250px">dt_pgm</td>
				<td><a href=""><img
						src="/Cofre/resources/imagens/alterar.png" alt="Alterar" /></a></td>
				<td><a href="${pageContext.request.contextPath}/penalty/delete/${penalty.penaltyId}.html">
					<img src="/Cofre/resources/imagens/excluir.gif" alt="Remover" /></a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<jsp:include page="footer.jsp" flush="true"></jsp:include>