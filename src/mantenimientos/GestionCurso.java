package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import interfaces.CursoInterface;
import model.Curso;
import model.CursoProfesor;
import model.ListarCursos;
import utils.MySQLConexion;

public class GestionCurso implements CursoInterface{

	@Override
	public int registrar(Curso c) {
		int rs = 0;	// 0 en caso de Error
		//Plantilla de BD
		Connection con = null;			// obtener la conexión --> MySQLConexion
		PreparedStatement pst = null;	// preparar las sentencias que vamos a ejecutar
		try {
			con = MySQLConexion.getConexion();
			
			String sql = "insert into curso values (?,?,?,?,?,?,?,1)";
			
			pst = con.prepareStatement(sql);
			pst.setString(1, c.getCodigo());
			pst.setString(2, c.getNombre());
			pst.setInt(3, c.getCreditos());
			pst.setInt(4, c.getCiclo());
			pst.setInt(5, c.getCanthoras());
			pst.setInt(6, c.getCodEscuela());
			pst.setInt(7, c.getCapacidad());
			
			rs = pst.executeUpdate();
			
		} catch (Exception msg) {
			JOptionPane.showMessageDialog(null, "Error al registrar curso\n"+msg.getMessage());
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
			
			String sql = "update curso set estado = 0 where codCurso = ?";
			pst = con.prepareStatement(sql);
			
			pst.setString(1, codigo);
			
			rs = pst.executeUpdate();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error en eliminar curso\n"+e.getMessage());
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
			
			String sql = "update curso set estado = 1 where codCurso = ?";
			pst = con.prepareStatement(sql);
			
			pst.setString(1, codigo);
			
			rs = pst.executeUpdate();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error en habilitar curso\n"+e.getMessage());
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
	public int actualizar(Curso c) {
		int rs = 0;
		// Plantilla (Copy/Paste)
				Connection con = null;			// obtener la conexión --> MySQLConexion
				PreparedStatement pst = null;	// preparar las sentencias que vamos a ejecutar
				try {
					con = MySQLConexion.getConexion();
					
					String sql = "update curso set nombreCurso = ?, creditos = ?, ciclo = ?, cantHoras = ?, codEscuela = ?,capacidad = ? where codCurso = ?";
					pst = con.prepareStatement(sql);
					
					pst.setString(1, c.getNombre());
					pst.setInt(2, c.getCreditos());
					pst.setInt(3, c.getCiclo());
					pst.setInt(4, c.getCanthoras());
					pst.setInt(5, c.getCodEscuela());
					pst.setInt(6, c.getCapacidad());
					pst.setString(7,c.getCodigo());
					
					rs = pst.executeUpdate();
					
				} catch (Exception msg) {
					JOptionPane.showMessageDialog(null, "Error en actualizar curso\n"+msg.getMessage());
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
	public Curso buscar(String codigo) {
		Curso c = null;
		// Plantilla de BD (Copy/paste)
		Connection con = null;			// obtener la conexión --> MySQLConexion
		PreparedStatement pst = null;	// preparar las sentencias que vamos a ejecutar
		ResultSet rs = null;	// "almacenar" temporalmente el resultado de la consulta
		try {
			con = MySQLConexion.getConexion();
			
			String sql = "select * from curso where codCurso = ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, codigo);
			
			rs = pst.executeQuery();			
			
			// ---- pasar lo almacenado en el objeto "rs" a la lista			
			if (rs.next()) {
				c = new Curso();
				c.setCodigo(rs.getString(1));
				c.setNombre(rs.getString(2));
				c.setCreditos(rs.getInt(3));
				c.setCiclo(rs.getInt(4));
				c.setCanthoras(rs.getInt(5));
				c.setCodEscuela(rs.getInt(6));
				c.setCapacidad(rs.getInt(7));
				c.setEstado(rs.getInt(8));
			}	
		} catch (Exception msg) {
			JOptionPane.showMessageDialog(null, "Error en buscar curso\n"+msg.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException msg) {
				System.out.println("Error al cerrar!");
			}
		}
		return c;
	}

	@Override
	public ArrayList<Curso> listado() {
		ArrayList<Curso> lista = null;
		// Plantilla de BD (Copy/Paste)
		Connection con = null;			// obtener la conexión --> MySQLConexion
		PreparedStatement pst = null;	// preparar las sentencias que vamos a ejecutar
		ResultSet rs = null;	// "almacenar" temporalmente el resultado de la consulta
		try {
			con = MySQLConexion.getConexion();
			
			String sql = "select * from curso";
			pst = con.prepareStatement(sql);
			
			rs = pst.executeQuery();					
			
			// Crear lista con ArrayList de tipo Usuario
			lista = new ArrayList<Curso>();
			
			// ---- pasar lo almacenado en el objeto "rs" a la lista			
			while (rs.next()) {
				Curso c = new Curso();
				c.setCodigo(rs.getString(1));
				c.setNombre(rs.getString(2));
				c.setCreditos(rs.getInt(3));
				c.setCiclo(rs.getInt(4));
				c.setCanthoras(rs.getInt(5));
				c.setCodEscuela(rs.getInt(6));
				c.setCapacidad(rs.getInt(7));
				c.setEstado(rs.getInt(8));
				lista.add(c);
			}
			
		} catch (Exception msg) {
			JOptionPane.showMessageDialog(null, "Error en listado de cursos\n"+msg.getMessage());
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
	public ArrayList<ListarCursos> lista() {
		ArrayList<ListarCursos> lista = null;
		Connection con = null;			// obtener la conexión --> MySQLConexion
		PreparedStatement pst = null;	// preparar las sentencias que vamos a ejecutar
		ResultSet rs = null;	// "almacenar" temporalmente el resultado de la consulta
		try {
			con = MySQLConexion.getConexion();
			
			String sql = "call usp_listarCursos()";
			pst = con.prepareStatement(sql);
			
			rs = pst.executeQuery();			
			
			// Crear lista con ArrayList de tipo Usuario
			lista = new ArrayList<ListarCursos>();
			
			// ---- pasar lo almacenado en el objeto "rs" a la lista			
			while (rs.next()) {
				ListarCursos lc = new ListarCursos();
				lc.setCodCurso(rs.getString(1));
				lc.setNombreCurso(rs.getString(2));
				lc.setCreditos(rs.getInt(3));
				lc.setCiclo(rs.getInt(4));
				lc.setCantHoras(rs.getInt(5));
				lc.setNomreEscuela(rs.getNString(6));
				lc.setCapacidad(rs.getInt(7));
				lista.add(lc);
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error en listado de cursos\n"+e.getMessage());
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
	public ArrayList<CursoProfesor> listar() {
		ArrayList<CursoProfesor> listar = null;
		Connection con = null;			// obtener la conexión --> MySQLConexion
		PreparedStatement pst = null;	// preparar las sentencias que vamos a ejecutar
		ResultSet rs = null;	// "almacenar" temporalmente el resultado de la consulta
		try {
			con = MySQLConexion.getConexion();
			
			String sql = "call usp_curso_profesor()";
			pst = con.prepareStatement(sql);
			
			rs = pst.executeQuery();			
			
			// Crear lista con ArrayList de tipo Usuario
			listar = new ArrayList<CursoProfesor>();
			
			// ---- pasar lo almacenado en el objeto "rs" a la lista			
			while (rs.next()) {
				CursoProfesor cp = new CursoProfesor();
				cp.setCodCurso(rs.getString(1));
				cp.setNomCurso(rs.getString(2));
				cp.setCapacidadCurso(rs.getInt(3));
				cp.setProfesor(rs.getString(4));
				cp.setCodProf(rs.getString(5));
				cp.setNomEscuela(rs.getString(6));
				cp.setPrecioEscuela(rs.getDouble(7));
				listar.add(cp);
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error en listado de cursos, profesor y escuela\n"+e.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar!");
			}
		}
		return listar;
	}

}
