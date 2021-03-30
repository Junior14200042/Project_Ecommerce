<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<%
		String img=request.getParameter("img");
	%>
	<form action="../ServletController" method="post">
		<label>Nombre</label>
		<input type="text" name="txtNombre">
		<label>Precio</label>
		<input type="text" name="txtPrecio">
		<label></label>
		<input type="hidden" name="accion" value="registrarProducto">
		<input type="hidden" name="txtImagen" value="<%=img %>">
		<input type="submit" value="Registrar" name="cargarImagen">
	
	
	</form>
	
</body>
</html>