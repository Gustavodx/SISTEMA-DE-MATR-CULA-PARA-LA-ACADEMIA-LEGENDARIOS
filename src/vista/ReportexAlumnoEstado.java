package vista;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mantenimientos.GestionAlumno;
import model.Alumno;
import model.AlumnoEstado;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ReportexAlumnoEstado extends JInternalFrame {
	private final JLabel lblNewLabel_1 = new JLabel("Fecha Inicial:");
	private JTextArea txtSalida;
	private JComboBox cboEstado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReportexAlumnoEstado frame = new ReportexAlumnoEstado();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ReportexAlumnoEstado() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 494, 400);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Reporte por Fecha de Ingreso:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setBounds(10, 0, 279, 46);
		contentPane.add(lblNewLabel);
		
		JButton btnReporte = new JButton("Reporte");
		btnReporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listado();
				imprimirPDF();
			}
		});
		btnReporte.setBounds(200, 327, 89, 23);
		contentPane.add(btnReporte);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(20, 57, 104, 23);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 106, 458, 210);
		contentPane.add(scrollPane);
		
		txtSalida = new JTextArea();
		scrollPane.setViewportView(txtSalida);
		
		cboEstado = new JComboBox();
		cboEstado.setModel(new DefaultComboBoxModel(new String[] {"Registrado", "Matriculado", "Retirado"}));
		cboEstado.setToolTipText("Registrado\r\nMatriculado\r\nRetirado");
		cboEstado.setBounds(120, 57, 111, 22);
		contentPane.add(cboEstado);
	}
	
	void listado() {
		
		String estado = leerEstado();
		
		GestionAlumno ga = new GestionAlumno();
		ArrayList<AlumnoEstado> lista = ga.listadoxEstado(estado);
		
		txtSalida.setText("Reporte por Estado de Alumno:\n");
		
		txtSalida.append("Codigo\tNombre y Apellidos\t\tCarrera\tDescripción\n");
		for(AlumnoEstado ae: lista) {
			txtSalida.append(ae.getCodalum()+ "\t"+ae.getNomcompleto()+"\t"+ae.getCarrera()+"\t"+ae.getDescripcion()+"\n");
		}
		
	}
	
	String leerEstado() {
		return cboEstado.getSelectedItem().toString();
	}	
	
	
	AlumnoEstado ae = new AlumnoEstado();
	
	
void imprimirPDF() {
		
	String estado = leerEstado();
	
	GestionAlumno ga = new GestionAlumno();
	ArrayList<AlumnoEstado> lista = ga.listadoxEstado(estado);		
		String nomarchivo = "reportes/"+ ae.getCodalum()+ ".pdf";
	
		try {
			Document doc = new Document();	// agregar los elementos a imprimir
			FileOutputStream fos = new FileOutputStream(nomarchivo);	// crea el archivo
			PdfWriter pdfw = PdfWriter.getInstance(doc, fos);
			
			doc.open();	// abre para empezar a "imprimir"
			
			doc.add(new Paragraph("Boleta de Listado por Estado de Alumno: "));
			doc.add(new Paragraph(" "));	// espacio
			doc.add(new Paragraph(" "));
			doc.add(new Paragraph(" "));
		
			// tabla con el detalle de la compra
			PdfPTable tabla = new PdfPTable(4);	// 5 columnas para la tabla
			for (AlumnoEstado ae: lista) {
				tabla.addCell(ae.getCodalum());
				tabla.addCell(ae.getNomcompleto());
				tabla.addCell(ae.getCarrera());
				tabla.addCell(ae.getDescripcion());
			}
			doc.add(tabla);

			
			doc.close();
			// para visualizar
			Desktop.getDesktop().open(new File(nomarchivo));
			
		} catch (Exception e) {
			alerta(e.getMessage());
		}
		
	}
	

	void alerta(String msg) {
		JOptionPane.showMessageDialog(this, msg);
	}	
}

