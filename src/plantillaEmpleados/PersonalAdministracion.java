package plantillaEmpleados;

public class PersonalAdministracion extends Empleado {

	
	

	public void sueldoNeto() {
		int neto = 84;
		double sueldoNeto = ((neto/100.0)*this.sueldoBruto);
		System.out.println("Sueldo neto: " + Math.round(sueldoNeto*100.0)/100.0);
	}
	public void indemnizacion() {
		
		if((Math.floor((this.getAntiguedadTotal()/365.0)*100.0)/100.0) == 1) {
		double indemnizacion = (2.0/3.0)*(this.sueldoBruto);
		System.out.println("Indemnizacion: " + indemnizacion);
		}
		
	}
	public void aumentoSueldoBruto() {
		int aumentoS = 6;
		double anyosParaAumentar = Math.floor(this.getAntiguedad()/365.0);
		double aumentoFinal = (aumentoS*anyosParaAumentar);
		
		sueldoBruto = sueldoBruto + (aumentoFinal/100)*sueldoBruto;
		this.setAntiguedad(antiguedad - (int)(365*anyosParaAumentar));
		this.setAntiguedadTotal(antiguedadTotal + (int)(365*anyosParaAumentar));
		
	}
	
	//Constructor
	public PersonalAdministracion(String nombre, String apellidos, String dni, int antiguedad) {
		super(nombre, apellidos, dni, antiguedad);
		this.setPuesto("Personal de administracion");
		this.setSueldoBruto(1635);
		
		while(this.antiguedad >= 365) {
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