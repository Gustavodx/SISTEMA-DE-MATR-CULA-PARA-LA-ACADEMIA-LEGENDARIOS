package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import com.toedter.calendar.JDateChooser;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import mantenimientos.GestionAlumno;
import mantenimientos.GestionCurso;
import mantenimientos.GestionEscuela;
import mantenimientos.GestionMatricula;
import model.CursoProfesor;
import model.DetalleMatricula;
import model.ListaMatriculaBoleta;
import model.Matricula;

import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class FrmMatricula extends JInternalFrame {

	private JPanel contentPane;
	public static JTextField txtNombreAlumno;
	public static JTextField txtDniAlumno;
	public static JTextField txtCodigoMatricula;
	public static JTextField txtCodigoCurso;
	public static JTextField txtNombreCurso;
	public static JTextField txtNombreProfesor;
	public static JTextField txtPrecioEscuela;
	public static JTextField txtNombreEscuela;
	public static JTextField txtCapacidadCurso;
	public static JTextField txtCodigoAlumno;
	
	DefaultTableModel modelo = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMatricula frame = new FrmMatricula();
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
	public FrmMatricula() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 988, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Datos del Alumno", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 265, 95);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Codigo:");
		lblNewLabel.setBounds(10, 22, 67, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(10, 45, 52, 14);
		panel.add(lblNewLabel_1);
		
		txtCodigoAlumno = new JTextField();
		txtCodigoAlumno.setEditable(false);
		txtCodigoAlumno.setBounds(66, 19, 52, 20);
		panel.add(txtCodigoAlumno);
		txtCodigoAlumno.setColumns(10);
		
		txtNombreAlumno = new JTextField();
		txtNombreAlumno.setEditable(false);
		txtNombreAlumno.setBounds(66, 42, 177, 20);
		panel.add(txtNombreAlumno);
		txtNombreAlumno.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("DNI:");
		lblNewLabel_3.setBounds(10, 70, 46, 14);
		panel.add(lblNewLabel_3);
		
		txtDniAlumno = new JTextField();
		txtDniAlumno.setEditable(false);
		txtDniAlumno.setBounds(66, 67, 86, 20);
		panel.add(txtDniAlumno);
		txtDniAlumno.setColumns(10);
		
		JButton btnBuscarAlumno = new JButton("");
		btnBuscarAlumno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgAlumno a = new DlgAlumno();
				a.setVisible(true);
			}
		});
		btnBuscarAlumno.setContentAreaFilled(false);
		btnBuscarAlumno.setBorder(null);
		btnBuscarAlumno.setIcon(new ImageIcon(FrmMatricula.class.getResource("/img/busca.png")));
		btnBuscarAlumno.setBounds(128, 11, 37, 30);
		panel.add(btnBuscarAlumno);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(298, 22, 320, 74);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Matricula:");
		lblNewLabel_4.setBounds(39, 11, 56, 14);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Fecha:");
		lblNewLabel_5.setBounds(50, 44, 45, 14);
		panel_1.add(lblNewLabel_5);
		
		txtCodigoMatricula = new JTextField();
		txtCodigoMatricula.setEditable(false);
		txtCodigoMatricula.setBounds(126, 8, 99, 20);
		panel_1.add(txtCodigoMatricula);
		txtCodigoMatricula.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Datos de Matricula", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 117, 637, 144);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Curso:");
		lblNewLabel_6.setBounds(10, 22, 46, 14);
		panel_2.add(lblNewLabel_6);
		
		txtCodigoCurso = new JTextField();
		txtCodigoCurso.setEditable(false);
		txtCodigoCurso.setBounds(72, 19, 62, 20);
		panel_2.add(txtCodigoCurso);
		txtCodigoCurso.setColumns(10);
		
		txtNombreCurso = new JTextField();
		txtNombreCurso.setEditable(false);
		txtNombreCurso.setBounds(144, 19, 224, 20);
		panel_2.add(txtNombreCurso);
		txtNombreCurso.setColumns(10);
		
		txtNombreProfesor = new JTextField();
		txtNombreProfesor.setEditable(false);
		txtNombreProfesor.setBounds(72, 53, 200, 20);
		panel_2.add(txtNombreProfesor);
		txtNombreProfesor.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Profesor:");
		lblNewLabel_8.setBounds(10, 56, 62, 14);
		panel_2.add(lblNewLabel_8);
		
		txtPrecioEscuela = new JTextField();
		txtPrecioEscuela.setEditable(false);
		txtPrecioEscuela.setBounds(529, 19, 86, 20);
		panel_2.add(txtPrecioEscuela);
		txtPrecioEscuela.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Costo:");
		lblNewLabel_9.setBounds(473, 22, 46, 14);
		panel_2.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Escuela:");
		lblNewLabel_10.setBounds(306, 56, 62, 14);
		panel_2.add(lblNewLabel_10);
		
		txtNombreEscuela = new JTextField();
		txtNombreEscuela.setEditable(false);
		txtNombreEscuela.setBounds(378, 53, 237, 20);
		panel_2.add(txtNombreEscuela);
		txtNombreEscuela.setColumns(10);
		
		JButton btnBuscarCurso = new JButton("");
		btnBuscarCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgCurso c = new DlgCurso();
				c.setVisible(true);
			}
		});
		btnBuscarCurso.setIcon(new ImageIcon(FrmMatricula.class.getResource("/img/busca.png")));
		btnBuscarCurso.setContentAreaFilled(false);
		btnBuscarCurso.setBorder(null);
		btnBuscarCurso.setBounds(202, 84, 37, 30);
		panel_2.add(btnBuscarCurso);
		
		JButton btnAgregar = new JButton("");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarCurso();
			}
		});
		btnAgregar.setIcon(new ImageIcon(FrmMatricula.class.getResource("/img/add.png")));
		btnAgregar.setContentAreaFilled(false);
		btnAgregar.setBorder(null);
		btnAgregar.setBounds(272, 85, 37, 30);
		panel_2.add(btnAgregar);
		
		JLabel lblNewLabel_11 = new JLabel("Capacidad Curso:");
		lblNewLabel_11.setBounds(426, 89, 105, 14);
		panel_2.add(lblNewLabel_11);
		
		txtCapacidadCurso = new JTextField();
		txtCapacidadCurso.setEditable(false);
		txtCapacidadCurso.setBounds(529, 86, 86, 20);
		panel_2.add(txtCapacidadCurso);
		txtCapacidadCurso.setColumns(10);		
		
		txtCodigoProfesor = new JTextField();
		txtCodigoProfesor.setEditable(false);
		txtCodigoProfesor.setBounds(72, 84, 86, 20);
		panel_2.add(txtCodigoProfesor);
		txtCodigoProfesor.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Cod Prof:");
		lblNewLabel_2.setBounds(10, 89, 62, 14);
		panel_2.add(lblNewLabel_2);
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiaGUI();
			}
		});
		btnNuevo.setBounds(10, 527, 89, 23);
		contentPane.add(btnNuevo);
		
		JButton btnFinalizarCompra = new JButton("Finalizar Matricula");
		btnFinalizarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finalizarMatricula();
			}
		});
		btnFinalizarCompra.setBounds(202, 527, 147, 23);
		contentPane.add(btnFinalizarCompra);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 272, 952, 243);
		contentPane.add(scrollPane);
		
		tblS = new JTable();
		tblS.setModel(modelo);
		modelo.addColumn("CODCURSO");		
		modelo.addColumn("CURSO");
		modelo.addColumn("ALUMNO");
		modelo.addColumn("ESCUELA");
		modelo.addColumn("FECHA");
		modelo.addColumn("IMPORTE TOTAL");
		tblS.getColumnModel().getColumn(0).setPreferredWidth(35);
		tblS.getColumnModel().getColumn(1).setPreferredWidth(150);
		scrollPane.setViewportView(tblS);
		
		txtFechaMatricula = new JTextField();
		txtFechaMatricula.setEditable(false);
		txtFechaMatricula.setBounds(126, 41, 99, 20);
		panel_1.add(txtFechaMatricula);
		txtFechaMatricula.setColumns(10);
		
		txtCodigoMatricula.setText(obtenerNumBoleta());
		txtFechaMatricula.setText(new SimpleDateFormat("yyyy/MM/dd").format(new Date()));
		
		JLabel lblNewLabel_7 = new JLabel("Total a pagar:");
		lblNewLabel_7.setBounds(738, 531, 99, 14);
		contentPane.add(lblNewLabel_7);
		
		txtTotal = new JTextField();
		txtTotal.setBounds(816, 528, 86, 20);
		contentPane.add(txtTotal);
		txtTotal.setColumns(10);
		
	}
	
	Matricula m = new Matricula();
	
	ArrayList<DetalleMatricula> carro = new ArrayList<DetalleMatricula>();
	private JTable tblS;
	public static JTextField txtCodigoProfesor;
	private JScrollPane scrollPane;
	
	void limpiaGUI() {
		m = new Matricula();
		carro.clear();		
		txtCodigoCurso.setText("");
		txtCodigoProfesor.setText("");
		txtCodigoAlumno.setText("");
		txtNombreCurso.setText("");
		txtNombreAlumno.setText("");
		txtDniAlumno.setText("");
		txtPrecioEscuela.setText("");
		txtNombreProfesor.setText("");
		txtNombreEscuela.setText("");
		txtCapacidadCurso.setText("");
		txtTotal.setText("");
		modelo.setRowCount(0);
		totalpago = 0;
	}
	
	void agregarCurso() {
		String codigoCurso = leerCodigoCurso();
		String nombreCurso = leerNombreCurso();
		String codProfesor = leerCodProf();
		double precioEscuela = leerPrecioEscuela();
		String nombreEscuela = leerNombreEscuela();
		String nombreAlumno = leerNombreAlumno();
		String fecha = obtenerFecha();		
		int capacidadCurso = leerCapacidad();
		
		if(codigoCurso==null||nombreCurso==null||codProfesor==null||precioEscuela==-1||nombreEscuela==null||nombreAlumno==null||fecha==null||capacidadCurso==-1) {
			return;
		}
		
		if (capacidadCurso == 0) {
			alerta("Capacidad maxima de Curso alcanzada");
			return;
		}
		
		double importe = (0.18*precioEscuela)+precioEscuela;
		totalpago += importe;
				
		DetalleMatricula dm = new DetalleMatricula();
		
		dm.setCodProf(codProfesor);
		dm.setCodCurso(codigoCurso);
		dm.setVacante(1);
		dm.setImporte(importe);
		carro.add(dm);
		aviso("Curso "+nombreCurso+" agregado correctamente");
		
		Object datos[] = {codigoCurso,nombreCurso,nombreAlumno,nombreEscuela,fecha,importe};
		modelo.addRow(datos);
		txtTotal.setText(String.format("S/%7.2f", totalpago));
		txtCodigoCurso.setText("");
		txtNombreCurso.setText("");
		txtNombreProfesor.setText("");
		txtCodigoProfesor.setText("");
		txtPrecioEscuela.setText("");
		txtCapacidadCurso.setText("");
		txtNombreEscuela.setText("");		
	}
	
	void finalizarMatricula() {
		String codMatricula = obtenerNumBoleta();
		String fechaMatri = obtenerFecha();
		String codAlu = leerCodigoAlumno();
		String codEmpleado = obtenerCodEmp();
		double totalBol = totalpago;
		
		if (codAlu == null) {
			return;
		}
		
		// Matricula m = new Matricula();
		m.setCodMatri(codMatricula);
		m.setFecha(fechaMatri);
		m.setCodAlu(codAlu);
		m.setCodEmp(codEmpleado);
		m.setTotalPago(totalBol);
		
		GestionMatricula gm = new GestionMatricula();
		int ok = gm.realizarMatricula(m, carro);
		
		if (ok == 0) {
			alerta("Error al realizar la matricula....");
			return;
		}
		int i = modelo.getRowCount();
		if (i == 0) {
			alerta("Error, debe añadir un curso al carro");
			return;
		} else {
			aviso("Matricula exitosa");
			txtCodigoMatricula.setText(obtenerNumBoleta());
			imprimirMatricula();			
			limpiaGUI();
		}
	}
	
	void imprimirMatricula() {
		String nomarchivo = "reportes/"+ m.getCodMatri() + ".pdf";
		try {
			Document doc = new Document();	// agregar los elementos a imprimir
			FileOutputStream fos = new FileOutputStream(nomarchivo);	// crea el archivo
			PdfWriter pdfw = PdfWriter.getInstance(doc, fos);
			
			doc.open();	// abre para empezar a "imprimir"
			
			doc.add(new Paragraph("Boleta de Matricula"));
			doc.add(new Paragraph(" "));	// espacio
			doc.add(new Paragraph("Num de Boleta...: "+m.getCodMatri()));
			doc.add(new Paragraph("Fecha...........: "+m.getFecha()));
			doc.add(new Paragraph("Alumno..........: "+new GestionAlumno().buscar(m.getCodAlu()).getNombre()+" "+new GestionAlumno().buscar(m.getCodAlu()).getApellido()));
			doc.add(new Paragraph("-----------------------------------------------------------------------------------------------------------------------------------"));
			
			// tabla con el detalle de la compra
			PdfPTable tabla = new PdfPTable(3);	// 5 columnas para la tabla
			for (DetalleMatricula dm : carro) {
				tabla.addCell(dm.getCodCurso());
				tabla.addCell(new GestionCurso().buscar(dm.getCodCurso()).getNombre());
				tabla.addCell(String.format("S/%8.2f", dm.getImporte()));
			}
			doc.add(tabla);
			doc.add(new Paragraph("Total: "+m.getTotalPago()));
			doc.add(new Paragraph("-----------------------------------------------------------------------------------------------------------------------------------"));
			
			doc.close();
			// para visualizar
			Desktop.getDesktop().open(new File(nomarchivo));
			
		} catch (Exception e) {
			alerta(e.getMessage());
		}
	}
	
	double totalpago = 0;
	private JTextField txtFechaMatricula;
	private JTextField txtTotal;
	
	private String obtenerNumBoleta() {
		// TODO Auto-generated method stub
		GestionMatricula gm = new GestionMatricula();
		return gm.generaNumMatricula();
	}
	
	/*private String obtenerCodigoEmpleado() {
		return Logueo.e.getCodigoEmpleado();
	}*/
	
	private String leerCodigoAlumno() {
		if (txtCodigoAlumno.getText().isEmpty()) {
			alerta("Debe seleccionar un cliente");
			return null;
		}
		return txtCodigoAlumno.getText();
	}
	
	private String leerCodigoCurso() {
		return txtCodigoCurso.getText();
	}
	
	private int leerCapacidad() {
		return Integer.parseInt(txtCapacidadCurso.getText());
	}
	
	private String leerNombreCurso() {
		return txtNombreCurso.getText();
	}
	
	private String leerNombreProfesor() {
		return txtNombreProfesor.getText();
	}
	
	private String leerNombreEscuela() {
		return txtNombreEscuela.getText();
	}
	
	private String leerNombreAlumno() {
		return txtNombreAlumno.getText();
	}
	
	private Double leerPrecioEscuela() {
		return Double.parseDouble(txtPrecioEscuela.getText());
	}
	
	private String leerCodMatri() {
		return txtCodigoMatricula.getText();
	}
	
	private String leerCodProf() {
		return txtCodigoProfesor.getText();
	}
	
	private String obtenerFecha() {
		// Obtener la fecha del sistema
		return new SimpleDateFormat("yyyy/MM/dd").format(new Date());
	}
	
	private String obtenerCodEmp() {
		// Código de la persona que atiende --> Logueo
		return FrmLogin.e.getCodigo();
	}
	
	void alerta(String msg) {
		JOptionPane.showMessageDialog(this, msg,"Error...",JOptionPane.ERROR_MESSAGE);
	}
	
	void aviso(String msg) {
		JOptionPane.showMessageDialog(this, msg,"Mensaje",JOptionPane.INFORMATION_MESSAGE);
	}
}
