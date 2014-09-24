<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<script type="text/javascript" src="javascript.js"></script>
		<title>Insert title here</title>
	</head>
	<body onload="muda()" onmousemove="validaParam(); validaUrl(); botao()" onkeyup="validaParam(); botao(); validaUrl()">
		<form action="gerenciador">
			<table>
				<tr>
					<td>URL:</td>
					<td><input type="text" id="url" name="url"></td>				
				</tr>
				<tr>
					<td>Parâmetro:</td>
					<td><input type="text" id="param" name="arg"></td>				
				</tr>
				<tr>
					<td>Argumento de Entrada:</td>
					<td><input type="text" id="url" name="argEntrada"></td>				
				</tr>
				<tr>
					<td>Método:</td>
					<td>
						<select name="metodo" size="1">
							<option value="post">POST</option>
							<option value="get">GET</option>				
						</select>
					
					</td>				
				</tr>			
			</table>
			<input type="submit" id="botao" value="Salvar">		
		</form>	
		
	</body>
</html>