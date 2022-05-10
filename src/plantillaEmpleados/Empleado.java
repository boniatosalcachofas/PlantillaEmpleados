package plantillaEmpleados;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Locale.Category;

public class Empleado implements Cobros{
	
	String nombre;
	String apellidos;
	String dni;
	String puesto;
	int antiguedad = 0;
	int antiguedadTotal = 0;
	double sueldoBruto;
	int PorcentajeNeto;
	int aumentoPorAnyo;
	int categoria;
	
	

	
	public void mostrarInformacion(int i) {
		
		System.out.println(i + ".- " + this.puesto.toUpperCase() + ": " + this.nombre + " " + this.apellidos + ", " + this.dni + ". " + (this.antiguedad+this.antiguedadTotal) + " dias de antiguedad");
		
	}
	public void sueldoNeto() {

		double sueldoNeto = ((this.PorcentajeNeto/100.0)*this.sueldoBruto);
		if(puesto.equals("Directivo")) {
			sueldoNeto = sueldoNeto + 200;
		}
		System.out.println("Sueldo neto: " + Math.round(sueldoNeto*100.0)/100.0);
	}
	public void indemnizacion(Empleado trabajador) {
		
		if((this.getAntiguedadTotal()/365.0) >= 1 && !(trabajador instanceof Directivo)) {
			double indemnizacion = (2.0/3.0)*(this.sueldoBruto);
			System.out.println("Indemnizacion: " + Math.round(indemnizacion*100.0)/100.0);
		}else if((this.getAntiguedadTotal()/365.0) >= 1 && (this.getAntiguedadTotal()/365.0) <= 3 && (trabajador instanceof Directivo)){
			
			double cantidadIndemnizacion = Math.round((this.getAntiguedadTotal()/365.0)*100.0)/100.0;
			double indemnizacion = (2.0/3.0)*(this.sueldoBruto)*cantidadIndemnizacion;
			System.out.println("Indemnizacion: " + Math.round(indemnizacion*100.0)/100.0);
			
		}else if((this.getAntiguedadTotal()/365.0) >= 1 && (trabajador instanceof JefePlanta) && (trabajador instanceof JefeSeccion)) {
			double indemnizacion = (2.0/3.0)*(this.sueldoBruto);
			indemnizacion = indemnizacion + (400*categoria);
			System.out.println("Indemnizacion: " + Math.round(indemnizacion*100.0)/100.0);
		}
		
	}	
	public void aumentoSueldoBruto() {
		
		double anyosParaAumentar = Math.floor(this.getAntiguedad()/365.0);
		double aumentoFinal = (this.aumentoPorAnyo*anyosParaAumentar);
		
		sueldoBruto = sueldoBruto + (aumentoFinal/100)*sueldoBruto;
		this.setAntiguedad(antiguedad - (int)(365*anyosParaAumentar));
		this.setAntiguedadTotal(antiguedadTotal + (int)(365*anyosParaAumentar));
					
	}
	
	public void pasoTiempo(int dias) {
		
		this.antiguedad = this.antiguedad + dias;
		
		while(this.antiguedad >= 365) aumentoSueldoBruto();
		
	}
	
	//Constructores
	public Empleado(String nombre, String apellidos, String dni, int antiguedad, int categoria) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.antiguedad = antiguedad;
		this.categoria = categoria;
	}
	
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

	public int getAumentoPorAnyo() {
		return aumentoPorAnyo;
	}
	public void setAumentoPorAnyo(int aumentoPorAnyo) {
		this.aumentoPorAnyo = aumentoPorAnyo;
	}
	public int getPorcentajeNeto() {
		return PorcentajeNeto;
	}
	public void setPorcentajeNeto(int porcentajeNeto) {
		PorcentajeNeto = porcentajeNeto;
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
