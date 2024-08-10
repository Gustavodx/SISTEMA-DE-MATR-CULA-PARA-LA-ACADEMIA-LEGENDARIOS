package interfaces;

import java.util.ArrayList;

import model.ListaProfesores;
import model.Profesor;

public interface ProfesorInterface {
	
	public int registrar(Profesor p);
	
	public int eliminar(String codigo);
	
public int habilitar(String codigo);
	
	public int actualizar(Profesor p);
	
	public Profesor buscar(String codigo);
	
	public ArrayList<Profesor> listado();
	
	public ArrayList<ListaProfesores> lista();
}
