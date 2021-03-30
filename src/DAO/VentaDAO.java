package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import configuracion.Conexion;
import modelo.Venta;
import modelo.detalleVenta;

public class VentaDAO {

	public static Connection con;
	Conexion conexion=null;
	
	public VentaDAO() {
		conexion=new Conexion();
	}
	
	public boolean registrarVenta(Venta v,ArrayList<detalleVenta> d) throws SQLException{
		
		boolean rpta=false;
		try {
			con=conexion.conectar();
			CallableStatement cl=con.prepareCall("{ call sp_RegistrarVenta(?,?)}");
			cl.registerOutParameter(1, Types.INTEGER);
			cl.setString(2, v.getCliente());
			int i=cl.executeUpdate();
			
			int i2=0;
			v.setCodigoVenta(cl.getInt(i));
			CallableStatement cl2=con.prepareCall("{call sp_RegistrarDetalle(?,?,?,?) }");
			
			for(detalleVenta dv : d) {
				cl2.setInt(1, v.getCodigoVenta());
				cl2.setInt(2, dv.getCodigoProducto());
				cl2.setDouble(3, dv.getCantidad());
				cl2.setDouble(4, dv.getDescuento());
				i2=cl2.executeUpdate();
			}
			if(i2>0) {
				rpta=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conexion.cerrar();
		return rpta;
	}
}
