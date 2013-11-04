<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" flush="true">  
	<jsp:param name="title" value="Cadastro de Times"/>  
</jsp:include> 	
<p>${message}</p>
<form:form method="POST" commandName="team" action="${pageContext.request.contextPath}/team/addTeam.html" class="form-horizontal" >
	<fieldset>			
		<div class="form-group">
 				<label class="col-lg-2 control-label" for="name">Nome:</label>
 				<div class="col-lg-3">
   				<form:input path="name" type="text" placeholder="Insira o nome" class="form-control" />
 				</div>
		</div>			
		<div class="form-group">
		  <label class="col-lg-1 control-label" for="cadastroEquipe"></label>
			  <div class="col-lg-1 control-label">
			    <button id="addTeam" name="addTeam" class="btn btn-default">Cadastrar</button>
			  </div>
		</div>
	</fieldset>
</form:form>				

<jsp:include page="footer.jsp" flush="true"/>