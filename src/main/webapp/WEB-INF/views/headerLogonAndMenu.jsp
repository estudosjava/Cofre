<div class="row-fluid">
	<div class="span2">
		<ul class="thumbnails">
			<li class="span10">
				<a href="homepage.jsp" class="thumbnail">
					<img src="/Cofre/resources/imagens/cofrinho.jpg" alt="Página Inicial">
				</a>
			</li>
		</ul>
	</div>
	<div class="span10">
		<div class="navbar-inner">
			<ul class="nav nav-pills" id="menuSup">
		    <li class="dropdown"> <a id="drop1" href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">Usuários <b class="caret"></b></a>
            <ul class="dropdown-menu">
            <li><a tabindex="-1" href="http://google.com">Cadastro</a></li>
            <li><a tabindex="-1" href="#anotherAction">Pesquisa</a></li>
            </ul>
            </li>
		    <li class="dropdown"> 
		    <a id="drop1" href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">Times <b class="caret"></b></a>
            <ul class="dropdown-menu">
            <li><a tabindex="-1" href="${pageContext.request.contextPath}/team/addTeam.html">Cadastro</a></li>
            <li><a tabindex="-1" href="${pageContext.request.contextPath}/team/listTeam.html">Pesquisa</a></li>
            </ul>
            </li>
			<li class="dropdown"> 
			<a id="drop1" href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">Multas <b class="caret"></b></a>
            <ul class="dropdown-menu">
            <li><a tabindex="-1" href="#">Cadastro</a></li>
            <li><a tabindex="-1" href="#">Pesquisa</a></li>
            <li class="divider"></li>
            <li><a tabindex="-1">Tipos de Multa:</a></li>
            <li><a tabindex="-1" href="${pageContext.request.contextPath}/typepenalty/addTypePenalty.html">Cadastro</a></li>
            <li><a tabindex="-1" href="#">Pesquisa</a></li>
            </ul>
            </li>
    		
		</div>
	</div>	
</div>