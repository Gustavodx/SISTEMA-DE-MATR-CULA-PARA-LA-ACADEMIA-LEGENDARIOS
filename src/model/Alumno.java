package model;

public class Alumno {
	
	private String codigo;
	private String dni;
	private String nombre;
	private String apellido;
	private String fecha;
	private int codEscuela;
	private String carrera;
	private int fono;
	private String direccion;
	private int estadoAlumno;
	private int estado;
	
	@Override
	public String toString() {
		return "Alumno [codigo=" + codigo + ", dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", fecha=" + fecha + ", codEscuela=" + codEscuela + ", carrera=" + carrera + ", fono=" + fono
				+ ", direccion=" + direccion + ", estadoAlumno=" + estadoAlumno + ", estado=" + estado + "]";
	}
	
	public Alumno() {
		
	}
	
	public Alumno(String codigo, String dni, String nombre, String apellido, String fecha, int codEscuela,
			String carrera, int fono, String direccion, int estadoAlumno, int estado) {
		this.codigo = codigo;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecha = fecha;
		this.codEscuela = codEscuela;
		this.carrera = carrera;
		this.fono = fono;
		this.direccion = direccion;
		this.estadoAlumno = estadoAlumno;
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
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public int getCodEscuela() {
		return codEscuela;
	}
	public void setCodEscuela(int codEscuela) {
		this.codEscuela = codEscuela;
	}
	public String getCarrera() {
		return carrera;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	public int getFono() {
		return fono;
	}
	public void setFono(int fono) {
		this.fono = fono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getEstadoAlumno() {
		return estadoAlumno;
	}
	public void setEstadoAlumno(int estadoAlumno) {
		this.estadoAlumno = estadoAlumno;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
}
