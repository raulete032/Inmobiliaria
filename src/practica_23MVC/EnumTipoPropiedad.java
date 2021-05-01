package practica_23MVC;

public enum EnumTipoPropiedad {
	
	
	LOCAL("Local comercial"), APARCAMIENTO("Plaza de aparcamiento"), VIVIENDA("Vivienda"), FINCA("Finca rústica"), SOLAR("Solar");
	
	private String tipoPropiedad;
	
	//Constructor
	EnumTipoPropiedad(String tipo){
		tipoPropiedad=tipo;
	}

	//GETTERS y SETTERS
	public String getTipoPropiedad() {return tipoPropiedad;}

	public void setTipoPropiedad(String tipoPropiedad) {this.tipoPropiedad = tipoPropiedad;}	
	
	
	
	
}//fin Enum
