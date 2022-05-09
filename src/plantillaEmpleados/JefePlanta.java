package plantillaEmpleados;

public class JefePlanta extends Empleado {
	
	int categoria = 0;
	double sueldoBruto = 1825.5 + (60*categoria);
	
	
	public void sueldoNeto() {
		int neto = 81;
		System.out.println("Sueldo neto: " + ((neto/100)*this.sueldoBruto));
		
	}
	public void indemnizacion() {
		
		double diasTrabajados = (double)this.getAntiguedadTotal();
		double anyosParaAumentar = diasTrabajados/365;
		System.out.println("Indemnizacion: " + ((2/3)*this.sueldoBruto)*anyosParaAumentar);
		
	}
	
	public void aumentoSueldoBruto() {
		int aumentoS = 9;
		double anyosParaAumentar = Math.floor((double)this.getAntiguedad()/365);
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
		
		if(antiguedad >= 365) {
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
