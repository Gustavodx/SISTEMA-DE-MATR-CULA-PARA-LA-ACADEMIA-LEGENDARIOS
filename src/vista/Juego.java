package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hilo.HiloCarro;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Juego extends JInternalFrame {

	private JPanel contentPane;
	private JLabel lblCarro01;
	private JLabel lblCarro02;
	private JLabel lblPista;
	private JButton btnIniciar;
	private JButton btnReiniciar;
	
	public static boolean activo = true;
	public static JLabel lblMeta;
	
	public static boolean isActivo() {
		return activo;
	}
	
	public static void setActivo(boolean cambia) {
		activo = cambia;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Juego frame = new Juego();
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
	public Juego() {
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);

		setTitle("Carrera\r\n");
		setBounds(100, 100, 675, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblCarro01 = new JLabel("");
			lblCarro01.setIcon(new ImageIcon(Juego.class.getResource("/img/cars001.png")));
			lblCarro01.setBounds(10, 35, 128, 57);
			contentPane.add(lblCarro01);
		}
		{
			lblCarro02 = new JLabel("");
			lblCarro02.setIcon(new ImageIcon(Juego.class.getResource("/img/cars002.png")));
			lblCarro02.setBounds(10, 145, 128, 57);
			contentPane.add(lblCarro02);
		}
		{
			lblMeta = new JLabel("");
			lblMeta.setIcon(new ImageIcon(Juego.class.getResource("/img/meta.png")));
			lblMeta.setBounds(586, 11, 46, 207);
			contentPane.add(lblMeta);
		}
		{
			lblPista = new JLabel("");
			lblPista.setIcon(new ImageIcon(Juego.class.getResource("/img/pista.jpg")));
			lblPista.setBounds(-102, 0, 761, 228);
			contentPane.add(lblPista);
		}
		{
			btnIniciar = new JButton("Iniciar");
			btnIniciar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnIniciar(e);
				}
			});
			btnIniciar.setBackground(new Color(0, 255, 0));
			btnIniciar.setIcon(new ImageIcon(Juego.class.getResource("/img/star.png")));
			btnIniciar.setBounds(159, 247, 128, 33);
			contentPane.add(btnIniciar);
		}
		{
			btnReiniciar = new JButton("Reiniciar");
			btnReiniciar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actionPerformedBtnReiniciar(e);
				}
			});
			btnReiniciar.setBackground(new Color(255, 0, 0));
			btnReiniciar.setIcon(new ImageIcon(Juego.class.getResource("/img/update.png")));
			btnReiniciar.setBounds(349, 247, 128, 33);
			contentPane.add(btnReiniciar);
		}
	}

	protected void actionPerformedBtnIniciar(ActionEvent e) {
		
		HiloCarro cars1 = new HiloCarro(lblCarro01, "Carro Rojo");
		HiloCarro cars2 = new HiloCarro(lblCarro02, "Carro Azul");
		cars1.start();
		cars2.start();
	}
	
	protected void actionPerformedBtnReiniciar(ActionEvent e) {
		
		lblCarro01.setBounds(10, 35, 128, 57);
		lblCarro02.setBounds(10, 145, 128, 57);
		Juego.setActivo(true);
	}
}


















