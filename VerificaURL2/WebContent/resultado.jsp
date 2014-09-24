<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.util.*" %>
 <%@ page import="br.com.wic.DAO.*" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta http-equiv="refresh" content="500">
		<title>Insert title here</title>
	</head>
	<body>
		<%	ArrayList<Endereco> lista = (ArrayList<Endereco>) request.getAttribute("lista"); %>
		  															
		<table  border=1 cellspacing=0 cellpadding=2>
		<tr>		
			<td>Serviço</td> <td>Status</td>
		</tr>
		<tr>
			<% for(Endereco e:lista){ 	 %>
		</tr>
		
		<tr>
			<td><%=e.getUrl() %></td> 
			<td><%=e.getStatus() %></td>			
		</tr>		
			<%} %>		
					
	</table>
	<br>
	<form action="adiciona.jsp">
		<input type="submit" value="Inserir" name="insere">		
	</form>
	
	
		
	</body>
</html>