package model;

public class Curso {
	
	private String codigo;
	private String nombre;
	private int creditos;
	private int ciclo;
	private int canthoras;
	private int codEscuela;
	private int capacidad;
	private int estado;
	
	
	public Curso() {
		
	}
	public Curso(String codigo, String nombre, int creditos, int ciclo, int canthoras, int codEscuela, int estado,
			int capacidad) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.creditos = creditos;
		this.ciclo = ciclo;
		this.canthoras = canthoras;
		this.codEscuela = codEscuela;
		this.estado = estado;
		this.capacidad = capacidad;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCreditos() {
		return creditos;
	}
	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}
	public int getCiclo() {
		return ciclo;
	}
	public void setCiclo(int ciclo) {
		this.ciclo = ciclo;
	}
	public int getCanthoras() {
		return canthoras;
	}
	public void setCanthoras(int canthoras) {
		this.canthoras = canthoras;
	}
	public int getCodEscuela() {
		return codEscuela;
	}
	public void setCodEscuela(int codEscuela) {
		this.codEscuela = codEscuela;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
}
