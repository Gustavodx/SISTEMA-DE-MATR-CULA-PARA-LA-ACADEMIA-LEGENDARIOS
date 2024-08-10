package interfaces;

import java.util.ArrayList;

import model.Alumno;
import model.AlumnoCarrera;
import model.AlumnoEstado;
import model.EstadosAlumnos;
import model.NombreAlumno;

public interface AlumnoInterface {
	
	public int registrar(Alumno a);
	
	public int eliminar(String codigo);
	
	public int habilitar(String codigo);
	
	public int actualizar(Alumno c);
	
	public Alumno buscar(String codigo);
	
	//listado de todos los alumnos
	public ArrayList<Alumno> listado();
	
	
	public ArrayList<EstadosAlumnos> lista();
	
	//LISTADO XFECHA
	public ArrayList<Alumno> listadoxFecha(String fi,String ff);
	//
	
	
	//public ArrayList<Alumno> listadoxEstado(String estado);
	
	public ArrayList<AlumnoEstado> listadoxEstado(String estado);
	//
	public ArrayList<AlumnoCarrera> listadoxCarrera(String carrera);
	
	public ArrayList<NombreAlumno> listadoNombreAlumno();
	
	
	
	
	
	
	public ArrayList<EstadosAlumnos> listaRetirados();
	
	public ArrayList<EstadosAlumnos> listadoMatriculados();
	
	public ArrayList<EstadosAlumnos> listadoRegistrados();
}
