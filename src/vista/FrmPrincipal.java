package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JDesktopPane;
import java.awt.CardLayout;
import java.awt.Color;

public class FrmPrincipal extends JFrame {

	private JPanel contentPane;
	private JDesktopPane escritorio;
	private JMenu mnJuego;
	private JMenuItem mntmCarrera;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipal frame = new FrmPrincipal();
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
	public FrmPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmPrincipal.class.getResource("/img/profesor (2).png")));
		setTitle("Bienvenido");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 647, 419);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Sistema");
		mnNewMenu.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/system.png")));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Cerrar");
		mntmNewMenuItem.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/log out.png")));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "¿Esta seguro querer cerrar?") == 0) {
					dispose();
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("Mantenimientos");
		mnNewMenu_1.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/settings.png")));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmAlumno = new JMenuItem("Alumno");
		mntmAlumno.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/student.png")));
		mntmAlumno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmMantenimientoAlumno a = new FrmMantenimientoAlumno();
				a.setVisible(true);
				
				escritorio.add(a);
				a.show();
				
			}
		});
		mnNewMenu_1.add(mntmAlumno);
		
		JMenuItem mntmCurso = new JMenuItem("Curso");
		mntmCurso.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/class.png")));
		mntmCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmMantenimientoCurso curso = new FrmMantenimientoCurso();
				curso.setVisible(true);
				
				escritorio.add(curso);
				curso.show();
				
			}
		});
		mnNewMenu_1.add(mntmCurso);
		
		JMenuItem mntmProfesor = new JMenuItem("Profesor");
		mntmProfesor.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/teacher icon.png")));
		mntmProfesor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmMantenimientoProfesor p = new FrmMantenimientoProfesor();
				p.setVisible(true);
				escritorio.add(p);
				p.show();
			}
		});
		mnNewMenu_1.add(mntmProfesor);
		
		JMenuItem mntmEmpleado = new JMenuItem("Empleado");
		mntmEmpleado.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/worker.png")));
		mntmEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmMantenimientoEmpleado emp = new FrmMantenimientoEmpleado();
				emp.setVisible(true);
				escritorio.add(emp);
				emp.show();
				
			}
		});
		mnNewMenu_1.add(mntmEmpleado);
		
		JMenu mnNewMenu_4 = new JMenu("Reporte");
		mnNewMenu_4.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/reports.png")));
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmReporteAlumnos = new JMenuItem("Reporte Ingreso de Empleados");
		mntmReporteAlumnos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				ReportexFechaEmpleado em = new ReportexFechaEmpleado();
				em.setVisible(true);
				escritorio.add(em);
				em.show();
			}
		});
		mntmReporteAlumnos.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/report users.png")));
		mnNewMenu_4.add(mntmReporteAlumnos);
		
		JMenuItem mntmReporteInscripcion = new JMenuItem("Reporte Inscripci\u00F3n de Alumnos");
		mntmReporteInscripcion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReportexFchaIngreso a = new ReportexFchaIngreso();
				a.setVisible(true);
				escritorio.add(a);
				a.show();
				
			}
		});
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Reporte Estado de Alumnos");
		mntmNewMenuItem_1.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/worker.png")));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgAlumnosRetirados dar = new DlgAlumnosRetirados();
				dar.setVisible(true);
			}
			
		});
		mnNewMenu_4.add(mntmNewMenuItem_1);
		mntmReporteInscripcion.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/report inscription.png")));
		mnNewMenu_4.add(mntmReporteInscripcion);
		
		JMenu mnNewMenu_3 = new JMenu("Transaccion");
		mnNewMenu_3.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/transaction.png")));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Matricula");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmMatricula m = new FrmMatricula();
				m.setVisible(true);
				escritorio.add(m);
				m.show();
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_6);
		{
			mnJuego = new JMenu("Juego");
			mnJuego.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/game.png")));
			menuBar.add(mnJuego);
			{
				mntmCarrera = new JMenuItem("Carrera ");
				mntmCarrera.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						actionPerformedMntmCarrera(e);
					}
				});
				mntmCarrera.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/race.png")));
				mnJuego.add(mntmCarrera);
				
			}
		}
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		{
			escritorio = new JDesktopPane();
			escritorio.setBackground(new Color(204, 255, 255));
			contentPane.add(escritorio, "name_68719770982300");
		}
		this.setExtendedState(MAXIMIZED_BOTH);
	
		
	}
	protected void actionPerformedMntmCarrera(ActionEvent e) {
		Juego j = new Juego();
		j.setVisible(true);
		escritorio.add(j);
		j.show();
	}
}



