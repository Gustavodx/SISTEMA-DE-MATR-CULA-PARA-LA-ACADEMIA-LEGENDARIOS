package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import interfaces.EscuelaInterface;
import model.Escuela;
import utils.MySQLConexion;

public class GestionEscuela implements EscuelaInterface{

	@Override
	public ArrayList<Escuela> listado() {
		ArrayList<Escuela> lista = null;
		// Plantilla de BD (Copy/Paste)
		Connection con = null;			// obtener la conexión --> MySQLConexion
		PreparedStatement pst = null;	// preparar las sentencias que vamos a ejecutar
		ResultSet rs = null;	// "almacenar" temporalmente el resultado de la consulta
		try {
			con = MySQLConexion.getConexion();
			
			String sql = "select * from escuela";
			pst = con.prepareStatement(sql);
			
			rs = pst.executeQuery();			
			
			// Crear lista con ArrayList de tipo Usuario
			lista = new ArrayList<Escuela>();
			
			// ---- pasar lo almacenado en el objeto "rs" a la lista			
			while (rs.next()) {
				Escuela e = new Escuela();
				e.setCodEscuela(rs.getInt(1));
				e.setNomEscuela(rs.getString(2));
				e.setPrecioEscuela(rs.getDouble(3));
				lista.add(e);
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error en listado de escuelas\n"+e.getMessage());
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
	public Escuela buscar(int codigo) {
		Escuela e = null;
		Connection con = null;			// obtener la conexión --> MySQLConexion
		PreparedStatement pst = null;	// preparar las sentencias que vamos a ejecutar
		ResultSet rs = null;	// "almacenar" temporalmente el resultado de la consulta
		try {
			con = MySQLConexion.getConexion();
			
			String sql = "select * from escuela where codEscuela = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, codigo);
			
			rs = pst.executeQuery();			
			
			// ---- pasar lo almacenado en el objeto "rs" a la lista			
			if (rs.next()) {
				e = new Escuela();
				e.setCodEscuela(rs.getInt(1));
				e.setNomEscuela(rs.getString(2));
				e.setPrecioEscuela(rs.getDouble(3));
			}	
		} catch (Exception msg) {
			JOptionPane.showMessageDialog(null, "Error en buscar escuela\n"+msg.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException msg) {
				System.out.println("Error al cerrar!");
			}
		}
		return e;
	}
	
}
