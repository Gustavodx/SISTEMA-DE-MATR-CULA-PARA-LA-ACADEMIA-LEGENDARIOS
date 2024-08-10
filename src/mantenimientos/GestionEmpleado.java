package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import interfaces.EmpleadoInterface;
import model.Alumno;
import model.Empleado;
import model.ListarEmpleados;
import utils.MySQLConexion;

public class GestionEmpleado implements EmpleadoInterface{

	@Override
	public int registrar(Empleado e) {
		int rs = 0;	// 0 en caso de Error
		//Plantilla de BD
		Connection con = null;			// obtener la conexi�n --> MySQLConexion
		PreparedStatement pst = null;	// preparar las sentencias que vamos a ejecutar
		try {
			con = MySQLConexion.getConexion();
			
			String sql = "insert into empleado values (?,?,?,?,?,?,?,?,default)";
			
			pst = con.prepareStatement(sql);
			pst.setString(1, e.getCodigo());
			pst.setString(2, e.getDni());
			pst.setString(3, e.getNombre());
			pst.setString(4, e.getApellido());
			pst.setString(5, e.getUsuario());
			pst.setString(6, e.getClave());
			pst.setString(7, e.getTelefono());
			pst.setString(8, e.getFecha());
			
			rs = pst.executeUpdate();
			
		} catch (Exception msg) {
			JOptionPane.showMessageDialog(null, "Error al registrar empleado\n"+msg.getMessage());
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
			
			String sql = "update empleado set estado = 0 where codEmpleado = ?";
			pst = con.prepareStatement(sql);
			
			pst.setString(1, codigo);
			
			rs = pst.executeUpdate();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error en eliminar empleado\n"+e.getMessage());
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
	public int actualizar(Empleado e) {
		int rs = 0;
		// Plantilla (Copy/Paste)
				Connection con = null;			// obtener la conexi�n --> MySQLConexion
				PreparedStatement pst = null;	// preparar las sentencias que vamos a ejecutar
				try {
					con = MySQLConexion.getConexion();
					
					String sql = "update empleado set nombreEmpleado = ?, clave = ?, telefono = ? where codEmpleado = ?";
					pst = con.prepareStatement(sql);
					
					pst.setString(1, e.getNombre());
					pst.setString(2, e.getClave());
					pst.setString(3, e.getTelefono());
					pst.setString(4, e.getCodigo());
					
					rs = pst.executeUpdate();
					
				} catch (Exception msg) {
					JOptionPane.showMessageDialog(null, "Error en actualizar\n"+msg.getMessage());
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
	public Empleado buscar(String codigo) {
		Empleado e = null;
		// Plantilla de BD (Copy/paste)
		Connection con = null;			// obtener la conexi�n --> MySQLConexion
		PreparedStatement pst = null;	// preparar las sentencias que vamos a ejecutar
		ResultSet rs = null;	// "almacenar" temporalmente el resultado de la consulta
		try {
			con = MySQLConexion.getConexion();
			
			String sql = "select * from empleado where codEmpleado = ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, codigo);
			
			rs = pst.executeQuery();			
			
			// ---- pasar lo almacenado en el objeto "rs" a la lista			
			if (rs.next()) {
				e = new Empleado();
				e.setCodigo(rs.getString(1));
				e.setDni(rs.getString(2));
				e.setNombre(rs.getString(3));
				e.setApellido(rs.getString(4));
				e.setUsuario(rs.getString(5));
				e.setClave(rs.getString(6));
				e.setTelefono(rs.getString(7));
				e.setFecha(rs.getString(8));
				e.setEstado(rs.getInt(9));
			}	
		} catch (Exception msg) {
			JOptionPane.showMessageDialog(null, "Error en buscar empleado\n"+msg.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException msg) {
				System.out.println("Error al cerrar!");
			}
		}
		return e;
	}

	@Override
	public Empleado validarAcceso(String usuario, String clave) {
		Empleado e = null;
		// Plantilla de la BD (Copy/Paste)
		Connection con = null;			// obtener la conexi�n --> MySQLConexion
		PreparedStatement pst = null;	// preparar las sentencias que vamos a ejecutar
		ResultSet rs = null;	// "almacenar" temporalmente el resultado de la consulta
		try {
			con = MySQLConexion.getConexion();
			
			String sql = "call usp_login(?,?)";
			pst = con.prepareStatement(sql);
			
			pst.setString(1, usuario);
			pst.setString(2, clave);
			
			rs = pst.executeQuery();
			
			// ---- pasar lo almacenado en el objeto "rs" a la lista			
			if (rs.next()) {
				e = new Empleado();
				e.setCodigo(rs.getString(1));
				e.setDni(rs.getString(2));
				e.setNombre(rs.getString(3));
				e.setApellido(rs.getString(4));
				e.setUsuario(rs.getString(5));
				e.setClave(rs.getString(6));
				e.setTelefono(rs.getString(7));
				e.setFecha(rs.getString(8));
				e.setEstado(rs.getInt(9));
			}
			
		} catch (Exception msg) {
			JOptionPane.showMessageDialog(null, "Error en validar acceso de empleado\n"+msg.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException msg) {
				System.out.println("Error al cerrar!");
			}
		}
		return e;
	}

	@Override
	public ArrayList<Empleado> listado() {
		ArrayList<Empleado> lista = null;
		// Plantilla de BD (Copy/Paste)
				Connection con = null;			// obtener la conexi�n --> MySQLConexion
				PreparedStatement pst = null;	// preparar las sentencias que vamos a ejecutar
				ResultSet rs = null;	// "almacenar" temporalmente el resultado de la consulta
				try {
					con = MySQLConexion.getConexion();
					
					String sql = "select * from empleado";
					pst = con.prepareStatement(sql);
					
					rs = pst.executeQuery();					
					
					// Crear lista con ArrayList de tipo Usuario
					lista = new ArrayList<Empleado>();
					
					// ---- pasar lo almacenado en el objeto "rs" a la lista			
					while (rs.next()) {
						Empleado e = new Empleado();
						e.setCodigo(rs.getString(1));
						e.setDni(rs.getString(2));
						e.setNombre(rs.getString(3));
						e.setApellido(rs.getString(4));
						e.setUsuario(rs.getString(5));
						e.setClave(rs.getString(6));
						e.setTelefono(rs.getString(7));
						e.setFecha(rs.getString(8));
						e.setEstado(rs.getInt(9));
						lista.add(e);
					}
					
				} catch (Exception msg) {
					JOptionPane.showMessageDialog(null, "Error en listado de empleados\n"+msg.getMessage());
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
	public int habilitar(String codigo) {
		int rs = 0;
		// Plantilla (Copy/Paste)
		Connection con = null;			// obtener la conexi�n --> MySQLConexion
		PreparedStatement pst = null;	// preparar las sentencias que vamos a ejecutar
		try {
			con = MySQLConexion.getConexion();
			
			String sql = "update empleado set estado = 1 where codEmpleado = ?";
			pst = con.prepareStatement(sql);
			
			pst.setString(1, codigo);
			
			rs = pst.executeUpdate();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error en habilitar empleado\n"+e.getMessage());
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
	public ArrayList<ListarEmpleados> lista() {
		ArrayList<ListarEmpleados> lista = null;
		Connection con = null;			// obtener la conexi�n --> MySQLConexion
		PreparedStatement pst = null;	// preparar las sentencias que vamos a ejecutar
		ResultSet rs = null;	// "almacenar" temporalmente el resultado de la consulta
		try {
			con = MySQLConexion.getConexion();
			
			String sql = "call usp_empleados()";
			pst = con.prepareStatement(sql);
			
			rs = pst.executeQuery();			
			
			// Crear lista con ArrayList de tipo Usuario
			lista = new ArrayList<ListarEmpleados>();
			
			// ---- pasar lo almacenado en el objeto "rs" a la lista			
			while (rs.next()) {
				ListarEmpleados ea = new ListarEmpleados();
				ea.setCodigo(rs.getString(1));
				ea.setDni(rs.getString(2));
				ea.setNombre(rs.getString(3));
				ea.setUsuario(rs.getString(4));
				ea.setClave(rs.getString(5));
				ea.setFono(rs.getString(6));
				ea.setFecha(rs.getString(7));
				lista.add(ea);
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error en listado de empleados\n"+e.getMessage());
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
	public Empleado validoAcceso(String usuario, String contrasena) {
		Empleado e = null;
		// Plantilla BD
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "select * from empleado where usuario = ? and clave = ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, usuario);
			pst.setString(2, contrasena);
			
			rs = pst.executeQuery();
			
			if(rs.next()){
				e = new Empleado();
				e.setCodigo(rs.getString(1));
				e.setDni(rs.getString(2));
				e.setNombre(rs.getString(3));
				e.setApellido(rs.getString(4));
				e.setUsuario(rs.getString(5));
				e.setClave(rs.getString(6));
				e.setTelefono(rs.getString(7));
				e.setFecha(rs.getString(8));
				e.setEstado(rs.getInt(9));
			}else {
				JOptionPane.showMessageDialog(null, "Usuario o contrase�a incorrecta");
			}
			
		} catch (Exception e2) {
			System.out.println("Error en validar Empleado " + e2.getMessage());
			JOptionPane.showMessageDialog(null, "Error en validar Empleado " + e2.getMessage());
		}finally {
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar ");
			}
		}
		return e;
	}

	@Override
	public ArrayList<Empleado> listadoxFecha(String fi, String ff) {
		ArrayList<Empleado> lista = null;
		// Plantilla BD
				Connection con = null;			// obtener la conexi�n --> MySQLConexion
				PreparedStatement pst = null;	// preparar las sentencias que vamos a ejecutar
				ResultSet rs = null;	// "almacenar" temporalmente el resultado de la consulta
				try {
					con = MySQLConexion.getConexion();
					
					String sql = "select * from empleado where fechaIngreso between ? and ?";
					pst = con.prepareStatement(sql);
					pst.setString(1, fi);
					pst.setString(2, ff);
					
					rs = pst.executeQuery();					
					
					// Crear lista con ArrayList de tipo Usuario
					lista = new ArrayList<Empleado>();
					
					// ---- pasar lo almacenado en el objeto "rs" a la lista			
					while (rs.next()) {
						Empleado e = new Empleado();
						e.setCodigo(rs.getString(1));
						e.setDni(rs.getString(2));
						e.setNombre(rs.getString(3));
						e.setApellido(rs.getString(4));
						e.setUsuario(rs.getString(5));
						e.setClave(rs.getString(6));
						e.setTelefono(rs.getString(7));
						e.setFecha(rs.getString(8));
						e.setEstado(rs.getInt(9));
						lista.add(e);
					}
					
				} catch (Exception msg) {
					JOptionPane.showMessageDialog(null, "Error en listado de Empleados\n"+msg.getMessage());
				} finally {
					try {
						con.close();
					} catch (SQLException msg) {
						System.out.println("Error al cerrar!");
					}
				}
		return lista;
	}
}
