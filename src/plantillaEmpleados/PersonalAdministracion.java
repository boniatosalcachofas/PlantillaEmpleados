package plantillaEmpleados;

public class PersonalAdministracion extends Empleado {

	
	

	
	//Constructor
	public PersonalAdministracion(String nombre, String apellidos, String dni, int antiguedad) {
		super(nombre, apellidos, dni, antiguedad);
		this.setPuesto("Personal de administracion");
		this.setSueldoBruto(1635);
		this.setPorcentajeNeto(84);
		this.setAumentoPorAnyo(6);
		
		
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