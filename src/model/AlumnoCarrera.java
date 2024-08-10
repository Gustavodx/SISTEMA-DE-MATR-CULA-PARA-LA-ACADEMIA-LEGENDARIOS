package model;

public class AlumnoCarrera {
	private String codalumno;
	private String dnialumno;
	private String noncompleto;
	private String escuela;
	private String carrera;
	
	
	public String getCodalumno() {
		return codalumno;
	}
	public void setCodalumno(String codalumno) {
		this.codalumno = codalumno;
	}
	public String getDnialumno() {
		return dnialumno;
	}
	public void setDnialumno(String dnialumno) {
		this.dnialumno = dnialumno;
	}
	public String getNoncompleto() {
		return noncompleto;
	}
	public void setNoncompleto(String noncompleto) {
		this.noncompleto = noncompleto;
	}
	public String getEscuela() {
		return escuela;
	}
	public void setEscuela(String escuela) {
		this.escuela = escuela;
	}
	public String getCarrera() {
		return carrera;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	public AlumnoCarrera(String codalumno, String dnialumno, String noncompleto, String escuela, String carrera) {
		super();
		this.codalumno = codalumno;
		this.dnialumno = dnialumno;
		this.noncompleto = noncompleto;
		this.escuela = escuela;
		this.carrera = carrera;
	}
	public AlumnoCarrera() {
		super();
	}
	

	
	
	
}
