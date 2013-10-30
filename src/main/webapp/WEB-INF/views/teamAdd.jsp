<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" flush="true">  
	<jsp:param name="title" value="Cadastro de Times"/>  
</jsp:include> 	
<form method="POST" commandName="team" action="${pageContext.request.contextPath}/team/addTeam.html" class="form-horizontal" >
	<fieldset>			
		<div class="control-group">
 				<label class="control-label" for="name">Nome:</label>
 				<div class="controls">
   				<input id="name" name="name" type="text" placeholder="" class="input-medium" >
 				</div>
		</div>			
		<div class="control-group">
		  <label class="control-label" for="cadastroEquipe"></label>
			  <div class="controls">
			    <button id="addTeam" name="addTeam" class="btn btn-default" align="left">Cadastrar</button>
			  </div>
		</div>
	</fieldset>
</form>				

<jsp:include page="footer.jsp" flush="true"/>