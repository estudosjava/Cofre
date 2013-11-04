<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" flush="true">  
	<jsp:param name="title" value="Cadastro de Tipos de Multa"/>  
</jsp:include> 	

<p>${message}</p>

<form:form method="POST" commandName="typepenalty" action="${pageContext.request.contextPath}/typepenalty/addTypePenalty.html" class="form-horizontal" >
	<fieldset>			
		<div class="form-group">
 				<label class="col-lg-2 control-label" for="description">Descrição:</label>
 				<div class="col-lg-3">
   				<form:textarea path="description" placeholder="Insira a descrição" class="form-control"></form:textarea>
 				</div>
		</div>
		<div class="form-group">
 				<label class="col-lg-2 control-label" for="value">Valor:</label>
 				<div class="col-lg-3">
   				<form:input path="value" name="value" type="currency" placeholder="Insira o valor" class="form-control" />
 				</div>
		</div>			
		<div class="form-group">
		  <label class="col-lg-1 control-label" for="cadastroTipoMulta"></label>
			  <div class="col-lg-1 control-label">
			    <button id="addTypePenalty" name="addTypePenalty" class="btn btn-default">Cadastrar</button>
			  </div>
		</div>
	</fieldset>
</form:form>				

<jsp:include page="footer.jsp" flush="true"/>