<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" flush="true">  
<jsp:param name="title" value="Cadastro de Usuários"/>  
</jsp:include> 						
<p>${message}</p>
<form:form method="POST" commandName="user" action="${pageContext.request.contextPath}/user/add.html" class="form-horizontal">									
	<div class="form-group">					
	  <label class="col-lg-2 control-label">Nome </label>
      <div class="col-lg-3">
      	<form:input path="name" class="form-control" placeholder="Insira o nome" />		    				
	  </div>					  
	</div>	
	<div class="form-group">					
	  <label class="col-lg-2 control-label">Login </label>
      <div class="col-lg-3">
      	<form:input path="login" type="text" class="form-control" placeholder="Insira o login" />		    				
	  </div>					  
	</div>
	<div class="form-group">					
	  <label class="col-lg-2 control-label">Senha </label>
      <div class="col-lg-3">
      	<form:input path="password" type="text" class="form-control" placeholder="Insira o senha" />		    				
	  </div>					  
	</div>
	<div class="form-group">					
	  <label class="col-lg-2 control-label">Tipo de Usuário </label>
      <div class="col-lg-3">
      	<form:input path="userTypeId" type="text" class="form-control" placeholder="Insira o tipo de usuário" />		    				
	  </div>					  
	</div>	
	<div class="form-group">					
	  <label class="col-lg-2 control-label">Time </label>
      <div class="col-lg-3">
      	<form:select path="team.teamId" class="form-control" required="True">
      	   <form:option value="">Selecione...</form:option>
      	   <c:forEach items="${teams}" var="team">      	     
      	     <form:option value="${team.teamId}">${team.name}</form:option>
      	   </c:forEach>
      	</form:select>		    				
	  </div>					  
	</div>
	<div class="form-group">
		<div class="col-lg-1 control-label"></div>
		<div class="col-lg-1 control-label">
	      	<input type="submit" value="Cadastrar" class="btn btn-default" />		    				
		</div>
	</div>							
</form:form>
<p></p>				
<jsp:include page="footer.jsp" flush="true"></jsp:include> 				