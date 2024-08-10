package model;

public class NombreAlumno {
	
	private String codAlu;
	private String alumno;
	private String dniAlu;
	
	@Override
	public String toString() {
		return "NombreAlumno [codAlu=" + codAlu + ", alumno=" + alumno + ", dniAlu=" + dniAlu + "]";
	}
	
	public NombreAlumno() {
		
	}
	
	public NombreAlumno(String codAlu, String alumno, String dniAlu) {
		this.codAlu = codAlu;
		this.alumno = alumno;
		this.dniAlu = dniAlu;
	}
	
	public String getCodAlu() {
		return codAlu;
	}
	public void setCodAlu(String codAlu) {
		this.codAlu = codAlu;
	}
	public String getAlumno() {
		return alumno;
	}
	public void setAlumno(String alumno) {
		this.alumno = alumno;
	}
	public String getDniAlu() {
		return dniAlu;
	}
	public void setDniAlu(String dniAlu) {
		this.dniAlu = dniAlu;
	}	
}
