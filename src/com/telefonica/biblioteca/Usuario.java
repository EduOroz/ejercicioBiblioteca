package com.telefonica.biblioteca;

public class Usuario {

	private String nombre;
	private String apellidos;
	private int id;
	private String dni;
	private String direccion;
	private int edad;
	
	public Usuario () {
		
	}

	public Usuario(String nombre, String apellidos, int id, String dni, String direccion, int edad) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.id = id;
		this.dni = dni;
		this.direccion = direccion;
		this.edad = edad;
	}
	
	@Override
	public String toString(){
		return "Usuario{ Nombre= " +getNombre() + ", Apellidos= " +getApellidos() +", ID= " +getId() + ", DNI= " +getDni() +", "
				+ "Dirección= " +getDireccion() +", Edad= " +getEdad()+"}" ;
	}

	public String getNombre() {
		return nombre;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	
}
