package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import mantenimientos.GestionCurso;
import model.Curso;
import model.CursoProfesor;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class DlgCurso extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	DefaultTableModel modelo = new DefaultTableModel() {
		// para que no se pueda editar la tabla de resultado
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	private JTable tblS;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgCurso dialog = new DlgCurso();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgCurso() {
		setBounds(100, 100, 815, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 11, 779, 206);
			contentPanel.add(scrollPane);
			{
				tblS = new JTable();
				tblS.setModel(modelo);
				modelo.addColumn("CODCURSO");
				modelo.addColumn("NOMCURSO");
				modelo.addColumn("CAPACIDAD");
				modelo.addColumn("PROFESOR");
				modelo.addColumn("CODPROFE");
				modelo.addColumn("NOMESCUELA");
				modelo.addColumn("PRECIO");
				scrollPane.setViewportView(tblS);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						enviarDatos();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		llenaTabla();
	}
	
	void enviarDatos() {
		// obtener la fila seleccionada
		int fila = tblS.getSelectedRow();
		
		// validar si ha seleccionado una fila
		if (fila == -1) {
			JOptionPane.showMessageDialog(this, "Debe seleccionar un cliente");
			return;
		}
		//System.out.println("Código: "+tblSalida.getValueAt(fila, 0));
		//System.out.println("Nombre: "+tblSalida.getValueAt(fila, 1));
		
		// Enviar los datos de la tabla a los campos del FrmBoleta
		FrmMatricula.txtCodigoCurso.setText(tblS.getValueAt(fila, 0).toString());
		FrmMatricula.txtNombreCurso.setText(tblS.getValueAt(fila, 1).toString());
		FrmMatricula.txtCapacidadCurso.setText(tblS.getValueAt(fila, 2).toString());
		FrmMatricula.txtNombreProfesor.setText(tblS.getValueAt(fila, 3).toString());
		FrmMatricula.txtCodigoProfesor.setText(tblS.getValueAt(fila, 4).toString());
		FrmMatricula.txtNombreEscuela.setText(tblS.getValueAt(fila, 5).toString());
		FrmMatricula.txtPrecioEscuela.setText(tblS.getValueAt(fila, 6).toString());
		dispose();
	}
	
	void llenaTabla() {
		// 1. obtener el listado de los usuarios tipo cliente -> Gestion
		GestionCurso gc = new GestionCurso();
		ArrayList<CursoProfesor> lista = gc.listar();
		
		// 2. pasar el listado a la tabla
		for (CursoProfesor cp : lista) {
			Object datos[] = {cp.getCodCurso(),cp.getNomCurso(),cp.getCapacidadCurso(),cp.getProfesor(),cp.getCodProf(),cp.getNomEscuela(),cp.getPrecioEscuela()};
			modelo.addRow(datos);
		}
	}
}
