package plantillaEmpleados;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
	
	static ArrayList <Empleado> arrayEmpleados = new ArrayList();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonalAdministracion a = new PersonalAdministracion("juan", "gore", "123", 366);
		PersonalAdministracion b = new PersonalAdministracion("juan", "gore", "123", 366);
		MozoAlmacen c = new MozoAlmacen("juan", "gore", "123", 366);
		MozoAlmacen d = new MozoAlmacen("juan", "gore", "123", 654);
		JefeSeccion e = new JefeSeccion("juan", "gore", "123", 354,1);
		JefeSeccion f = new JefeSeccion("juan", "gore", "123", 657,1);
		JefePlanta g = new JefePlanta("juan", "gore", "123", 432,3);
		JefePlanta h = new JefePlanta("juan", "gore", "123", 456,2);
		Directivo i = new Directivo("juan", "gore", "123", 127,false);
		Directivo j = new Directivo("juan", "gore", "123", 730,true);
		
		
		arrayEmpleados.add(a);
		arrayEmpleados.add(b);
		arrayEmpleados.add(c);
		arrayEmpleados.add(d);
		arrayEmpleados.add(e);
		arrayEmpleados.add(f);
		arrayEmpleados.add(g);
		arrayEmpleados.add(h);
		arrayEmpleados.add(i);
		arrayEmpleados.add(j);
		
		while (true) {
			menuPrincipal();
		}
		
	}
	
	public static void menuPrincipal(){
		
		Scanner scInt = new Scanner(System.in);
		
		System.out.println("PLANTILLA DE EMPLEADOS\n\n"
				+ "1.- Introducir trabajador\n"
				+ "2.- Eliminar trabajador\n"
				+ "3.- Listado trabajadores\n"
				+ "4.- Listado trabajadores por puesto\n"
				+ "5.- Avance temporal\n"
				+ "6.- Mostrar matriz dias trabajador");
	
		int eleccion = scInt.nextInt();
		boolean stockTrabajadores;
		
		switch (eleccion) {
		
		case 1:
			obtenerDatosEmpleado();
			break;
		case 2:
			//booleano con el fin de verificar si hay trabajadores o no
			stockTrabajadores = mostrarTrabajadores();
			if(stockTrabajadores) {
				eliminarTrabajador();
			}
			break;
		case 3:
			//booleano con el fin de verificar si hay trabajadores o no
			stockTrabajadores = mostrarTrabajadores();
			if(stockTrabajadores) {
				infoExtendida();
			}
			break;
		case 4:
			listadoPorPuesto();
			break;
		case 5:
			
		}
			
			}
	public static void obtenerDatosEmpleado() {
		Scanner scInt = new Scanner(System.in);
		Scanner scLine = new Scanner(System.in);
		String datosEmpleado[] = new String[3];
		
			
		System.out.println("Nombre del empleado:");
		datosEmpleado[0] = scLine.nextLine();
		System.out.println("Apellidos del empleado:");
		datosEmpleado[1] = scLine.nextLine();
		System.out.println("DNI del empleado");
		datosEmpleado[2] = scLine.nextLine();

			System.out.println("Puesto del empleado:\n" + 
					"1.- Mozo de almacen.\n" + 
					"2.- Jefe de seccion.\n" + 
					"3.- Jefe de planta.\n" + 
					"4.- Personal de administracion.\n" + 
					"5.- Directivo");
			int eleccionPuesto = scLine.nextInt();
		System.out.println("Antiguedad del empleado:");
		int antiguedad = scInt.nextInt();
		
		introducirEmpleado(scInt, datosEmpleado, eleccionPuesto, antiguedad);
		
		
	}

	public static void introducirEmpleado(Scanner scInt, String[] datosEmpleado, int eleccionPuesto, int antiguedad) {
		int categoria = 0;
		
		switch (eleccionPuesto) {

		case 1:
			MozoAlmacen mozo = new MozoAlmacen(datosEmpleado[0], datosEmpleado[1], datosEmpleado[2], antiguedad);
			arrayEmpleados.add(mozo);
			break;
		case 2:
			while (categoria < 1 || categoria > 3) {
				System.out.println("Categoria: 1,2 o 3");
				categoria = scInt.nextInt();
			}
			JefeSeccion jefeSeccion = new JefeSeccion(datosEmpleado[0], datosEmpleado[1], datosEmpleado[2], antiguedad,
					categoria);
			arrayEmpleados.add(jefeSeccion);
			break;
		case 3:
			while (categoria < 1 || categoria > 4) {
				System.out.println("Categoria: 1,2,3 o 4");
				categoria = scInt.nextInt();
			}
			JefePlanta jefePlanta = new JefePlanta(datosEmpleado[0], datosEmpleado[1], datosEmpleado[2], antiguedad,
					categoria);
			arrayEmpleados.add(jefePlanta);
			break;
		case 4:
			PersonalAdministracion personal = new PersonalAdministracion(datosEmpleado[0], datosEmpleado[1],
					datosEmpleado[2], antiguedad);
			arrayEmpleados.add(personal);
			break;
		case 5:
			boolean consejo;
			//Si es true significa que pertenece al consejo
			while (true) {
				System.out.println("¿Esta en el consejo de administracion?" + "\n1.- Si" + "\n2.- No");
				int eleccion = scInt.nextInt();
				if (eleccion == 1) {
					consejo = true;
					break;
				} else if (eleccion == 2) {
					consejo = false;
					break;
				}
			}
			Directivo directivo = new Directivo(datosEmpleado[0], datosEmpleado[1], datosEmpleado[2], antiguedad,
					consejo);
			arrayEmpleados.add(directivo);
			break;

		}
	}

	public static boolean mostrarTrabajadores() {
		
		if (arrayEmpleados.size() >= 1) {
			for (int i = 0; i < arrayEmpleados.size(); i++) {

				arrayEmpleados.get(i).mostrarInformacion(i + 1);
				

			}
			return true;
		} else {
		
			System.out.println("No hay trabajadores en la plantilla");
			continuarOperaciones();
			return false;
		}
		
		
	

	}

	

	public static void eliminarTrabajador() {
		Scanner scInt = new Scanner(System.in);

		System.out.println("ï¿½Que trabajador deseas eliminar?");
		int eleccion = scInt.nextInt() - 1;

		for (int i = 0; i < arrayEmpleados.size(); i++) {

			if (i == eleccion)
				arrayEmpleados.remove(i);
			break;
		}

	}
	
	public static void infoExtendida() {
		
		Scanner scInt = new Scanner(System.in);

		System.out.println("¿Que trabajador deseas mostrar su informacion?");
		int eleccion = scInt.nextInt() - 1;

		for (int i = 0; i < arrayEmpleados.size(); i++) {

			if (i == eleccion) {
				arrayEmpleados.get(i).sueldoNeto();
				arrayEmpleados.get(i).indemnizacion();
				break;
			}
				
		}
		
	}
	
	public static void listadoPorPuesto() {
		Scanner scInt = new Scanner(System.in);
		
		System.out.println("Puesto del empleado a mostrar:\n" + 
					"1.- Mozo de almacen.\n" + 
					"2.- Jefe de seccion.\n" + 
					"3.- Jefe de planta.\n" + 
					"4.- Personal de administracion.\n" + 
					"5.- Directivo");
		
		int eleccion = scInt.nextInt();
		
		if (arrayEmpleados.size() > 0) {
			for (int i = 0; i < arrayEmpleados.size(); i++) {
				int numerador = 1;
				switch (eleccion) {

				case 1:
					if (arrayEmpleados.get(i) instanceof MozoAlmacen) {
						arrayEmpleados.get(i).mostrarInformacion(numerador);
					arrayEmpleados.get(i).sueldoNeto();
					numerador++;
					}
					break;
				case 2:
					if (arrayEmpleados.get(i) instanceof JefeSeccion) {
						arrayEmpleados.get(i).mostrarInformacion(numerador);
					arrayEmpleados.get(i).sueldoNeto();
					numerador++;
					}
					break;
				case 3:
					if (arrayEmpleados.get(i) instanceof JefePlanta) {
						arrayEmpleados.get(i).mostrarInformacion(numerador);
					arrayEmpleados.get(i).sueldoNeto();
					numerador++;
					}
					break;
				case 4:
					if (arrayEmpleados.get(i) instanceof PersonalAdministracion) {
						arrayEmpleados.get(i).mostrarInformacion(numerador);
					arrayEmpleados.get(i).sueldoNeto();
					numerador++;
					}
					break;
				case 5:
					if (arrayEmpleados.get(i) instanceof Directivo) {
						arrayEmpleados.get(i).mostrarInformacion(numerador);
					arrayEmpleados.get(i).sueldoNeto();
					numerador++;
					}
					break;
				}

			} 
		}
		
		
	}
	
	public static void avanceTemporal() {
		
		
		
	}
	
	
	public static void continuarOperaciones() {
		Scanner scLine = new Scanner(System.in);
		System.out.println("Pulse intro para continuar");
		scLine.nextLine();
	}


}
	
	
