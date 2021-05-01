package practica_23MVC;

public class Test {

	public static void main(String[] args) {

		
		Propiedad23 pro1 = new Propiedad23(1, EnumTipoPropiedad.LOCAL, "C/Infante, 45", 70f,"El local no tiene baño e instalaciones de agua, luz y teléfono", 10000);
		Propiedad23 pro2 = new Propiedad23(2, EnumTipoPropiedad.APARCAMIENTO, "C/Voltereta, 31", 10f,"El aparcamiento es muy amplio. Centro ciudad", 10);
		Propiedad23 pro3 = new Propiedad23(3, EnumTipoPropiedad.SOLAR, "C/Remedios, 1", 200f,"Solar con permiso de edificación", 100500);
		
		
		Vivienda23 vi1 = new Vivienda23(11, "C/Regaliz 32", 200, "Una casa muy amplia y con mucha luz", 200000, EnumTipoVivienda.CASA, (byte) 3, (byte) 5 );
		Vivienda23 vi2 = new Vivienda23(12, "C/Galleta 27", 250, "Una casa grande, de dos plantas", 250000, EnumTipoVivienda.DUPLEX, (byte) 3, (byte) 6 );
		Vivienda23 vi3 = new Vivienda23(13, "C/Leche 266", 300, "Primera línea de playa", 321000, EnumTipoVivienda.ADOSADO, (byte) 2, (byte) 4 );
		
		
		Inmobiliaria23 inm = new Inmobiliaria23();
		
		//Las añado desordenas para que se vea como las muestra ordenas
		inm.añade(pro1);
		inm.añade(pro2);
		inm.añade(pro3);
		inm.añade(vi1);
		inm.añade(vi2);
		inm.añade(vi3);
		
		
		Propiedad23 propiedad = inm.buscar(11);
		
		Vivienda23 vivienda = (Vivienda23)propiedad;	
		
		System.out.println(vivienda.getBaños());
		
		
		
		
	}

}
