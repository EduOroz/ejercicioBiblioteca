package com.telefonica.biblioteca;

public class Libro {
	
	private String isbn;
	private String titulo;
	private String editorial;
	private int num_paginas;
	private String autor;
	private String año_publicacion;
	
	public Libro(){
	};
	
	public Libro(String isbn, String titulo, String editorial, int num_paginas, String autor, String año_publicacion) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.editorial = editorial;
		this.num_paginas = num_paginas;
		this.autor = autor;
		this.año_publicacion = año_publicacion;
	}
	
	@Override
	public String toString(){
		return "Libro{ ISBN= " +getIsbn() + ", titulo= " +getTitulo() +", editorial= " +getEditorial() + ", Numero Páginas= " +getNum_paginas() +", "
				+ "Autor= " +getAutor() +", Año Publicación= " +getAño_publicacion()+"}" ;
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

	public String getAño_publicacion() {
		return año_publicacion;
	}

	public void setAño_publicacion(String año_publicacion) {
		this.año_publicacion = año_publicacion;
	}


	
}
