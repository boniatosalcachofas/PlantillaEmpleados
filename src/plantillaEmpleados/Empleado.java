package plantillaEmpleados;

import java.util.Scanner;
import java.util.Arrays;

public abstract class Empleado implements Cobros{
	
	String nombre;
	String apellidos;
	String dni;
	String puesto;
	int antiguedad = 0;
	int antiguedadTotal = 0;
	double sueldoBruto;
	
	
	public abstract void sueldoNeto();
	public abstract void indemnizacion();
	
	public void mostrarInformacion(int i) {
		
		System.out.println(i + ".- " + this.puesto.toUpperCase() + ": " + this.nombre + " " + this.apellidos + ", " + this.dni + ". " + (this.antiguedad+this.antiguedadTotal) + " dias de antiguedad");
		
	}
	
	//Constructores
	public Empleado(String nombre, String apellidos, String dni, int antiguedad) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.antiguedad = antiguedad;
	}

	//Getters and setters
	
	
	public String getNombre() {
		return nombre;
	}

	public double getSueldoBruto() {
		return sueldoBruto;
	}
	public void setSueldoBruto(double sueldoBruto) {
		this.sueldoBruto = sueldoBruto;
	}
	public int getAntiguedadTotal() {
		return antiguedadTotal;
	}
	public void setAntiguedadTotal(int antiguedadTotal) {
		this.antiguedadTotal = antiguedadTotal;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public int getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}
}
