package model;

public class DetalleMatricula {
	
	private String codMatri;
	private String codProf;
	private String codCurso;
	private double importe;
	private int vacante;
	
	public DetalleMatricula() {
		
	}
	public DetalleMatricula(String codMatri, String codProf, String codCurso, double importe, int vacante) {
		this.codMatri = codMatri;
		this.codProf = codProf;
		this.codCurso = codCurso;
		this.importe = importe;
		this.vacante = vacante;
	}
	public String getCodMatri() {
		return codMatri;
	}
	public void setCodMatri(String codMatri) {
		this.codMatri = codMatri;
	}
	public String getCodProf() {
		return codProf;
	}
	public void setCodProf(String codProf) {
		this.codProf = codProf;
	}
	public String getCodCurso() {
		return codCurso;
	}
	public void setCodCurso(String codCurso) {
		this.codCurso = codCurso;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	public int getVacante() {
		return vacante;
	}
	public void setVacante(int vacante) {
		this.vacante = vacante;
	}
	
}
