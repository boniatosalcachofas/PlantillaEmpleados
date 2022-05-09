package plantillaEmpleados;

public class PersonalAdministracion extends Empleado {

	double sueldoBruto = 1635;
	
	

	public void sueldoNeto() {
		double neto = 84;
		System.out.println("Sueldo neto: " + (int)((neto/100)*this.sueldoBruto));
	}
	public void indemnizacion() {
		double diasTrabajados = (double)this.getAntiguedadTotal();
		double anyosParaAumentar = diasTrabajados/365;
		double indemnizacion = (2/3)*(double)(this.sueldoBruto)*anyosParaAumentar;
		System.out.println("Indemnizacion: " + indemnizacion);
		
	}
	public void aumentoSueldoBruto() {
		int aumentoS = 6;
		double anyosParaAumentar = Math.floor((double)this.getAntiguedad()/365);
		double aumentoFinal = (aumentoS*anyosParaAumentar);
		
		sueldoBruto = sueldoBruto + (aumentoFinal/100)*sueldoBruto;
		this.setAntiguedad(antiguedad - (int)(365*anyosParaAumentar));
		this.setAntiguedadTotal(antiguedadTotal + (int)(365*anyosParaAumentar));
		
	}
	
	//Constructor
	public PersonalAdministracion(String nombre, String apellidos, String dni, int antiguedad) {
		super(nombre, apellidos, dni, antiguedad);
		this.setPuesto("Personal de administracion");
		
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