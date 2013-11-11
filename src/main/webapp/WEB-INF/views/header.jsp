<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="UTF-8">    
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
	<link href="/Cofre/resources/css/bootstrap.css" rel="stylesheet">
	<link href="/Cofre/resources/css/bootstrap-responsive.css" rel="stylesheet">
	<script type="text/javascript" src="/Cofre/resources/js/jquery.js"></script>
	<script type="text/javascript" src="/Cofre/resources/js/bootstrap-dropdown.js"></script>
	<script type="text/javascript" src="/Cofre/resources/js/cofreJSTools.js"></script>
	<script type="text/javascript" src="/Cofre/resources/js/jquery.maskMoney.js" ></script>
	<script type="text/javascript" src="/Cofre/resources/js/convertDate.js" ></script>		
	<%
		String title = request.getParameter("title");
	%>
	<title><%=title%></title> 
</head>
<body>
	<div class="container-fluid">	
		<%@ include file = "headerLogonAndMenu.jsp" %>		
		<div class="row-fluid">
		  	<div class="span2"></div>
			<div class="span8">
				<form class="form-horizontal">
					<fieldset>
						<legend><%=title%></legend>
					</fieldset>
				</form>		