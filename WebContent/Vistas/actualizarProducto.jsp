<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="DAO.ProductoDAO"%>
<%@ page import="modelo.Producto"%>
<%@ page import="java.util.*"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">
</head>
<body>

	<div class="container" style="margin-top: 100px;">

		<%
		ProductoDAO pDAO = new ProductoDAO();
		Producto p = pDAO.obtenerProducto(Integer.parseInt(request.getParameter("id")));
		%>



		<div class="row">
			<div class="card-group">
				<div class="card">
					<div class="card-body">
						<img src="../img/polo.jpg" height="auto" width="100%">
					</div>
				</div>
				<div class="card text-left">

					<div class="card-body">
					<form action="../ServletController" method="post">
							<label for="">Nombre</label> 
							<input type="hidden" name="txtcodigo" value="<%=p.getCodigoProducto()%>"> 
							<input type="text" class="form-control" name="txtNombre" value="<%=p.getNombre()%>">
							<label for="">Precio</label>
							<div class="input-group mb-2 mr-sm-2">
								<div class="input-group-prepend">
									<div class="input-group-text">S/.</div>
								</div>
								<input type="text" class="form-control" name="txtPrecio" value="<%=p.getPrecio()%>">
							</div>
							<input type="hidden" name="accion" value="actualizarProducto">
							<input type="submit" class="btn btn-success form-control" value="Actualizar" name="btnActualizar"> 
					</form>
					</div>
				</div>
			</div>
		</div>

	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
		crossorigin="anonymous"></script>
</body>
</html>