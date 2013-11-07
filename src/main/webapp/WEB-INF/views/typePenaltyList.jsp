<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<jsp:include page="header.jsp" flush="true">  
        <jsp:param name="title" value="Lista de Tipos de Multa"/>  
</jsp:include>                         
<p>${message}</p>        
<table class="table table-striped" style="width: 700px">        
        <thead>
		<tr>							
			<th>Descrição</th>
			<th>Valor</th>
			<th></th>
			<th></th>
		</tr>
	</thead>
        <tbody>
                <c:forEach items="${typepenaltys}" var="typepenalty">
                  <tr>
                    <td style="width: 250px">${typepenalty.description}</td>
                    <td style="width: 250px">R$
                    <fmt:formatNumber value="${typepenalty.value}" minFractionDigits="2" type="number"/>
                    </td>
                    <td><a href="${pageContext.request.contextPath}/typepenalty/edit/${typepenalty.typePenaltyId}.html"><img src="/Cofre/resources/imagens/alterar.png" alt="Alterar"/></a></td>
                    <td><a href="${pageContext.request.contextPath}/typepenalty/delete/${typepenalty.typePenaltyId}.html"><img src="/Cofre/resources/imagens/excluir.gif" alt="Remover"/></a></td>
                  </tr>
                </c:forEach>
        </tbody>
</table>
<jsp:include page="footer.jsp" flush="true"></jsp:include>