package model;

public class Profesor {
	
	private String codigo;
	private String dni;
	private String nom;
	private String ape;
	private String fono;
	private String fecha;
	private String codCurso;
	private int codEscuela;
	private String direc;
	private int estado;
	
	@Override
	public String toString() {
		return "Profesor [codigo=" + codigo + ", dni=" + dni + ", nom=" + nom + ", ape=" + ape + ", fono=" + fono
				+ ", fecha=" + fecha + ", codCurso=" + codCurso + ", codEscuela=" + codEscuela + ", direc=" + direc
				+ ", estado=" + estado + "]";
	}

	public Profesor() {
		
	}

	public Profesor(String codigo, String dni, String nom, String ape, String fono, String fecha, String codCurso,
			int codEscuela, String direc, int estado) {
		this.codigo = codigo;
		this.dni = dni;
		this.nom = nom;
		this.ape = ape;
		this.fono = fono;
		this.fecha = fecha;
		this.codCurso = codCurso;
		this.codEscuela = codEscuela;
		this.direc = direc;
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
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getApe() {
		return ape;
	}
	public void setApe(String ape) {
		this.ape = ape;
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
	public String getCodCurso() {
		return codCurso;
	}
	public void setCodCurso(String codCurso) {
		this.codCurso = codCurso;
	}
	public int getCodEscuela() {
		return codEscuela;
	}
	public void setCodEscuela(int codEscuela) {
		this.codEscuela = codEscuela;
	}
	public String getDirec() {
		return direc;
	}
	public void setDirec(String direc) {
		this.direc = direc;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
}
