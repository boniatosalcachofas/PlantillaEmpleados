package plantillaEmpleados;

public class MozoAlmacen extends Empleado {
	
	double sueldoBruto = 1545.5;
	
	
	
	
	public void sueldoNeto() {
		int neto = 85;
		System.out.println("Sueldo neto: " + ((neto/100)*this.sueldoBruto));
	}
	public void indemnizacion() {
		
		double diasTrabajados = (double)this.getAntiguedadTotal();
		double anyosParaAumentar = diasTrabajados/365;
		System.out.println("Indemnizacion: " + ((2/3)*this.sueldoBruto)*anyosParaAumentar);
		
	}	
	public void aumentoSueldoBruto() {
		int aumentoS = 5;
		double anyosParaAumentar = Math.floor((double)this.getAntiguedad()/365);
		double aumentoFinal = (aumentoS*anyosParaAumentar);
		
		sueldoBruto = sueldoBruto + (aumentoFinal/100)*sueldoBruto;
		this.setAntiguedad(antiguedad - (int)(365*anyosParaAumentar));
		this.setAntiguedadTotal(antiguedadTotal + (int)(365*anyosParaAumentar));
					
	}
		
	
	//Constructor
	public MozoAlmacen(String nombre, String apellidos, String dni, int antiguedad) {
		super(nombre, apellidos, dni, antiguedad);
		this.setPuesto("Mozo de almacen");
		
		if(antiguedad >= 365) {
			aumentoSueldoBruto();
		}
	}

	//Getters and setters
	public double getSueldoBruto() {
		return sueldoBruto;
	}


	public void setSueldoBruto(double sueldoBruto) {
		this.sueldoBruto = sueldoBruto;
	}
	
	
	
	
}