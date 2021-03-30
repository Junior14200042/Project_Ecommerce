package configuracion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	private String url="jdbc:mysql://localhost:3306/Proyecto_Venta?useSSL=false&&serverTimezone=UTC";
	private String usuario="root";
	private String pass="admin";
	private Connection con=null;
	
	public Connection conectar() throws SQLException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,usuario,pass);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	public void cerrar() throws SQLException {
		if(con!=null || !con.isClosed()) {
			con.close();
		}
	}
}

