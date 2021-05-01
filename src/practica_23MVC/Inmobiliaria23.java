package practica_23MVC;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;


public class Inmobiliaria23 {

	
	private TreeSet<Propiedad23> inmo;
	
	
	/**
	 * Constructor
	 */
	public Inmobiliaria23() {
		
		this.inmo= new TreeSet<Propiedad23>();
	}


	//GETTERS y SETTERS
	public TreeSet<Propiedad23> getInmo() {return inmo;}

	public void setInmo(TreeSet<Propiedad23> inmo) {this.inmo = inmo;}
	
	
	
	/**
	 * Método que añade una propiead a la inmobiliaria
	 */
	public boolean añade(Propiedad23 pro) {
		
		return this.inmo.add(pro);		
	}
	
	
	/**
	 * Método que devuelve la propiedad buscada
	 * @param cod
	 * @return
	 */
	public Propiedad23 buscar(int cod) {
		boolean sw=false;
		Propiedad23 propiedadBuscada=null;
		
		if(inmo.isEmpty())
			return null;
		
		
		Iterator<Propiedad23> it= inmo.iterator();
		while(sw==false && it.hasNext()) {		
						
			propiedadBuscada=it.next();
			if(propiedadBuscada.getCodPropiedad()==cod) {
				sw=true;
			}
		}
		if(!sw) {
			return null;
		}
		return propiedadBuscada;		
	}
	
	
	
	/**
	 * Devuelve true si la propiedad que se la pasa como parámetro está en el TreeSet
	 * @param pro
	 * @return
	 */
	public boolean buscar(Propiedad23 pro) {
		
		return this.inmo.contains(pro);		
	}
	
	
	
	/**
	 * Borra la propiedad que se le pasa como parámetro en el caso de que esté en el TreeSet
	 */
	public boolean borra(Propiedad23 pro) {
		
		return this.inmo.remove(pro);		
	}
	
	
	
	
	public boolean borrar2(int cod) {
		
		boolean sw=false;
		Propiedad23 propiedadBuscada=null;
		
		Iterator<Propiedad23> it= inmo.iterator();
		while(sw==false && it.hasNext()) {		
						
			propiedadBuscada=it.next();
			if(propiedadBuscada.getCodPropiedad()==cod) {
				sw=true;
				this.inmo.remove(propiedadBuscada);
			}
		}
		if(!sw) {
			return false;
		}
		return true;		
	}
	
	
	
	
	
	
	/**
	 * Redefinición del método toString
	 */
	public String toString() {
		
		String cad="";
		
		for(Iterator<Propiedad23> it = this.inmo.iterator(); it.hasNext();) {
			
			cad= cad + it.next() + " \n";	
		}	
	
		return cad;
	}
	
	
	
	
	/**
	 * Redefinición del método toString. Lo muestra ordenado por precio "clase exterior"
	 */
	public String getPropiedadesOrdenPrecio1() {
		
		String cad= "";
		
		ArrayList<Propiedad23> inmoPrecio = new ArrayList<Propiedad23>();
		
		inmoPrecio.addAll(inmo);
		
		Collections.sort(inmoPrecio,new OrdenPrecio23());		
		
		for(Iterator<Propiedad23> it = inmoPrecio.iterator(); it.hasNext();) {
			
			cad= cad + it.next() + "\n";	
		}	
	
		return cad;	
	}
	
	
	/**
	 * Redefinición del método toString. Lo muestra ordenado por precio "clase anónima" 
	 */
	public String getPropiedadesOrdenPrecio2() {
		
		String cad= "";
		
		ArrayList<Propiedad23> inmoPrecio = new ArrayList<Propiedad23>();
		
		inmoPrecio.addAll(inmo);
		
		Collections.sort(inmoPrecio, new Comparator<Propiedad23>() {
			
			@Override
			public int compare(Propiedad23 propiedad1, Propiedad23 propiedad2) {
				return (int) (propiedad1.getPrecio() - propiedad2.getPrecio());
			}			
		});
		
		for(Iterator<Propiedad23> it = inmoPrecio.iterator(); it.hasNext();) {
			
			cad= cad + it.next() + "\n";	
		}		
		return cad;			
	}
	
	
	
	/**
	 * Redefinición del método toString. Lo muestra ordenado por precio "expresión lambda"
	 */
	public String getPropiedadesOrdenPrecio3() {
		
		String cad= "";
		
		ArrayList<Propiedad23> inmoPrecio = new ArrayList<Propiedad23>();
		
		inmoPrecio.addAll(inmo);
		
		Collections.sort(inmoPrecio,
				(Propiedad23 propiedad1, Propiedad23 propiedad2) -> {
					return (int) (propiedad1.getPrecio() - propiedad2.getPrecio());
				}				
		);
				
		for(Iterator<Propiedad23> it = inmoPrecio.iterator(); it.hasNext();) {
			
			cad= cad + it.next() + "\n";	
		}		
		return cad;		
	}
	
	
	
	public String getPropiedadesOrdenPrecio4() {
		
		String cad= "";
		
		ArrayList<Propiedad23> inmoPrecio = new ArrayList<Propiedad23>();
		
		inmoPrecio.addAll(inmo);
		
		Collections.sort(inmoPrecio,new OrdenPrecio23());		
		
		for(Iterator<Propiedad23> it = inmoPrecio.iterator(); it.hasNext();) {
			
			cad= cad + it.next() + "\n";	
		}	
	
		return cad;	
	}
		
	
	
	
}//fin class
