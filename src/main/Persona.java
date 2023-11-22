package main;

import java.time.LocalDateTime;

public class Persona {
	
	private String nombre;
	private String apellido;
	private LocalDateTime fechNacimiento;
	private Carrito carrito;
	
	public Persona(String nombre, String apellido, LocalDateTime fechNacimiento, Carrito carrito) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechNacimiento = fechNacimiento;
		this.carrito = carrito;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDateTime getFechNacimiento() {
		return fechNacimiento;
	}

	public void setFechNacimiento(LocalDateTime fechNacimiento) {
		this.fechNacimiento = fechNacimiento;
	}

	public Carrito getCarrito() {
		return carrito;
	}

	public void setCarrito(Carrito carrito) {
		this.carrito = carrito;
	}

	public int edad() {
		return LocalDateTime.now().getDayOfYear() - fechNacimiento.getDayOfYear();
	}
	
}
