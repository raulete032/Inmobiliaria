package practica_23MVC;

public class Vivienda23 extends Propiedad23 {
	
	
	private static final float BENEFICIO_VIVIENDA= 0.0025f;
	
	private EnumTipoVivienda tipoVivienda;
	private byte baños, dormitorios;
	
	
	
	/**
	 * Constructor
	 */
	public Vivienda23(int codPropiedad, String direccion, float metros2, String descripcion, float precio, EnumTipoVivienda tipoVivienda, byte baños, byte dormitorios) {
		
		super(codPropiedad, EnumTipoPropiedad.VIVIENDA, direccion, metros2, descripcion, precio);
		this.tipoVivienda = tipoVivienda;
		this.baños = baños;
		this.dormitorios = dormitorios;
		
	}


	//GETTERS y SETTERS
	public static float getBeneficioVivienda() {return BENEFICIO_VIVIENDA;}
	public EnumTipoVivienda getTipoVivienda() {return tipoVivienda;}
	public byte getBaños() {return baños;}
	public byte getDormitorios() {return dormitorios;}

	public void setTipoVivienda(EnumTipoVivienda tipoVivienda) {this.tipoVivienda = tipoVivienda;}
	public void setBaños(byte baños) {this.baños = baños;}
	public void setDormitorios(byte dormitorios) {this.dormitorios = dormitorios;}
	
 
	  
	/**
	 * Redefinición del método beneficio
	 */
	@Override
	public float beneficio() {
		
		return super.beneficio() + this.getPrecio()*BENEFICIO_VIVIENDA;
	}
	
	
	/**
	 * Redefinición método toString 
	 */
	@Override
	public String toString() {
		
		return super.toString() +
				"\n\tTipo de vivienda: " + this.tipoVivienda +
				"\n\tNúmero dormitorios: " + this.dormitorios +
				"\n\tNúmero baños: " + this.baños;
		
	}
	
	
	
	
}
