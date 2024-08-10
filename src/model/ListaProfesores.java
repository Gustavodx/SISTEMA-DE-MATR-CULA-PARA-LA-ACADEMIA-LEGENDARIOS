package model;

public class ListaProfesores {
	
	private String cod;
	private String dni;
	private String profesor;
	private String fono;
	private String fecha;
	private String nomCurso;
	private String nomEscuela;
	private String direc;
	
	@Override
	public String toString() {
		return "ListaProfesores [cod=" + cod + ", dni=" + dni + ", profesor=" + profesor + ", fono=" + fono + ", fecha="
				+ fecha + ", nomCurso=" + nomCurso + ", nomEscuela=" + nomEscuela + ", direc=" + direc + "]";
	}
	
	public ListaProfesores() {
		
	}
	
	public ListaProfesores(String cod, String dni, String profesor, String fono, String fecha, String nomCurso,
			String nomEscuela, String direc) {
		super();
		this.cod = cod;
		this.dni = dni;
		this.profesor = profesor;
		this.fono = fono;
		this.fecha = fecha;
		this.nomCurso = nomCurso;
		this.nomEscuela = nomEscuela;
		this.direc = direc;
	}
	
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getProfesor() {
		return profesor;
	}
	public void setProfesor(String profesor) {
		this.profesor = profesor;
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
	public String getNomCurso() {
		return nomCurso;
	}
	public void setNomCurso(String nomCurso) {
		this.nomCurso = nomCurso;
	}
	public String getNomEscuela() {
		return nomEscuela;
	}
	public void setNomEscuela(String nomEscuela) {
		this.nomEscuela = nomEscuela;
	}
	public String getDirec() {
		return direc;
	}
	public void setDirec(String direc) {
		this.direc = direc;
	}
}
