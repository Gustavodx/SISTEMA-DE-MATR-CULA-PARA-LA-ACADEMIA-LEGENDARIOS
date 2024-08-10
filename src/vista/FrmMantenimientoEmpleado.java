package vista;

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
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import mantenimientos.GestionEmpleado;
import model.Empleado;
import model.ListarEmpleados;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JPasswordField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FrmMantenimientoEmpleado extends JInternalFrame {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtUsuario;
	private JTextField txtTelefono;
	
	DefaultTableModel modelo = new DefaultTableModel();
	private JPasswordField txtClave;
	private JDateChooser txtFecha;
	private JComboBox cboOperaciones;
	private JTable tblSalida;
	private JScrollPane scrollPane;
	private JButton btnProcesar;
	private JButton btnBuscar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMantenimientoEmpleado frame = new FrmMantenimientoEmpleado();
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
	public FrmMantenimientoEmpleado() {
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setTitle("Mantenimiento Empleados");
		setBounds(100, 100, 790, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Codigo Empleado:");
		lblNewLabel.setBounds(20, 14, 112, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblDniEmpleado = new JLabel("DNI Empleado:");
		lblDniEmpleado.setBounds(20, 39, 112, 14);
		contentPane.add(lblDniEmpleado);
		
		JLabel lblNombreEmpleado = new JLabel("Nombre Empleado:");
		lblNombreEmpleado.setBounds(20, 64, 112, 14);
		contentPane.add(lblNombreEmpleado);
		
		JLabel lblApellidoEmpleado = new JLabel("Apellido Empleado:");
		lblApellidoEmpleado.setBounds(20, 89, 112, 14);
		contentPane.add(lblApellidoEmpleado);
		
		JLabel lblUsuario = new JLabel("Usuario Empleado:");
		lblUsuario.setBounds(20, 114, 112, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblClave = new JLabel("Clave:");
		lblClave.setBounds(20, 139, 112, 14);
		contentPane.add(lblClave);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(20, 164, 112, 14);
		contentPane.add(lblTelefono);
		
		JLabel lblFechaIngreso = new JLabel("Fecha Ingreso:");
		lblFechaIngreso.setBounds(20, 189, 112, 14);
		contentPane.add(lblFechaIngreso);		
		cboOperaciones = new JComboBox();
		cboOperaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operacionSeleccionada();
			}
		});
		cboOperaciones.setModel(new DefaultComboBoxModel(new String[] {"Seleccione Operacion", "Registrar", "Consultar", "Actualizar", "Deshabilitar Empleado", "Habilitar Empleado"}));
		cboOperaciones.setBounds(436, 10, 160, 22);
		contentPane.add(cboOperaciones);
		
		txtCodigo = new JTextField();
		txtCodigo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtCodigo.getText().length() > 3) {
					e.consume();
				}
			}
		});
		txtCodigo.setBounds(151, 11, 86, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtDni = new JTextField();
		txtDni.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char tecla = e.getKeyChar();
				if (txtDni.getText().length() > 7) {
					e.consume();
				}
				if(tecla < '0' || tecla > '9') {
					e.consume();
				}
			}
		});
		txtDni.setBounds(151, 36, 86, 20);
		contentPane.add(txtDni);
		txtDni.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtNombre.getText().length() > 29) {
					e.consume();
				}
			}
		});
		txtNombre.setBounds(151, 61, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtApellido.getText().length() > 29) {
					e.consume();
				}
			}
		});
		txtApellido.setBounds(151, 86, 86, 20);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtUsuario = new JTextField();
		txtUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtUsuario.getText().length() > 4) {
					e.consume();
				}
			}
		});
		txtUsuario.setBounds(151, 111, 86, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char tecla = e.getKeyChar();
				if (tecla < '0' || tecla > '9') {
					e.consume();
				}
				if (txtTelefono.getText().length() > 8) {
					e.consume();
				}
				
			}
		});
		txtTelefono.setBounds(151, 161, 86, 20);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtFecha = new JDateChooser();
		txtFecha.setBounds(151, 183, 123, 20);
		contentPane.add(txtFecha);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				procesar();
			}
		});
		btnProcesar.setBounds(629, 14, 112, 36);
		contentPane.add(btnProcesar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		btnLimpiar.setBounds(629, 64, 112, 36);
		contentPane.add(btnLimpiar);
		
		txtClave = new JPasswordField();
		txtClave.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtClave.getText().length() > 4) {
					e.consume();
				}
			}
		});
		txtClave.setBounds(151, 136, 86, 17);
		contentPane.add(txtClave);
		
		cboOperaciones.setSelectedIndex(0);
		txtCodigo.setEnabled(false);
		txtDni.setEnabled(false);
		txtNombre.setEnabled(false);
		txtApellido.setEnabled(false);
		txtUsuario.setEnabled(false);
		txtClave.setEnabled(false);
		txtTelefono.setEnabled(false);
		txtFecha.setEnabled(false);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 254, 754, 196);
		contentPane.add(scrollPane);
		
		tblSalida = new JTable();
		tblSalida.setModel(modelo);
		modelo.addColumn("CODIGO");
		modelo.addColumn("DNI");
		modelo.addColumn("EMPLEADO");
		modelo.addColumn("USUARIO");
		modelo.addColumn("CLAVE");
		modelo.addColumn("TELEFONO");
		modelo.addColumn("FECHA");
		tblSalida.getColumnModel().getColumn(3).setPreferredWidth(30);
		tblSalida.getColumnModel().getColumn(2).setPreferredWidth(150);
		tblSalida.getColumnModel().getColumn(0).setPreferredWidth(40);
		tblSalida.getColumnModel().getColumn(5).setPreferredWidth(40);
		tblSalida.getColumnModel().getColumn(4).setPreferredWidth(30);
		scrollPane.setViewportView(tblSalida);
		
		btnBuscar = new JButton("Buscar Empleado");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				obtenerEmpleado();
			}
		});
		btnBuscar.setBounds(247, 10, 144, 23);
		contentPane.add(btnBuscar);
		btnBuscar.setEnabled(false);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(629, 110, 112, 36);
		contentPane.add(btnSalir);
		
		listarEmpleado();
	}
	
	void procesar() {
		int opcion = cboOperaciones.getSelectedIndex();
		if (opcion == 0) {
			alerta("Seleccione operaciÛn a realizar");
		}
		if (opcion == 1) { // registrar
			String codigo = leerCodigo();
			String dni = leerDni();
			String nombre = leerNombre();
			String apellido = leerApellido();
			String usuario = leerUsuario();
			String clave = leerClave();
			String fono = leerTelefono();
			String fecha = leerFecha();
			
			if (codigo==null||dni==null||nombre==null||apellido==null||usuario==null||clave==null||fono==null||fecha==null) {
				return;
			}
			
			Empleado e = new Empleado();
			e.setCodigo(codigo);
			e.setDni(dni);
			e.setNombre(nombre);
			e.setApellido(apellido);
			e.setUsuario(usuario);
			e.setClave(clave);
			e.setTelefono(fono);
			e.setFecha(fecha);
						
			GestionEmpleado ge = new GestionEmpleado();
			int ok = ge.registrar(e);
			
			if (ok == 0) {
				alerta("Error al registrar empleado");
			} else {
				alerta("Empleado "+e.getNombre()+" "+e.getApellido()+" registrado correctamente");
				listarEmpleado();
			}
		}
		if (opcion == 2) {	// consultar
			alerta("Para consultar, ingresar codigo de empleado y clickear al boton Buscar Empleado");
		}
		if (opcion == 3) {	// actualizar
			String nombre,apellido,clave,telefono;
			String codigo;
			
			nombre = leerNombre();
			apellido = leerApellido();
			clave = leerClave();
			telefono = leerTelefono();
			codigo = leerCodigo();
			
			if (codigo==null||nombre==null||apellido==null||clave==null||telefono==null) {
				return;
			}
			
			Empleado e = new Empleado();
			e.setNombre(nombre);
			e.setApellido(apellido);
			e.setClave(clave);
			e.setTelefono(telefono);
			e.setCodigo(codigo);
			
			GestionEmpleado ge = new GestionEmpleado();
			int ok = ge.actualizar(e);
			if (ok == 0) {
				alerta("Error al actualizar empleado");
			} else {
				alerta("Empleado "+e.getNombre()+" "+e.getApellido()+" actualizado");
				listarEmpleado();
			}
		}
		if (opcion == 4) {	// Eliminar
			String codigo = leerCodigo();
			if (codigo == null) {
				return;
			}
			GestionEmpleado ge = new GestionEmpleado();
			int ok = ge.eliminar(codigo);
			if (ok == 0) {
				alerta("Error al deshabilitar empleado\nEl empleado ingresado no existe");
			} else {
				alerta("Empleado "+codigo+" deshabilitado");
				txtCodigo.setText("");
				ArrayList<Empleado> lista = ge.listado();
				if (lista == null) {
					return;
				}
				listarEmpleado();
			}
			
		}
		if (opcion == 5) { // Habilitar
			String codigo = leerCodigo();
			if (codigo == null) {
				return;
			}
			GestionEmpleado ge = new GestionEmpleado();
			int ok = ge.habilitar(codigo);
			if (ok == 0) {
				alerta("Error al habilitar\nEl codigo ingresado no existe");
			}
			else {
				alerta("Empleado "+codigo+" habilitado");
				txtCodigo.setText("");
				ArrayList<Empleado> lista = ge.listado();
				if (lista == null) {
					return;
				}
				listarEmpleado();
			}
		}
	}
	
	void obtenerEmpleado() {
		String codigo = leerCodigo();
		Empleado e = new GestionEmpleado().buscar(codigo);
		if (codigo == null) {
			return;
		}
		if (e==null) {
			alerta("El codigo de empleado no existe");
		} else {
			txtDni.setText(e.getDni());
			txtNombre.setText(e.getNombre());
			txtApellido.setText(e.getApellido());
			txtUsuario.setText(e.getUsuario());
			txtClave.setText(e.getClave());
			txtTelefono.setText(e.getTelefono());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				txtFecha.setDate(sdf.parse(e.getFecha()));
			} catch (ParseException msg) {
				alerta("Error al leer fecha\n"+msg.getMessage());
			}
			txtCodigo.setEnabled(true);
			txtCodigo.requestFocus();
			txtNombre.setEnabled(true);
			txtApellido.setEnabled(true);
			txtUsuario.setEnabled(true);
			txtClave.setEnabled(true);
			txtTelefono.setEnabled(true);
			txtFecha.setEnabled(true);
		}
	}
	
	void listarEmpleado() {
		GestionEmpleado ge = new GestionEmpleado();
		ArrayList<ListarEmpleados> lista = ge.lista();
		if (lista == null) {
			alerta("Lista de empleados vacia");
			return;
		} else {
			modelo.setRowCount(0);
			for (ListarEmpleados e : lista) {
				Object datos[] = {e.getCodigo(),e.getDni(),e.getNombre(),e.getUsuario(),e.getClave(),e.getFono(),e.getFecha()};
				modelo.addRow(datos);
			}
		}
	}
	
	void limpiar() {
		txtCodigo.setText("");
		txtDni.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		txtUsuario.setText("");
		txtClave.setText("");
		txtTelefono.setText("");
		txtFecha.setDate(new Date());
		//modelo.getDataVector().removeAllElements();
		//tblSalida.updateUI();
	}
	
	void operacionSeleccionada() {
		int opcion = cboOperaciones.getSelectedIndex();
		switch (opcion) {
		case 1:	// registrar
			txtCodigo.setEnabled(true);
			txtCodigo.requestFocus();
			txtDni.setEnabled(true);
			txtNombre.setEnabled(true);
			txtApellido.setEnabled(true);
			txtUsuario.setEnabled(true);
			txtClave.setEnabled(true);
			txtTelefono.setEnabled(true);
			txtFecha.setEnabled(true);
			txtFecha.setDate(new Date());
			btnBuscar.setEnabled(false);
			btnProcesar.setEnabled(true);
			break;
		case 2:	// consultar
			txtCodigo.setEnabled(true);
			txtCodigo.requestFocus();
			txtDni.setEnabled(false);
			txtNombre.setEnabled(false);
			txtApellido.setEnabled(false);
			txtUsuario.setEnabled(false);
			txtClave.setEnabled(false);
			txtTelefono.setEnabled(false);
			txtFecha.setEnabled(false);
			txtFecha.setDate(new Date());
			btnBuscar.setEnabled(true);
			btnProcesar.setEnabled(false);
			break;
		case 3:	// actualizar
			txtCodigo.setEnabled(true);
			txtCodigo.requestFocus();
			txtDni.setEnabled(false);
			txtNombre.setEnabled(true);
			txtApellido.setEnabled(true);
			txtUsuario.setEnabled(false);
			txtClave.setEnabled(true);
			txtTelefono.setEnabled(true);
			txtFecha.setEnabled(false);
			txtFecha.setDate(new Date());
			btnBuscar.setEnabled(false);
			btnProcesar.setEnabled(true);
			break;
		case 4:	// eliminar
			txtCodigo.setEnabled(true);
			txtCodigo.requestFocus();
			txtDni.setEnabled(false);
			txtNombre.setEnabled(false);
			txtApellido.setEnabled(false);
			txtUsuario.setEnabled(false);
			txtClave.setEnabled(false);
			txtTelefono.setEnabled(false);
			txtFecha.setEnabled(false);
			txtFecha.setDate(new Date());
			btnBuscar.setEnabled(false);
			btnProcesar.setEnabled(true);
			break;
		case 5:	// habilitar
			txtCodigo.setEnabled(true);
			txtCodigo.requestFocus();
			txtDni.setEnabled(false);
			txtNombre.setEnabled(false);
			txtApellido.setEnabled(false);
			txtUsuario.setEnabled(false);
			txtClave.setEnabled(false);
			txtTelefono.setEnabled(false);
			txtFecha.setEnabled(false);
			txtFecha.setDate(new Date());
			btnBuscar.setEnabled(false);
			btnProcesar.setEnabled(true);
			break;
		default:
			break;
		}
	}
	
	String leerTelefono() {
		if(txtTelefono.getText().equals("")) {
			alerta("Ingrese telÈfono");
			return null;
		}
		if(!txtTelefono.getText().matches("[0-9]{9}")) {
			alerta("Telefono no v·lido\n\nSolo son v·lidos 9 dÌgitos");
			return null;
		}
		try {
			return txtTelefono.getText();
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
			alerta("DNI no v·lido\n\nSolo Acepta n˙meros de 8 caracteres");
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
		if (!txtCodigo.getText().matches("[E]{1}[0-9]{3}")) {
			alerta("Codigo no v·lido\n\nSolo Acepta letra 'E' seguido de 3 numeros");
			return null;
		}
		try {
			return txtCodigo.getText();
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

	String leerClave() {
		if (txtClave.getText().equals("")) {
			alerta("Ingrese clave");
			return null;
		}
		if (!txtClave.getText().matches("[[A-Za-z·ÈÌÛ˙Ò—¡…Õ”⁄]+[0-9]]{5}")) {
			alerta("Clave no v·lida\n\nAcepta n˙meros y letras, max 5 caracteres");
			return null;
		}
		try {
			return txtClave.getText();
		} catch (NumberFormatException e) {
			alerta("Error\n"+e.getMessage());
			return null;
		}
	}

	String leerUsuario() {
		if (txtUsuario.getText().equals("")) {
			alerta("Ingrese usuario");
			return null;
		}
		if (!txtUsuario.getText().matches("[[A-Za-z·ÈÌÛ˙Ò—¡…Õ”⁄]+[0-9]]{5}")) {
			alerta("Usuario no v·lido\n\nSolo Acepta n˙meros y letras, max 5 caracteres");
			return null;
		}
		try {
			return txtUsuario.getText();
		} catch (NumberFormatException e) {
			alerta("Error\n"+e.getMessage());
			return null;
		}
	}

	String leerApellido() {
		if (txtApellido.getText().equals("")) {
			alerta("Ingrese apellido");
			return null;
		}
		if (!txtApellido.getText().matches("[[A-Za-z·ÈÌÛ˙Ò—¡…Õ”⁄]+(\\s[A-Za-z·ÈÌÛ˙Ò—¡…Õ”⁄]+)*]{2,30}")) {
			alerta("Apellido no v·lido\n\nSolo acepta letras, 2 min y 30 max.");
			return null;
		}
		try {
			return txtApellido.getText();
		} catch (NumberFormatException e) {
			alerta("Error\n"+e.getMessage());
			return null;
		}
	}

	String leerNombre() {
		if (txtNombre.getText().equals("")) {
			alerta("Ingrese nombre");
			return null;
		}
		if (!txtNombre.getText().matches("[[A-Za-z·ÈÌÛ˙Ò—¡…Õ”⁄]+(\\s[A-Za-z·ÈÌÛ˙Ò—¡…Õ”⁄]+)*]{2,30}")) {
			alerta("Nombre no v·lido\n\nSolo acepta letras, 2 min y 30 max.");
			return null;
		}
		try {
			return txtNombre.getText();
		} catch (NumberFormatException e) {
			alerta("Error\n"+e.getMessage());
			return null;
		}
	}
	
	int leerEstado() {
		/*Empleado e = new Empleado();
		int resultado = 1;
		if (resultado == e.getEstado()) {
			txtEstado.setText("Activo");
		} else {
			txtEstado.setText("Eliminado");
		}
		return Integer.parseInt(txtEstado.getText());*/
		return 1;
	}
	
	void alerta(String msg) {
		JOptionPane.showMessageDialog(this, msg,"Aviso",JOptionPane.INFORMATION_MESSAGE);
	}
}
