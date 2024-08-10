package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import mantenimientos.GestionAlumno;
import model.Alumno;
import model.EstadosAlumnos;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FrmMantenimientoAlumno extends JInternalFrame {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtNom;
	private JTextField txtApe;
	private JTextField txtEscuela;
	private JTextField txtCarrera;
	private JTextField txtFono;
	private JTextField txtDirec;
	
	DefaultTableModel modelo = new DefaultTableModel();
	private JComboBox cboOperaciones;
	private JTextField txtDni;
	private JDateChooser txtFecha;
	private JButton btnBuscar;
	private JButton btnProcesar;
	private JTable tblS;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMantenimientoAlumno frame = new FrmMantenimientoAlumno();
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
	public FrmMantenimientoAlumno() {
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setTitle("Mantenimiento Alumnos");
		setBounds(100, 100, 935, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Codigo Alumno:");
		lblNewLabel.setBounds(28, 11, 107, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNombres = new JLabel("Nombres:");
		lblNombres.setBounds(28, 59, 107, 14);
		contentPane.add(lblNombres);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(28, 84, 107, 14);
		contentPane.add(lblApellidos);
		
		JLabel lblFechaIngreso = new JLabel("Fecha Ingreso:");
		lblFechaIngreso.setBounds(28, 109, 107, 14);
		contentPane.add(lblFechaIngreso);
		
		JLabel lblEscuela = new JLabel("Escuela:");
		lblEscuela.setBounds(28, 134, 107, 14);
		contentPane.add(lblEscuela);
		
		JLabel lblCarrera = new JLabel("Carrera:");
		lblCarrera.setBounds(28, 159, 107, 14);
		contentPane.add(lblCarrera);
		
		JLabel lblTelefonoAlumno = new JLabel("Telefono:");
		lblTelefonoAlumno.setBounds(28, 184, 107, 14);
		contentPane.add(lblTelefonoAlumno);
		
		JLabel lblDireccionAlumno = new JLabel("Direccion:");
		lblDireccionAlumno.setBounds(28, 209, 107, 14);
		contentPane.add(lblDireccionAlumno);
		
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
		txtCodigo.setBounds(145, 8, 86, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
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
		txtNom.setBounds(145, 56, 167, 20);
		contentPane.add(txtNom);
		txtNom.setColumns(10);
		
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
		txtApe.setBounds(145, 81, 167, 20);
		contentPane.add(txtApe);
		txtApe.setColumns(10);
		
		txtEscuela = new JTextField();
		txtEscuela.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char tecla = e.getKeyChar();
				if (tecla < '0' || tecla > '9') {
					e.consume();
				}
			}
		});
		txtEscuela.setEnabled(false);
		txtEscuela.setBounds(145, 131, 86, 20);
		contentPane.add(txtEscuela);
		txtEscuela.setColumns(10);
		
		txtCarrera = new JTextField();
		txtCarrera.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtCarrera.getText().length() > 29) {
					e.consume();
				}
			}
		});
		txtCarrera.setEnabled(false);
		txtCarrera.setBounds(145, 156, 207, 20);
		contentPane.add(txtCarrera);
		txtCarrera.setColumns(10);
		
		txtFono = new JTextField();
		txtFono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char tecla = e.getKeyChar();
				if (tecla < '0' || tecla > '9') {
					e.consume();
				}
				if (txtFono.getText().length() > 8) {
					e.consume();
				}
			}
		});
		txtFono.setEnabled(false);
		txtFono.setBounds(145, 181, 86, 20);
		contentPane.add(txtFono);
		txtFono.setColumns(10);
		
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
		txtDirec.setBounds(145, 206, 167, 20);
		contentPane.add(txtDirec);
		txtDirec.setColumns(10);
		
		txtFecha = new JDateChooser();
		txtFecha.setBounds(124, 103, 107, 20);
		contentPane.add(txtFecha);
		
		btnBuscar = new JButton("Buscar Alumno");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				obtenerAlumno();
			}
		});
		btnBuscar.setBounds(241, 30, 151, 23);
		contentPane.add(btnBuscar);
		
		cboOperaciones = new JComboBox();
		cboOperaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operacionSeleccionada();
			}
		});
		cboOperaciones.setModel(new DefaultComboBoxModel(new String[] {"Seleccione Operacion", "Registrar", "Consultar", "Actualizar", "Deshabilitar Alumnos", "Habilitar Alumnos"}));
		cboOperaciones.setBounds(402, 30, 173, 22);
		contentPane.add(cboOperaciones);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				procesar();
			}
		});
		btnProcesar.setBounds(598, 30, 89, 23);
		contentPane.add(btnProcesar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		btnLimpiar.setBounds(598, 80, 89, 23);
		contentPane.add(btnLimpiar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(598, 130, 89, 23);
		contentPane.add(btnSalir);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(28, 34, 107, 14);
		contentPane.add(lblDni);
		
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
		txtDni.setBounds(145, 31, 86, 20);
		contentPane.add(txtDni);
		btnBuscar.setEnabled(false);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 234, 899, 224);
		contentPane.add(scrollPane);
		
		tblS = new JTable();
		tblS.setModel(modelo);
		modelo.addColumn("CODIGO");
		modelo.addColumn("DNI");
		modelo.addColumn("ALUMNO");
		modelo.addColumn("FECHA");
		modelo.addColumn("ESCUELA");
		modelo.addColumn("CARRERA");
		modelo.addColumn("TELEFONO");
		modelo.addColumn("DIRECCION");
		modelo.addColumn("DESCRIPCION");
		tblS.getColumnModel().getColumn(0).setPreferredWidth(15);
		tblS.getColumnModel().getColumn(1).setPreferredWidth(10);
		tblS.getColumnModel().getColumn(3).setPreferredWidth(20);
		tblS.getColumnModel().getColumn(4).setPreferredWidth(35);
		tblS.getColumnModel().getColumn(6).setPreferredWidth(25);
		tblS.getColumnModel().getColumn(8).setPreferredWidth(45);
		tblS.getColumnModel().getColumn(5).setPreferredWidth(110);
		tblS.getColumnModel().getColumn(2).setPreferredWidth(105);
		scrollPane.setViewportView(tblS);
		listarAlumno();
		txtFecha.setEnabled(false);
		
	}
	
	void operacionSeleccionada() {
		int opcion = cboOperaciones.getSelectedIndex();
		switch (opcion) {
		case 1:	// registrar
			txtCodigo.setEnabled(true);
			txtCodigo.requestFocus();
			txtDni.setEnabled(true);
			txtNom.setEnabled(true);
			txtApe.setEnabled(true);
			txtFecha.setEnabled(true);
			txtFecha.setDate(new Date());
			txtEscuela.setEnabled(true);
			txtCarrera.setEnabled(true);
			txtFono.setEnabled(true);
			txtDirec.setEnabled(true);
			btnBuscar.setEnabled(false);
			btnProcesar.setEnabled(true);
			break;
		case 2:	// consultar
			txtCodigo.setEnabled(true);
			txtCodigo.requestFocus();
			txtDni.setEnabled(false);
			txtNom.setEnabled(false);
			txtApe.setEnabled(false);
			txtFecha.setDate(new Date());
			txtFecha.setEnabled(false);
			txtEscuela.setEnabled(false);
			txtCarrera.setEnabled(false);
			txtFono.setEnabled(false);
			txtDirec.setEnabled(false);
			btnBuscar.setEnabled(true);
			btnProcesar.setEnabled(false);
			break;
		case 3:	// actualizar
			txtCodigo.setEnabled(true);
			txtCodigo.requestFocus();
			txtDni.setEnabled(false);
			txtNom.setEnabled(true);
			txtApe.setEnabled(true);
			txtFecha.setEnabled(false);
			txtEscuela.setEnabled(true);
			txtCarrera.setEnabled(true);
			txtFono.setEnabled(true);
			txtDirec.setEnabled(true);
			btnBuscar.setEnabled(false);
			btnProcesar.setEnabled(true);
			break;
		case 4:	// deshabilitar
			txtCodigo.setEnabled(true);
			txtCodigo.requestFocus();
			txtDni.setEnabled(false);
			txtNom.setEnabled(false);
			txtApe.setEnabled(false);
			txtFecha.setEnabled(false);
			txtFecha.setDate(new Date());
			txtEscuela.setEnabled(false);
			txtCarrera.setEnabled(false);
			txtFono.setEnabled(false);
			txtDirec.setEnabled(false);
			btnBuscar.setEnabled(false);
			btnProcesar.setEnabled(true);
			break;
		case 5:	// habilitar
			txtCodigo.setEnabled(true);
			txtCodigo.requestFocus();
			txtDni.setEnabled(false);
			txtNom.setEnabled(false);
			txtApe.setEnabled(false);
			txtFecha.setEnabled(false);
			txtFecha.setDate(new Date());
			txtEscuela.setEnabled(false);
			txtCarrera.setEnabled(false);
			txtFono.setEnabled(false);
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
		txtFecha.setDate(new Date());
		txtEscuela.setText("");
		txtCarrera.setText("");
		txtFono.setText("");
		txtDirec.setText("");
		txtCodigo.setEnabled(false);
		txtDni.setEnabled(false);
		txtNom.setEnabled(false);
		txtApe.setEnabled(false);
		txtFecha.setEnabled(false);
		txtEscuela.setEnabled(false);
		txtCarrera.setEnabled(false);
		txtFono.setEnabled(false);
		txtDirec.setEnabled(false);
		btnBuscar.setEnabled(false);
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
			String fecha = leerFecha();
			int codEsc = leerEscuela();
			String carrera = leerCarrera();
			int fono = leerFono();
			String direc = leerDirec();
			
			if (codigo==null||dni==null||nom==null||ape==null||fecha==null||
					codEsc==-1||carrera==null||fono==-1||direc==null) {
				return;
			}
			
			Alumno a = new Alumno();
			a.setCodigo(codigo);
			a.setDni(dni);
			a.setNombre(nom);
			a.setApellido(ape);
			a.setFecha(fecha);
			a.setCodEscuela(codEsc);
			a.setCarrera(carrera);
			a.setFono(fono);
			a.setDireccion(direc);
			
			GestionAlumno ga = new GestionAlumno();
			int ok = ga.registrar(a);
			if (ok==0) {
				alerta("Error al registrar alumno");
			} else {
				alerta("Alumno "+a.getApellido()+" registrado correctamente");
				listarAlumno();
			}			
		}
		if (opcion == 2) {	// consultar
			alerta("Para consultar, ingresar codigo de alumno y clickear al boton Buscar Alumno");
		}
		if (opcion == 3) {
			String codigo = leerCodigo();
			String nom = leerNom();
			String ape = leerApe();
			int codEsc = leerEscuela();
			String carrera = leerCarrera();
			int fono = leerFono();
			String direc = leerDirec();
			
			if (codigo==null||nom==null||ape==null||codEsc==-1||carrera==null||fono==-1||direc==null) {
				return;
			}
			
			Alumno a = new Alumno();
			a.setCodigo(codigo);
			a.setNombre(nom);
			a.setApellido(ape);
			a.setCodEscuela(codEsc);
			a.setCarrera(carrera);
			a.setFono(fono);
			a.setDireccion(direc);
			
			GestionAlumno ga = new GestionAlumno();
			int ok = ga.actualizar(a);
			if (ok == 0) {
				alerta("Error al encontrar curso");
			} else {
				alerta("Alumno "+a.getApellido()+" actualizado");
				listarAlumno();
			}
		}
		if (opcion == 4) {
			String codigo = leerCodigo();
			if (codigo == null) {
				return;
			}
			GestionAlumno ga = new GestionAlumno();
			int ok = ga.eliminar(codigo);
			if (ok == 0) {
				alerta("Error al deshabilitar alumno\nEl alumno ingresado no existe");
			} else {
				alerta("Alumno "+codigo+" deshabilitado");
				txtCodigo.setText("");
				ArrayList<Alumno> lista = ga.listado();
				if (lista == null) {
					return;
				}
				listarAlumno();
			}
		}
		if (opcion == 5) {
			String codigo = leerCodigo();
			if (codigo == null) {
				return;
			}
			GestionAlumno ga = new GestionAlumno();
			int ok = ga.habilitar(codigo);
			if (ok == 0) {
				alerta("Error al habilitar alumno\nEl alumno ingresado no existe");
			} else {
				alerta("Alumno "+codigo+" habilitado");
				txtCodigo.setText("");
				ArrayList<Alumno> lista = ga.listado();
				if (lista == null) {
					return;
				}
				listarAlumno();
			}
		}
	}
	
	void obtenerAlumno() {
		String codigo = leerCodigo();
		Alumno a = new GestionAlumno().buscar(codigo);
		if (codigo==null) {
			return;
		}
		if (a==null) {
			alerta("El codigo de alumno no existe");
		} else {
			txtDni.setText(a.getDni());
			txtNom.setText(a.getNombre());
			txtApe.setText(a.getApellido());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				txtFecha.setDate(sdf.parse(a.getFecha()));
			} catch (ParseException msg) {
				alerta("Error al leer fecha\n"+msg.getMessage());
			}
			//date = new SimpleDateFormat("d MMM yyyy").parse((String) a.getFecha().toString());			
			txtEscuela.setText(a.getCodEscuela()+"");
			txtCarrera.setText(a.getCarrera());
			txtFono.setText(a.getFono()+"");
			txtDirec.setText(a.getDireccion());
			
			txtCodigo.setEnabled(true);
			txtCodigo.requestFocus();
			txtDni.setEnabled(true);
			txtNom.setEnabled(true);
			txtApe.setEnabled(true);
			txtFecha.setEnabled(true);
			txtEscuela.setEnabled(true);
			txtCarrera.setEnabled(true);
			txtFono.setEnabled(true);
			txtDirec.setEnabled(true);
		}
	}
	
	void listarAlumno() {
		GestionAlumno ga = new GestionAlumno();
		ArrayList<EstadosAlumnos> lista = ga.lista();
		if (lista==null) {
			alerta("Lista de alumnos vacia");
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
	
	String leerCarrera() {
		if (txtCarrera.getText().equals("")) {
			alerta("Ingrese carrera");
			return null;
		}
		if (!txtCarrera.getText().matches("[[A-Za-z·ÈÌÛ˙Ò—¡…Õ”⁄]+(\\s[A-Za-z·ÈÌÛ˙Ò—¡…Õ”⁄]+)*]{2,30}")) {
			alerta("Carrera no valida\n\nSolo acepta letras, 2 min y 30 max.");
			return null;
		}
		try {
			return txtCarrera.getText();
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
	
	int leerEscuela() {
		if(txtEscuela.getText().equals("")) {
			alerta("Ingrese codigo de escuela");
			return -1;
		}
		if(!txtEscuela.getText().matches("[0-9]+")) {
			alerta("Codigo de escuela no v·lido\n\nSolo acepta numeros enteros");
			return -1;
		}
		try {
			return Integer.parseInt(txtEscuela.getText());
		} catch (NumberFormatException e) {
			alerta("Error\n"+e.getMessage());
			return -1;
		}
	}
	
	int leerFono() {
		if(txtFono.getText().equals("")) {
			alerta("Ingrese telÈfono");
			return -1;
		}
		if(!txtFono.getText().matches("[0-9]{9}")) {
			alerta("Telefono no v·lido\n\nSolo son v·lidos 9 dÌgitos");
			return -1;
		}
		try {
			return Integer.parseInt(txtFono.getText());
		} catch (NumberFormatException e) {
			alerta("Error\n"+e.getMessage());
			return -1;
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
	
	String leerCodigo() {
		if (txtCodigo.getText().equals("")) {
			alerta("Ingrese codigo");
			return null;
		}
		if (!txtCodigo.getText().matches("[A]{1}[0-9]{3}")) {
			alerta("Codigo no v·lido\n\nSolo Acepta letra 'A' seguido de 3 numeros");
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
