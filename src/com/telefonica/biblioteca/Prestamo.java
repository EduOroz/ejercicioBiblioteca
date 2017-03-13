package com.telefonica.biblioteca;

public class Prestamo {

	private int id_prestamo;
	private int id_cliente;
	private String isbn;
	private String fecha_prestamo;
	private String fecha_recibido;
	private int sancion;
	
	public Prestamo () {}

	public Prestamo(int id_prestamo, int id_cliente, String isbn, String fecha_prestamo) {
		super();
		this.id_prestamo = id_prestamo;
		this.id_cliente = id_cliente;
		this.isbn = isbn;
		this.fecha_prestamo = fecha_prestamo;
	}

	
	public Prestamo(int id_prestamo, int id_cliente, String isbn, String fecha_prestamo, String fecha_recibido,
			int sancion) {
		super();
		this.id_prestamo = id_prestamo;
		this.id_cliente = id_cliente;
		this.isbn = isbn;
		this.fecha_prestamo = fecha_prestamo;
		this.fecha_recibido = fecha_recibido;
		this.sancion = sancion;
	}

	@Override
	public String toString(){
		return "Prestamo{ Num_prestamo= " +getId_prestamo() + ", A quién= " +getId_cliente() +", Libro= " +getIsbn() + ", Fecha del prestamo= " +getFecha_prestamo() +", "
				+ "Fecha devolución libro= " +getFecha_recibido() +", Sanción= " +getSancion()+"}" ;
	}
	
	public int getId_prestamo() {
		return id_prestamo;
	}

	public void setId_prestamo(int id_prestamo) {
		this.id_prestamo = id_prestamo;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getFecha_prestamo() {
		return fecha_prestamo;
	}

	public void setFecha_prestamo(String fecha_prestamo) {
		this.fecha_prestamo = fecha_prestamo;
	}

	public String getFecha_recibido() {
		return fecha_recibido;
	}

	public void setFecha_recibido(String fecha_recibido) {
		this.fecha_recibido = fecha_recibido;
	}

	public int getSancion() {
		return sancion;
	}

	public void setSancion(int sancion) {
		this.sancion = sancion;
	}
	
	
	
}
