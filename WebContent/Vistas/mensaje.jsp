<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>
	<% 
		if(request.getParameter("mensaje")!=null){
			out.println(request.getParameter("mensaje"));
		}
	%>
	</h2>
	<h3><a href="../index.jsp">Regresar al Inicio</a></h3>
</body>
</html>