package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import interfaces.AlumnoInterface;
import model.Alumno;
import model.AlumnoCarrera;
import model.AlumnoEstado;
import model.EstadosAlumnos;
import model.NombreAlumno;
import utils.MySQLConexion;

public class GestionAlumno implements AlumnoInterface{

	@Override
	public int registrar(Alumno a) {
		int rs = 0;	// 0 en caso de Error
		//Plantilla de BD
		Connection con = null;			// obtener la conexi�n --> MySQLConexion
		PreparedStatement pst = null;	// preparar las sentencias que vamos a ejecutar
		try {
			con = MySQLConexion.getConexion();
			
			String sql = "insert into alumno values (?,?,?,?,?,?,?,?,?,default,default)";
			
			pst = con.prepareStatement(sql);
			pst.setString(1, a.getCodigo());
			pst.setString(2, a.getDni());
			pst.setString(3, a.getNombre());
			pst.setString(4, a.getApellido());
			pst.setString(5, a.getFecha());
			pst.setInt(6, a.getCodEscuela());
			pst.setString(7, a.getCarrera());
			pst.setInt(8, a.getFono());
			pst.setString(9, a.getDireccion());
			
			rs = pst.executeUpdate();
			
		} catch (Exception msg) {
			JOptionPane.showMessageDialog(null, "Error al registrar alumno\n"+msg.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException msg) {
				System.out.println("Error al cerrar!");
			}
		}
		return rs;
	}

