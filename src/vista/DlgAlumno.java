package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import mantenimientos.GestionAlumno;
import model.Alumno;
import model.NombreAlumno;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class DlgAlumno extends JDialog {

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
			DlgAlumno dialog = new DlgAlumno();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgAlumno() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 206);
		contentPanel.add(scrollPane);
		
		tblS = new JTable();
		tblS.setModel(modelo);
		modelo.addColumn("CODIGO");
		modelo.addColumn("ALUMNO");
		modelo.addColumn("DNI");
		scrollPane.setViewportView(tblS);
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
	
	void llenaTabla() {
		GestionAlumno ga = new GestionAlumno();
		ArrayList<Alumno> lista = ga.listado();
		
		for (Alumno a : lista) {
			if (a.getEstadoAlumno() != 3) {
				Object datos[] = {a.getCodigo(),a.getNombre()+" "+a.getApellido(),a.getDni()};
				modelo.addRow(datos);
			}			
		}
	}
	
	void enviarDatos() {
		int fila = tblS.getSelectedRow();
		if (fila == -1) {
			JOptionPane.showMessageDialog(tblS, "Debe seleccionar un alumno");
			return;
		}		
		FrmMatricula.txtCodigoAlumno.setText(tblS.getValueAt(fila, 0).toString());
		FrmMatricula.txtNombreAlumno.setText(tblS.getValueAt(fila, 1).toString());
		FrmMatricula.txtDniAlumno.setText(tblS.getValueAt(fila, 2).toString());
		dispose();
	}
}
