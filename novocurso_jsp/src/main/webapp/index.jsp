<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<form method="POST" action="/FuncionarioServlet">
		 <label for="login">Login:</label>
		 <input type="text" id="login" name="login"/><br />	
		<label for="senha">Senha:</label>
		 <input type="password" id="senha" name="senha"/><br /><br />
		 <input type="submit" value="Enviar"/>	
		
		</form>
	
	

</body>
</html>