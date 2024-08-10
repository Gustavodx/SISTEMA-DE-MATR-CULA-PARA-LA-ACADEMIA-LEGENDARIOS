package interfaces;

import java.util.ArrayList;

import model.Curso;
import model.CursoProfesor;
import model.ListarCursos;

public interface CursoInterface {
	
	public int registrar(Curso c);
	
	public int eliminar(String codigo);
	
	public int habilitar(String codigo);
	
	public int actualizar(Curso c);
	
	public Curso buscar(String codigo);
	
	public ArrayList<Curso> listado();
	
	public ArrayList<ListarCursos> lista();
	
	public ArrayList<CursoProfesor> listar();
}
