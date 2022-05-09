package plantillaEmpleados;

public class JefeSeccion extends Empleado {
	
	int categoria = 0;
	double sueldoBruto = 1750 + (50*categoria);
	
	
	
	
	public void sueldoNeto() {
		int neto = 83;
		System.out.println("Sueldo neto: " + ((neto/100)*this.sueldoBruto));
		
	}
	public void indemnizacion() {
		
		double diasTrabajados = (double)this.getAntiguedadTotal();
		double anyosParaAumentar = diasTrabajados/365;
		System.out.println("Indemnizacion: " + ((2/3)*this.sueldoBruto)*anyosParaAumentar);
		
	}
	public void aumentoSueldoBruto() {
		int aumentoS = 7;
		double anyosParaAumentar = Math.floor((double)this.getAntiguedad()/365);
		double aumentoFinal = (aumentoS*anyosParaAumentar);
		
		sueldoBruto = sueldoBruto + (aumentoFinal/100)*sueldoBruto;
		this.setAntiguedad(antiguedad - (int)(365*anyosParaAumentar));
		this.setAntiguedadTotal(antiguedadTotal + (int)(365*anyosParaAumentar));
		
		
	}
	
	//Constructor
	public JefeSeccion(String nombre, String apellidos, String dni, int antiguedad, int categoria) {
		super(nombre, apellidos, dni, antiguedad);
		this.categoria = categoria;
		this.setPuesto("Jefe de seccion");
		
		if(antiguedad >= 365) {
			aumentoSueldoBruto();
		}
	}


	//Getters and setters
	public int getCategoria() {
		return categoria;
	}



	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}



	public double getSueldoBruto() {
		return sueldoBruto;
	}



	public void setSueldoBruto(double sueldoBruto) {
		this.sueldoBruto = sueldoBruto;
	}

	
}
