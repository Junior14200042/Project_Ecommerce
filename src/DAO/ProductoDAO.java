package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Producto;
import configuracion.Conexion;

public class ProductoDAO {

	public static Connection con;
	Conexion conexion=new Conexion();
	
	public ArrayList<Producto> ProductoAll() throws SQLException{
		
		con=conexion.conectar();
		
		ArrayList<Producto> producto=new ArrayList<Producto>();
		
		try {
			CallableStatement cl = con.prepareCall("{call listarProductos()}");
			ResultSet rs=cl.executeQuery();
			
			while(rs.next()) {
				Producto p =new Producto(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4));	
				producto.add(p);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conexion.cerrar();
		return producto;
	}
	
	public Producto obtenerProducto(int codigo) throws SQLException {
		
		con=conexion.conectar();
		Producto p=null;
		CallableStatement cl=con.prepareCall("{call sp_ProductoCod(?)}");
		cl.setInt(1, codigo);
		ResultSet rs=cl.executeQuery();
		while(rs.next()) {
			p=new Producto(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4));
		}
		conexion.cerrar();
		return p;
	}
	
	public boolean actualizarProducto(Producto producto) throws SQLException {
		
		
		con=conexion.conectar();
		CallableStatement cl=con.prepareCall("{call sp_actualizarPro(?,?,?)}");
		cl.setInt(1,producto.getCodigoProducto());
		cl.setString(2, producto.getNombre());
		cl.setDouble(3, producto.getPrecio());
		boolean rpta=cl.executeUpdate()>0;
		conexion.cerrar();
		return rpta;
	}
	
	public boolean guardarProducto(Producto producto) throws SQLException {
		con=conexion.conectar();
		CallableStatement cl=con.prepareCall("{call sp_insertarPro(?,?,?)}");
		cl.setString(1, producto.getNombre());
		cl.setDouble(2, producto.getPrecio());
		cl.setString(3, producto.getImagen());
		boolean rpta=cl.executeUpdate()>0;
		conexion.cerrar();
		return rpta;
	}
}
