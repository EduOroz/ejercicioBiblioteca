package com.telefonica.biblioteca;

import java.util.Scanner;

public class ProgramaPrincipal {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		String opcion = "", isbn, titulo, autor, editorial, año_publicacion, nombre, apellidos, dni, direccion;
		//String c;
		int num_paginas, edad;
		//Libro biblioteca = new Libro();		//Variable para consultar todos los libros
		Query q = new Query(new Conexion());
		
		while (!opcion.equals("9")){
			System.out.println("");
			System.out.println("Bienvenido, elija una de las siguientes opciones:");
			System.out.println("1 - Crea un nuevo libro");
			System.out.println("2 - Crear un nuevo usuario");
			System.out.println("3 - Mostrar libros disponibles");
			System.out.println("4 - Mostrar usuarios disponibles");
			System.out.println("5 - Gestionar un préstamo");
			System.out.println("6 - Mostrar los préstamos en curso");
			System.out.println("9 - Salir");
			opcion = teclado.nextLine();
			//System.out.println("He recogido: "+opcion);
			//Según la opción:
			switch(opcion){
				case "1": 	System.out.println("Introduce los datos del libro a dar de alta");
							System.out.println("ISBN:");
							isbn = teclado.nextLine();
							System.out.println("Titulo:");
							titulo = teclado.nextLine();
							System.out.println("Autor:");
							autor = teclado.nextLine();
							System.out.println("Editorial:");
							editorial = teclado.nextLine();
							System.out.println("Año publicación:");
							año_publicacion = teclado.nextLine();
							System.out.println("Número Páginas:");
							num_paginas = teclado.nextInt();
							//System.out.println("Introduciendo datos....");
							if (!q.existsBook(isbn)) {
								q.newBook(isbn, titulo, editorial, num_paginas, autor, año_publicacion);
							} else {System.out.println("No se ha podido dar de alta, el isbn ya existe en la biblioteca");}
							break;
							
				case "2":	System.out.println("Introduce los datos del usuario a dar de alta");
							System.out.println("Nombre:");
							nombre = teclado.nextLine();
							System.out.println("Apellidos:");
							apellidos = teclado.nextLine();
							System.out.println("Dni:");
							dni = teclado.nextLine();
							System.out.println("Direccion:");
							direccion = teclado.nextLine();
							System.out.println("Edad:");							
							edad = teclado.nextInt();
							//System.out.println("Introduciendo datos....");
							if (!q.existsUser(dni)) {
								q.newUser(nombre, apellidos, dni, direccion, edad);
							} else {System.out.println("No se ha podido dar de alta, el usuario ya existe en la biblioteca");}
							
				
							break;
							
				case "3": 	System.out.println("Los libros que tenemos actualmente en la biblioteca son:");
							q.showBooks();
							
							break;
				
				case "4": 	System.out.println("Los usuarios dados de alta en la biblioteca son:");
							q.showUsers();
				
							break;
				
				case "5":	System.out.println("Introduce el DNI del usuarios que desea solicitar el prestamo");
							dni = teclado.nextLine();
							System.out.println("Introduce el ISBN del libro para el que desea solicitar el prestamo");
							isbn = teclado.nextLine();
							q.newPrestamo(dni, isbn);
									
							break;
				
				case "6": 	System.out.println("Los prestamos realizados en la biblioteca son:");
							q.showPrestamos();
				
							break;
							
				case "9": 	System.out.println("Gracias por jugar con nosotros :)");
							break;
			}
		}
	
	}

}
