package plantillaEmpleados;

public class JefePlanta extends Empleado {
	
	int categoria = 0;
	
	

	
	
	//Constructor
	public JefePlanta(String nombre, String apellidos, String dni, int antiguedad, int categoria) {
		super(nombre, apellidos, dni, antiguedad, categoria);
		this.categoria = categoria;
		this.setPuesto("Jefe de planta");
		this.setSueldoBruto(1825.5 + (60*categoria));
		this.setPorcentajeNeto(81);
		this.setAumentoPorAnyo(9);
		
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
