package hilo;

import javax.swing.JFrame;

import vista.FrmLogin;

public class HiloCerrar extends Thread{
	
	private JFrame Ventana;
	
	public HiloCerrar(JFrame ventana) {
		this.Ventana = ventana;
	}
	//crear el metodo run
	public void run() {
		//El contador 15 -> 0
		for(int i = 20; i >=0; i--) {
			//el contador de la etiqueta
			if(i<=20)
				FrmLogin.lblMensaje.setText("!Esta ventana se va cerrar en " + i + "s!");
			    System.out.print(i+"s");
			    //System.out.print(i+",");
			    
	       //intervalo
		   try {
			  Thread.sleep(1000);
		   } catch (Exception e) {
			  System.out.println("Error en pausa del contador :" + e.getMessage());
		   }
        }
		//finalizando el contador se tiene que cerrar la ventana 
		Ventana.dispose();	
	}
}
