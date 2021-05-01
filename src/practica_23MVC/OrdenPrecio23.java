package practica_23MVC;
import java.util.Comparator;

public class OrdenPrecio23 implements Comparator<Propiedad23> {

	/**
	 * Redefinimos el compare para que lo orene por precio
	 */
	@Override
	public int compare(Propiedad23 propiedad1, Propiedad23 propiedad2) {
		
		return (int) (propiedad1.getPrecio() - propiedad2.getPrecio());
	}

}



