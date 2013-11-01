<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<jsp:include page="header.jsp" flush="true">  
	<jsp:param name="title" value="Edição de Times"/>  
</jsp:include>
<form:form method="POST" commandName="team" action="${pageContext.request.contextPath}/team/edit/${team.teamId}.html" class="form-horizontal">
	<fieldset>	
		<div class="form-group">
				<label class="col-lg-2 control-label" for="name">Nome:</label>
				<div class="col-lg-3">
					<form:input path="name" class="form-control" />
				</div>
		</div>	
		<div class="form-group">
		  <div class="col-lg-3 control-label">
		    <input type="submit" class="btn btn-default" value="Alterar" />
		  </div>
		</div>
	</fieldset>
</form:form>				
<jsp:include page="footer.jsp" flush="true"/>  				