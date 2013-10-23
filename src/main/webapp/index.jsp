<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login</title>

	<link href="resources/css/bootstrap.css" rel="stylesheet">
	<link href="resources/css/bootstrap-responsive.css" rel="stylesheet">
	<script type="text/javascript" src="resources/js/jquery.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap-dropdown.js"></script>
</head>
<body>

	<div class="container-fluid">
		
			<div class="row-fluid">
				<div class="span2">
					<ul class="thumbnails">
						<li class="span10">
							<a href="#" class="thumbnail">
								<img src="resources/imagens/cofrinho.jpg" alt="">
							</a>
						</li>
					</ul>
				</div>
				<div class="span10"></div>	
			</div>
			<div class="row-fluid">
				<div class="span2"></div>
				<div class="span10">
					<form method="POST" action="validaUsuario" class="form-signin">
				        <h2 class="form-signin-heading">Login</h2>
				        <input type="text" name="login" id="login" class="form-control" placeholder="Usuário" autofocus="">
				        <br>
				        <input type="password" name="senha" id="senha" class="form-control" placeholder="Senha">
				        <br>
				        <button class="btn btn-lg btn-primary" type="submit">Entrar</button>
				     </form>
				</div>
			</div>
		</div>
</body>
</html>