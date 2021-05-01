package practica_23MVC;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class JFrame23 extends JFrame {

	
	private static final long serialVersionUID = -4007340962829047999L;
	
	
	private JMenuBar barraMenu;
	private JMenu archivo, editar;
	private JMenuItem buscar;
	
	/**
	 * Constructor
	 * @param titulo
	 */
	public JFrame23(String titulo) {
		
		super(titulo);
		
		creaBarra();		
	}
	
	
	
	/**
	 * Método que crea la barra
	 */
	private void creaBarra() {
		
		this.barraMenu = new JMenuBar();
		
		this.archivo = new JMenu("Archivo");
		this.editar = new JMenu("Editar");
		this.buscar = new JMenuItem("Buscar");
		
		barraMenu.add(archivo);
		barraMenu.add(editar);
		editar.add(buscar);
		
		this.setJMenuBar(barraMenu);
		
	}


	public JMenuBar getBarraMenu() {return barraMenu;}
	public JMenu getArchivo() {return archivo;}	
	public JMenuItem getBuscar() {return buscar;}


	/**
	 * Método que añade el control
	 * @param ctr
	 */
	public void añadeControl(Controlador23 ctr) {
		
		this.buscar.addActionListener(ctr);		
		
	}
	
	
	
	

}
