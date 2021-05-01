package practica_23MVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;



public class Controlador23 implements FocusListener,
									ActionListener,
									ItemListener,
									KeyListener
									{

	
	//Variables de instancia
	private Vista23 miVista;
	private Inmobiliaria23 modeloInmo;
	private JFrame23 ventana;
	
	
	/**
	 * Constructor
	 * @param miVista
	 */
	public Controlador23(Vista23 v, JFrame23 ventana) {
		this.miVista = v;
		this.modeloInmo = new Inmobiliaria23();
		this.ventana = ventana;
	}


	//*******************
	//FOCUSLISTENER
	//******************
	
	@Override
	public void focusGained(FocusEvent arg0) {
		
		if(arg0.getSource() == this.miVista.getPrecio()) { //si es Precio
			miVista.getPrecio().setText(""); //le quito el 0
			
		}
		if(arg0.getSource() == this.miVista.getSuperficie()) {//si es Superficie
			miVista.getSuperficie().setText(""); //le quito el 0
		}
		
	}


	@Override
	public void focusLost(FocusEvent arg0) {		
		
		if(arg0.getSource() == this.miVista.getCodigo()) {//perdió el foco Código			
			
			if(!this.miVista.getCodigo().getText().equals("")) {//es distinto a cadena vacía
				boolean sw= verificaCod();	
				
				if(sw) {
					mostrar();
				}
					
			}
		}
	}//end focusLost
	
	
	
	
	//*******************
	//ACTIONLISTENNERS
	//******************
	@Override
	public void actionPerformed(ActionEvent arg0) {

		
		if(arg0.getSource() == this.miVista.getGuardar()) {//se ha pulsado Guardar
			
			guardaPropiedad();
			miVista.getCodigo().setText(""); //Lo pongo fuera, porque en el método mostrar() (en focusLost) también lo uso. Y en ese NO interesa que se quite
			porDefecto();
			
		}
		
		if(arg0.getSource() == this.miVista.getLimpiar()) {//se ha pulsado Limpiar
			miVista.getCodigo().setText("");
			porDefecto();
			
		}
		
		if(arg0.getSource() == this.miVista.getBorrar()) {//se ha puslado Borrar
			
			borrarPropiedad();
			miVista.getCodigo().setText("");
			porDefecto();
		}
		
		if(arg0.getSource() == this.miVista.getListado()) { //se ha pulsado Listado						
			listado();
		}
		
		if (arg0.getSource() == this.miVista.getOcultar()) {
			
			ocultar();
		}
		
		if(arg0.getSource() == this.ventana.getBuscar()) {
			
			String cod= JOptionPane.showInputDialog("Introduce código Propiedad");
						
			boolean sw= verificaCod(cod);
			
			if(sw) {
				this.miVista.getCodigo().setText(cod);
				mostrar();
			}
			
		}
		
		
		
		
		
	}
	
	
	
	//******************
	//ITEMLISTENERS
	//******************
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		
		if(arg0.getSource() == this.miVista.getTipoPropiedad()) { //si es el ComboBox de TipoPropiedad
			
			if(this.miVista.getTipoPropiedad().getSelectedItem().equals(EnumTipoPropiedad.VIVIENDA)) {
				habilitaVivienda(true);
				habilitaFinca(false);
			}
			else if(this.miVista.getTipoPropiedad().getSelectedItem().equals(EnumTipoPropiedad.FINCA)){
				habilitaVivienda(false);
				habilitaFinca(true);				
			}
			else {
				habilitaVivienda(false);
				habilitaFinca(false);
			}			
		}// end if ComboBox de TipoPropiedad
		
		
		
	}
	
	
	
	
	//********************
	//KEYLISTENER
	//*******************
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		
		if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {			
			mostrar();
		}
		
	}


	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	

	
	//*************************
	//RESTO DE MÉTODOS
	//*************************
	
	/**
	 * Método que habilita o deshabilita el panel de la Vivienda
	 * @param b
	 */
	private void habilitaVivienda(boolean b) {

		this.miVista.getTipoVivienda().setEnabled(b);
		this.miVista.getDormitorios().setEnabled(b);
		this.miVista.getBaños().setEnabled(b);		
	}

	/**
	 * Método que habilita o deshabilita el panel de la Finca
	 * @param b
	 */
	private void habilitaFinca(boolean b) {		
		this.miVista.getTipoTerreno().setEnabled(b);
		this.miVista.getLuzSi().setEnabled(b);
		this.miVista.getLuzNo().setEnabled(b);
		this.miVista.getAguaSi().setEnabled(b);
		this.miVista.getAguaNo().setEnabled(b);
		this.miVista.getViviendaSi().setEnabled(b);
		this.miVista.getViviendaNo().setEnabled(b);
	}

	
	/**
	 * Método que guarda una Propiedad
	 */
	private void guardaPropiedad() {
		
		int codPropiedad=0;
		EnumTipoPropiedad tipoPropiedad;
		float precio=0;
		float metros2=0;
		String direccion="";			
		String descripcion="";
		EnumTipoVivienda tipoVivienda;
		byte dormitorios =0;
		byte baños = 0;
		EnumTipoTerreno tipoTerreno;
		boolean luz, agua, vivienda;
		
		try {
			
			codPropiedad = Integer.parseInt(this.miVista.getCodigo().getText());
			tipoPropiedad = (EnumTipoPropiedad)this.miVista.getTipoPropiedad().getSelectedItem();
			precio = Float.parseFloat(this.miVista.getPrecio().getText());
			metros2 = Float.parseFloat(this.miVista.getSuperficie().getText());
			direccion = this.miVista.getDireccion().getText();
			descripcion = this.miVista.getDescripcion().getText();
			
			if(tipoPropiedad.equals(EnumTipoPropiedad.VIVIENDA)) { //es una Vivienda
				
				tipoVivienda = (EnumTipoVivienda)this.miVista.getTipoVivienda().getSelectedItem();
				baños = (byte)this.miVista.getBaños().getSelectedItem();
				dormitorios = (byte)this.miVista.getDormitorios().getSelectedItem();			
				
				Vivienda23 viviendaNueva = new Vivienda23(codPropiedad,direccion, metros2, descripcion, precio, tipoVivienda, baños, dormitorios);
				
				this.modeloInmo.añade(viviendaNueva);
				JOptionPane.showMessageDialog(this.miVista,"Se han almacenado los siguientes datos: \n" + viviendaNueva.toString(), "Message", JOptionPane.INFORMATION_MESSAGE);				
			}
			
			else if(tipoPropiedad.equals(EnumTipoPropiedad.FINCA)) { // es una Finca Rústica
				
				tipoTerreno = (EnumTipoTerreno)this.miVista.getTipoTerreno().getSelectedItem();
				luz = this.miVista.getLuzSi().isSelected();
				agua = this.miVista.getAguaSi().isSelected();
				vivienda = this.miVista.getViviendaSi().isSelected();
				
				FincaRustica23 fincaNueva = new FincaRustica23(codPropiedad, direccion, metros2, descripcion, precio, tipoTerreno, luz, agua, vivienda);
				
				this.modeloInmo.añade(fincaNueva);
				
				JOptionPane.showMessageDialog(this.miVista,"Se han almacenado los siguientes datos: \n" + fincaNueva.toString(), "Message", JOptionPane.INFORMATION_MESSAGE);				
			}
			
			else { //es una Propiedad "a secas"
				
				Propiedad23 nuevaPropiedad = new Propiedad23 (codPropiedad, tipoPropiedad, direccion, metros2, descripcion, precio);
				
				this.modeloInmo.añade(nuevaPropiedad);
				
				JOptionPane.showMessageDialog(this.miVista,"Se han almacenado los siguientes datos: \n" + nuevaPropiedad.toString(), "Message", JOptionPane.INFORMATION_MESSAGE);
				
			}			
			
		}
		catch(NumberFormatException e) {			
			JOptionPane.showMessageDialog(this.miVista,"Datos erróneos", "ERROR", JOptionPane.ERROR_MESSAGE);
		}		
	}//end guardarPropiedad
	
	
	/**
	 * Método que muestra la información de una propiedad existente
	 */
	private void mostrar() {
		
		Propiedad23 p = modeloInmo.buscar(Integer.parseInt(miVista.getCodigo().getText())); //estoy seguro que es un nº ya que no saltó en verificaCod()
		
		if(modeloInmo.getInmo().isEmpty()){//si está vacía se sale
			return;
		}
		
		if(p==null) {//si no existe, se sale
			porDefecto();
			return;
		}		
		
		
		if(p.getCodPropiedad()==Integer.parseInt(miVista.getCodigo().getText())) {
			JOptionPane.showMessageDialog(miVista, "Esta propiedad ya existe", "Propiedad existente", JOptionPane.ERROR_MESSAGE);
			miVista.getGuardar().setEnabled(false);
		}
		
		//Variables locales
		EnumTipoPropiedad tipoPropiedad = p.getTipoPropiedad();
		float precio= p.getPrecio();
		float metros2= p.getMetros2();
		String direccion= p.getDireccion();			
		String descripcion= p.getDescripcion();		
				
		miVista.getPrecio().setText(String.valueOf(precio));
		miVista.getSuperficie().setText(String.valueOf(metros2));
		miVista.getDireccion().setText(direccion);
		miVista.getDescripcion().setText(descripcion);
		miVista.getTipoPropiedad().setSelectedItem(tipoPropiedad);
		
		if(p.getTipoPropiedad()==EnumTipoPropiedad.VIVIENDA) {
			
			EnumTipoVivienda tipoVivienda = ((Vivienda23)p).getTipoVivienda();
			byte dormitorios = (byte)((Vivienda23)p).getDormitorios();
			byte baños = (byte)((Vivienda23)p).getBaños();
			 
			miVista.getTipoVivienda().setSelectedItem(tipoVivienda);
			miVista.getDormitorios().setSelectedItem(dormitorios);
			miVista.getBaños().setSelectedItem(baños);			
		}
		
		else if(p.getTipoPropiedad()==EnumTipoPropiedad.FINCA) {
			
			EnumTipoTerreno tipoTerreno = ((FincaRustica23)p).getTipoTerreno();
			boolean luz = ((FincaRustica23)p).isLuz();
			boolean agua = ((FincaRustica23)p).isAgua();
			boolean vivienda = ((FincaRustica23)p).isVivienda();			
						
			miVista.getTipoTerreno().setSelectedItem(tipoTerreno);
			
			if(!luz) {
				miVista.getLuzNo().setSelected(true);
			}
			else {
				miVista.getLuzSi().setSelected(true);
			}
			if(!agua) {
				miVista.getAguaNo().setSelected(true);
			}
			else {
				miVista.getAguaSi().setSelected(true);
			}
			if(!vivienda) {
				miVista.getViviendaNo().setSelected(true);
			}
			else {
				miVista.getViviendaSi().setSelected(vivienda);
			}
	
			
/*			if(!luz) {
				miVista.getLuzNo().setSelected(true);
			}
			if(!agua) {
				miVista.getAguaNo().setSelected(true);
			}
			if(!vivienda) {
				miVista.getViviendaNo().setSelected(true);
			}
*/		
						
		}
		
		
		
	}//end mostrar
	
	 
	
	/**
	 * Método que comprueba que el código introducido es correcto.
	 * Esto me ayuda evitar que se introduzca un código incorrecto, para
	 * que al buscar por cod no de error
	 */
	private boolean verificaCod() {
		boolean sw = true;
		try {
			Integer.parseInt(miVista.getCodigo().getText());
			
		}
		catch(NumberFormatException e) {
			sw= false;
			JOptionPane.showMessageDialog(miVista, "Código no válido", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		return sw;
	}//end verificaCod
	
	
	/**
	 * Método que devuelve todos los componentes a su estado inicial
	 */
	private void porDefecto() {
		
		miVista.getTipoPropiedad().setSelectedItem(EnumTipoPropiedad.FINCA);
		miVista.getPrecio().setText("0");
		miVista.getSuperficie().setText("0");
		miVista.getDireccion().setText("");
		miVista.getDescripcion().setText("");
		
		miVista.getTipoVivienda().setSelectedItem(EnumTipoVivienda.CASA);
		miVista.getDormitorios().setSelectedIndex(0);
		miVista.getBaños().setSelectedIndex(0);
		
		miVista.getTipoTerreno().setSelectedItem(EnumTipoTerreno.REGADIO);
		miVista.getLuzSi().setSelected(true);
		miVista.getAguaSi().setSelected(true);
		miVista.getViviendaSi().setSelected(true);
		
		miVista.getGuardar().setEnabled(true);
		miVista.getBorrar().setEnabled(true);
		miVista.getLimpiar().setEnabled(true);
		
	}
	
	
	/**
	 * Método que borra una propiedad
	 */
	private void borrarPropiedad() {
		
		
		if(miVista.getCodigo().getText().equals("")) {//si no hay nada en Codigo no hace nada
			return;
		}
		
		else {
			
			int cod = Integer.parseInt(miVista.getCodigo().getText());
			
			boolean sw = modeloInmo.borrar2(cod);
			
			if(sw)
				JOptionPane.showMessageDialog(miVista, "Propiedad BORRADA", "Eliminación", JOptionPane.ERROR_MESSAGE);
			else
				JOptionPane.showMessageDialog(miVista, "Esa propiedad NO existe y por tanto no se puede eliminar", "Eliminación", JOptionPane.ERROR_MESSAGE);			
		}		
	}
	
	
	/**
	 * Método que muestre un listado con todas las Propiedades
	 */
	private void listado() {		
		
		this.miVista.getpListadoPropiedades().setVisible(true);		
		this.miVista.getListadoPropiedades().setText(this.modeloInmo.toString());
		
		this.ventana.pack();
		
		ventana.setLocationRelativeTo(null);
		
	}
	
	
	/**
	 * Método que oculta el panel del Listado propiedades
	 */
	private void ocultar() {
		
		this.miVista.getpListadoPropiedades().setVisible(false);
		
		this.ventana.pack();
		ventana.setLocationRelativeTo(null);
		
	}
	
	/**
	 * Método que verifica si un código es correcto
	 * @param cod
	 * @return
	 */
	private boolean verificaCod(String cod) {
		boolean sw = true;
		try {
			Integer.parseInt(cod);
			
		}
		catch(NumberFormatException e) {
			sw= false;
			JOptionPane.showMessageDialog(miVista, "Código no válido", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		return sw;
		
	}
	
	
	
}//end Class Controlador_pr23
