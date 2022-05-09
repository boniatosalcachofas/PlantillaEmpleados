package plantillaEmpleados;

public class Directivo extends Empleado {

	int comision = 0;
	double sueldoBruto = 4500 + comision;
	boolean consejo;
	
	
	public void sueldoNeto() {
		int neto = 73;
		double sueldoNeto = ((neto/100.0)*this.sueldoBruto);
		System.out.println("Sueldo neto: " + Math.round(sueldoNeto*100.0)/100.0);
	}
	public void indemnizacion() {
		
		if (this.getAntiguedadTotal()/365.0 >= 1 && this.getAntiguedadTotal()/365.0 <= 3) {
			double anyosParaAumentar = Math.floor(this.getAntiguedadTotal() / 365.0);
			double indemnizacion = (2.0 / 3.0) * (this.sueldoBruto) * anyosParaAumentar;
			System.out.println("Indemnizacion: " + indemnizacion);
		}
		
	}
	
	public void aumentoSueldoBruto() {
		int aumentoS = 12;
		double anyosParaAumentar = Math.floor(this.getAntiguedad()/365.0);
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
		
		while(this.antiguedad >= 365) {
			aumentoSueldoBruto();
		}
	}
	
	
	
	
	
	
}