	@Override
	public int eliminar(String codigo) {
		int rs = 0;
		// Plantilla (Copy/Paste)
		Connection con = null;			// obtener la conexi�n --> MySQLConexion
		PreparedStatement pst = null;	// preparar las sentencias que vamos a ejecutar
		try {
			con = MySQLConexion.getConexion();
			
			String sql = "update alumno set estado = 0 , estadoAlumno = 3 where codAlumno = ?";
			pst = con.prepareStatement(sql);
			
			pst.setString(1, codigo);
			
			rs = pst.executeUpdate();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error en eliminar alumno\n"+e.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar!");
			}
		}
		return rs;
	}

	@Override
	public int habilitar(String codigo) {
		int rs = 0;
		// Plantilla (Copy/Paste)
		Connection con = null;			// obtener la conexi�n --> MySQLConexion
		PreparedStatement pst = null;	// preparar las sentencias que vamos a ejecutar
		try {
			con = MySQLConexion.getConexion();
			
			String sql = "update alumno set estado = 1 , estadoAlumno = 1 where codAlumno = ?";
			pst = con.prepareStatement(sql);
			
			pst.setString(1, codigo);
			
			rs = pst.executeUpdate();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error en habilitar alumno\n"+e.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar!");
			}
		}
		return rs;
	}

	@Override
	public int actualizar(Alumno a) {
		int rs = 0;
		// Plantilla (Copy/Paste)
				Connection con = null;			// obtener la conexi�n --> MySQLConexion
				PreparedStatement pst = null;	// preparar las sentencias que vamos a ejecutar
				try {
					con = MySQLConexion.getConexion();
					
					String sql = "update alumno set nombreAlumno = ?, codEscuela = ?, carrera = ?, telefonoAlumno = ?, direccionAlumno = ? where codAlumno = ?";
					pst = con.prepareStatement(sql);
					
					pst.setString(1, a.getNombre());
					pst.setInt(2, a.getCodEscuela());
					pst.setString(3, a.getCarrera());
					pst.setInt(4, a.getFono());
					pst.setString(5, a.getDireccion());
					pst.setString(6, a.getCodigo());
					
					rs = pst.executeUpdate();
					
				} catch (Exception msg) {
					JOptionPane.showMessageDialog(null, "Error en actualizar alumno\n"+msg.getMessage());
				} finally {
					try {
						con.close();
					} catch (SQLException msg) {
						System.out.println("Error al cerrar!");
					}
				}
		return rs;
	}

	@Override
	public Alumno buscar(String codigo) {
		Alumno a = null;
		// Plantilla de BD (Copy/paste)
				Connection con = null;			// obtener la conexi�n --> MySQLConexion
				PreparedStatement pst = null;	// preparar las sentencias que vamos a ejecutar
				ResultSet rs = null;	// "almacenar" temporalmente el resultado de la consulta
				try {
					con = MySQLConexion.getConexion();
					
					String sql = "select * from alumno where codAlumno = ?";
					pst = con.prepareStatement(sql);
					pst.setString(1, codigo);
					
					rs = pst.executeQuery();			
					
					// ---- pasar lo almacenado en el objeto "rs" a la lista			
					if (rs.next()) {
						a = new Alumno();
						a.setCodigo(rs.getString(1));
						a.setDni(rs.getString(2));
						a.setNombre(rs.getString(3));
						a.setApellido(rs.getString(4));
						a.setFecha(rs.getString(5));
						a.setCodEscuela(rs.getInt(6));
						a.setCarrera(rs.getString(7));
						a.setFono(rs.getInt(8));
						a.setDireccion(rs.getString(9));
						a.setEstadoAlumno(rs.getInt(10));
						a.setEstado(rs.getInt(11));
					}	
				} catch (Exception msg) {
					JOptionPane.showMessageDialog(null, "Error en buscar alumno\n"+msg.getMessage());
				} finally {
					try {
						con.close();
					} catch (SQLException msg) {
						System.out.println("Error al cerrar!");
					}
				}
		return a;
	}

	@Override
	public ArrayList<Alumno> listado() {
		ArrayList<Alumno> lista = null;
		// Plantilla de BD (Copy/Paste)
				Connection con = null;			// obtener la conexi�n --> MySQLConexion
				PreparedStatement pst = null;	// preparar las sentencias que vamos a ejecutar
				ResultSet rs = null;	// "almacenar" temporalmente el resultado de la consulta
				try {
					con = MySQLConexion.getConexion();
					
					String sql = "select * from alumno";
					pst = con.prepareStatement(sql);
					
					rs = pst.executeQuery();					
					
					// Crear lista con ArrayList de tipo Usuario
					lista = new ArrayList<Alumno>();
					
					// ---- pasar lo almacenado en el objeto "rs" a la lista			
					while (rs.next()) {
						Alumno a = new Alumno();
						a.setCodigo(rs.getString(1));
						a.setDni(rs.getString(2));
						a.setNombre(rs.getString(3));
						a.setApellido(rs.getString(4));
						a.setFecha(rs.getString(5));
						a.setCodEscuela(rs.getInt(6));
						a.setCarrera(rs.getString(7));
						a.setFono(rs.getInt(8));
						a.setDireccion(rs.getString(9));
						a.setEstadoAlumno(rs.getInt(10));
						a.setEstado(rs.getInt(11));
						lista.add(a);
					}
					
				} catch (Exception msg) {
					JOptionPane.showMessageDialog(null, "Error en listado de alumnos\n"+msg.getMessage());
				} finally {
					try {
						con.close();
					} catch (SQLException msg) {
						System.out.println("Error al cerrar!");
					}
				}
		return lista;
	}

	@Override
	public ArrayList<EstadosAlumnos> lista() {
		ArrayList<EstadosAlumnos> lista = null;
		Connection con = null;			// obtener la conexi�n --> MySQLConexion
		PreparedStatement pst = null;	// preparar las sentencias que vamos a ejecutar
		ResultSet rs = null;	// "almacenar" temporalmente el resultado de la consulta
		try {
			con = MySQLConexion.getConexion();
			
			String sql = "call usp_estados_alumnos()";
			pst = con.prepareStatement(sql);
			
			rs = pst.executeQuery();			
			
			// Crear lista con ArrayList de tipo Usuario
			lista = new ArrayList<EstadosAlumnos>();
			
			// ---- pasar lo almacenado en el objeto "rs" a la lista			
			while (rs.next()) {
				EstadosAlumnos ea = new EstadosAlumnos();
				ea.setCodAlumno(rs.getString(1));
				ea.setDniALumno(rs.getString(2));
				ea.setNomAlumno(rs.getString(3));
				ea.setFechIngreso(rs.getString(4));
				ea.setNomEscuela(rs.getString(5));
				ea.setCarrera(rs.getString(6));
				ea.setFonoAlumno(rs.getString(7));
				ea.setDirecAlumno(rs.getString(8));
				ea.setDescripcion(rs.getString(9));
				lista.add(ea);
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error en listado de alumnos\n"+e.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar!");
			}
		}
		return lista;
	}

	@Override
	public ArrayList<Alumno> listadoxFecha(String fi, String ff) {
		ArrayList<Alumno> lista = null;
		// Plantilla BD
		Connection con = null;			// obtener la conexi�n --> MySQLConexion
		PreparedStatement pst = null;	// preparar las sentencias que vamos a ejecutar
		ResultSet rs = null;	// "almacenar" temporalmente el resultado de la consulta
		try {
			con = MySQLConexion.getConexion();
			
			String sql = "select * from alumno where fechaIngresoAlumno between ? and ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, fi);
			pst.setString(2, ff);
			
			rs = pst.executeQuery();					
			
			// Crear lista con ArrayList de tipo Usuario
			lista = new ArrayList<Alumno>();
			
			// ---- pasar lo almacenado en el objeto "rs" a la lista			
			while (rs.next()) {
				Alumno a = new Alumno();
				a.setCodigo(rs.getString(1));
				a.setDni(rs.getString(2));
				a.setNombre(rs.getString(3));
				a.setApellido(rs.getString(4));
				a.setFecha(rs.getString(5));
				a.setCodEscuela(rs.getInt(6));
				a.setCarrera(rs.getString(7));
				a.setFono(rs.getInt(8));
				a.setDireccion(rs.getString(9));
				a.setEstadoAlumno(rs.getInt(10));
				a.setEstado(rs.getInt(11));
				lista.add(a);
			}
			
		} catch (Exception msg) {
			JOptionPane.showMessageDialog(null, "Error en listado de alumnos\n"+msg.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException msg) {
				System.out.println("Error al cerrar!");
			}
		}
		
		return lista;
	}

	@Override
	public ArrayList<NombreAlumno> listadoNombreAlumno() {
		ArrayList<NombreAlumno> lista = null;
		Connection con = null;			// obtener la conexi�n --> MySQLConexion
		PreparedStatement pst = null;	// preparar las sentencias que vamos a ejecutar
		ResultSet rs = null;	// "almacenar" temporalmente el resultado de la consulta
		try {
			con = MySQLConexion.getConexion();
			
			String sql = "call nomalumno()";
			pst = con.prepareStatement(sql);
			
			rs = pst.executeQuery();			
			
			// Crear lista con ArrayList de tipo Usuario
			lista = new ArrayList<NombreAlumno>();
			
			// ---- pasar lo almacenado en el objeto "rs" a la lista			
			while (rs.next()) {
				NombreAlumno b = new NombreAlumno();
				b.setCodAlu(rs.getString(1));
				b.setAlumno(rs.getString(2));
				b.setDniAlu(rs.getString(3));
				lista.add(b);
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error en listado Alumnos\n"+e.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar!");
			}
		}
		return lista;
	}

	@Override
	public ArrayList<AlumnoEstado> listadoxEstado(String estado) {
		ArrayList<AlumnoEstado> lista = null;
		//Plantilla BD
		Connection con = null;			// obtener la conexi�n --> MySQLConexion
		PreparedStatement pst = null;	// preparar las sentencias que vamos a ejecutar
		ResultSet rs = null;	// "almacenar" temporalmente el resultado de la consulta
		try {
			con = MySQLConexion.getConexion();
			
			String sql = "call usp_listadoEstadoAlumno(?)";
			pst = con.prepareStatement(sql);
			pst.setString(1,estado);
			
			rs = pst.executeQuery();					
			
			// Crear lista con ArrayList de tipo Usuario
			lista = new ArrayList<AlumnoEstado>();
			
			// ---- pasar lo almacenado en el objeto "rs" a la lista			
			while (rs.next()) {
				AlumnoEstado ae = new AlumnoEstado();
				ae.setCodalum(rs.getString(1));
				ae.setNomcompleto(rs.getString(2));
				ae.setCarrera(rs.getString(3));
				ae.setDescripcion(rs.getString(4));
				lista.add(ae);
			}
			
		} catch (Exception msg) {
			JOptionPane.showMessageDialog(null, "Error en listado de alumnos\n"+msg.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException msg) {
				System.out.println("Error al cerrar!");
			}
		}
		
		return lista;
	}

	@Override
	public ArrayList<AlumnoCarrera> listadoxCarrera(String carrera) {
		ArrayList<AlumnoCarrera> lista = null;
		// PLantilla BD
		Connection con = null;			// obtener la conexi�n --> MySQLConexion
		PreparedStatement pst = null;	// preparar las sentencias que vamos a ejecutar
		ResultSet rs = null;	// "almacenar" temporalmente el resultado de la consulta
		try {
			con = MySQLConexion.getConexion();
			
			String sql = "call usp_listadoAlumnosxCarrera(?)";
			pst = con.prepareStatement(sql);
			pst.setString(1,carrera);
			
			rs = pst.executeQuery();					
			
			// Crear lista con ArrayList de tipo Usuario
			lista = new ArrayList<AlumnoCarrera>();
			
			// ---- pasar lo almacenado en el objeto "rs" a la lista			
			while (rs.next()) {
				AlumnoCarrera ac = new AlumnoCarrera();
				ac.setCodalumno(rs.getString(1));
				ac.setDnialumno(rs.getString(2));
				ac.setNoncompleto(rs.getString(3));
				ac.setEscuela(rs.getString(4));
				ac.setCarrera(rs.getString(5));
				lista.add(ac);
			}
			
		} catch (Exception msg) {
			JOptionPane.showMessageDialog(null, "Error en listado de Carrera\n"+msg.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException msg) {
				System.out.println("Error al cerrar!");
			}
		}
		return lista;
	}

	@Override
	public ArrayList<EstadosAlumnos> listaRetirados() {
		ArrayList<EstadosAlumnos> lista = null;
		Connection con = null;			// obtener la conexi�n --> MySQLConexion
		PreparedStatement pst = null;	// preparar las sentencias que vamos a ejecutar
		ResultSet rs = null;	// "almacenar" temporalmente el resultado de la consulta
		try {
			con = MySQLConexion.getConexion();
			
			String sql = "call usp_listadoEstadoAlumno(?)";
			pst = con.prepareStatement(sql);
		
			
			rs = pst.executeQuery();			
			
			// Crear lista con ArrayList de tipo Usuario
			lista = new ArrayList<EstadosAlumnos>();
			
			// ---- pasar lo almacenado en el objeto "rs" a la lista			
			while (rs.next()) {
				EstadosAlumnos ea = new EstadosAlumnos();
				ea.setCodAlumno(rs.getString(1));
				ea.setDniALumno(rs.getString(2));
				ea.setNomAlumno(rs.getString(3));
				ea.setFechIngreso(rs.getString(4));
				ea.setNomEscuela(rs.getString(5));
				ea.setCarrera(rs.getString(6));
				ea.setFonoAlumno(rs.getString(7));
				ea.setDirecAlumno(rs.getString(8));
				ea.setDescripcion(rs.getString(9));
				lista.add(ea);
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error en listado de alumnos retirados\n"+e.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar!");
			}
		}
		return lista;
	}

	@Override
	public ArrayList<EstadosAlumnos> listadoMatriculados() {
		ArrayList<EstadosAlumnos> lista = null;
		Connection con = null;			// obtener la conexi�n --> MySQLConexion
		PreparedStatement pst = null;	// preparar las sentencias que vamos a ejecutar
		ResultSet rs = null;	// "almacenar" temporalmente el resultado de la consulta
		try {
			con = MySQLConexion.getConexion();
			
			String sql = "call usp_listadoEstadoAlumno(?)";
			pst = con.prepareStatement(sql);
			
			rs = pst.executeQuery();			
			
			// Crear lista con ArrayList de tipo Usuario
			lista = new ArrayList<EstadosAlumnos>();
			
			// ---- pasar lo almacenado en el objeto "rs" a la lista			
			while (rs.next()) {
				EstadosAlumnos ea = new EstadosAlumnos();
				ea.setCodAlumno(rs.getString(1));
				ea.setDniALumno(rs.getString(2));
				ea.setNomAlumno(rs.getString(3));
				ea.setFechIngreso(rs.getString(4));
				ea.setNomEscuela(rs.getString(5));
				ea.setCarrera(rs.getString(6));
				ea.setFonoAlumno(rs.getString(7));
				ea.setDirecAlumno(rs.getString(8));
				ea.setDescripcion(rs.getString(9));
				lista.add(ea);
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error en listado de alumnos matriculados\n"+e.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar!");
			}
		}
		return lista;
	}

	@Override
	public ArrayList<EstadosAlumnos> listadoRegistrados() {
		ArrayList<EstadosAlumnos> lista = null;
		Connection con = null;			// obtener la conexi�n --> MySQLConexion
		PreparedStatement pst = null;	// preparar las sentencias que vamos a ejecutar
		ResultSet rs = null;	// "almacenar" temporalmente el resultado de la consulta
		try {
			con = MySQLConexion.getConexion();
			
			String sql = "call usp_listadoEstadoAlumno(?)";
			pst = con.prepareStatement(sql);
			
			rs = pst.executeQuery();			
			
			// Crear lista con ArrayList de tipo Usuario
			lista = new ArrayList<EstadosAlumnos>();
			
			// ---- pasar lo almacenado en el objeto "rs" a la lista			
			while (rs.next()) {
				EstadosAlumnos ea = new EstadosAlumnos();
				ea.setCodAlumno(rs.getString(1));
				ea.setDniALumno(rs.getString(2));
				ea.setNomAlumno(rs.getString(3));
				ea.setFechIngreso(rs.getString(4));
				ea.setNomEscuela(rs.getString(5));
				ea.setCarrera(rs.getString(6));
				ea.setFonoAlumno(rs.getString(7));
				ea.setDirecAlumno(rs.getString(8));
				ea.setDescripcion(rs.getString(9));
				lista.add(ea);
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error en listado de alumnos registrados\n"+e.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar!");
			}
		}
		return lista;
	}	
}
