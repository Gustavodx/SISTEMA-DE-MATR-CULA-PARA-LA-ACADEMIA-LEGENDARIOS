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

import mantenimientos.GestionCurso;
import mantenimientos.GestionEmpleado;
import mantenimientos.GestionEscuela;
import model.Curso;
import model.Empleado;
import model.Escuela;
import model.ListarCursos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FrmMantenimientoCurso extends JInternalFrame {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtCreditos;
	private JTextField txtCiclo;
	private JTextField txtHoras;
	
	DefaultTableModel modelo = new DefaultTableModel();
	private JComboBox cboEscuela;
	private JComboBox cboOperaciones;
	private JButton btnSalir;
	private JLabel lblNewLabel_7;
	private JTextField txtCapacidad;
	private JButton btnAgregarDatos;
	private JButton btnProcesar;
	private JTable tblSalida;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMantenimientoCurso frame = new FrmMantenimientoCurso();
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
	public FrmMantenimientoCurso() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Mantenimiento Cursos");
		setBounds(100, 100, 845, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Codigo Curso:");
		lblNewLabel.setBounds(30, 22, 81, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre Curso:");
		lblNewLabel_1.setBounds(30, 47, 94, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Creditos:");
		lblNewLabel_2.setBounds(30, 72, 81, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Ciclo:");
		lblNewLabel_3.setBounds(30, 97, 81, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Total Horas:");
		lblNewLabel_4.setBounds(30, 122, 81, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Nombre Escuela:");
		lblNewLabel_5.setBounds(30, 147, 124, 14);
		contentPane.add(lblNewLabel_5);
		
		txtCodigo = new JTextField();
		txtCodigo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtCodigo.getText().length() > 3) {
					e.consume();
				}
			}
		});
		txtCodigo.setBounds(134, 19, 86, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtNombre.getText().length() > 29) {
					e.consume();
				}
			}
		});
		txtNombre.setBounds(134, 44, 218, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtCreditos = new JTextField();
		txtCreditos.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char tecla = e.getKeyChar();
				if (tecla < '0' || tecla > '9') {
					e.consume();
				}
			}
		});
		txtCreditos.setBounds(134, 69, 86, 20);
		contentPane.add(txtCreditos);
		txtCreditos.setColumns(10);
		
		txtCiclo = new JTextField();
		txtCiclo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char tecla = e.getKeyChar();
				if (tecla < '0' || tecla > '9') {
					e.consume();
				}
			}
		});
		txtCiclo.setBounds(134, 94, 86, 20);
		contentPane.add(txtCiclo);
		txtCiclo.setColumns(10);
		
		txtHoras = new JTextField();
		txtHoras.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char tecla = e.getKeyChar();
				if (tecla < '0' || tecla > '9') {
					e.consume();
				}
			}
		});
		txtHoras.setBounds(134, 119, 86, 20);
		contentPane.add(txtHoras);
		txtHoras.setColumns(10);
		
		cboEscuela = new JComboBox();
		cboEscuela.setEnabled(false);
		cboEscuela.setBounds(134, 145, 188, 18);
		contentPane.add(cboEscuela);
		
		cboOperaciones = new JComboBox();
		cboOperaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operacionSeleccionada();
			}
		});
		cboOperaciones.setModel(new DefaultComboBoxModel(new String[] {"Seleccione Operacion", "Registrar", "Consultar", "Actualizar", "Deshabilitar Cursos", "Habilitar Cursos"}));
		cboOperaciones.setBounds(377, 18, 157, 22);
		contentPane.add(cboOperaciones);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				procesar();
			}
		});
		btnProcesar.setBounds(560, 18, 135, 35);
		contentPane.add(btnProcesar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		btnLimpiar.setBounds(560, 63, 135, 35);
		contentPane.add(btnLimpiar);		
		txtCodigo.setEnabled(false);
		txtNombre.setEnabled(false);
		txtCreditos.setEnabled(false);
		txtCiclo.setEnabled(false);
		txtHoras.setEnabled(false);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(560, 118, 135, 23);
		contentPane.add(btnSalir);
		
		lblNewLabel_7 = new JLabel("Capacidad:");
		lblNewLabel_7.setBounds(236, 72, 67, 14);
		contentPane.add(lblNewLabel_7);
		
		txtCapacidad = new JTextField();
		txtCapacidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char tecla = e.getKeyChar();
				if (tecla < '0' || tecla > '9') {
					e.consume();
				}
			}
		});
		txtCapacidad.setEnabled(false);
		txtCapacidad.setBounds(313, 69, 86, 20);
		contentPane.add(txtCapacidad);
		txtCapacidad.setColumns(10);
		
		btnAgregarDatos = new JButton("Buscar Curso");
		btnAgregarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				obtenerCurso();
			}
		});
		btnAgregarDatos.setBounds(230, 18, 122, 23);
		contentPane.add(btnAgregarDatos);
		btnAgregarDatos.setEnabled(false);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 185, 809, 265);
		contentPane.add(scrollPane);
		
		tblSalida = new JTable();
		tblSalida.setModel(modelo);
		modelo.addColumn("CODIGO");
		modelo.addColumn("CURSO");
		modelo.addColumn("CREDITOS");
		modelo.addColumn("CICLO");
		modelo.addColumn("TOTAL HORAS");
		modelo.addColumn("ESCUELA");
		modelo.addColumn("CAPACIDAD");
		tblSalida.getColumnModel().getColumn(1).setPreferredWidth(200);
		tblSalida.getColumnModel().getColumn(3).setPreferredWidth(30);
		tblSalida.getColumnModel().getColumn(4).setPreferredWidth(50);
		tblSalida.getColumnModel().getColumn(2).setPreferredWidth(40);
		tblSalida.getColumnModel().getColumn(6).setPreferredWidth(40);
		scrollPane.setViewportView(tblSalida);
		listarCurso();
		llenaCombo();
	}
	
	void operacionSeleccionada() {
		int opcion = cboOperaciones.getSelectedIndex();
		switch (opcion) {
		case 1:	// registrar
			txtCodigo.setEnabled(true);
			txtCodigo.requestFocus();
			txtNombre.setEnabled(true);
			txtCreditos.setEnabled(true);
			txtCiclo.setEnabled(true);
			txtHoras.setEnabled(true);
			txtCapacidad.setEnabled(true);
			cboEscuela.setEnabled(true);
			btnAgregarDatos.setEnabled(false);
			btnProcesar.setEnabled(true);
			break;
		case 2:	// consultar
			txtCodigo.setEnabled(true);
			txtCodigo.requestFocus();
			txtNombre.setEnabled(false);
			txtCreditos.setEnabled(false);
			txtCiclo.setEnabled(false);
			txtHoras.setEnabled(false);
			cboEscuela.setEnabled(false);
			txtCapacidad.setEnabled(false);
			btnAgregarDatos.setEnabled(true);
			btnProcesar.setEnabled(false);
			break;
		case 3:	// actualizar
			txtCodigo.setEnabled(true);
			txtCodigo.requestFocus();
			txtNombre.setEnabled(true);
			txtCreditos.setEnabled(true);
			txtCiclo.setEnabled(true);
			txtHoras.setEnabled(true);
			cboEscuela.setEnabled(true);
			btnAgregarDatos.setEnabled(true);
			txtCapacidad.setEnabled(true);
			btnAgregarDatos.setEnabled(false);
			btnProcesar.setEnabled(true);
			break;
		case 4:	// eliminar
			txtCodigo.setEnabled(true);
			txtCodigo.requestFocus();
			txtNombre.setEnabled(false);
			txtCreditos.setEnabled(false);
			txtCiclo.setEnabled(false);
			txtHoras.setEnabled(false);
			cboEscuela.setEnabled(false);
			btnAgregarDatos.setEnabled(false);
			txtCapacidad.setEnabled(false);
			btnProcesar.setEnabled(true);
			break;
		case 5:	// habilitar
			txtCodigo.setEnabled(true);
			txtCodigo.requestFocus();
			txtNombre.setEnabled(false);
			txtCreditos.setEnabled(false);
			txtCiclo.setEnabled(false);
			txtHoras.setEnabled(false);
			cboEscuela.setEnabled(false);
			btnAgregarDatos.setEnabled(false);
			txtCapacidad.setEnabled(false);
			btnProcesar.setEnabled(true);
			break;
		default:
			break;
		}
	}
	
	void limpiar() {
		txtCodigo.setText("");
		txtNombre.setText("");
		txtCreditos.setText("");
		txtCiclo.setText("");
		txtHoras.setText("");
		cboEscuela.setSelectedIndex(0);
		txtCapacidad.setText("");
		txtCodigo.setEnabled(false);
		txtNombre.setEnabled(false);
		txtCreditos.setEnabled(false);
		txtCiclo.setEnabled(false);
		txtHoras.setEnabled(false);
		cboEscuela.setEnabled(false);
		btnAgregarDatos.setEnabled(false);
		txtCapacidad.setEnabled(false);
		cboOperaciones.setSelectedIndex(0);
	}
	
	void procesar() {
		int opcion = cboOperaciones.getSelectedIndex();
		if (opcion == 0) {
			alerta("Seleccione operación a realizar");
		}
		if (opcion == 1) { // registrar
			String codigo = leerCodigo();
			String nombreCurso = leerNombreCurso();
			int creditos = leerCreditos();
			int ciclo = leerCiclo();
			int cantHoras = leerCantHoras();
			int codEscuela = leerCodEscuela();
			int capacidad = leerCapacidad();
			int estado = leerEstado();
			
			if (codigo==null||nombreCurso==null||creditos==-1||ciclo==-1||cantHoras==-1||codEscuela==-1|| capacidad == -1||estado==-1) {
				return;
			}
			
			Curso c = new Curso();
			c.setCodigo(codigo);
			c.setNombre(nombreCurso);
			c.setCreditos(creditos);
			c.setCiclo(ciclo);
			c.setCanthoras(cantHoras);
			c.setCodEscuela(codEscuela);
			c.setCapacidad(capacidad);
			c.setEstado(estado);
			
			GestionCurso gc = new GestionCurso();
			int ok = gc.registrar(c);
			
			if (ok == 0) {
				alerta("Error al registrar curso");
			} else {
				alerta("Curso "+c.getNombre()+" registrado correctamente");
				listarCurso();
			}
		}
		if (opcion == 2) {	// consultar
			alerta("Para consultar, ingresar codigo de curso y clickear al boton Buscar Curso");
		}
		if (opcion == 3) {	// actualizar
			String codigo = leerCodigo();
			String nombreCurso = leerNombreCurso();
			int creditos = leerCreditos();
			int ciclo = leerCiclo();
			int cantHoras = leerCantHoras();
			int codEscuela = leerCodEscuela();
			int capacidad = leerCapacidad();
			int estado = leerEstado();
			
			if (codigo==null||nombreCurso==null||creditos==-1||ciclo==-1||cantHoras==-1||codEscuela==-1|| capacidad == -1||estado==-1) {
				return;
			}
			
			Curso c = new Curso();
			c.setCodigo(codigo);
			c.setNombre(nombreCurso);
			c.setCreditos(creditos);
			c.setCiclo(ciclo);
			c.setCanthoras(cantHoras);
			c.setCodEscuela(codEscuela);
			c.setCapacidad(capacidad);
			c.setEstado(estado);
			
			GestionCurso gc = new GestionCurso();
			int ok = gc.actualizar(c);
			if (ok == 0) {
				alerta("Error al actualizar curso");
			} else {
				alerta("Curso "+c.getNombre()+" actualizado");
				listarCurso();
			}			
		}
		/*if (opcion == 4) {	// listado
			GestionCurso gc = new GestionCurso();
			ArrayList<ListarCursos> lista = gc.lista();
			if (lista == null) {
				alerta("Lista de cursos vacía");
				return;
			}
			listarCurso();
		}*/
		if (opcion == 4) { // Deshabilitar
			String codigo = leerCodigo();
			if (codigo == null) {
				return;
			}
			GestionCurso gc = new GestionCurso();
			int ok = gc.eliminar(codigo);
			if (ok == 0) {
				alerta("Error al deshabilitar curso\nEl codigo ingresado no existe");
			}
			else {
				alerta("Curso "+codigo+" deshabilitado");
				txtCodigo.setText("");
				ArrayList<Curso> lista = gc.listado();
				if (lista == null) {
					return;
				}
				listarCurso();
			}
		}
		if (opcion == 5) {	// habilitar
			String codigo = leerCodigo();
			if (codigo == null) {
				return;
			}
			GestionCurso gc = new GestionCurso();
			int ok = gc.habilitar(codigo);
			if (ok == 0) {
				alerta("Error al habilitar curso\nEl codigo ingresado no existe");
			}
			else {
				alerta("Curso "+codigo+" habilitado");
				txtCodigo.setText("");
			}
			ArrayList<Curso> lista = gc.listado();
			if (lista == null) {
				return;
			}
			listarCurso();
		}
	}
	
	void obtenerCurso() {
		String codigo = leerCodigo();
		Curso c = new GestionCurso().buscar(codigo);
		if (codigo==null) {
			return;
		}
		if (c == null) {
			alerta("El codigo de curso no existe");
		}
		else {
				txtCreditos.setText(c.getCreditos()+"");
				txtCiclo.setText(c.getCiclo()+"");
				txtHoras.setText(c.getCanthoras()+"");
				txtCapacidad.setText(c.getCapacidad()+"");
				cboEscuela.setSelectedIndex(c.getCodEscuela());
				txtNombre.setText(c.getNombre());
				txtCodigo.setEnabled(true);
				txtCodigo.requestFocus();
				txtNombre.setEnabled(true);
				txtCreditos.setEnabled(true);
				txtCiclo.setEnabled(true);
				txtHoras.setEnabled(true);
				cboEscuela.setEnabled(true);
				txtCapacidad.setEnabled(true);
		}
	}
	
	void listarCurso() {
		GestionCurso gc = new GestionCurso();
		ArrayList<ListarCursos> lista = gc.lista();
		if (lista == null) {
			alerta("Lista de cursos vacía");
			return;
		} else {
			modelo.setRowCount(0);
			for (ListarCursos c : lista) {				
				Object datos[] = {c.getCodCurso(),c.getNombreCurso(),c.getCreditos(),c.getCiclo(),
						c.getCantHoras(),c.getNomreEscuela(),c.getCapacidad()};
				modelo.addRow(datos);
			}
		}
	}
	private int leerCapacidad() {
		if(txtCapacidad.getText().equals("")) {
			alerta("Ingrese capacidad");
			return -1;	// valor de control en caso de error
		}
		
		if (!txtCapacidad.getText().matches("[[1-9]{1}([0-9]+)*]{1,3}")) {
			alerta("El valor de capacidad solo acepta números enteros\n3 digitos max");
			return -1;
		}
		
		try {
			return Integer.parseInt(txtCapacidad.getText());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			alerta("Valor de capacidad NO VÁLIDO\n\nSólo acepta números\n" + e.getMessage());
			return -1;
		}
	}
	void llenaCombo() {
		GestionEscuela ge = new GestionEscuela();
		ArrayList<Escuela> lista = ge.listado();
		if (lista == null) {
			alerta("Lista de escuelas vacía");
			return;
		}
		cboEscuela.addItem("Seleccione Escuela");
		for (Escuela e : lista) {
			cboEscuela.addItem(e.getCodEscuela()+"-"+e.getNomEscuela());
		}
	}
	
	int leerCodEscuela() {
		if(cboEscuela.getSelectedIndex() == 0){
			alerta("Seleccione escuela");
			return -1;
		}
		return cboEscuela.getSelectedIndex();
	}
	
	int leerCreditos() {
		if(txtCreditos.getText().equals("")) {
			alerta("Ingrese creditos");
			return -1;	// valor de control en caso de error
		}
		
		if (!txtCreditos.getText().matches("[[1-9]{1}([0-9]+)*]{1,3}")) {
			alerta("El valor de creditos solo acepta números enteros\n3 digitos max");
			return -1;
		}
		
		try {
			return Integer.parseInt(txtCreditos.getText());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			alerta("Valor de creditos NO VÁLIDO\n\nSólo acepta números\n" + e.getMessage());
			return -1;
		}
	}
	
	int leerCantHoras() {
		if(txtHoras.getText().equals("")) {
			alerta("Ingrese horas del curso");
			return -1;	// valor de control en caso de error
		}
		
		if (!txtHoras.getText().matches("[[1-9]{1}([0-9]+)*]{1,3}")) {
			alerta("El valor de horas del curso solo acepta números enteros\n3 digitos max");
			return -1;
		}
		
		try {
			return Integer.parseInt(txtHoras.getText());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			alerta("Valor de horas del curso NO VÁLIDO\n\nSólo acepta números\n" + e.getMessage());
			return -1;
		}
	}
	
	int leerCiclo() {
		if(txtCiclo.getText().equals("")) {
			alerta("Ingrese ciclo");
			return -1;	// valor de control en caso de error
		}
		
		if (!txtCiclo.getText().matches("[[1-9]{1}([0-9]+)*]{1,2}")) {
			alerta("El valor de ciclo solo acepta números enteros\n2 digitos max");
			return -1;
		}
		
		try {
			return Integer.parseInt(txtCiclo.getText());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			alerta("Valor de ciclo NO VÁLIDO\n\nSólo acepta números\n" + e.getMessage());
			return -1;
		}
	}
	
	String leerCodigo() {
		if (txtCodigo.getText().equals("")) {
			alerta("Ingrese codigo");
			return null;
		}
		if (!txtCodigo.getText().matches("[C]{1}[0-9]{3}")) {
			alerta("Codigo no válido\n\nSolo Acepta letra 'C' seguido de 3 numeros");
			return null;
		}
		try {
			return txtCodigo.getText();
		} catch (NumberFormatException e) {
			alerta("Error\n"+e.getMessage());
			return null;
		}
	}

	String leerNombreCurso() {
		if (txtNombre.getText().equals("")) {
			alerta("Ingrese nombre");
			return null;
		}
		if (!txtNombre.getText().matches("[[A-Za-záéíóúñÑÁÉÍÓÚ]+(\\s[A-Za-záéíóúñÑÁÉÍÓÚ]+)*]{2,40}")) {
			alerta("Nombre no válido\n\nSolo acepta letras, 2 min y 30 max.");
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
		JOptionPane.showMessageDialog(this, msg);
	}
	
}
