package plantillaEmpleados;

public class JefePlanta extends Empleado {
	
	int categoria = 0;
	double sueldoBruto = 1825.5 + (60*categoria);
	
	
	public void sueldoNeto() {
		int neto = 81;
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
		int aumentoS = 9;
		double anyosParaAumentar = Math.floor(this.getAntiguedad()/365.0);
		double aumentoFinal = (aumentoS*anyosParaAumentar);
		
		sueldoBruto = sueldoBruto + (aumentoFinal/100)*sueldoBruto;
		this.setAntiguedad(antiguedad - (int)(365*anyosParaAumentar));
		this.setAntiguedadTotal(antiguedadTotal + (int)(365*anyosParaAumentar));
		
		
	}
	//Constructor
	public JefePlanta(String nombre, String apellidos, String dni, int antiguedad, int categoria) {
		super(nombre, apellidos, dni, antiguedad);
		this.categoria = categoria;
		this.setPuesto("Jefe de planta");
		
		while(this.antiguedad >= 365) {
			aumentoSueldoBruto();
		}
	}

	//Getters and...
	public int getCategoria() {
		return categoria;
	}


	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}


	public double getSueldobruto() {
		return sueldoBruto;
	}


	public void setSueldobruto(double sueldobruto) {
		this.sueldoBruto = sueldobruto;
	}
	
	
	
}
