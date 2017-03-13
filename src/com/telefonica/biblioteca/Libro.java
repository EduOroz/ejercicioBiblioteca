package com.telefonica.biblioteca;

public class Libro {
	
	private String isbn;
	private String titulo;
	private String editorial;
	private int num_paginas;
	private String autor;
	private String a�o_publicacion;
	
	public Libro(){
	};
	
	public Libro(String isbn, String titulo, String editorial, int num_paginas, String autor, String a�o_publicacion) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.editorial = editorial;
		this.num_paginas = num_paginas;
		this.autor = autor;
		this.a�o_publicacion = a�o_publicacion;
	}
	
	@Override
	public String toString(){
		return "Libro{ ISBN= " +getIsbn() + ", titulo= " +getTitulo() +", editorial= " +getEditorial() + ", Numero P�ginas= " +getNum_paginas() +", "
				+ "Autor= " +getAutor() +", A�o Publicaci�n= " +getA�o_publicacion()+"}" ;
	}
	

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public int getNum_paginas() {
		return num_paginas;
	}

	public void setNum_paginas(int num_paginas) {
		this.num_paginas = num_paginas;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getA�o_publicacion() {
		return a�o_publicacion;
	}

	public void setA�o_publicacion(String a�o_publicacion) {
		this.a�o_publicacion = a�o_publicacion;
	}


	
}
