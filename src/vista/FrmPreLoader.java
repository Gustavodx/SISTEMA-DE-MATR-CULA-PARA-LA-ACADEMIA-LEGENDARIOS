package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hilo.HiloBarra;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollBar;
import javax.swing.JProgressBar;
import java.awt.Color;

public class FrmPreLoader extends JFrame {

	private JPanel contentPane;
	public static JLabel lblMensaje;
	public static JProgressBar prbCarga;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPreLoader frame = new FrmPreLoader();
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
	public FrmPreLoader() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 314, 130);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMensajes = new JLabel("El sistema está cargando...");
		lblMensajes.setForeground(Color.BLACK);
		lblMensajes.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMensajes.setBounds(66, 11, 190, 14);
		contentPane.add(lblMensajes);
		
		prbCarga = new JProgressBar();
		prbCarga.setForeground(Color.LIGHT_GRAY);
		prbCarga.setStringPainted(true);
		prbCarga.setBounds(0, 36, 298, 21);
		contentPane.add(prbCarga);
		
		lblMensaje = new JLabel("");
		lblMensaje.setBounds(10, 68, 278, 14);
		contentPane.add(lblMensaje);
		iniciarBarra();
		
		this.setLocationRelativeTo(null); //para centrar
	}
	void iniciarBarra() {
		HiloBarra h = new HiloBarra(this);
		h.start();
	}
	
	
}
