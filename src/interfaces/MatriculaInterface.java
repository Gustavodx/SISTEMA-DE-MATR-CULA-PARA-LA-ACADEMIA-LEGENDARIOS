package interfaces;

import java.util.ArrayList;

import model.DetalleMatricula;
import model.ListaMatriculaBoleta;
import model.Matricula;

public interface MatriculaInterface {
	
	public String generaNumMatricula();
	
	// realiza la venta -> registro en las tablas cabecera y detalle
	// actualizar los productos
	public int realizarMatricula(Matricula m, ArrayList<DetalleMatricula> detalles);
	
	// listado de las ventas por fecha
	public ArrayList<Matricula> matriculasxFecha(String fecha);
	
	// listado de los detalles segun la boleta
	public ArrayList<DetalleMatricula> detallexNumMatricula(String codMatri);
	
	public ArrayList<Matricula> listadomatriculasxfechas(String fi, String ff);
	
	public ArrayList<ListaMatriculaBoleta> listarDatosBoleta();
}
