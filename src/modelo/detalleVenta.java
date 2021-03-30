package modelo;

/*
 * codigoVenta int NOT NULL,
  codigoProducto int NOT NULL,
  cantidad decimal(18,2) NOT NULL,
  descuento decimal(18,2) NOT NULL,
 */
public class detalleVenta {
	private int codigoVenta;
	private int codigoProducto;
	private double cantidad;
	private double descuento;
	private Venta venta;
	private Producto producto;
	
	public detalleVenta() {
		
	}

	public detalleVenta(int codigoVenta, int codigoProducto, double cantidad, double descuento,Venta venta, Producto producto) {
		this.codigoVenta = codigoVenta;
		this.codigoProducto = codigoProducto;
		this.cantidad = cantidad;
		this.descuento = descuento;
		this.venta=venta;
		this.producto=producto;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCodigoVenta() {
		return codigoVenta;
	}

	public void setCodigoVenta(int codigoVenta) {
		this.codigoVenta = codigoVenta;
	}

	public int getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	
	
}
