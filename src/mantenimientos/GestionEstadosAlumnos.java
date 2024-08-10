package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import interfaces.EstadosInterface;
import model.EstadosAlumnosTabla;
import utils.MySQLConexion;

public class GestionEstadosAlumnos implements EstadosInterface{

	@Override
	public ArrayList<EstadosAlumnosTabla> lista() {
		ArrayList<EstadosAlumnosTabla> lista = null;
		Connection con = null;			// obtener la conexi�n --> MySQLConexion
		PreparedStatement pst = null;	// preparar las sentencias que vamos a ejecutar
		ResultSet rs = null;	// "almacenar" temporalmente el resultado de la consulta
		try {
			con = MySQLConexion.getConexion();
			
			String sql = "select * from estados_alumnos";
			pst = con.prepareStatement(sql);
			
			rs = pst.executeQuery();			
			
			// Crear lista con ArrayList de tipo Usuario
			lista = new ArrayList<EstadosAlumnosTabla>();
			
			// ---- pasar lo almacenado en el objeto "rs" a la lista			
			while (rs.next()) {
				EstadosAlumnosTabla ea = new EstadosAlumnosTabla();
				ea.setCod(rs.getInt(1));
				ea.setDescripcion(rs.getString(2));
				lista.add(ea);
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error en listado de estados\n"+e.getMessage());
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
