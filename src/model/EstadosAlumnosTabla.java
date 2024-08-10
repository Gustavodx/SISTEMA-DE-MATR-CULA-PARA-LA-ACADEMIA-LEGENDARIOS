package model;

public class EstadosAlumnosTabla {
	
	private int cod;
	private String descripcion;
	
	@Override
	public String toString() {
		return "EstadosAlumnosTabla [cod=" + cod + ", descripcion=" + descripcion + "]";
	}

	public EstadosAlumnosTabla() {
		
	}
	
	public EstadosAlumnosTabla(int cod, String descripcion) {
		this.cod = cod;
		this.descripcion = descripcion;
	}
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
