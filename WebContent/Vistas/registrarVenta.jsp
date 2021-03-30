<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="modelo.*" %>
<%@page import="java.util.*" %>
<%@page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body>

	<div class="container" style="margin-top: 100px;">
		<form action="ServletController" method="post">
	<%
			ArrayList<detalleVenta> lista=(ArrayList<detalleVenta>)session.getAttribute("carrito");
			double total=0;
			if(lista!=null){
				for(detalleVenta d:lista) {
	
	%>     
	        <div class="row">
	            <div class="card-group">
	                <div class="card">
	                    <div class="card-body">
	                        <img src="img/<%= d.getProducto().getImagen() %>" height="auto" width="100%">
	                    </div>
	                </div>
	                <div class="card text-left">
                  
                    <div class="card-body">
                    		<input type="hidden" name="accion" value="registrarVenta">
	                        <div class="form-group">
	                            <label for="">Nombre</label>
	                            <input type="text" readonly class="form-control" name="txtNombre" value="<%= d.getProducto().getNombre() %>">
	                        </div>
	                        <div class="row">
	                            <div class=" col form-group">
	                                <label for="">Precio</label>
	                                <input type="text" readonly class="form-control" name="txtPrecio" value="<%= d.getProducto().getPrecio() %>">
	                            </div>
	                            <div class="col form-group">
	                                <label for="">Cantidad</label>
	                                <input type="text" readonly class="form-control" name="txtCantidad" value="<%= d.getCantidad() %>">
	                            </div>
	                            <div class="col form-group">
	                                <label for="">Descuento</label>
	                                <input type="text" readonly class="form-control" name="txtDescuento" value="<%= d.getDescuento() %>">
	                            </div>
	                            <div class="col form-group">
	                                <label for="">Sub-Total</label>
	                                <input type="text" readonly class="form-control" value="<%= d.getProducto().getPrecio()*d.getCantidad() %>">
	                            </div>
	                        </div>
                      		<div class="form-group">
	                          <label for="">Total</label>
	                          <input type="number" class="form-control" name="txtTotal" value="<%= total=total+(d.getProducto().getPrecio()*d.getCantidad()-d.getDescuento()) %>">
                     		</div>
                    </div>
                    
                  </div>
    <% 
				}
			}
	%>          
           	 	</div>
       		 </div>
				     <input type="submit" class="btn btn-success form-control" value="Registrar Venta">
		</form>
		<h2><a href="index.jsp">Seguir Comprando</a></h2>
	</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
</body>
</html>