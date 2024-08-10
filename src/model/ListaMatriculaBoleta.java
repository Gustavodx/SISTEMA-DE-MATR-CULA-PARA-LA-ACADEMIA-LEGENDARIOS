package model;

public class ListaMatriculaBoleta {
	
	private String codCurso;
	private String nomCurso;
	private Double precio;
	private Double importeTotal;
	
	@Override
	public String toString() {
		return "ListaMatriculaBoleta [codCurso=" + codCurso + ", nomCurso=" + nomCurso + ", precio=" + precio
				+ ", importeTotal=" + importeTotal + "]";
	}

	public ListaMatriculaBoleta() {
		
	}

	public ListaMatriculaBoleta(String codCurso, String nomCurso, Double precio, Double importeTotal) {
		this.codCurso = codCurso;
		this.nomCurso = nomCurso;
		this.precio = precio;
		this.importeTotal = importeTotal;
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

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Double getImporteTotal() {
		return importeTotal;
	}

	public void setImporteTotal(Double importeTotal) {
		this.importeTotal = importeTotal;
	}
}
