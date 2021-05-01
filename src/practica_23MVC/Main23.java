package practica_23MVC;

import javax.swing.JFrame;

public class Main23 {

	public static void main(String[] args) {

		JFrame23 ventana = new JFrame23("Agencia Inmobiliaria");
		Vista23 miVista = new Vista23();
		
		
		Controlador23 ctr = new Controlador23(miVista, ventana);		
		ventana.añadeControl(ctr);
		miVista.añadeControl(ctr);
		
		
	//	JFrame ventana = new JFrame("Agencia Inmobiliaria");	
		ventana.setContentPane(miVista);
		ventana.setVisible(true);		
		ventana.pack();
		ventana.setLocationRelativeTo(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}

}
