package plantillaEmpleados;

public class Directivo extends Empleado {

	int comision = 0;
	double sueldoBruto = 4500 + comision;
	boolean consejo;
	
	
	public void sueldoNeto() {
		int neto = 73;
		if(consejo) System.out.println("Sueldo neto: " + (((neto/100)*this.sueldoBruto)+200));
		else System.out.println("Sueldo neto: " + ((neto/100)*this.sueldoBruto));
	}
	public void indemnizacion() {
		
		double diasTrabajados = (double)this.getAntiguedadTotal();
		double anyosParaAumentar = diasTrabajados/365;
		System.out.println("Indemnizacion: " + ((2/3)*this.sueldoBruto)*anyosParaAumentar);
		
	}
	
	public void aumentoSueldoBruto() {
		int aumentoS = 12;
		double anyosParaAumentar = Math.floor((double)this.getAntiguedad()/365);
		double aumentoFinal = (aumentoS*anyosParaAumentar);
		
		sueldoBruto = sueldoBruto + (aumentoFinal/100)*sueldoBruto;
		this.setAntiguedad(antiguedad - (int)(365*anyosParaAumentar));
		this.setAntiguedadTotal(antiguedadTotal + (int)(365*anyosParaAumentar));
		
	}
	
	//Constructo
	public Directivo(String nombre, String apellidos, String dni, int antiguedad, boolean consejo) {
		super(nombre, apellidos, dni, antiguedad);
		this.consejo = consejo;
		this.setPuesto("Directivo");
		
		if(antiguedad >= 365) {
			aumentoSueldoBruto();
		}
	}
	
	
	
	
	
	
}
