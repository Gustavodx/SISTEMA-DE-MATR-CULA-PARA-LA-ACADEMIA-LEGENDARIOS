package model;

public class Empleado {
	
	private String codigo;
	private String dni;
	private String nombre;
	private String apellido;
	private String usuario;
	private String clave;
	private String telefono;
	private String fecha;
	private int estado;
	
	@Override
	public String toString() {
		return "Empleado [codigo=" + codigo + ", dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", usuario=" + usuario + ", clave=" + clave + ", telefono=" + telefono + ", fecha=" + fecha
				+ ", estado=" + estado + "]";
	}
	
	public Empleado() {
		
	}
	
	public Empleado(String codigo, String dni, String nombre, String apellido, String usuario, String clave,
			String telefono, String fecha, int estado) {
		this.codigo = codigo;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.usuario = usuario;
		this.clave = clave;
		this.telefono = telefono;
		this.fecha = fecha;
		this.estado = estado;
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
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
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
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}	
}
