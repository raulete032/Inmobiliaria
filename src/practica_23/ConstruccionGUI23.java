package practica_23;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
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

public class ConstruccionGUI23 extends JFrame {
	
	private static final long serialVersionUID = 6824577370937558815L;
	
	
	//Variables de instancia
	private JTextField cod, precio, superficie, direccion;
	private JComboBox <EnumTipoPropiedad> tipoProp;
	private JComboBox <EnumTipoVivienda> tipoVivienda;
	private JComboBox<EnumTipoTerreno> tipoTerreno;
	private JComboBox <Integer>  numDormi, numBanios;
	private JTextArea descripcion;
	private JRadioButton sumElecSI, sumElecNO, sumAguaSI, sumAguaNO, dispoViviSI, dispoViviNO;
	private JButton guardar, borrar, limpiar;	
		
	/**
	 * Constructor
	 */
	public ConstruccionGUI23(String titulo) {
		super(titulo);	
		
		//Obtengo el contenedor principal
		Container cp = this.getContentPane();
		
				
		JPanel panelPrincipal = new JPanel();
		
		panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
		
		panelPrincipal.setBorder(new EmptyBorder(10,20,10,20));
		
		
		//************************
		//DATOS GENERALES
		//*************************
		JPanel pGenerales = new JPanel(new BorderLayout());
				
		pGenerales = preparaPanelDatosGenerales();
		estableceBorde(pGenerales, "Datos generales");		
		
		//****************
		// DATOS ESPECÍFICOS PARA VIVIENDA
		//*****************
		
		JPanel pDatosEspeVivi = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		pDatosEspeVivi= preparaDatosEspecificosVivienda();		
		
		estableceBorde(pDatosEspeVivi, "Datos específicos para vivienda");		
			
		//*****************
		// DATOS ESPECÍFICOS PARA FINCAS RÚSTICAS
		//*****************
		
		JPanel pDatosEspeFinca = new JPanel(new GridLayout(4, 1));
		
		pDatosEspeFinca = preparaDatosEspecificosFincaRustica();
		
		estableceBorde(pDatosEspeFinca, "Datos generales");
			
		
		//*********************
		// OPERACIONES DISPONIBLES
		//**********************
		
		JPanel pOperacionesDisponibles = new JPanel();
		
		pOperacionesDisponibles = preparaOperacionesDisponibles();
		
		
		panelPrincipal.add(pGenerales);
		panelPrincipal.add(pDatosEspeVivi);
		panelPrincipal.add(pDatosEspeFinca);
		panelPrincipal.add(pOperacionesDisponibles);
		
		cp.add(panelPrincipal);
		
		
	}//end constructor
	
	
	
