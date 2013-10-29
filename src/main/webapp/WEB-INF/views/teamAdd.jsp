<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<%@ include file = "header1.jsp" %>	
    <title>Cadastro de Time</title>
	</head>
	<body>
		<div class="container-fluid">
		<%@ include file = "header2.jsp" %>
			<div class="row-fluid">
				<div class="span2">
				   <%@ include file = "menu.jsp" %>
				</div>
				<div class="span10">
				<form method="POST" commandName="team" action="${pageContext.request.contextPath}/team/addTeam.html" class="form-horizontal" >
				<fieldset>
				<!-- Form Name -->
				<legend>Time</legend>
				<!-- Text input-->
				<div class="control-group">
  				<label class="control-label" for="name">Nome:</label>
  				<div class="controls">
    			<input id="name" name="name" type="text" placeholder="" class="input-medium" required="">
  				</div>
				</div>
				<!-- Button -->
				<div class="control-group">
				  <label class="control-label" for="cadastroEquipe"></label>
				  <div class="controls">
				    <button id="addTeam" name="addTeam" class="btn btn-default" align="left">Cadastrar</button>
				  </div>
				</div>
				</fieldset>
				</form>				
				</div>
			</div>
		</div>
</body>
</html>