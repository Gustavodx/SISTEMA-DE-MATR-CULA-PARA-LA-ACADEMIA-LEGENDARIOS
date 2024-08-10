package model;

public class AlumnoEstado {
		private String codalum;
		private String nomcompleto;
		private String carrera;
		private String descripcion;
		
		
		
		public String getCodalum() {
			return codalum;
		}
		public void setCodalum(String codalum) {
			this.codalum = codalum;
		}
		public String getNomcompleto() {
			return nomcompleto;
		}
		public void setNomcompleto(String nomcompleto) {
			this.nomcompleto = nomcompleto;
		}
		public String getCarrera() {
			return carrera;
		}
		public void setCarrera(String carrera) {
			this.carrera = carrera;
		}
		public String getDescripcion() {
			return descripcion;
		}
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
		public AlumnoEstado(String codalum, String nomcompleto, String carrera, String descripcion) {
			super();
			this.codalum = codalum;
			this.nomcompleto = nomcompleto;
			this.carrera = carrera;
			this.descripcion = descripcion;
		}
		
		
		public AlumnoEstado() {
			super();
		}
		
		
		

}
