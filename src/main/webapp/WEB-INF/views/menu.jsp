<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.io.BufferedReader"%>
<%@ page import="java.io.FileReader"%>
<%@ page import="java.util.StringTokenizer"%>
<%@ page import="java.io.File"%>
	<div class="navbar-inner">
			<ul class="nav nav-pills" id="menuSup">

			<%
				FileReader fr = new FileReader(new File(session.getServletContext().getRealPath("/") + "menu.properties"));
	
				BufferedReader br = new BufferedReader(fr);
				String stringDomain = "";
				String action = "";
				String label = "";
				int i = 0;
				boolean print = false;
	
				while ((stringDomain = br.readLine()) != null) {
					if (i == 1 && print) i = 2;
					StringTokenizer obj = new StringTokenizer(stringDomain, "=");
					if (obj.hasMoreTokens()) {
						label = obj.nextToken();
						action = obj.nextToken();
					}
					if (label.equals(action)) {
			%>
						<li class="dropdown">
							<a id="drop1" href="#" role="button"class="dropdown-toggle" data-toggle="dropdown"><%=label%><b class="caret"></b></a>
							<ul class="dropdown-menu">
			<%
						i = 1;
					} else {
						if (i == 1) {
			%>				<li><a tabindex="-1" href="<%=action%>">Cadastro</a></li>
			<%				print = true;
						}
						if (i == 2) {
			%>				<li><a tabindex="-1" href="<%=action%>">Pesquisa</a></li>
			<%				i = 0;
							print = false;
						}
						if (i == 0) {
			%>									</ul>
				</li>

			<%				print = false;
							i = 11;
						}
					}
					System.out.println(label + " " + action);
					label = "";
					action = "";
				}
				br.close();
				fr.close();
			%>
		</ul>
	</div>