	/**
	 * Método que le pone borde y un título a un JPanel
	 * @param p
	 * @param textoBorde
	 */
	private void estableceBorde(JPanel p, String textoBorde) {
		
		p.setBorder(new CompoundBorder(
							new EmptyBorder(5,5,5,5),
							new TitledBorder(new LineBorder(Color.GRAY, 1, true), textoBorde)
				));		
	}//end estableceBorde
	
	
	/**
	 * Método que prepara el JPanel de Datos generales
	 * @param p
	 * @return
	 */
	private JPanel preparaPanelDatosGenerales() {
		
		JPanel pGenerales = new JPanel(new BorderLayout());		
		JPanel pGenerales1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
		JPanel pGenerales2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
		JPanel pGenerales3 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
		
				
		JLabel codigo = new JLabel("Código: ");
		this.cod = new JTextField(3);
		cod.setHorizontalAlignment(JTextField.RIGHT);
		JLabel tipoPropiedad = new JLabel("Tipo propiedad: ");
		this.tipoProp = new JComboBox<EnumTipoPropiedad>(EnumTipoPropiedad.values());
		tipoProp.setSelectedIndex(3);
		JLabel precioL = new JLabel("Precio: ");
		this.precio = new JTextField(10);
		precio.setHorizontalAlignment(JTextField.RIGHT);
		JLabel superficieL = new JLabel("Superficie: ");
		this.superficie = new JTextField(3);
		superficie.setHorizontalAlignment(JTextField.RIGHT);
		JLabel direccL = new JLabel("Dirección: ");
		this.direccion = new JTextField(40);
		JLabel descri = new JLabel("Descripción: ");
		this.descripcion = new JTextArea(5,38);
		JScrollPane pScroll = new JScrollPane(descripcion);

		this.descripcion.setBorder(new LineBorder(Color.GRAY));
		
		
		pGenerales1.add(codigo);
		pGenerales1.add(cod);
		pGenerales1.add(tipoPropiedad);
		pGenerales1.add(tipoProp);
		pGenerales1.add(precioL);
		pGenerales1.add(precio);
		pGenerales1.add(superficieL);
		pGenerales1.add(superficie);
		
		pGenerales2.add(direccL);
		pGenerales2.add(direccion);
		
		pGenerales3.add(descri);
		pGenerales3.add(pScroll);
		
			
		pGenerales.add(pGenerales1,BorderLayout.NORTH);
		pGenerales.add(pGenerales2, BorderLayout.CENTER);
		pGenerales.add(pGenerales3, BorderLayout.SOUTH);		
		
		return pGenerales;
	}// end preparaPanelDatosGenerales
	
	
	/**
	 * Método que prepara el panel de los Datos específicos para vivienda
	 * @return
	 */
	private JPanel preparaDatosEspecificosVivienda() {
		
		JPanel pDatosEspeVivi = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JLabel tipoV = new JLabel("Tipo de vivienda: ");
		this.tipoVivienda = new JComboBox<EnumTipoVivienda>(EnumTipoVivienda.values());	
		tipoVivienda.setEnabled(false);
		JLabel numeroDorm = new JLabel("Número dormitorios: ");
		this.numDormi = new JComboBox<Integer>();
		numDormi.addItem(10);
		JLabel numBan = new JLabel ("Número baños: ");
		this.numBanios = new JComboBox<Integer>();
		numBanios.addItem(10);
		
		
		pDatosEspeVivi.add(tipoV);
		pDatosEspeVivi.add(tipoVivienda);
		pDatosEspeVivi.add(numeroDorm);
		pDatosEspeVivi.add(numDormi);
		pDatosEspeVivi.add(numBan);
		pDatosEspeVivi.add(numBanios);
		
		return pDatosEspeVivi;		
	}// end preparaDatosEspecificosVivienda
	
	
	/**
	 * Método que prepara el panel de Datos Específicos para fincas rústicas
	 * @return
	 */
	private JPanel preparaDatosEspecificosFincaRustica() {
		
		JPanel pDatosEspeFinca = new JPanel(new GridLayout(4, 1));
		//Creo los paneles
		JPanel pTipoTerreno = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel pSumElec = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel pSumAgua = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel pDispoVivi = new JPanel(new FlowLayout(FlowLayout.LEFT));


		//Inicializo las variables de instancia
		JLabel tipoTerreJL = new JLabel("Tipo terrreno: ");
		this.tipoTerreno = new JComboBox<EnumTipoTerreno>(EnumTipoTerreno.values());		
		JLabel sumElecJL = new JLabel("Suministro eléctrico: ");
		this.sumElecSI = new JRadioButton("Sí");
		this.sumElecNO = new JRadioButton("No");		
		JLabel sumAguaJL = new JLabel("Suministro de agua: ");
		this.sumAguaSI = new JRadioButton("Sí");
		this.sumAguaNO = new JRadioButton("No");
		JLabel dispoViviJL = new JLabel("Dispone de vivienda: ");
		this.dispoViviSI = new JRadioButton("Sí");
		this.dispoViviNO = new JRadioButton("No");


		//Creo los grupos para los RadioButton
		ButtonGroup gElec = new ButtonGroup();
		ButtonGroup gAgua = new ButtonGroup();
		ButtonGroup gVivi = new ButtonGroup();

		//Añado los RadioButton a su respectivo grupo
		gElec.add(sumElecSI);
		gElec.add(sumElecNO);;

		gAgua.add(sumAguaSI);
		gAgua.add(sumAguaNO);

		gVivi.add(dispoViviSI);
		gVivi.add(dispoViviNO);

		//Añado cada compnente a su panel		
		pTipoTerreno.add(tipoTerreJL);
		pTipoTerreno.add(tipoTerreno);

		pSumElec.add(sumElecJL);
		pSumElec.add(sumElecSI);
		pSumElec.add(sumElecNO);

		pSumAgua.add(sumAguaJL);
		pSumAgua.add(sumAguaSI);
		pSumAgua.add(sumAguaNO);


		pDispoVivi.add(dispoViviJL);
		pDispoVivi.add(dispoViviSI);
		pDispoVivi.add(dispoViviNO);				

		pDatosEspeFinca.add(pTipoTerreno);
		pDatosEspeFinca.add(pSumElec);
		pDatosEspeFinca.add(pSumAgua);
		pDatosEspeFinca.add(pDispoVivi);

		return pDatosEspeFinca;		
	}//end preparaDatosEspecificosFincaRustica
	
	
	
	/**
	 * Método que prepara el JPanel Operaciones disponibles
	 * @return
	 */
	private JPanel preparaOperacionesDisponibles() {
		
		JPanel pOperacionesDisponibles = new JPanel();
		
		this.guardar = new JButton("Guardar propiedad");
		this.borrar = new JButton("Borrar propiedad");
		this.limpiar = new JButton("Limpiar formulario");
		
		pOperacionesDisponibles.add(guardar);
		pOperacionesDisponibles.add(borrar);
		pOperacionesDisponibles.add(limpiar);
		
		estableceBorde(pOperacionesDisponibles, "Operaciones disponibles");
		
		return pOperacionesDisponibles;
	}// end preparaOperacionesDisponibles
	
	
	

}//fin class ConstruccionGUI23
