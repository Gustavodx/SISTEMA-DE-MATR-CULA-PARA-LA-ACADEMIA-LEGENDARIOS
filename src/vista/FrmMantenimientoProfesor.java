package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;

import mantenimientos.GestionAlumno;
import mantenimientos.GestionProfesor;
import model.Alumno;
import model.ListaProfesores;
import model.Profesor;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FrmMantenimientoProfesor extends JInternalFrame {

	private JPanel contentPane;
	private JTextField txtApe;
	private JTextField txtNom;
	private JTextField txtDni;
	private JTextField txtCodigo;
	private JTextField txtFono;
	private JTextField txtDirec;
	private JTextField txtCodCurso;
	private JTextField txtCodEscuela;
	private JTable tblS;
	
	DefaultTableModel modelo = new DefaultTableModel();
	private JComboBox cboOperaciones;
	private JButton btnProcesar;
	private JButton btnBuscar;
	private JDateChooser txtFecha;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMantenimientoProfesor frame = new FrmMantenimientoProfesor();
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
	public FrmMantenimientoProfesor() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Mantenimiento Profesores");
		setBounds(100, 100, 1070, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodigoProfesor = new JLabel("Codigo Profesor:");
		lblCodigoProfesor.setBounds(29, 14, 107, 14);
		contentPane.add(lblCodigoProfesor);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(29, 37, 107, 14);
		contentPane.add(lblDni);
		
		JLabel lblNombres = new JLabel("Nombres:");
		lblNombres.setBounds(29, 62, 107, 14);
		contentPane.add(lblNombres);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(29, 87, 107, 14);
		contentPane.add(lblApellidos);
		
		JLabel lblFechaIngreso = new JLabel("Fecha Ingreso:");
		lblFechaIngreso.setBounds(29, 150, 107, 14);
		contentPane.add(lblFechaIngreso);
		
		txtFecha = new JDateChooser();
		txtFecha.setEnabled(false);
		txtFecha.setBounds(146, 144, 107, 20);
		contentPane.add(txtFecha);
		
		txtApe = new JTextField();
		txtApe.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtApe.getText().length() > 29) {
					e.consume();
				}
			}
		});
		txtApe.setEnabled(false);
		txtApe.setColumns(10);
		txtApe.setBounds(146, 84, 167, 20);
		contentPane.add(txtApe);
		
		txtNom = new JTextField();
		txtNom.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtNom.getText().length() > 29) {
					e.consume();
				}
			}
		});
		txtNom.setEnabled(false);
		txtNom.setColumns(10);
		txtNom.setBounds(146, 59, 167, 20);
		contentPane.add(txtNom);
		
		txtDni = new JTextField();
		txtDni.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtDni.getText().length() > 7) {
					e.consume();
				}
			}
		});
		txtDni.setEnabled(false);
		txtDni.setColumns(10);
		txtDni.setBounds(146, 34, 86, 20);
		contentPane.add(txtDni);
		
		txtCodigo = new JTextField();
		txtCodigo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtCodigo.getText().length() > 3) {
					e.consume();
				}
			}
		});
		txtCodigo.setEnabled(false);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(146, 11, 86, 20);
		contentPane.add(txtCodigo);
		
		JLabel lblTelefonoAlumno = new JLabel("Telefono:");
		lblTelefonoAlumno.setBounds(29, 115, 107, 14);
		contentPane.add(lblTelefonoAlumno);
		
		txtFono = new JTextField();
		txtFono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtFono.getText().length() > 8) {
					e.consume();
				}
			}
		});
		txtFono.setEnabled(false);
		txtFono.setColumns(10);
		txtFono.setBounds(146, 112, 86, 20);
		contentPane.add(txtFono);
		
		JLabel lblDireccionAlumno = new JLabel("Direccion:");
		lblDireccionAlumno.setBounds(29, 230, 107, 14);
		contentPane.add(lblDireccionAlumno);
		
		txtDirec = new JTextField();
		txtDirec.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtDirec.getText().length() > 39) {
					e.consume();
				}
			}
		});
		txtDirec.setEnabled(false);
		txtDirec.setColumns(10);
		txtDirec.setBounds(146, 227, 167, 20);
		contentPane.add(txtDirec);
		
		JLabel lblNewLabel = new JLabel("Codigo Curso:");
		lblNewLabel.setBounds(29, 175, 107, 14);
		contentPane.add(lblNewLabel);
		
		txtCodCurso = new JTextField();
		txtCodCurso.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtCodCurso.getText().length() > 3) {
					e.consume();
				}
			}
		});
		txtCodCurso.setEnabled(false);
		txtCodCurso.setBounds(146, 172, 86, 20);
		contentPane.add(txtCodCurso);
		txtCodCurso.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Codigo Escuela:");
		lblNewLabel_1.setBounds(29, 200, 107, 14);
		contentPane.add(lblNewLabel_1);
		
		txtCodEscuela = new JTextField();
		txtCodEscuela.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char tecla = e.getKeyChar();
				if (tecla < '0' || tecla > '9') {
					e.consume();
				}
			}
		});
		txtCodEscuela.setEnabled(false);
		txtCodEscuela.setBounds(146, 197, 86, 20);
		contentPane.add(txtCodEscuela);
		txtCodEscuela.setColumns(10);
		
		btnBuscar = new JButton("Buscar Profesor");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				obtenerProfesor();
			}
		});
		btnBuscar.setBounds(242, 10, 138, 23);
		contentPane.add(btnBuscar);
		
		cboOperaciones = new JComboBox();
		cboOperaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operacionSeleccionada();
			}
		});
		cboOperaciones.setModel(new DefaultComboBoxModel(new String[] {"Seleccione Operacion", "Registrar", "Consultar", "Actualizar", "Deshabilitar Profesor", "Habilitar Profesor"}));
		cboOperaciones.setBounds(404, 10, 157, 22);
		contentPane.add(cboOperaciones);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				procesar();
			}
		});
		btnProcesar.setBounds(605, 11, 107, 40);
		contentPane.add(btnProcesar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		btnLimpiar.setBounds(605, 61, 107, 40);
		contentPane.add(btnLimpiar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(605, 111, 107, 33);
		contentPane.add(btnSalir);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 255, 1034, 225);
		contentPane.add(scrollPane);
		
		tblS = new JTable();
		modelo.addColumn("CODIGO");
		modelo.addColumn("DNI");
		modelo.addColumn("PROFESOR");
		modelo.addColumn("FONO");
		modelo.addColumn("FECHA");
		modelo.addColumn("CURSO");
		modelo.addColumn("ESCUELA");
		modelo.addColumn("DIRECCION");
		tblS.setModel(modelo);
		tblS.getColumnModel().getColumn(1).setPreferredWidth(30);
		tblS.getColumnModel().getColumn(2).setPreferredWidth(90);
		tblS.getColumnModel().getColumn(3).setPreferredWidth(20);
		tblS.getColumnModel().getColumn(4).setPreferredWidth(20);
		tblS.getColumnModel().getColumn(0).setPreferredWidth(15);
		tblS.getColumnModel().getColumn(5).setPreferredWidth(140);
		tblS.getColumnModel().getColumn(6).setPreferredWidth(30);
		
		scrollPane.setViewportView(tblS);
		txtFecha.setDate(new Date());
		
		btnBuscar.setEnabled(false);
		btnProcesar.setEnabled(false);
		listarProfesor();
	}
	
	void operacionSeleccionada() {
		int opcion = cboOperaciones.getSelectedIndex();
		switch (opcion) {
		case 1:
			txtCodigo.setEnabled(true);
			txtCodigo.requestFocus();
			txtDni.setEnabled(true);
			txtNom.setEnabled(true);
			txtApe.setEnabled(true);
			txtFono.setEnabled(true);
			txtFecha.setDate(new Date());
			txtFecha.setEnabled(true);
			txtCodCurso.setEnabled(true);
			txtCodEscuela.setEnabled(true);
			txtDirec.setEnabled(true);
			btnBuscar.setEnabled(false);
			btnProcesar.setEnabled(true);
			break;
		case 2:
			txtCodigo.setEnabled(true);
			txtCodigo.requestFocus();
			txtDni.setEnabled(false);
			txtNom.setEnabled(false);
			txtApe.setEnabled(false);
			txtFono.setEnabled(false);
			txtFecha.setDate(new Date());
			txtFecha.setEnabled(false);
			txtCodCurso.setEnabled(false);
			txtCodEscuela.setEnabled(false);
			txtDirec.setEnabled(false);
			btnBuscar.setEnabled(true);
			btnProcesar.setEnabled(false);
			break;
		case 3:
			txtCodigo.setEnabled(true);
			txtCodigo.requestFocus();
			txtDni.setEnabled(false);
			txtNom.setEnabled(true);
			txtApe.setEnabled(true);
			txtFono.setEnabled(true);
			txtFecha.setDate(new Date());
			txtFecha.setEnabled(false);
			txtCodCurso.setEnabled(true);
			txtCodEscuela.setEnabled(true);
			txtDirec.setEnabled(true);
			btnBuscar.setEnabled(false);
			btnProcesar.setEnabled(true);
			break;
		case 4:
			txtCodigo.setEnabled(true);
			txtCodigo.requestFocus();
			txtDni.setEnabled(false);
			txtNom.setEnabled(false);
			txtApe.setEnabled(false);
			txtFono.setEnabled(false);
			txtFecha.setDate(new Date());
			txtFecha.setEnabled(false);
			txtCodCurso.setEnabled(false);
			txtCodEscuela.setEnabled(false);
			txtDirec.setEnabled(false);
			btnBuscar.setEnabled(false);
			btnProcesar.setEnabled(true);
			break;
		case 5:
			txtCodigo.setEnabled(true);
			txtCodigo.requestFocus();
			txtDni.setEnabled(false);
			txtNom.setEnabled(false);
			txtApe.setEnabled(false);
			txtFono.setEnabled(false);
			txtFecha.setDate(new Date());
			txtFecha.setEnabled(false);
			txtCodCurso.setEnabled(false);
			txtCodEscuela.setEnabled(false);
			txtDirec.setEnabled(false);
			btnBuscar.setEnabled(false);
			btnProcesar.setEnabled(true);
			break;
		default:
			break;
		}
	}
	
	void limpiar() {
		txtCodigo.setText("");
		txtDni.setText("");
		txtNom.setText("");
		txtApe.setText("");
		txtFono.setText("");
		txtFecha.setDate(new Date());
		txtCodCurso.setText("");
		txtCodEscuela.setText("");
		txtDirec.setText("");
		txtCodigo.setEnabled(false);
		txtDni.setEnabled(false);
		txtNom.setEnabled(false);
		txtApe.setEnabled(false);
		txtFono.setEnabled(false);
		txtCodCurso.setEnabled(false);
		txtCodEscuela.setEnabled(false);
		txtDirec.setEnabled(false);
	}
	
	void procesar() {
		int opcion = cboOperaciones.getSelectedIndex();
		if (opcion == 0) {
			alerta("Seleccione operaciÛn a realizar");
		}
		if (opcion == 1) {
			String codigo = leerCodigo();
			String dni = leerDni();
			String nom = leerNom();
			String ape = leerApe();
			String fono = leerFono();
			String fecha = leerFecha();
			String codCurso = leerCodCurso();
			int codEscuela = leerEscuela();
			String direc = leerDirec();
			
			if (codigo==null||dni==null||nom==null||ape==null||fecha==null||
					fono==null||codCurso==null||codEscuela==-1||direc==null) {
				return;
			}
			
			Profesor p = new Profesor();
			p.setCodigo(codigo);
			p.setDni(dni);
			p.setNom(nom);
			p.setApe(ape);
			p.setFono(fono);
			p.setFecha(fecha);
			p.setCodCurso(codCurso);
			p.setCodEscuela(codEscuela);
			p.setDirec(direc);
			
			GestionProfesor gp = new GestionProfesor();
			int ok = gp.registrar(p);
			if (ok==0) {
				alerta("Error al registrar profesor");
			} else {
				alerta("Profesor "+p.getApe()+" registrado correctamente");
				listarProfesor();
			}
		}
		if (opcion == 2) {
			alerta("Para consultar, ingresar codigo de profesor y clickear al boton Buscar Profesor");
		}
		if (opcion == 3) {
			String codigo = leerCodigo();
			String nom = leerNom();
			String ape = leerApe();
			String fono = leerFono();
			String codCurso = leerCodCurso();
			int codEscuela = leerEscuela();
			String direc = leerDirec();
			
			Profesor p = new Profesor();
			p.setCodigo(codigo);
			p.setNom(nom);
			p.setApe(ape);
			p.setFono(fono);
			p.setCodCurso(codCurso);
			p.setCodEscuela(codEscuela);
			p.setDirec(direc);
			
			GestionProfesor gp = new GestionProfesor();
			int ok = gp.actualizar(p);
			if (ok == 0) {
				alerta("Error al encontrar profesor");
			} else {
				alerta("Profesor "+p.getApe()+" actualizado");
				listarProfesor();
			}
		}
		if (opcion == 4) {
			String codigo = leerCodigo();
			if (codigo == null) {
				return;
			}
			GestionProfesor gp = new GestionProfesor();
			int ok = gp.eliminar(codigo);
			if (ok == 0) {
				alerta("Error al deshabilitar profesor\nEl profesor ingresado no existe");
			} else {
				alerta("Profesor "+codigo+" deshabilitado");
				txtCodigo.setText("");
				ArrayList<Profesor> lista = gp.listado();
				if (lista == null) {
					return;
				}
				listarProfesor();
			}
		}
		if (opcion == 5) {
			String codigo = leerCodigo();
			if (codigo == null) {
				return;
			}
			GestionProfesor gp = new GestionProfesor();
			int ok = gp.habilitar(codigo);
			if (ok == 0) {
				alerta("Error al habilitar profesor\nEl profesor ingresado no existe");
			} else {
				alerta("Profesor "+codigo+" habilitado");
				txtCodigo.setText("");
				ArrayList<Profesor> lista = gp.listado();
				if (lista == null) {
					return;
				}
				listarProfesor();
			}
		}
	}
		
		void obtenerProfesor() {
			String codigo = leerCodigo();
			Profesor p = new GestionProfesor().buscar(codigo);
			if (codigo==null) {
				return;
			}
			if (p==null) {
				alerta("El codigo de profesor no existe");
			} else {
				txtDni.setText(p.getDni());
				txtNom.setText(p.getNom());
				txtApe.setText(p.getApe());
				txtFono.setText(p.getFono());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				try {
					txtFecha.setDate(sdf.parse(p.getFecha()));
				} catch (ParseException msg) {
					alerta("Error al leer fecha\n"+msg.getMessage());
				}
				txtCodCurso.setText(p.getCodCurso());
				txtCodEscuela.setText(p.getCodEscuela()+"");
				txtDirec.setText(p.getDirec());
				
				txtCodigo.setEnabled(true);
				txtDni.setEnabled(true);
				txtNom.setEnabled(true);
				txtApe.setEnabled(true);
				txtFono.setEnabled(true);
				txtFecha.setEnabled(true);
				txtCodCurso.setEnabled(true);
				txtCodEscuela.setEnabled(true);
				txtDirec.setEnabled(true);
			}
		}
		
		void listarProfesor() {
			GestionProfesor gp = new GestionProfesor();
			ArrayList<ListaProfesores> lista = gp.lista();
			if (lista==null) {
				alerta("Lista de profesores vacia");
				return;
			} else {
				modelo.setRowCount(0);
				for (ListaProfesores p : lista) {
					Object datos[] = {p.getCod(),p.getDni(),p.getProfesor(),p.getFono(),p.getFecha(),p.getNomCurso(),p.getNomEscuela(),p.getDirec()};
					modelo.addRow(datos);
				}
			}
		}
		
		String leerDirec() {
			if (txtDirec.getText().equals("")) {
				alerta("Ingrese direccion");
				return null;
			}
			if (!txtDirec.getText().matches("[[A-Za-z·ÈÌÛ˙Ò—¡…Õ”⁄]+(\\s[A-Za-z·ÈÌÛ˙Ò—¡…Õ”⁄]+)*(\\s[0-9]+)*]{2,40}")) {
				alerta("Direccion no v·lido\n\nAcepta letras y numeros, 2 char min y 40 char max.");
				return null;
			}
			try {
				return txtDirec.getText();
			} catch (NumberFormatException e) {
				alerta("Error\n"+e.getMessage());
				return null;
			}
		}
		
		int leerEscuela() {
			if(txtCodEscuela.getText().equals("")) {
				alerta("Ingrese codigo de escuela");
				return -1;
			}
			if(!txtCodEscuela.getText().matches("[0-9]+")) {
				alerta("Codigo de escuela no v·lido\n\nSolo acepta numeros enteros");
				return -1;
			}
			try {
				return Integer.parseInt(txtCodEscuela.getText());
			} catch (NumberFormatException e) {
				alerta("Error\n"+e.getMessage());
				return -1;
			}
		}
		
		String leerApe() {
			if (txtApe.getText().equals("")) {
				alerta("Ingrese apellido");
				return null;
			}
			if (!txtApe.getText().matches("[[A-Za-z·ÈÌÛ˙Ò—¡…Õ”⁄]+(\\s[A-Za-z·ÈÌÛ˙Ò—¡…Õ”⁄]+)*]{2,30}")) {
				alerta("Apellido no v·lido\n\nSolo acepta letras, 2 min y 30 max.");
				return null;
			}
			try {
				return txtApe.getText();
			} catch (NumberFormatException e) {
				alerta("Error\n"+e.getMessage());
				return null;
			}
		}
		
		String leerNom() {
			if (txtNom.getText().equals("")) {
				alerta("Ingrese nombre");
				return null;
			}
			if (!txtNom.getText().matches("[[A-Za-z·ÈÌÛ˙Ò—¡…Õ”⁄]+(\\s[A-Za-z·ÈÌÛ˙Ò—¡…Õ”⁄]+)*]{2,30}")) {
				alerta("Nombre no v·lido\n\nSolo acepta letras, 2 min y 30 max.");
				return null;
			}
			try {
				return txtNom.getText();
			} catch (NumberFormatException e) {
				alerta("Error\n"+e.getMessage());
				return null;
			}
		}
		
		String leerCodCurso() {
			if (txtCodCurso.getText().equals("")) {
				alerta("Ingrese codigo de curso");
				return null;
			}
			if (!txtCodCurso.getText().matches("[C]{1}[0-9]{3}")) {
				alerta("Codigo de curso no v·lido\n\nSolo Acepta letra 'C' seguido de 3 numeros");
				return null;
			}
			try {
				return txtCodCurso.getText();
			} catch (NumberFormatException e) {
				alerta("Error\n"+e.getMessage());
				return null;
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
		
		String leerFono() {
			if(txtFono.getText().equals("")) {
				alerta("Ingrese telÈfono");
				return null;
			}
			if(!txtFono.getText().matches("[0-9]{9}")) {
				alerta("Telefono no v·lido\n\nSolo son v·lidos 9 dÌgitos");
				return null;
			}
			try {
				return txtFono.getText();
			} catch (NumberFormatException e) {
				alerta("Error\n"+e.getMessage());
				return null;
			}
		}
		
		String leerDni() {
			if (txtDni.getText().equals("")) {
				alerta("Ingrese DNI");
				return null;
			}
			if (!txtDni.getText().matches("[0-9]{8}")) {
				alerta("DNI no v·lido\n\nSolo acepta numeros de 8 digitos");
				return null;
			}
			try {
				return txtDni.getText();
			} catch (NumberFormatException e) {
				alerta("Error\n"+e.getMessage());
				return null;
			}
		}
		
		String leerCodigo() {
			if (txtCodigo.getText().equals("")) {
				alerta("Ingrese codigo");
				return null;
			}
			if (!txtCodigo.getText().matches("[P]{1}[0-9]{3}")) {
				alerta("Codigo no v·lido\n\nSolo Acepta letra 'P' seguido de 3 numeros");
				return null;
			}
			try {
				return txtCodigo.getText();
			} catch (NumberFormatException e) {
				alerta("Error\n"+e.getMessage());
				return null;
			}
		}
	
	void alerta(String msg) {
		JOptionPane.showMessageDialog(this, msg);
	}	
}
