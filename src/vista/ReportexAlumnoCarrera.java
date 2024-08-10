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
import model.AlumnoCarrera;
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

public class ReportexAlumnoCarrera extends JInternalFrame {
	private final JLabel lblNewLabel_1 = new JLabel("Carreras:");
	private JTextArea txtSalida;
	private JComboBox cboCarrera;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReportexAlumnoCarrera frame = new ReportexAlumnoCarrera();
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
	public ReportexAlumnoCarrera() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 494, 400);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Reporte por Carrera:");
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
		
		cboCarrera = new JComboBox();
		cboCarrera.setModel(new DefaultComboBoxModel(new String[] {"Computacion e Informatica", "Traduccion e Interpretacion", "Medicina Veterinaria"}));
		cboCarrera.setBounds(98, 57, 191, 22);
		contentPane.add(cboCarrera);
	}
	
	void listado() {
		
		String carrera = leerCarrera();
		GestionAlumno ga = new GestionAlumno();
		ArrayList<AlumnoCarrera> lista = ga.listadoxCarrera(carrera);
		
		txtSalida.setText("Reporte por Carrera:\n");
		txtSalida.append("Codigo\tDNI\tNombre y Apellidos\tEscuela\tCarrera\n");
		for(AlumnoCarrera ac: lista) {
			txtSalida.append(ac.getCodalumno()+ "\t"+ac.getDnialumno()+"\t"+ac.getNoncompleto()+"\t"+ac.getEscuela()+"\t"+ac.getCarrera()+"\n");
		}
		
	}
	
	
	
 AlumnoCarrera ac = new AlumnoCarrera();
	
	void imprimirPDF() {
		
		String carrera = leerCarrera();
		
		GestionAlumno ga = new GestionAlumno();
		ArrayList<AlumnoCarrera> lista = ga.listadoxCarrera(carrera);		
			String nomarchivo = "reportes/"+ ac.getCodalumno()+ ".pdf";
		
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
				PdfPTable tabla = new PdfPTable(5);	// 5 columnas para la tabla
				for (AlumnoCarrera ac: lista) {
					tabla.addCell(ac.getCodalumno());
					tabla.addCell(ac.getDnialumno());
					tabla.addCell(ac.getNoncompleto());
					tabla.addCell(ac.getEscuela());
					tabla.addCell(ac.getCarrera());
				}
				doc.add(tabla);

				
				doc.close();
				// para visualizar
				Desktop.getDesktop().open(new File(nomarchivo));
				
			} catch (Exception e) {
				alerta(e.getMessage());
			}
			
		
	}
	
	String leerCarrera() {
		return cboCarrera.getSelectedItem().toString();
	}	
	
	void alerta(String msg) {
		JOptionPane.showMessageDialog(this, msg);
	}	
}

