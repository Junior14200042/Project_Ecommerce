package modelo;

import java.sql.Timestamp;

/*codigoVenta int NOT NULL,
  cliente varchar(100) NOT NULL,
  fecha datetime NOT NULL,*/

public class Venta {
	private int codigoVenta;
	private String cliente;
	private Timestamp fecha;
	
	public Venta() {
		
	}
	public int getCodigoVenta() {
		return codigoVenta;
	}

	public void setCodigoVenta(int codigoVenta) {
		this.codigoVenta = codigoVenta;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public Venta(int codigoVenta, String cliente, Timestamp fecha) {
		this.codigoVenta = codigoVenta;
		this.cliente = cliente;
		this.fecha = fecha;
	}
}
