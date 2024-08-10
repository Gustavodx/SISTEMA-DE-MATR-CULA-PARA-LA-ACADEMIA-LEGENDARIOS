package hilo;

import javax.swing.JFrame;

import vista.FrmPreLoader;
import vista.FrmPrincipal;

public class HiloBarra extends Thread{
		private JFrame ventana;
	public HiloBarra(JFrame ventana) {
		this.ventana = ventana;	
		}
	
	@Override
public void run() {
		//contador de 0 a 100
		for (int i=0; i<=100;i++) {
			//usar el contador para el valor de la barra
			FrmPreLoader.prbCarga.setValue(i);
			switch (i) {
			case 20:
				FrmPreLoader.lblMensaje.setText("Iniciando datos del programa...");
				break;
			
			case 35:
				FrmPreLoader.lblMensaje.setText("Espere un momento...");
				break;
			case 80:
				FrmPreLoader.lblMensaje.setText("Obteniendo informacion...");
				break;
			case 95:
				FrmPreLoader.lblMensaje.setText("El programa esta listo");
				break;

			default:
				break;
			}
			//pausa
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				System.out.println("Error en pasua de barra: "+e.getMessage());
			}
		}
	
	//abrir el FrmPrincipal
		FrmPrincipal v = new FrmPrincipal();
		v.setVisible(true);
		ventana.dispose();
	
	}
}
