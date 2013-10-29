<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>Cadastro de usuário</title>
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
								<a href="#">Times</a>
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
					  <h4>O que é o Cofrinho?</h4>
					  <p>Projeto desenvolvido para calcular as infrações diárias cometidas por cada usuário pertencente a uma equipe de trabalho.</p>
				</div>
			</div>
		</div>
</body>
</html>