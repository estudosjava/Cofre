<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" flush="true">  
	<jsp:param name="title" value="Cadastro de Multa"/>  
</jsp:include> 	
<p>${message}</p>
<form:form method="POST" commandName="penalty" action="${pageContext.request.contextPath}/penalty/add.html" class="form-horizontal" >
	<div class="form-group">					
	  <label class="col-lg-2 control-label"> </label>
      <div class="col-lg-3">      
      	<form:select path="penalty.user.id" itens="${user}" class="form-control" placeholder="Insira o usuário" />
      	
<%--       		<form:option value="0" label="Selecione..." /> --%>
<%--       		<form:options items="${users}" itemValue="userId" itemLabel="name"/> --%>
<%--         </form:select>	    				 --%>
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
<jsp:include page="footer.jsp" flush="true"/> 				