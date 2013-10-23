<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.io.BufferedReader"%>
<%@ page import="java.io.FileReader"%>
<%@ page import="java.util.StringTokenizer"%>
<%@ page import="java.io.File"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="/Cofre/resources/css/bootstrap.css" rel="stylesheet">
<link href="/Cofre/resources/css/bootstrap-responsive.css" rel="stylesheet">
</head>
<body>
	<div class="dropdown">
		<ul class="nav nav-pills nav-stacked" style="max-width: 300px;">
			<%
				FileReader fr = new FileReader(new File(session.getServletContext().getRealPath("/") + "menu.properties"));

				BufferedReader br = new BufferedReader(fr);
				String stringDomain = "";

				while ((stringDomain = br.readLine()) != null) {
					StringTokenizer obj = new StringTokenizer(stringDomain, "=");
					String action = "";
					String label = "";
					while (obj.hasMoreTokens()) {
						label = obj.nextToken();
						action = obj.nextToken();
					}
			%>
			<li><a href="<%=action%>"><%=label%></a></li>
			<%
				}
				br.close();
				fr.close();
			%>
		</ul>
	</div>
	
</body>
</html>