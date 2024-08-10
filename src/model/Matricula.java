package model;

public class Matricula {
	
	private String codMatri;
	private String fecha;
	private String codAlu;
	private String codEmp;
	private double totalPago;
	
	public Matricula() {
		
	}
	public Matricula(String codMatri, String fecha, String codAlu, String codEmp, double totalPago) {
		this.codMatri = codMatri;
		this.fecha = fecha;
		this.codAlu = codAlu;
		this.codEmp = codEmp;
		this.totalPago = totalPago;
	}
	public String getCodMatri() {
		return codMatri;
	}
	public void setCodMatri(String codMatri) {
		this.codMatri = codMatri;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getCodAlu() {
		return codAlu;
	}
	public void setCodAlu(String codAlu) {
		this.codAlu = codAlu;
	}
	public String getCodEmp() {
		return codEmp;
	}
	public void setCodEmp(String codEmp) {
		this.codEmp = codEmp;
	}
	public double getTotalPago() {
		return totalPago;
	}
	public void setTotalPago(double totalPago) {
		this.totalPago = totalPago;
	}
	
}
