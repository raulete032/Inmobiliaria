package practica_23MVC;

public class FincaRustica23 extends Propiedad23 {
	
	private static final float BENEFICIO_FINCA = 0.005f;

	private EnumTipoTerreno tipoTerreno;
	private boolean luz, agua, vivienda;
	
	
	/**
	 * Constructor
	 */
	public FincaRustica23(int codPropiedad, String direccion, float metros2, String descripcion, float precio, EnumTipoTerreno tipoTerreno, boolean luz, boolean agua, boolean vivienda) {
		super(codPropiedad, EnumTipoPropiedad.FINCA, direccion, metros2, descripcion, precio);
		this.tipoTerreno = tipoTerreno;
		this.luz = luz;
		this.agua = agua;
		this.vivienda = vivienda;
	}


	//GETTERS y SETTERS
	public EnumTipoTerreno getTipoTerreno() {return tipoTerreno;}
	public boolean isLuz() {return luz;}
	public boolean isAgua() {return agua;}
	public boolean isVivienda() {return vivienda;}

	public void setTipoTerreno(EnumTipoTerreno tipoTerreno) {this.tipoTerreno = tipoTerreno;}
	public void setLuz(boolean luz) {this.luz = luz;}
	public void setAgua(boolean agua) {this.agua = agua;}
	public void setVivienda(boolean vivienda) {this.vivienda = vivienda;}
	
	
	
	/**
	 * Redefino el método para que sume el 0.05% por ser Finca Rústica
	 */
	@Override
	public float beneficio () {
		
		return super.beneficio() + this.getPrecio()*BENEFICIO_FINCA;
	}
	
	
	
	public String toString() {
		
		return 	super.toString() +
				"\n\tTipo terreno: " + this.tipoTerreno +
				"\n\tDispone da luz: " + (this.luz==true?"SÍ":"NO")+
				"\n\tDispone de agua: " + (this.agua==true?"SÍ":"NO")+
				"\n\tDispone de vivienda: " + (this.vivienda==true?"SÍ":"NO");
				
				
		
		
	}
	
	

	
	
	

}
