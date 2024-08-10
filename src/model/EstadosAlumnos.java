package model;

public class EstadosAlumnos {
	private String codAlumno;
	private String dniALumno;
	private String nomAlumno;
	private String fechIngreso;
	private String nomEscuela;
	private String carrera;
	private String fonoAlumno;
	private String direcAlumno;
	private String descripcion;
	
	public EstadosAlumnos() {
		
	}

	public EstadosAlumnos(String codAlumno, String dniALumno, String nomAlumno, String fechIngreso, String nomEscuela,
			String carrera, String fonoAlumno, String direcAlumno, String descripcion) {
		this.codAlumno = codAlumno;
		this.dniALumno = dniALumno;
		this.nomAlumno = nomAlumno;
		this.fechIngreso = fechIngreso;
		this.nomEscuela = nomEscuela;
		this.carrera = carrera;
		this.fonoAlumno = fonoAlumno;
		this.direcAlumno = direcAlumno;
		this.descripcion = descripcion;
	}
	
	public String getCodAlumno() {
		return codAlumno;
	}
	public void setCodAlumno(String codAlumno) {
		this.codAlumno = codAlumno;
	}
	public String getDniALumno() {
		return dniALumno;
	}
	public void setDniALumno(String dniALumno) {
		this.dniALumno = dniALumno;
	}
	public String getNomAlumno() {
		return nomAlumno;
	}
	public void setNomAlumno(String nomAlumno) {
		this.nomAlumno = nomAlumno;
	}
	public String getFechIngreso() {
		return fechIngreso;
	}
	public void setFechIngreso(String fechIngreso) {
		this.fechIngreso = fechIngreso;
	}
	public String getNomEscuela() {
		return nomEscuela;
	}
	public void setNomEscuela(String nomEscuela) {
		this.nomEscuela = nomEscuela;
	}
	public String getCarrera() {
		return carrera;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	public String getFonoAlumno() {
		return fonoAlumno;
	}
	public void setFonoAlumno(String fonoAlumno) {
		this.fonoAlumno = fonoAlumno;
	}
	public String getDirecAlumno() {
		return direcAlumno;
	}
	public void setDirecAlumno(String direcAlumno) {
		this.direcAlumno = direcAlumno;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}	
}
