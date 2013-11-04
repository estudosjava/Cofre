<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<jsp:include page="header.jsp" flush="true">  
	<jsp:param name="title" value="Edição de Tipos de Multa"/>  
</jsp:include> 	

<p>${message}</p>

<form:form method="POST" commandName="typepenalty" action="${pageContext.request.contextPath}/typepenalty/edit/${typepenalty.typePenaltyId}.html" class="form-horizontal" >		
	<div class="form-group">
			<label class="col-lg-2 control-label">Descrição </label>
		    <div class="col-lg-3">
		       <form:textarea path="description" class="form-control" placeholder="Insira a descricao" />		    				
			</div>		 			
	</div>
	
	<%-- <div class="form-group">
			<label class="col-lg-2 control-label">Time </label>
		    <div class="col-lg-3">
		       <form:input path="teamId" class="form-control" placeholder="Insira o valor" />		    				
			</div>	
	</div> --%>
	<div class="form-group">
			<label class="col-lg-2 control-label">Descrição </label>
		    <div class="col-lg-3">
		       <form:input path="value" type="currency" class="form-control" placeholder="Insira o valor" />		    				
			</div>	
	</div>			
	<div class="form-group">
	  <div class="col-lg-1 control-label"></div>
	  <div class="col-lg-1 control-label">
	   	<input type="submit" value="Alterar" class="btn btn-default" />		    				
	  </div>
	</div>
</form:form>				
<jsp:include page="footer.jsp" flush="true"/>