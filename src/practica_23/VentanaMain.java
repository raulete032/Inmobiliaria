package practica_23;

import java.awt.Dimension;

import javax.swing.JFrame;

public class VentanaMain {

	public static void main(String[] args) {

		
		ConstruccionGUI23 ventana = new ConstruccionGUI23("Agencia inmobiliaria");
		
		ventana.setVisible(true);
		
		ventana.setPreferredSize(new Dimension(750, 570));
		ventana.pack();
		

		ventana.setLocationRelativeTo(null);
		
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
	}

}
