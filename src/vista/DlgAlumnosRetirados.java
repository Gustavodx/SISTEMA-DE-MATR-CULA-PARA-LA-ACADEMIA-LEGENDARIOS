package vista;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import mantenimientos.GestionAlumno;
import mantenimientos.GestionEstadosAlumnos;
import model.Empleado;
import model.EstadosAlumnos;
import model.EstadosAlumnosTabla;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.awt.event.ActionEvent;

public class DlgAlumnosRetirados extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JComboBox cboEstados;
	private JButton btnListar;
	
	DefaultTableModel modelo = new DefaultTableModel();
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnImprimir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgAlumnosRetirados dialog = new DlgAlumnosRetirados();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgAlumnosRetirados() {
		setBounds(100, 100, 928, 403);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Estado de Alumnos:");
		lblNewLabel.setBounds(25, 33, 114, 14);
		contentPanel.add(lblNewLabel);
		
		cboEstados = new JComboBox();
		cboEstados.setBounds(149, 29, 137, 22);
		contentPanel.add(cboEstados);
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				procesar();
			}
		});
		btnListar.setBounds(306, 29, 105, 23);
		contentPanel.add(btnListar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 109, 892, 244);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		table.setModel(modelo);
		modelo.addColumn("CODIGO");
		modelo.addColumn("DNI");
		modelo.addColumn("ALUMNO");
		modelo.addColumn("FECHA");
		modelo.addColumn("ESCUELA");
		modelo.addColumn("CARRERA");
		modelo.addColumn("TELEFONO");
		modelo.addColumn("DIRECCION");
		modelo.addColumn("DESCRIPCION");
		table.getColumnModel().getColumn(0).setPreferredWidth(15);
		table.getColumnModel().getColumn(1).setPreferredWidth(10);
		table.getColumnModel().getColumn(3).setPreferredWidth(20);
		table.getColumnModel().getColumn(4).setPreferredWidth(35);
		table.getColumnModel().getColumn(6).setPreferredWidth(25);
		table.getColumnModel().getColumn(8).setPreferredWidth(45);
		table.getColumnModel().getColumn(5).setPreferredWidth(110);
		table.getColumnModel().getColumn(2).setPreferredWidth(105);
		scrollPane.setViewportView(table);
		
		btnImprimir = new JButton("Imprimir");
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imprimir();
			}
		});
		btnImprimir.setBounds(306, 63, 105, 23);
		contentPanel.add(btnImprimir);
		
		llenaCombo();
	}
	
	void procesar() {
		int opcion = cboEstados.getSelectedIndex();
		if (opcion == 0) {
			alerta("Seleccione Estado");
		}
		if (opcion == 1) {
			GestionAlumno ga = new GestionAlumno();
			ArrayList<EstadosAlumnos> lista = ga.listadoRegistrados();
			if (lista==null) {
				alerta("Lista de alumnos registrados vacia");
				return;
			} else {
				modelo.setRowCount(0);
				for (EstadosAlumnos e : lista) {
					Object datos[] = {e.getCodAlumno(),e.getDniALumno(),e.getNomAlumno(),e.getFechIngreso(),e.getNomEscuela(),
									e.getCarrera(),e.getFonoAlumno(),e.getDirecAlumno(),e.getDescripcion()};
					modelo.addRow(datos);
				}
			}
		}
		if (opcion == 2) {
			GestionAlumno ga = new GestionAlumno();
			ArrayList<EstadosAlumnos> lista = ga.listadoMatriculados();
			if (lista==null) {
				alerta("Lista de alumnos matriculados vacia");
				return;
			} else {
				modelo.setRowCount(0);
				for (EstadosAlumnos e : lista) {
					Object datos[] = {e.getCodAlumno(),e.getDniALumno(),e.getNomAlumno(),e.getFechIngreso(),e.getNomEscuela(),
									e.getCarrera(),e.getFonoAlumno(),e.getDirecAlumno(),e.getDescripcion()};
					modelo.addRow(datos);
				}
			}
		}
		if (opcion == 3) {
			GestionAlumno ga = new GestionAlumno();
			ArrayList<EstadosAlumnos> lista = ga.listaRetirados();
			if (lista==null) {
				alerta("Lista de alumnos retirados vacia");
				return;
			} else {
				modelo.setRowCount(0);
				for (EstadosAlumnos e : lista) {
					Object datos[] = {e.getCodAlumno(),e.getDniALumno(),e.getNomAlumno(),e.getFechIngreso(),e.getNomEscuela(),
									e.getCarrera(),e.getFonoAlumno(),e.getDirecAlumno(),e.getDescripcion()};
					modelo.addRow(datos);
				}
			}
		}
	}
	
	void imprimir() {
		int opcion = cboEstados.getSelectedIndex();
		if (opcion == 0) {
			alerta("Seleccione Estado");
		}
		if(opcion == 1) {
			GestionAlumno ga = new GestionAlumno();
			ArrayList<EstadosAlumnos> lista = ga.listadoRegistrados();
			String nomarchivo = "reportes/Lista de Alumnos Registrados.pdf";
			try {
				Document doc = new Document();	// agregar los elementos a imprimir
				FileOutputStream fos = new FileOutputStream(nomarchivo);	// crea el archivo
				PdfWriter pdfw = PdfWriter.getInstance(doc, fos);				
				doc.open();	// abre para empezar a "imprimir"				
				doc.add(new Paragraph("Listado de Alumnos Registrados: "));
				doc.add(new Paragraph(" "));		
				// tabla con el detalle de la compra
				PdfPTable tabla = new PdfPTable(5);	// columnas para la tabla
				for (EstadosAlumnos e: lista) {
					tabla.addCell(e.getCodAlumno());
					tabla.addCell(e.getNomAlumno());					
					tabla.addCell(e.getDirecAlumno());
					tabla.addCell(e.getCarrera());
					tabla.addCell(e.getFechIngreso());
				}
				doc.add(tabla);			
				doc.close();
				// para visualizar
				Desktop.getDesktop().open(new File(nomarchivo));				
			} catch (Exception e) {
				alerta(e.getMessage());
			}
		}
		if(opcion == 2) {
			GestionAlumno ga = new GestionAlumno();
			ArrayList<EstadosAlumnos> lista = ga.listadoMatriculados();
			String nomarchivo = "reportes/Lista de Alumnos Matriculados.pdf";
			try {
				Document doc = new Document();	// agregar los elementos a imprimir
				FileOutputStream fos = new FileOutputStream(nomarchivo);	// crea el archivo
				PdfWriter pdfw = PdfWriter.getInstance(doc, fos);				
				doc.open();	// abre para empezar a "imprimir"				
				doc.add(new Paragraph("Listado de Alumnos Matriculados: "));
				doc.add(new Paragraph(" "));		
				// tabla con el detalle de la compra
				PdfPTable tabla = new PdfPTable(5);	// 5 columnas para la tabla
				for (EstadosAlumnos e: lista) {
					tabla.addCell(e.getCodAlumno());
					tabla.addCell(e.getNomAlumno());
					tabla.addCell(e.getFechIngreso());
					tabla.addCell(e.getNomEscuela());
					tabla.addCell(e.getCarrera());
				}
				doc.add(tabla);			
				doc.close();
				Desktop.getDesktop().open(new File(nomarchivo));				
			} catch (Exception e) {
				alerta(e.getMessage());
			}
		}
		if(opcion == 3) {
			GestionAlumno ga = new GestionAlumno();
			ArrayList<EstadosAlumnos> lista = ga.listaRetirados();
			String nomarchivo = "reportes/Lista de Alumnos Retirados.pdf";
			try {
				Document doc = new Document();	// agregar los elementos a imprimir
				FileOutputStream fos = new FileOutputStream(nomarchivo);	// crea el archivo
				PdfWriter pdfw = PdfWriter.getInstance(doc, fos);				
				doc.open();	// abre para empezar a "imprimir"				
				doc.add(new Paragraph("Listado de Alumnos Retirados: "));
				doc.add(new Paragraph(" "));		
				// tabla con el detalle de la compra
				PdfPTable tabla = new PdfPTable(3);	// 5 columnas para la tabla
				for (EstadosAlumnos e: lista) {
					tabla.addCell(e.getCodAlumno());
					tabla.addCell(e.getNomAlumno());
					tabla.addCell(e.getFechIngreso());
				}
				doc.add(tabla);			
				doc.close();
				Desktop.getDesktop().open(new File(nomarchivo));				
			} catch (Exception e) {
				alerta(e.getMessage());
			}
		}
	}
	
	void llenaCombo() {
		GestionEstadosAlumnos ge = new GestionEstadosAlumnos();
		ArrayList<EstadosAlumnosTabla> lista = ge.lista();
		if (lista == null) {
			alerta("Lista de estados vacía");
			return;
		}
		cboEstados.addItem("Seleccione Estado");
		for (EstadosAlumnosTabla eat : lista) {
			cboEstados.addItem(eat.getCod()+"-"+eat.getDescripcion());
		}
	}
	
	void alerta(String msg) {
		JOptionPane.showMessageDialog(this, msg);
	}
}
