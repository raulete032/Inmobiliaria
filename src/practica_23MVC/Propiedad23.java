package practica_23MVC;

/**
 * Esta clase creará objetos tipo Propiedad
 *
 */
public class Propiedad23 implements Comparable<Propiedad23> {
	
	
	//CONSTANTES
	private final float GASTOS_GESTORIA =150f;
	private final float BENEFICIO_COMUN= 0.0075f;
	
	//Variables de instancia
	private int codPropiedad;
	private EnumTipoPropiedad tipoPropiedad;
	private String direccion;
	private float metros2;
	private String descripcion;
	private float precio;
	
	
	/**
	 * Constructor
	 */
	public Propiedad23(int codPropiedad, EnumTipoPropiedad tipoPropiedad, String direccion, 
			float metros2, String descripcion, float precio) {
		super();
		this.codPropiedad = codPropiedad;
		this.tipoPropiedad = tipoPropiedad;
		this.direccion = direccion;
		this.metros2 = metros2;
		this.descripcion = descripcion;
		this.precio = precio;
	}


	//GETTERS y SETTERS
	public int getCodPropiedad() {return codPropiedad;}
	public EnumTipoPropiedad getTipoPropiedad() {return tipoPropiedad;}
	public String getDireccion() {return direccion;}
	public float getMetros2() {return metros2;}
	public String getDescripcion() {return descripcion;}
	public float getPrecio() {return precio;}

	public void setCodPropiedad(int codPropiedad) {this.codPropiedad = codPropiedad;}
	public void setTipoPropiedad(EnumTipoPropiedad tipoPropiedad) {this.tipoPropiedad = tipoPropiedad;}
	public void setDireccion(String direccion) {this.direccion = direccion;}
	public void setMetros2(float metros2) {this.metros2 = metros2;}
	public void setDescripcion(String descripcion) {this.descripcion = descripcion;}
	public void setPrecio(float precio) {this.precio = precio;}


	/**
	 * HashCode
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codPropiedad;
		return result;
	}


	/**
	 * Método equals. Consideramos que dos propiedades son iguales si coincide su código
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Propiedad23 other = (Propiedad23) obj;
		if (codPropiedad != other.codPropiedad)
			return false;
		return true;
	}
	
	
	
	/**
	 * Método que calcula el beneficio de una propiedad "comun"
	 */
	public float beneficio() {
		
		return (this.precio*this.BENEFICIO_COMUN)+this.GASTOS_GESTORIA;		
	}
	

	
	@Override
	public String toString() {
		
		return this.tipoPropiedad.getTipoPropiedad().toUpperCase() +
				"\n\tBeneficio obtenido: " + this.beneficio() +
				"\n\tCódigo: " + this.codPropiedad +
				"\n\tSuperficie: " + this.metros2 + " metros cuadrados" +
				"\n\tDescripción: " + this.descripcion +
				"\n\tDireccion: " + this.direccion +
				"\n\tPrecio: " + this.precio;		
	}


	/**
	 * Ordenamos de forma ascendente
	 */
	@Override
	public int compareTo(Propiedad23 otraPropiedad) {
		
		return  this.codPropiedad - otraPropiedad.getCodPropiedad();	
		
	}



	
	
	
	
	
	
	
	
	
	

}
