<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<%@ include file = "header1.jsp" %>
	<title>Edição de Equipe</title>
</head>
<body>
	<div class="container-fluid">	
		<%@ include file = "header2.jsp" %>		
		<div class="row-fluid">
			<div class="span2">
				<%@ include file = "menu.jsp" %>
			</div>
			<div class="span10">
			<form:form method="POST" commandName="team" action="${pageContext.request.contextPath}/team/edit/${team.teamId}.html" class="form-horizontal">
				<fieldset>
				<!-- Form Name -->
				<legend>Alterar Equipe</legend>
				<!-- Text input-->
				<div class="control-group">
  				<label class="control-label" for="name">Nome:</label>
  				<div class="controls">
    			<form:input path="name" class="input-medium" />
  				</div>
				</div>
				<!-- Button -->
				<div class="control-group">
				  <div class="controls">
				    <input type="submit" class="btn btn-default" align="left" value="Alterar" />
				  </div>
				</div>
				
				</fieldset>
				</form:form>				
				</div>
				</div>
	</div>	
</body>
</html>