package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import interfaces.ProfesorInterface;
import model.Alumno;
import model.EstadosAlumnos;
import model.ListaProfesores;
import model.Profesor;
import utils.MySQLConexion;

public class GestionProfesor implements ProfesorInterface{

	@Override
	public int registrar(Profesor p) {
		int rs = 0;	// 0 en caso de Error
		//Plantilla de BD
		Connection con = null;			// obtener la conexión --> MySQLConexion
		PreparedStatement pst = null;	// preparar las sentencias que vamos a ejecutar
		try {
			con = MySQLConexion.getConexion();
			
			String sql = "insert into profesor values (?,?,?,?,?,?,?,?,?,default)";
			
			pst = con.prepareStatement(sql);
			pst.setString(1, p.getCodigo());
			pst.setString(2, p.getDni());
			pst.setString(3, p.getNom());
			pst.setString(4, p.getApe());
			pst.setString(5, p.getFono());
			pst.setString(6, p.getFecha());
			pst.setString(7, p.getCodCurso());
			pst.setInt(8, p.getCodEscuela());
			pst.setString(9, p.getDirec());
			
			rs = pst.executeUpdate();
			
		} catch (Exception msg) {
			JOptionPane.showMessageDialog(null, "Error al registrar profesor\n"+msg.getMessage());
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
		Connection con = null;			// obtener la conexión --> MySQLConexion
		PreparedStatement pst = null;	// preparar las sentencias que vamos a ejecutar
		try {
			con = MySQLConexion.getConexion();
			
			String sql = "update profesor set estado = 0 where codProfesor = ?";
			pst = con.prepareStatement(sql);
			
			pst.setString(1, codigo);
			
			rs = pst.executeUpdate();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error en eliminar profesor\n"+e.getMessage());
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
		Connection con = null;			// obtener la conexión --> MySQLConexion
		PreparedStatement pst = null;	// preparar las sentencias que vamos a ejecutar
		try {
			con = MySQLConexion.getConexion();
			
			String sql = "update profesor set estado = 1 where codProfesor = ?";
			pst = con.prepareStatement(sql);
			
			pst.setString(1, codigo);
			
			rs = pst.executeUpdate();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error en habilitar profesor\n"+e.getMessage());
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
	public int actualizar(Profesor p) {
		int rs = 0;
		// Plantilla (Copy/Paste)
				Connection con = null;			// obtener la conexión --> MySQLConexion
				PreparedStatement pst = null;	// preparar las sentencias que vamos a ejecutar
				try {
					con = MySQLConexion.getConexion();
					
					String sql = "update profesor set nombreProfesor = ?, apellidoProfesor = ?, telefonoProfesor = ?, codCurso = ?, codEscuela = ?, direccionProfesor = ? where codProfesor = ?";
					pst = con.prepareStatement(sql);
					
					pst.setString(1, p.getNom());
					pst.setString(2, p.getApe());
					pst.setString(3, p.getFono());
					pst.setString(4, p.getCodCurso());
					pst.setInt(5, p.getCodEscuela());
					pst.setString(6, p.getDirec());
					pst.setString(7, p.getCodigo());
					
					rs = pst.executeUpdate();
					
				} catch (Exception msg) {
					JOptionPane.showMessageDialog(null, "Error en actualizar profesor\n"+msg.getMessage());
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
	public Profesor buscar(String codigo) {
		Profesor p = null;
		Connection con = null;			// obtener la conexión --> MySQLConexion
		PreparedStatement pst = null;	// preparar las sentencias que vamos a ejecutar
		ResultSet rs = null;	// "almacenar" temporalmente el resultado de la consulta
		try {
			con = MySQLConexion.getConexion();
			
			String sql = "select * from profesor where codProfesor = ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, codigo);
			
			rs = pst.executeQuery();			
			
			// ---- pasar lo almacenado en el objeto "rs" a la lista			
			if (rs.next()) {
				p = new Profesor();
				p.setCodigo(rs.getString(1));
				p.setDni(rs.getString(2));
				p.setNom(rs.getString(3));
				p.setApe(rs.getString(4));
				p.setFono(rs.getString(5));
				p.setFecha(rs.getString(6));
				p.setCodCurso(rs.getString(7));
				p.setCodEscuela(rs.getInt(8));
				p.setDirec(rs.getString(9));
				p.setEstado(rs.getInt(10));
			}	
		} catch (Exception msg) {
			JOptionPane.showMessageDialog(null, "Error en buscar profesor\n"+msg.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException msg) {
				System.out.println("Error al cerrar!");
			}
		}
		return p;
	}

	@Override
	public ArrayList<Profesor> listado() {
		ArrayList<Profesor> lista = null;
		Connection con = null;			// obtener la conexión --> MySQLConexion
		PreparedStatement pst = null;	// preparar las sentencias que vamos a ejecutar
		ResultSet rs = null;	// "almacenar" temporalmente el resultado de la consulta
		try {
			con = MySQLConexion.getConexion();
			
			String sql = "select * from profesor";
			pst = con.prepareStatement(sql);
			
			rs = pst.executeQuery();					
			
			// Crear lista con ArrayList de tipo Usuario
			lista = new ArrayList<Profesor>();
			
			// ---- pasar lo almacenado en el objeto "rs" a la lista			
			while (rs.next()) {
				Profesor p = new Profesor();
				p.setCodigo(rs.getString(1));
				p.setDni(rs.getString(2));
				p.setNom(rs.getString(3));
				p.setApe(rs.getString(4));
				p.setFono(rs.getString(5));
				p.setFecha(rs.getString(6));
				p.setCodCurso(rs.getString(7));
				p.setCodEscuela(rs.getInt(8));
				p.setDirec(rs.getString(9));
				p.setEstado(rs.getInt(10));
				lista.add(p);
			}
			
		} catch (Exception msg) {
			JOptionPane.showMessageDialog(null, "Error en listado de profesores\n"+msg.getMessage());
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
	public ArrayList<ListaProfesores> lista() {
		ArrayList<ListaProfesores> lista = null;
		Connection con = null;			// obtener la conexión --> MySQLConexion
		PreparedStatement pst = null;	// preparar las sentencias que vamos a ejecutar
		ResultSet rs = null;	// "almacenar" temporalmente el resultado de la consulta
		try {
			con = MySQLConexion.getConexion();
			
			String sql = "call usp_profesores();";
			pst = con.prepareStatement(sql);
			
			rs = pst.executeQuery();			
			
			// Crear lista con ArrayList de tipo Usuario
			lista = new ArrayList<ListaProfesores>();
			
			// ---- pasar lo almacenado en el objeto "rs" a la lista			
			while (rs.next()) {
				ListaProfesores lp = new ListaProfesores();
				lp.setCod(rs.getString(1));
				lp.setDni(rs.getString(2));
				lp.setProfesor(rs.getString(3));
				lp.setFono(rs.getString(4));
				lp.setFecha(rs.getString(5));
				lp.setNomCurso(rs.getString(6));
				lp.setNomEscuela(rs.getString(7));
				lp.setDirec(rs.getString(8));
				lista.add(lp);
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error en listado de profesores\n"+e.getMessage());
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
