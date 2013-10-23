<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>Cadastro de Equipe</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
	<link href="resources/css/bootstrap.css" rel="stylesheet">
	<link href="resources/css/bootstrap-responsive.css" rel="stylesheet">
	<script type="text/javascript" src="resources/js/jquery.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap-dropdown.js"></script>
	<script>
		function teste (x, event)
		{
			event.preventDefault();
			$("#menuSup li").removeClass("active");
			$(x).addClass("active");
		}
		
		$(document).ready(function(){
				$(".menuSup").click(function(){
				$(".menuSup").removeClass("active");
				$(this).addClass("active");
			});
		});
	</script>
	</head>
	<body>
		<div class="container-fluid">
		
			<div class="row-fluid">
				<div class="span2">
					<ul class="thumbnails">
						<li class="span10">
							<a href="homepage.jsp" class="thumbnail">
								<img src="resources/imagens/cofrinho.jpg" alt="Página Inicial">
							</a>
						</li>
					</ul>
				</div>
				<div class="span10">
					<div class="navbar-inner">
						<ul class="nav nav-pills" id="menuSup">
							<li class="active menuSup">
								<a href="#">Usuários</a>
							</li>
							<li class="menuSup">
								<a href="${pageContext.request.contextPath}/equipe/list.html">Equipes</a>
							</li>
							<li class="menuSup">
								<a href="#">Multas</a>
							</li>		
						</ul>
					</div>
				</div>	
			</div>
			<div class="row-fluid">
				<div class="span2"><%@ include file = "menu.jsp" %></div>
				<div class="span10">
				<form method="POST" commandName="equipe" action="${pageContext.request.contextPath}/equipe/cadastrarEquipe.html" class="form-horizontal" >
				<fieldset>
				<!-- Form Name -->
				<legend>Equipe</legend>
				<!-- Text input-->
				<div class="control-group">
  				<label class="control-label" for="nome">Nome:</label>
  				<div class="controls">
    			<input id="nome" name="nome" type="text" placeholder="" class="input-medium" required="">
  				</div>
				</div>
				<!-- Button -->
				<div class="control-group">
				  <label class="control-label" for="cadastroEquipe"></label>
				  <div class="controls">
				    <button id="cadastroEquipe" name="cadastroEquipe" class="btn btn-default" align="left">Cadastrar</button>
				  </div>
				</div>
				
				</fieldset>
				</form>				
				</div>
			</div>
		</div>
		
</body>
</html>