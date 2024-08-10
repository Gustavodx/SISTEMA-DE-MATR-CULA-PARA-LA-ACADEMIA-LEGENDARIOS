package interfaces;

import java.util.ArrayList;

import model.Empleado;
import model.ListarEmpleados;

public interface EmpleadoInterface {
	
	public int registrar(Empleado e);
	
	public int eliminar(String codigo);
	
	public int habilitar(String codigo);
	
	public int actualizar(Empleado e);
	
	public Empleado buscar(String codigo);
	
	public Empleado validarAcceso(String usuario, String clave);
	
	//
	public ArrayList<Empleado> listadoxFecha(String fi,String ff);
	
	public ArrayList<Empleado> listado();
	
	public ArrayList<ListarEmpleados> lista();
	
	//metodo para validar el acceso, segun usuario y contrasena
	public Empleado validoAcceso (String usuario, String contrasena);
}
