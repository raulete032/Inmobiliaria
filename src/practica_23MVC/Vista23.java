package practica_23MVC;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Vista23 extends JPanel {

	private static final long serialVersionUID = -9007413000177263760L;
	
	
	//Variables de instancia
	private JTextField codigo, precio, superficie, direccion;
	private JTextArea descripcion;
	private JComboBox<EnumTipoPropiedad> tipoPropiedad;
	private JComboBox<EnumTipoVivienda> tipoVivienda;
	private JComboBox<EnumTipoTerreno> tipoTerreno;	
	private JComboBox<Byte> dormitorios;
	private JComboBox<Byte> baños;
	private JRadioButton luzSi, luzNo, aguaSi, aguaNo, viviendaSi, viviendaNo;
	private JButton guardar, borrar, limpiar, listado, ocultar, ordenar;
	private JTextArea listadoPropiedades;
	private JPanel pListadoPropiedades;
	
		
	/**
	 * Constructor
	 */
	public Vista23() {
		
		//El panel principal es BoxLayout()
		JPanel p1 = new JPanel();
		p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
		
		
		
		//**********************
		// DATOS GENERALES
		//*********************
		
		JPanel pGenerales = preparaPanelGenerales();		
		poneBorde(pGenerales, "Datos generales");
		
		
		//*********************
		//DATOS ESPECÍFICOS PARA VIVIENDA
		//********************
		
		JPanel pEspeciVivienda = preparaPanelEspeciVivienda();
		poneBorde(pEspeciVivienda, "Datos específicos para vivienda");
		
		
		//******************
		// DATOS ESPECÍFICOS PARA FINCAS RÚSTICAS
		//*****************
		
		JPanel pEspeciFincasRusticas = preparaPanelEspeciFincasRusticas();
		poneBorde(pEspeciFincasRusticas, "Datos específicos para fincas rústicas");
		
		
		//****************
		//OPERACIONES DISPONIBLES
		//****************
		
		JPanel pOperacionesDisponibles = preparaPanelOperacionesDisponibles();
		poneBorde(pOperacionesDisponibles, "Operaciones disponibles");
		
		
		
		//**************
		//LISTADO PROPIEDADES
		//***************
		
		this.pListadoPropiedades = preparaPanelListadoPropiedades();
		poneBorde(pListadoPropiedades, "Listado de las propiedades");
				
		
		p1.add(pGenerales);
		p1.add(pEspeciVivienda);
		p1.add(pEspeciFincasRusticas);
		p1.add(pOperacionesDisponibles);
		p1.add(pListadoPropiedades);
		
		
				
		this.add(p1);
		
	}//end Constructor
	
	
	//GETTERS
	public JTextField getCodigo() {return codigo;}
	public JTextField getPrecio() {return precio;}
	public JTextField getSuperficie() {return superficie;}
	public JTextField getDireccion() {return direccion;}
	public JTextArea getDescripcion() {return descripcion;}
	public JComboBox<EnumTipoPropiedad> getTipoPropiedad() {return tipoPropiedad;}	
	public JComboBox<EnumTipoVivienda> getTipoVivienda() {return tipoVivienda;}
	public JComboBox<EnumTipoTerreno> getTipoTerreno() {return tipoTerreno;}
	public JComboBox<Byte> getDormitorios() {return dormitorios;}
	public JComboBox<Byte> getBaños() {return baños;}
	public JRadioButton getLuzSi() {return luzSi;}
	public JRadioButton getLuzNo() {return luzNo;}
	public JRadioButton getAguaSi() {return aguaSi;}
	public JRadioButton getAguaNo() {return aguaNo;}
	public JRadioButton getViviendaSi() {return viviendaSi;}
	public JRadioButton getViviendaNo() {return viviendaNo;}
	public JButton getGuardar() {return guardar;}
	public JButton getBorrar() {return borrar;}
	public JButton getLimpiar() {return limpiar;}
	public JButton getListado() {return listado;}	
	public JTextArea getListadoPropiedades() {return listadoPropiedades;}
	public JButton getOcultar() {return ocultar;}
	public JPanel getpListadoPropiedades() {return pListadoPropiedades;}	
	public JButton getOrdenar() {return ordenar;}


	/**
	 * Método que pone borde a un panel
	 * @param panel
	 * @param titulo
	 */
	private void poneBorde(JPanel panel, String titulo) {
		
		panel.setBorder(new CompoundBorder(
							new EmptyBorder(5,5,5,5),
							new TitledBorder(new LineBorder(Color.GRAY, 1, true), titulo)
				
				));
		
	}// end poneBorde
	
	
	
	/**
	 * Método que prepara el panelDatosGenerales
	 * @return
	 */
	private JPanel preparaPanelGenerales () {
		
		//Pido memoria para las variables de instancia de este panel
		this.codigo = new JTextField(3);
		this.tipoPropiedad= new JComboBox<EnumTipoPropiedad>(EnumTipoPropiedad.values());				
		tipoPropiedad.setSelectedIndex(3);
		this.precio = new JTextField("0",10);
		precio.setHorizontalAlignment(JTextField.RIGHT);
		this.superficie = new JTextField("0",5);
		superficie.setHorizontalAlignment(JTextField.RIGHT);
		
		this.direccion = new JTextField(30);
		this.descripcion = new JTextArea(5,38);
		JScrollPane jspDescripcion = new JScrollPane(descripcion);
		
		//Creo los JLabel
		JLabel jlCodigo = new JLabel("Código: ");
		JLabel jlTipoProp = new JLabel("Tipo propiedad: ");
		JLabel jlPrecio = new JLabel("Precio: ");
		JLabel jlSuperf = new JLabel("Superficie: ");
		JLabel jlDirecc = new JLabel("Dirección: ");
		JLabel jlDescrip = new JLabel("Descripción: ");
		
		
		//Creo los paneles		
		JPanel pGeneralesPrinc = new JPanel(new BorderLayout());
		
		JPanel pGenerales1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel pGenerales2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel pGenerales3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		
		
		//Añado los componentes a sus respectivos paneles
		pGenerales1.add(jlCodigo);
		pGenerales1.add(this.codigo);
		pGenerales1.add(jlTipoProp);
		pGenerales1.add(tipoPropiedad);
		pGenerales1.add(jlPrecio);
		pGenerales1.add(precio);
		pGenerales1.add(jlSuperf);
		pGenerales1.add(superficie);
		
		pGenerales2.add(jlDirecc);
		pGenerales2.add(this.direccion);
		
		pGenerales3.add(jlDescrip);
		pGenerales3.add(jspDescripcion);
		
		
		pGeneralesPrinc.add(pGenerales1, BorderLayout.NORTH);
		pGeneralesPrinc.add(pGenerales2, BorderLayout.CENTER);
		pGeneralesPrinc.add(pGenerales3, BorderLayout.SOUTH);
		
		
		
		return pGeneralesPrinc;
		
	}// end preparaPanelGenerales
	
	
	
	/**
	 * Método que prepara el panel de los datos específicos para vivienda
	 * @return
	 */
	private JPanel preparaPanelEspeciVivienda() {
		
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		//Creo los JLabel
		JLabel jlTipoVivi = new JLabel("Tipo de vivienda: ");
		JLabel jlNumDormi = new JLabel("Número de dormitorios: ");
		JLabel jlNumBanios = new JLabel("Número baños: ");
		
		
		//Pido memoria para las variables de instancia de este panel
		this.tipoVivienda = new JComboBox<EnumTipoVivienda>(EnumTipoVivienda.values());
		tipoVivienda.setEnabled(false);
		this.dormitorios = new JComboBox<Byte>();
		dormitorios.setEnabled(false);
		this.baños = new JComboBox<Byte>();
		baños.setEnabled(false);
		
		//Relleno los ComboBox
		for(byte i=1; i<=10; i++) {
			dormitorios.addItem(i);			
		}
		
		for(byte i=1; i<=4; i++) {
			baños.addItem(i);			
		}
		
		//Añado los componentes al panel
		panel.add(jlTipoVivi);
		panel.add(this.tipoVivienda);
		panel.add(jlNumDormi);
		panel.add(dormitorios);
		panel.add(jlNumBanios);
		panel.add(baños);
		
		return panel;
	}//end preparaPanelEspeciVivienda
	
	
	
	/**
	 * Método que prepara el panel de Datos específicos para fincas rústicas
	 * @return
	 */
	private JPanel preparaPanelEspeciFincasRusticas() {
		
		//Creo los paneles
		JPanel panel = new JPanel(new GridLayout(4,1));
		
		JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		//Creo los JLable de este panel
		JLabel jlTipoTerreno = new JLabel("Tipo terreno: ");
		JLabel jlSumElec = new JLabel("Suministro eléctrico: ");
		JLabel jlSumAgua = new JLabel("Suministro de agua: ");
		JLabel jlDispVivi = new JLabel("Dispone de vivienda: ");
		
		
		//Pido memoria para las variable se instancia de este panel
		this.tipoTerreno = new JComboBox<EnumTipoTerreno>(EnumTipoTerreno.values());
		this.luzSi = new JRadioButton("Sí");
		luzSi.setSelected(true);
		this.luzNo = new JRadioButton("No");
		this.aguaSi = new JRadioButton("Sí");
		aguaSi.setSelected(true);
		this.aguaNo = new JRadioButton("No");
		this.viviendaSi = new JRadioButton("Sí");
		viviendaSi.setSelected(true);
		this.viviendaNo = new JRadioButton("No");
		
		
		//Creo los grupos de los RadioButton
		ButtonGroup grupoElect = new ButtonGroup();
		ButtonGroup grupoAgua = new ButtonGroup();
		ButtonGroup grupoVivi = new ButtonGroup();
		
		grupoElect.add(luzSi);
		grupoElect.add(luzNo);
		
		grupoAgua.add(aguaSi);
		grupoAgua.add(aguaNo);
		
		grupoVivi.add(viviendaSi);
		grupoVivi.add(viviendaNo);
		
		
		panel1.add(jlTipoTerreno);
		panel1.add(tipoTerreno);
		
		panel2.add(jlSumElec);
		panel2.add(luzSi);
		panel2.add(luzNo);
		
		panel3.add(jlSumAgua);
		panel3.add(aguaSi);
		panel3.add(aguaNo);
		
		panel4.add(jlDispVivi);
		panel4.add(viviendaSi);
		panel4.add(viviendaNo);		
		
		
		panel.add(panel1);
		panel.add(panel2);
		panel.add(panel3);
		panel.add(panel4);
		
		return panel;
	}//end preparaPanelEspeciFincasRusticas
	
	
	/**
	 * Método que prepara el panel de las Operaciones disponibles
	 * @return
	 */
	private JPanel preparaPanelOperacionesDisponibles() {
		
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		//Pido memoria para los componentes de este panel
		
		this.guardar = new JButton("Guardar propiedad");
		this.borrar = new JButton("Borrar propiedad");
		this.limpiar = new JButton("Limpiar formulario");
		this.listado = new JButton("Listado propiedades");
		
		panel.add(guardar);
		panel.add(borrar);
		panel.add(limpiar);	
		panel.add(listado);
		
		return panel;
	}//end preparaPanelOperacioensDisponibles
	
	
	/**
	 * Método que prepara el panel del Listado de las Propiedades
	 * @return
	 */
	private JPanel preparaPanelListadoPropiedades() {
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel panelBotones = new JPanel();
		
		this.listadoPropiedades = new JTextArea(10, 30);
		this.ocultar = new JButton("Ocultar");
		this.ordenar = new JButton("Ordenar");
		listadoPropiedades.setEditable(false);
		
		panelBotones.add(ocultar);
		panelBotones.add(ordenar);
		
		JScrollPane scrlPane = new JScrollPane(listadoPropiedades);
		
		panel.add(scrlPane);
		panel.add(panelBotones);
		
		
		panel.setVisible(false);
		
		return panel;
	}
	
	
	
	/**
	 * Método que añade el Control
	 * @param ctr
	 */
	public void añadeControl(Controlador23 ctr) {
		
		tipoPropiedad.addItemListener(ctr);
		tipoVivienda.addItemListener(ctr);
		tipoTerreno.addItemListener(ctr);
		
		guardar.addActionListener(ctr);
		borrar.addActionListener(ctr);
		limpiar.addActionListener(ctr);
		listado.addActionListener(ctr);
		ocultar.addActionListener(ctr);
		
		codigo.addFocusListener(ctr);
		precio.addFocusListener(ctr);
		superficie.addFocusListener(ctr);		
		
		codigo.addKeyListener(ctr);
		
		
	}//end añadeControl
	
	
	
	
	
	
	
}//end Vista_pr23
