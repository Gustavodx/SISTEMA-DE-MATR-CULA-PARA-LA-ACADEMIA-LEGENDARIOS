package model;

public class ListarEmpleados {
	
	private String codigo;
	private String dni;
	private String nombre;
	private String usuario;
	private String clave;
	private String fono;
	private String fecha;
	
	@Override
	public String toString() {
		return "ListarEmpleados [codigo=" + codigo + ", dni=" + dni + ", nombre=" + nombre + ", usuario=" + usuario
				+ ", clave=" + clave + ", fono=" + fono + ", fecha=" + fecha + "]";
	}
	public ListarEmpleados() {
		
	}
	public ListarEmpleados(String codigo, String dni, String nombre, String usuario, String clave, String fono,
			String fecha) {
		this.codigo = codigo;
		this.dni = dni;
		this.nombre = nombre;
		this.usuario = usuario;
		this.clave = clave;
		this.fono = fono;
		this.fecha = fecha;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getFono() {
		return fono;
	}
	public void setFono(String fono) {
		this.fono = fono;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
}
