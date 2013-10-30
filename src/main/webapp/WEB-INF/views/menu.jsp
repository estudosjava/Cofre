<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.io.BufferedReader"%>
<%@ page import="java.io.FileReader"%>
<%@ page import="java.util.StringTokenizer"%>
<%@ page import="java.io.File"%>
<div class="span2">
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
</div>	