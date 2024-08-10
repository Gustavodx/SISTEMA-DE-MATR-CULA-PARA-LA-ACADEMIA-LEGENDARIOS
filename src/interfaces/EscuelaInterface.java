package interfaces;

import java.util.ArrayList;

import model.Escuela;

public interface EscuelaInterface {
	
	public ArrayList<Escuela> listado();
	
	public Escuela buscar(int codigo);
}
