package Controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ProductoDAO;
import DAO.VentaDAO;
import modelo.Producto;
import modelo.Venta;
import modelo.detalleVenta;

/**
 * Servlet implementation class ServletController
 */
@WebServlet("/ServletController")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String accion=request.getParameter("accion");
		if(accion.equals("AnadirCarrito")) {
			this.anadirCarrito(request, response);
		}else if(accion.equals("actualizarProducto")) {
			this.actualizarProducto(request, response);
		}else if(accion.equals("registrarProducto")) {
			this.guardarProducto(request, response);
		}else if(accion.equals("registrarVenta")) {
			System.out.print("ingresó aqio");
			this.registrarVenta(request, response);
		}
		
	}
	
private void anadirCarrito(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductoDAO pDAO=new ProductoDAO();
		HttpSession session=request.getSession();
		ArrayList<detalleVenta> carrito;
		if(session.getAttribute("carrito")==null) {
			carrito=new ArrayList<detalleVenta>();
		}else {
			carrito= (ArrayList<detalleVenta>) session.getAttribute("carrito");
		}
		try {
			Producto p=pDAO.obtenerProducto(Integer.parseInt(request.getParameter("txtcodigo")));
			detalleVenta dv=new detalleVenta();
			dv.setCodigoProducto(Integer.parseInt(request.getParameter("txtcodigo")));
			dv.setProducto(p);
			dv.setCantidad(Double.parseDouble(request.getParameter("txtCantidad")));
			double subTotal=p.getPrecio()*dv.getCantidad();
			if(subTotal>50) {
				dv.setDescuento(subTotal*0.05);
			}else {
				dv.setDescuento(0);
			}
			int indice=-1;
			for(int i=0;i<carrito.size();i++) {
				detalleVenta d=carrito.get(i);
				if(d.getCodigoProducto()==p.getCodigoProducto()) {
					indice=i;
					break;
				}
			}
			if(indice==-1) {
				carrito.add(dv);
			}
			session.setAttribute("carrito", carrito);
			RequestDispatcher rq=request.getRequestDispatcher("Vistas/registrarVenta.jsp");
			rq.forward(request, response);
			
		} catch (NumberFormatException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	private void actualizarProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductoDAO pdao=new ProductoDAO();
				
		int codigoProducto=Integer.parseInt(request.getParameter("txtcodigo"));
		String nombre=request.getParameter("txtNombre");
		double precio=Double.parseDouble(request.getParameter("txtPrecio"));
		Producto p=new Producto(codigoProducto,nombre,precio);
		try {
			boolean rp= pdao.actualizarProducto(p);
			if(rp) {
				response.sendRedirect("Vistas/mensaje.jsp?mensaje=Se actualizo correctamente");
				
			}else {
				response.sendRedirect("Vistas/mensaje.jsp?mensaje=No se actualizo");
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	private void guardarProducto(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
			
			String nombre=request.getParameter("txtNombre");
			double precio=Double.parseDouble(request.getParameter("txtPrecio"));
			String imagen=request.getParameter("txtImagen");
			ProductoDAO pdao=new ProductoDAO();
			Producto p=new Producto(nombre,precio,imagen);
			try {
				boolean rpta =pdao.guardarProducto(p);
			
				if(rpta) {
					response.sendRedirect("Vistas/mensaje.jsp?mensaje=Se registro correctamente");
				}else {
					response.sendRedirect("Vistas/mensaje.jsp?mensaje=Hubo un error al registrar");
				}		
			} catch (SQLException e) {
				e.printStackTrace();
			}		
	}
	private void registrarVenta(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		
			boolean rpta=false;
			HttpSession session=request.getSession();
			Venta v=new Venta();
			VentaDAO vdao=new VentaDAO();
			v.setCliente(request.getParameter("txtNombre").toUpperCase());
			ArrayList<detalleVenta> dv =(ArrayList<detalleVenta>) session.getAttribute("carrito");
			try {
				rpta=vdao.registrarVenta(v, dv);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(rpta) {
				request.getSession().removeAttribute("carrito");
				response.sendRedirect("Vistas/mensaje.jsp?mensaje=Se registro la venta correctamente");
			}else {
				response.sendRedirect("Vistas/mensaje.jsp?mensaje=No se pudo registrar la venta");
			}	
	}
	

}
