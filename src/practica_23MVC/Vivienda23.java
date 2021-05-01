package practica_23MVC;

public class Vivienda23 extends Propiedad23 {
	
	
	private static final float BENEFICIO_VIVIENDA= 0.0025f;
	
	private EnumTipoVivienda tipoVivienda;
	private byte ba�os, dormitorios;
	
	
	
	/**
	 * Constructor
	 */
	public Vivienda23(int codPropiedad, String direccion, float metros2, String descripcion, float precio, EnumTipoVivienda tipoVivienda, byte ba�os, byte dormitorios) {
		
		super(codPropiedad, EnumTipoPropiedad.VIVIENDA, direccion, metros2, descripcion, precio);
		this.tipoVivienda = tipoVivienda;
		this.ba�os = ba�os;
		this.dormitorios = dormitorios;
		
	}


	//GETTERS y SETTERS
	public static float getBeneficioVivienda() {return BENEFICIO_VIVIENDA;}
	public EnumTipoVivienda getTipoVivienda() {return tipoVivienda;}
	public byte getBa�os() {return ba�os;}
	public byte getDormitorios() {return dormitorios;}

	public void setTipoVivienda(EnumTipoVivienda tipoVivienda) {this.tipoVivienda = tipoVivienda;}
	public void setBa�os(byte ba�os) {this.ba�os = ba�os;}
	public void setDormitorios(byte dormitorios) {this.dormitorios = dormitorios;}
	
 
	  
	/**
	 * Redefinici�n del m�todo beneficio
	 */
	@Override
	public float beneficio() {
		
		return super.beneficio() + this.getPrecio()*BENEFICIO_VIVIENDA;
	}
	
	
	/**
	 * Redefinici�n m�todo toString 
	 */
	@Override
	public String toString() {
		
		return super.toString() +
				"\n\tTipo de vivienda: " + this.tipoVivienda +
				"\n\tN�mero dormitorios: " + this.dormitorios +
				"\n\tN�mero ba�os: " + this.ba�os;
		
	}
	
	
	
	
}
