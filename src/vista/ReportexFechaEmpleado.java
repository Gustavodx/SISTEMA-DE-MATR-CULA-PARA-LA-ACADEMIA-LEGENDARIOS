package vista;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mantenimientos.GestionAlumno;
import mantenimientos.GestionEmpleado;
import model.Alumno;
import model.Empleado;

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
import javax.swing.JTable;

public class ReportexFechaEmpleado extends JInternalFrame {
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
					ReportexFechaEmpleado frame = new ReportexFechaEmpleado();
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
	public ReportexFechaEmpleado() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 494, 400);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Reporte por Ingreso de Empleados:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setBounds(10, 0, 369, 46);
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 106, 458, 210);
		contentPane.add(scrollPane);
		
		txtSalida = new JTextArea();
		txtSalida.setEditable(false);
		scrollPane.setViewportView(txtSalida);
		
		txtFecha = new JDateChooser();
		txtFecha.setBounds(108, 57, 99, 20);
		contentPane.add(txtFecha);
		
		txtFechaFinal = new JDateChooser();
		txtFechaFinal.setBounds(313, 57, 99, 20);
		contentPane.add(txtFechaFinal);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha Inicial: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(20, 63, 89, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Fecha Final: ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(228, 64, 89, 14);
		contentPane.add(lblNewLabel_1_1);
	}
	
	void listado() {
		
		String fecha1 = leerFecha();
		String fecha2 = leerFecha2();
		
		GestionEmpleado ge = new GestionEmpleado();
		ArrayList<Empleado> lista = ge.listadoxFecha(fecha1, fecha2);
				/*
		GestionAlumno ga = new GestionAlumno();
		ArrayList<Alumno> lista = ga.listadoxFecha(fecha1, fecha2);
		*/
		txtSalida.setText("Reporte por Fecha de Empleados:\n");
		
		txtSalida.append("Codigo\tNombre\tApellido\t\tFecha Ingreso\n");
		for(Empleado e: lista) {
			txtSalida.append(e.getCodigo()+ "\t"+e.getNombre()+"\t"+e.getApellido()+"\t"+e.getFecha()+"\n");
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
	void alerta(String msg) {
		JOptionPane.showMessageDialog(this, msg);
	}
	
	Empleado e = new Empleado();
	
void imprimirPDF() {
		
				String fecha1 = leerFecha();
				String fecha2 = leerFecha2();
		GestionEmpleado ge = new GestionEmpleado();
		ArrayList<Empleado> lista = ge.listadoxFecha(fecha1, fecha2);		
		String nomarchivo = "reportes/Lista de Empleados.pdf";
	
		try {
			Document doc = new Document();	// agregar los elementos a imprimir
			FileOutputStream fos = new FileOutputStream(nomarchivo);	// crea el archivo
			PdfWriter pdfw = PdfWriter.getInstance(doc, fos);
			
			doc.open();	// abre para empezar a "imprimir"
			
			doc.add(new Paragraph("Listado por Ingreso de Empleados: "));
			doc.add(new Paragraph(" "));	// espacio
			doc.add(new Paragraph("Desde " +leerFecha()+" hasta "+leerFecha2()));
			doc.add(new Paragraph(" "));
			doc.add(new Paragraph(" "));
	
			// tabla con el detalle de la compra
			PdfPTable tabla = new PdfPTable(4);	// 5 columnas para la tabla
			for (Empleado e: lista) {
				tabla.addCell(e.getCodigo());
				tabla.addCell(e.getNombre());
				tabla.addCell(e.getApellido());
				tabla.addCell(e.getFecha());
			}
			doc.add(tabla);			
			doc.close();
			// para visualizar
			Desktop.getDesktop().open(new File(nomarchivo));
			
		} catch (Exception e) {
			alerta(e.getMessage());
		}
		
	}
	
}

