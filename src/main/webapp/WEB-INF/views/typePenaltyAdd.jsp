<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" flush="true">  
	<jsp:param name="title" value="Cadastro de Tipos de Multa"/>  
</jsp:include> 	
<form method="POST" commandName="typepenalty" action="${pageContext.request.contextPath}/typepenalty/addTypePenalty.html" class="form-horizontal" >
	<fieldset>			
		<div class="form-group">
 				<label class="col-lg-2 control-label" for="description">Descrição:</label>
 				<div class="col-lg-3">
   				<textarea id="description" name="description" placeholder="Insira a descrição" class=form-control></textarea>
 				</div>
		</div>
		<div class="form-group">
 				<label class="col-lg-2 control-label" for="value">Valor:</label>
 				<div class="col-lg-3">
   				<input id="value" name="value" type="text" placeholder="Insira o valor" class=form-control >
 				</div>
		</div>			
		<div class="form-group">
		  <label class="col-lg-1 control-label" for="cadastroTipoMulta"></label>
			  <div class="col-lg-1 control-label">
			    <button id="addTeam" name="addTeam" class="btn btn-default">Cadastrar</button>
			  </div>
		</div>
	</fieldset>
</form>				

<jsp:include page="footer.jsp" flush="true"/>