package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import interfaces.MatriculaInterface;
import model.DetalleMatricula;
import model.ListaMatriculaBoleta;
import model.Matricula;
import utils.MySQLConexion;

public class GestionMatricula implements MatriculaInterface{

	@Override
	public String generaNumMatricula() {
		String codigo = "M0001";	// codigo por default, si no hay datos
		// Plantilla de búsqueda (Copy/Paste)
		Connection con = null;			// obtener la conexión --> MySQLConexion
		PreparedStatement pst = null;	// preparar las sentencias que vamos a ejecutar
		ResultSet rs = null;	// "almacenar" temporalmente el resultado de la consulta
		try {
			con = MySQLConexion.getConexion();
			// extrae la parte numerica del ultimo codigo de la tabla
			String sql = "select substring(max(codMatricula),2) from matricula";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			
			if (rs.next()) {
			// genera el codigo, incrementando su valor, completado con 0
				codigo = String.format("M%04d", rs.getInt(1) + 1);
			}	
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error en generar codigo de matricula\n"+e.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar!");
			}
		}
		return codigo;
	}

	@Override
	public int realizarMatricula(Matricula m, ArrayList<DetalleMatricula> detalles) {
		int rs = 0;
		// Plantilla registro (Copy/Paste)
		Connection con = null; // obtener la conexiÃ³n --> MySQLConexion
		PreparedStatement pst1 = null; // para registro de cabecera
		PreparedStatement pst2 = null; // para registro de detalles
		PreparedStatement pst3 = null; // para actualizar productos
		PreparedStatement pst4 = null;
		
		try {
			con = MySQLConexion.getConexion();
			// desactivar la confirmacion automatica
			con.setAutoCommit(false);
			
			String sql1 = "insert into matricula values (?,?,?,?,?)";
			pst1 = con.prepareStatement(sql1);
			// parametros
			pst1.setString(1, m.getCodMatri());
			pst1.setString(2, m.getFecha());
			pst1.setString(3, m.getCodAlu());
			pst1.setString(4, m.getCodEmp());
			pst1.setDouble(5, m.getTotalPago());
			rs = pst1.executeUpdate();
			
			String sql2 = "insert into detalleMatricula values(?,?,?,default,?)";
			String sql3 = "update curso set capacidad = capacidad - ? where codCurso = ?";
			String sql4 = "update alumno set estadoAlumno = 2 where codAlumno = ?";
			// recorre el detalle de la boleta
			for (DetalleMatricula dm : detalles) {
				// prepara los datos del detalle a registrar
				pst2 = con.prepareStatement(sql2);
				pst2.setString(1, m.getCodMatri());
				pst2.setString(2, dm.getCodProf());
				pst2.setString(3, dm.getCodCurso());
				//pst2.setInt(4, dm.getVacante());
				pst2.setDouble(4, dm.getImporte());
				rs += pst2.executeUpdate();
				// prepara los datos del producto a actualizar
				pst3 = con.prepareStatement(sql3);
				pst3.setInt(1, dm.getVacante());
				pst3.setString(2, dm.getCodCurso());
				rs += pst3.executeUpdate();
				pst4 = con.prepareStatement(sql4);
				pst4.setString(1, m.getCodAlu());
				rs += pst4.executeUpdate();
			}
			// confirmar las transacciones, si no hay problemas
			con.commit();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error en realizar Matricula\n" + e.getMessage());
			rs = 0; // reinicia el valor por default de control
			try {
				con.rollback();
			} catch (SQLException e1) {
				System.out.println("Error al deshacer : " + e1.getMessage());
			}
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Error al cerrar : " + e.getMessage());
			}
		}
		return rs;
	}

	@Override
	public ArrayList<Matricula> matriculasxFecha(String fecha) {
		ArrayList<Matricula> lista = null;
		Connection con = null;			// obtener la conexión --> MySQLConexion
		PreparedStatement pst = null;	// preparar las sentencias que vamos a ejecutar
		ResultSet rs = null;	// "almacenar" temporalmente el resultado de la consulta
		try {
			con = MySQLConexion.getConexion();
			
			String sql = "select * from matricula where fechaMatricula = ?";
			pst = con.prepareStatement(sql);
			
			pst.setString(1, fecha);
			
			rs = pst.executeQuery();			
			
			// Crear lista con ArrayList de tipo Usuario
			lista = new ArrayList<Matricula>();
			
			// ---- pasar lo almacenado en el objeto "rs" a la lista			
			while (rs.next()) {
				Matricula m = new Matricula();
				m.setCodMatri(rs.getString(1));
				m.setFecha(rs.getString(2));
				m.setCodAlu(rs.getString(3));
				m.setCodEmp(rs.getString(4));
				m.setTotalPago(rs.getDouble(5));
				lista.add(m);
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error en listado de Matriculas por Fecha\n"+e.getMessage());
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
	public ArrayList<DetalleMatricula> detallexNumMatricula(String codMatri) {
		ArrayList<DetalleMatricula> lista = null;
		Connection con = null;			// obtener la conexión --> MySQLConexion
		PreparedStatement pst = null;	// preparar las sentencias que vamos a ejecutar
		ResultSet rs = null;	// "almacenar" temporalmente el resultado de la consulta
		try {
			con = MySQLConexion.getConexion();
			
			String sql = "select * from detalleMatricula where codMatricula = ?";
			pst = con.prepareStatement(sql);
			
			pst.setString(1, codMatri);
			
			rs = pst.executeQuery();			
			
			// Crear lista con ArrayList de tipo Usuario
			lista = new ArrayList<DetalleMatricula>();
			
			// ---- pasar lo almacenado en el objeto "rs" a la lista			
			while (rs.next()) {
				DetalleMatricula dm = new DetalleMatricula();
				//dm.setCodMatri(rs.getString(1));
				dm.setCodProf(rs.getString(2));
				dm.setCodCurso(rs.getString(3));
				dm.setVacante(rs.getInt(4));
				dm.setImporte(rs.getDouble(5));
				lista.add(dm);
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error en listado de Detalle de Matricula por Codigo de Matricula\n"+e.getMessage());
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
	public ArrayList<Matricula> listadomatriculasxfechas(String fi, String ff) {
		ArrayList<Matricula> lista = null;
		Connection con = null;			// obtener la conexión --> MySQLConexion
		PreparedStatement pst = null;	// preparar las sentencias que vamos a ejecutar
		ResultSet rs = null;	// "almacenar" temporalmente el resultado de la consulta
		try {
			con = MySQLConexion.getConexion();
			
			String sql = "call usp_listadoMatriculasxFecha(?,?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, fi);
			pst.setString(2, ff);
			
			rs = pst.executeQuery();			
			
			// Crear lista con ArrayList de tipo UsuarioTipo
			lista = new ArrayList<Matricula>();
			
			// ---- pasar lo almacenado en el objeto "rs" a la lista			
			while (rs.next()) {
				Matricula c = new Matricula();
				c.setCodMatri(rs.getString(1));
				c.setFecha(rs.getString(2));
				c.setCodAlu(rs.getString(3));
				c.setCodEmp(rs.getString(4));
				c.setTotalPago(rs.getDouble(5));
				lista.add(c);
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error en listado de Matriculas por Fechas\n"+e.getMessage());
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
	public ArrayList<ListaMatriculaBoleta> listarDatosBoleta() {
		ArrayList<ListaMatriculaBoleta> lista = null;
		Connection con = null;			// obtener la conexión --> MySQLConexion
		PreparedStatement pst = null;	// preparar las sentencias que vamos a ejecutar
		ResultSet rs = null;	// "almacenar" temporalmente el resultado de la consulta
		try {
			con = MySQLConexion.getConexion();
			
			String sql = "call lista_matricula_boleta()";
			pst = con.prepareStatement(sql);
			
			rs = pst.executeQuery();			
			
			// Crear lista con ArrayList de tipo Usuario
			lista = new ArrayList<ListaMatriculaBoleta>();
			
			// ---- pasar lo almacenado en el objeto "rs" a la lista			
			while (rs.next()) {
				ListaMatriculaBoleta b = new ListaMatriculaBoleta();
				b.setCodCurso(rs.getString(1));
				b.setNomCurso(rs.getString(2));
				b.setPrecio(rs.getDouble(3));
				b.setImporteTotal(rs.getDouble(4));
				lista.add(b);
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error en listado datos de boleta matrícula\n"+e.getMessage());
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
