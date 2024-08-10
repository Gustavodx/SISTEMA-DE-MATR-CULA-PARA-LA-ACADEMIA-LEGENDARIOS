package vista;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mantenimientos.GestionAlumno;
import mantenimientos.GestionCurso;
import model.Alumno;
import model.DetalleMatricula;

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

public class ReportexFchaIngreso extends JInternalFrame {
	private final JLabel lblNewLabel_1 = new JLabel("Fecha Inicial:");
	private JTextArea txtSalida;
	private JDateChooser txtFecha;
	private JDateChooser txtFechaFinal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReportexFchaIngreso frame = new ReportexFchaIngreso();
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
	public ReportexFchaIngreso() {
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
		
		txtFecha = new JDateChooser();
		txtFecha.setBounds(112, 57, 104, 20);
		contentPane.add(txtFecha);
		
		txtFechaFinal = new JDateChooser();
		txtFechaFinal.setBounds(339, 57, 104, 20);
		contentPane.add(txtFechaFinal);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(20, 57, 104, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Fecha Final:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(244, 54, 104, 23);
		contentPane.add(lblNewLabel_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 106, 458, 210);
		contentPane.add(scrollPane);
		
		txtSalida = new JTextArea();
		txtSalida.setEditable(false);
		scrollPane.setViewportView(txtSalida);
	}
	
	void listado() {
		
		String fecha1 = leerFecha();
		String fecha2 = leerFecha2();
				
		GestionAlumno ga = new GestionAlumno();
		ArrayList<Alumno> lista = ga.listadoxFecha(fecha1, fecha2);
		
		txtSalida.setText("Reporte por Fecha de Ingreso:\n");
		
		txtSalida.append("Codigo\tNombre\tApellido\t\tFecha Ingreso\n");
		for(Alumno a: lista) {
			txtSalida.append(a.getCodigo()+ "\t"+a.getNombre()+"\t"+a.getApellido()+"\t"+a.getFecha()+"\n");
		}
		
	}
	
	String leerFecha() {
		// JCalendar != JTextField	//	Date o Calendar
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		
		Date fecha = txtFecha.getDate();
		Date fecha_actual = new Date();
		if (fecha == null) {
			alerta("Seleccione una fecha");
			return null;
		}
		if (fecha.after(fecha_actual)) {
			alerta("Solo puede escoger una fecha anterior a la actual");
			return null;
		}
		try {
			return sdf.format(txtFecha.getDate());
		} catch (NumberFormatException e) {
			alerta("Error\n"+e.getMessage());
			return null;
		}
	}	
	
	String leerFecha2() {
		// JCalendar != JTextField	//	Date o Calendar
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		
		Date fecha = txtFechaFinal.getDate();
		Date fecha_actual = new Date();
		if (fecha == null) {
			alerta("Seleccione una fecha");
			return null;
		}
		if (fecha.after(fecha_actual)) {
			alerta("Solo puede escoger una fecha anterior a la actual");
			return null;
		}
		try {
			return sdf.format(txtFechaFinal.getDate());
		} catch (NumberFormatException e) {
			alerta("Error\n"+e.getMessage());
			return null;
		}
	}
	
	Alumno a = new Alumno();
	
	void imprimirPDF() {
		
		String fecha1 = leerFecha();
		String fecha2 = leerFecha2();
		GestionAlumno ga = new GestionAlumno();
		ArrayList<Alumno> lista = ga.listadoxFecha(fecha1, fecha2);			
		String nomarchivo = "reportes/Lista de Alumnos.pdf";
	
		try {
			Document doc = new Document();	// agregar los elementos a imprimir
			FileOutputStream fos = new FileOutputStream(nomarchivo);	// crea el archivo
			PdfWriter pdfw = PdfWriter.getInstance(doc, fos);
			
			doc.open();	// abre para empezar a "imprimir"
			
			doc.add(new Paragraph("Listado por Fecha de Ingreso Alumnos: "));
			doc.add(new Paragraph(" "));	// espacio
			doc.add(new Paragraph("Desde " +leerFecha()+" hasta "+leerFecha2()));
			doc.add(new Paragraph(" "));
			doc.add(new Paragraph(" "));
			doc.add(new Paragraph(" "));
			/*doc.add(new Paragraph("Fecha...........: "+m.getFecha()));
			doc.add(new Paragraph("Alumno..........: "+new GestionAlumno().buscar(m.getCodAlu()).getNombre()+" "+new GestionAlumno().buscar(m.getCodAlu()).getApellido()));
			doc.add(new Paragraph("-----------------------------------------------------------------------------------------------------------------------------------"));
			*/
			// tabla con el detalle de la compra
			PdfPTable tabla = new PdfPTable(4);	// 5 columnas para la tabla
			for (Alumno a: lista) {
				tabla.addCell(a.getCodigo());
				tabla.addCell(a.getNombre());
				tabla.addCell(a.getApellido());
				tabla.addCell(a.getFecha());
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

