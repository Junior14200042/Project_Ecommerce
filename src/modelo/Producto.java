package modelo;

/*codigoProducto int NOT NULL,
nombre varchar(100) NOT NULL,
precio decimal(18,2) NOT NULL,
imagen varchar(20) NOT NULL,*/

public class Producto {
	private int codigoProducto;
	private String nombre;
	private double precio;
	private String imagen;
	
	public Producto() {
		
	}
	public Producto(int codigoProducto,String nombre,double precio) {
		this.codigoProducto=codigoProducto;
		this.nombre=nombre;
		this.precio=precio;
	}
	public Producto(String nombre,double precio,String imagen) {
		this.nombre=nombre;
		this.precio=precio;
		this.imagen=imagen;
	}
	public Producto(int codigoProducto,String nombre,double precio,String imagen) {
		this.codigoProducto=codigoProducto;
		this.nombre=nombre;
		this.precio=precio;
		this.imagen=imagen;
	}
	
	public int getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto=codigoProducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
}