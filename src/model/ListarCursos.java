package model;

public class ListarCursos {
	
	private String codCurso;
	private String nombreCurso;
	private int creditos;
	private int ciclo;
	private int cantHoras;
	private String nomreEscuela;
	private int capacidad;
	
	public ListarCursos() {
		
	}
	public ListarCursos(String codCurso, String nombreCurso, int creditos, int ciclo, int cantHoras,
			String nomreEscuela, int capacidad) {
		this.codCurso = codCurso;
		this.nombreCurso = nombreCurso;
		this.creditos = creditos;
		this.ciclo = ciclo;
		this.cantHoras = cantHoras;
		this.nomreEscuela = nomreEscuela;
		this.capacidad = capacidad;
	}
	public String getCodCurso() {
		return codCurso;
	}
	public void setCodCurso(String codCurso) {
		this.codCurso = codCurso;
	}
	public String getNombreCurso() {
		return nombreCurso;
	}
	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
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
	public int getCantHoras() {
		return cantHoras;
	}
	public void setCantHoras(int cantHoras) {
		this.cantHoras = cantHoras;
	}
	public String getNomreEscuela() {
		return nomreEscuela;
	}
	public void setNomreEscuela(String nomreEscuela) {
		this.nomreEscuela = nomreEscuela;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
}
