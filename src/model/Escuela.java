package model;

public class Escuela {
	
	private int codEscuela;
	private String nomEscuela;
	private double precioEscuela;
	
	@Override
	public String toString() {
		return "Escuela [codEscuela=" + codEscuela + ", nomEscuela=" + nomEscuela + ", precioEscuela=" + precioEscuela
				+ "]";
	}

	public Escuela() {
		
	}

	public Escuela(int codEscuela, String nomEscuela, double precioEscuela) {
		this.codEscuela = codEscuela;
		this.nomEscuela = nomEscuela;
		this.precioEscuela = precioEscuela;
	}
	
	public int getCodEscuela() {
		return codEscuela;
	}
	public void setCodEscuela(int codEscuela) {
		this.codEscuela = codEscuela;
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
