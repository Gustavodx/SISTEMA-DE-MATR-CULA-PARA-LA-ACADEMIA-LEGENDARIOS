package hilo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import vista.Juego;


public class HiloCarro extends Thread{

	private JLabel carro;
	private String jockey;
	
	
	public HiloCarro(JLabel carro, String jockey) {
		this.carro = carro;
		this.jockey = jockey;
	}
	
	@Override
	public void run() {
		while(Juego.isActivo()) {
			int avance = (int) (Math.random() * 10);
			carro.setLocation(carro.getX() + avance, carro.getY());
			if(carro.getX() + carro.getWidth() > Juego.lblMeta.getX()) {
				Juego.setActivo(false);
				JOptionPane.showMessageDialog(null, "Gano " + jockey);
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
