package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hilo.HiloCerrar;
import mantenimientos.GestionEmpleado;
//import mantenimientos.GestionEmpleado;
import model.Empleado;
import vista.FrmPreLoader;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class FrmLogin extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtUsuario;
	public static JLabel lblMensaje;
	private JLabel lblContrasena;
	private JLabel lblUsuario;
	private JButton btnIngresar;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					FrmLogin frame = new FrmLogin();
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
	public FrmLogin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmLogin.class.getResource("/img/profesor (2).png")));
		setTitle("Iniciar Sesion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 373, 512);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(this);
		btnIngresar.setBackground(new Color(50, 205, 50));
		btnIngresar.setIcon(new ImageIcon(FrmLogin.class.getResource("/img/iniciar-sesion.png")));
		btnIngresar.setBounds(30, 407, 116, 30);
		contentPane.add(btnIngresar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBackground(new Color(255, 0, 0));
		btnCerrar.setIcon(new ImageIcon(FrmLogin.class.getResource("/img/cerrar-sesion.png")));
		btnCerrar.setBounds(191, 407, 116, 30);
		contentPane.add(btnCerrar);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(101, 240, 170, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		lblUsuario = new JLabel("");
		lblUsuario.setIcon(new ImageIcon(FrmLogin.class.getResource("/img/usuario.png")));
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUsuario.setBounds(56, 224, 35, 51);
		contentPane.add(lblUsuario);
		
		lblContrasena = new JLabel("");
		lblContrasena.setIcon(new ImageIcon(FrmLogin.class.getResource("/img/bloquear.png")));
		lblContrasena.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblContrasena.setBounds(56, 303, 35, 39);
		contentPane.add(lblContrasena);
		
		JLabel lblNewLabel_1 = new JLabel("BIENVENIDO");
		lblNewLabel_1.setFont(new Font("Eras Bold ITC", Font.BOLD, 21));
		lblNewLabel_1.setBounds(101, 11, 162, 30);
		contentPane.add(lblNewLabel_1);
		
		lblMensaje = new JLabel("");
		lblMensaje.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblMensaje.setBounds(56, 199, 251, 14);
		contentPane.add(lblMensaje);
		
		txtClave = new JPasswordField();
		txtClave.setBounds(101, 313, 170, 20);
		contentPane.add(txtClave);
		{
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(FrmLogin.class.getResource("/img/user_login.png")));
			lblNewLabel.setBounds(118, 80, 128, 114);
			contentPane.add(lblNewLabel);
		}
		
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		iniciarTiempo();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	
    void iniciarTiempo() {		
		HiloCerrar hilo = new HiloCerrar(this);
		hilo.start();
	}
	
	public static Empleado e = new Empleado();
	private JPasswordField txtClave;
	private JLabel lblNewLabel;
	
	void ingresarPrincipal() {
		String usuario,clave;
		usuario = leerUsuario();
		clave = leerClave();
	
	//proceso
	GestionEmpleado ge = new GestionEmpleado();
	e = ge.validoAcceso(usuario, clave);
	
	//salida 
	if(e == null) {
		txtUsuario.setText("");
		txtClave.setText("");
		txtUsuario.requestFocus();
	}else {
		
		FrmPreLoader v = new FrmPreLoader();
		v.setVisible(true);
		FrmPrincipal fp = new FrmPrincipal();
		//fp.setVisible(true);
		fp.setTitle("Bienvenido:  " + e.getNombre() +  "  " + e.getApellido() + "Fecha Actual:  " + obtenerFecha());
		//
	
		//
		dispose();
	}
   }
	
	private String obtenerFecha(){
		return new SimpleDateFormat("yyyy/MM/dd").format(new Date());
	}
	
	protected void actionPerformedBtnIngresar(ActionEvent e) {
		ingresarPrincipal();
	}


	protected void actionPerformedBtnCerrar(ActionEvent e) {
		System.exit(0);
	}
	
	private String leerUsuario(){
		return txtUsuario.getText();
	}
	
	private String leerClave(){
		return txtClave.getText();
	}
}
