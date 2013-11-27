<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Erro ao efetuar Login</title>

	<link href="/Cofre/resources/css/bootstrap.css" rel="stylesheet">
	<link href="/Cofre/resources/css/bootstrap-responsive.css" rel="stylesheet">
	<script type="text/javascript" src="/Cofre/resources/js/jquery.js"></script>
	<script type="text/javascript" src="/Cofre/resources/js/bootstrap-dropdown.js"></script>
</head>
<body>

	<div class="container-fluid">
		
			<div class="row-fluid">
				<div class="span2">
					<ul class="thumbnails">
						<li class="span10">
							<a href="#" class="thumbnail">
								<img src="/Cofre/resources/imagens/cofrinho.jpg" alt="">
							</a>
						</li>
					</ul>
				</div>
				<div class="span10"></div>	
			</div>
			<div class="row-fluid">
				<div class="span2"></div>
				<div class="span2">
				<p>${message}</p>
					  <form action="/Cofre/login/validaUsuario" method="post" class="form-signin">
				         <h2 class="form-signin-heading">Login</h2>
				        <input type="text" name="login" id="login" class="form-control" placeholder="Usuário" autofocus="autofocus">
				        <br>
				        <input type="password" name="password" id="password" class="form-control" placeholder="Senha">
				        <br>
				        <button class="btn btn-lg btn-primary" type="submit">Entrar</button>
				      </form>
				</div>
			</div>
		</div>

</body>
</html>