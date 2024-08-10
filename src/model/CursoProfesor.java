package model;

public class CursoProfesor {
	
	private String codCurso;
	private String nomCurso;
	private int capacidadCurso;
	private String profesor;
	private String codProf;
	private String nomEscuela;
	private double precioEscuela;
	
	@Override
	public String toString() {
		return "CursoProfesor [codCurso=" + codCurso + ", nomCurso=" + nomCurso + ", capacidadCurso=" + capacidadCurso
				+ ", profesor=" + profesor + ", codProf=" + codProf + ", nomEscuela=" + nomEscuela + ", precioEscuela="
				+ precioEscuela + "]";
	}
	
	public CursoProfesor() {
		
	}
	
	public CursoProfesor(String codCurso, String nomCurso, int capacidadCurso, String profesor, String codProf,
			String nomEscuela, double precioEscuela) {
		this.codCurso = codCurso;
		this.nomCurso = nomCurso;
		this.capacidadCurso = capacidadCurso;
		this.profesor = profesor;
		this.codProf = codProf;
		this.nomEscuela = nomEscuela;
		this.precioEscuela = precioEscuela;
	}
	
	public String getCodCurso() {
		return codCurso;
	}
	public void setCodCurso(String codCurso) {
		this.codCurso = codCurso;
	}
	public String getNomCurso() {
		return nomCurso;
	}
	public void setNomCurso(String nomCurso) {
		this.nomCurso = nomCurso;
	}
	public int getCapacidadCurso() {
		return capacidadCurso;
	}
	public void setCapacidadCurso(int capacidadCurso) {
		this.capacidadCurso = capacidadCurso;
	}
	public String getProfesor() {
		return profesor;
	}
	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}
	public String getCodProf() {
		return codProf;
	}
	public void setCodProf(String codProf) {
		this.codProf = codProf;
	}
	public String getNomEscuela() {
		return nomEscuela;
	}
	public void setNomEscuela(String nomEscuela) {
		this.nomEscuela = nomEscuela;
	}
	public double getPrecioEscuela() {
		return precioEscuela;
	}
	public void setPrecioEscuela(double precioEscuela) {
		this.precioEscuela = precioEscuela;
	}
}
