package plantillaEmpleados;

public class Directivo extends Empleado {

	int comision = 0;
	boolean consejo;
	

	//Constructo
	public Directivo(String nombre, String apellidos, String dni, int antiguedad, boolean consejo) {
		super(nombre, apellidos, dni, antiguedad);
		this.consejo = consejo;
		this.setPuesto("Directivo");
		this.setSueldoBruto(4500 + comision);
		this.setPorcentajeNeto(73);
		this.setAumentoPorAnyo(12);
		
		while(this.antiguedad >= 365) {
			aumentoSueldoBruto();
		}
	}
	
	
	
	
	
	
}
