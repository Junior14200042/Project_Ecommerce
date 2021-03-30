<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h2 align="center">Cargar Imagen</h2>
	<form action="subirImagen.jsp" enctype="multipart/form-data" method="post">
		<label>Imagen</label>
		<input type="file" name="file">
		<input type="submit" value="Registrar" name="cargarImagen">
	</form>
</body>
</html>