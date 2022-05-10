package plantillaEmpleados;

public class MozoAlmacen extends Empleado {

	
	
	
	
		
	
	//Constructor
	public MozoAlmacen(String nombre, String apellidos, String dni, int antiguedad) {
		super(nombre, apellidos, dni, antiguedad);
		this.setPuesto("Mozo de almacen");
		this.setSueldoBruto(1545.5);
		this.setPorcentajeNeto(85);
		this.setAumentoPorAnyo(5);
		
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