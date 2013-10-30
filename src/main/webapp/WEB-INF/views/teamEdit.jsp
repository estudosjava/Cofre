<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<jsp:include page="header.jsp" flush="true">  
	<jsp:param name="title" value="Edição de Times"/>  
</jsp:include>
<form:form method="POST" commandName="team" action="${pageContext.request.contextPath}/team/edit/${team.teamId}.html" class="form-horizontal">
	<fieldset>	
		<div class="control-group">
				<label class="control-label" for="name">Nome:</label>
				<div class="controls">
					<form:input path="name" class="input-medium" />
				</div>
		</div>	
		<div class="control-group">
		  <div class="controls">
		    <input type="submit" class="btn btn-default" align="left" value="Alterar" />
		  </div>
		</div>
	</fieldset>
</form:form>				
<jsp:include page="footer.jsp" flush="true"/>  				