<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="modelo.*" %>
<%@page import="DAO.*" %>
<%@page import="java.util.ArrayList" %>
<%@page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ecommerce JR</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="#">Catálogo</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
            <a class="nav-link" href="#">Registrar Producto</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Registrar Venta</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Consultar Venta</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Cerrar Sesión</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
  
  <h2 style="text-align:center;margin-bottom:30px">Catalogo de Productos</h2>
  <div class="container">
	  <div class="row">
	
	     <div class="col-lg-3">
	
	        <h1 class="my-3">Shop-Jr</h1>
	        <div class="list-group">
	          <a href="#" class="list-group-item">Category 1</a>
	          <a href="#" class="list-group-item">Category 2</a>
	          <a href="#" class="list-group-item">Category 3</a>
	       	</div>
      	</div>
      	<div class="col-lg-9">
      		<div class="row">
      			<%
      				ProductoDAO pDAO=new ProductoDAO();
      				ArrayList<Producto> lista=pDAO.ProductoAll();
      				for(Producto p: lista){
      			%>		
      			<div class="col-lg-4 col-md-6 mb-4">
		            <div class="card h-100">
		              <a href="#"><img class="card-img-top" src="img/<%= p.getImagen()%>" alt=""></a>
		              <div class="card-body">
		                <h4 class="card-title">
		                  <a href="#"><%=p.getNombre() %></a>
		                </h4>
		                <h5>S/.<%=p.getPrecio() %></h5>
		                <p class="card-text"><a href="Vistas/anadirCarrito.jsp?id=<%= p.getCodigoProducto() %>">Añadir</a><br>
		                <a href="Vistas/actualizarProducto.jsp?id=<%= p.getCodigoProducto() %>">Actualizar</a></p>
		              </div>
		              <div class="card-footer">
		                <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
		              </div>
		          </div>
          		</div>
          		
          		<% } %>			
      		</div>
      	</div>
    </div>
  
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
</body>
</html>