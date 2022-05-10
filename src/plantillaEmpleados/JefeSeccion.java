package plantillaEmpleados;

public class JefeSeccion extends Empleado {
	
	int categoria = 0;
	
	
	
	

	
	//Constructor
	public JefeSeccion(String nombre, String apellidos, String dni, int antiguedad, int categoria) {
		super(nombre, apellidos, dni, antiguedad, categoria);
		this.categoria = categoria;
		this.setPuesto("Jefe de seccion");
		this.setSueldoBruto(1750 + (50*categoria));
		this.setPorcentajeNeto(83);
		this.setAumentoPorAnyo(7);
		
		while(this.antiguedad >= 365) {
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
