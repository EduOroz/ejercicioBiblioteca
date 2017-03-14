package com.telefonica.biblioteca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Query {

	Connection con = null;
	
	public Query(Conexion conexion){
		this.con = conexion.getConnection();
	}
	
	public void newBook(String isbn, String titulo, String editorial, int num_paginas, String autor, String año_publicacion){
		try {
			String query = "insert into libro (isbn, titulo, editorial, num_paginas, autor, año_publicacion) values (?,?,?,?,?,?);";
			//Vamos a indicar a la sentencia que nos devuelva las Keys generadas para saber que Id se le asigna
			PreparedStatement preparedStmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			preparedStmt.setString(1, isbn);
			preparedStmt.setString(2, titulo);
			preparedStmt.setString(3, editorial);
			preparedStmt.setInt(4, num_paginas);
			preparedStmt.setString(5, autor);
			preparedStmt.setString(6, año_publicacion);
			preparedStmt.execute();
			System.out.println("Se ha dado de alta un nuevo libro");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {} 
	
	}
	
	public boolean existsBook(String isbn){
		boolean existe = false;
		try {
			String query = "select count(*) from libro where isbn = '"+isbn +"';";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()){
				if (rs.getInt(1)==1) {
					//System.out.println("Ya existe un libro con el isbn proporcionado");
					existe = true;
				}
				
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return existe;
	
	} 
	
	public void newUser(String nombre, String apellidos, String dni, String direccion, int edad){
		try {
			String query = "insert into usuarios (dni, nombre, apellidos, direccion, edad) values (?,?,?,?,?);";
			//Vamos a indicar a la sentencia que nos devuelva las Keys generadas para saber que Id se le asigna
			PreparedStatement preparedStmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			preparedStmt.setString(1, dni);
			preparedStmt.setString(2, nombre);
			preparedStmt.setString(3, apellidos);
			preparedStmt.setString(4, direccion);
			preparedStmt.setInt(5, edad);
			preparedStmt.execute();
			System.out.println("Se ha dado de alta un nuevo usuario");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {} 
	}
	
	public boolean existsUser(String dni){
		boolean existe = false;
		try {
			String query = "select count(*) from usuarios where dni = '"+dni +"';";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()){
				if (rs.getInt(1)==1) {
					//System.out.println("Ya existe un usuario con el dni proporcionado");
					existe = true;
				}
				
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return existe;
	
	} 
	
	public boolean availablePrestamo(String isbn){
		boolean available = true;
		try {
			String query = "select count(*) from prestamos where `ISBN libro` = '"+isbn +"' and `fecha recibido` is null;";
			//System.out.println(query);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()){
				if (rs.getInt(1)==1) {
					available = false;
					//System.out.println(available);
				}
				
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return available;
	
	} 
	
	public void newPrestamo(String dni, String isbn){
		
		int id_cliente = -1;
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		//System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
		
		try {
			String query = "select ID from usuarios where DNI = '" +dni +"';";
			//System.out.println(query);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()){
				id_cliente = rs.getInt(1);
				//System.out.println("El id del cliente es: " +id_cliente);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			String query = "insert into prestamos (`ID cliente`, `ISBN libro`, `Fecha Prestamo`) values (?,?,?);";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setInt(1, id_cliente);
			preparedStmt.setString(2, isbn);
			preparedStmt.setString(3, dateFormat.format(date));
			preparedStmt.execute();
			System.out.println("Se ha creado el prestamos solicitado");

			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {} 
	
	}
	
	public Libro[] getBooks(){
		int num_libros=0;
		try {
			String query = "select count(*) from libro;";
			//Vamos a indicar a la sentencia que nos devuelva las Keys generadas para saber que Id se le asigna
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()){
				num_libros = rs.getInt(1);
				System.out.println("Número de libros en la biblioteca: " +num_libros);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Libro biblioteca[] = new Libro[num_libros];
		
		try {
			String query = "select * from libro;";
			//Vamos a indicar a la sentencia que nos devuelva las Keys generadas para saber que Id se le asigna
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			int i=0;
			while (rs.next()){
				biblioteca[i] = new Libro(rs.getString("isbn"), rs.getString("titulo"), rs.getString("editorial"), rs.getInt("num_paginas"), rs.getString("autor"), rs.getString("año_publicacion"));
				//System.out.println(i +": " +biblioteca[i].toString());
				i++;
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {} 
		return biblioteca;
	}
	
	public void showBooks(){
		Libro biblioteca[] = this.getBooks();
		for (int i=0; i < biblioteca.length; i++){
			System.out.println(i +": " +biblioteca[i].toString());
		}
	}
	
	public Usuario[] getUsers(){
		int num_users=0;
		try {
			String query = "select count(*) from usuarios;";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()){
				num_users = rs.getInt(1);
				System.out.println("Número de usuarios en la biblioteca: " +num_users);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Usuario usuarios[] = new Usuario[num_users];
		
		try {
			String query = "select * from usuarios;";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			int i=0;
			while (rs.next()){
				usuarios[i] = new Usuario(rs.getString("nombre"), rs.getString("apellidos"), rs.getInt("id"), rs.getString("dni"), rs.getString("direccion"), rs.getInt("edad"));
				i++;
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {} 
		return usuarios;
	}
	
	public void showUsers(){
		Usuario usuarios[] = this.getUsers();
		for (int i=0; i < usuarios.length; i++){
			System.out.println(i +": " +usuarios[i].toString());
		}
	}
	
	public Prestamo[] getPrestamos(){
		int num_prestamos=0;
		try {
			String query = "select count(*) from prestamos;";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()){
				num_prestamos = rs.getInt(1);
				System.out.println("Número de préstamos en la biblioteca: " +num_prestamos);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Prestamo prestamos[] = new Prestamo[num_prestamos];
		
		try {
			String query = "select prestamos.Id, usuarios.DNI, prestamos.`ISBN libro`, prestamos.`Fecha prestamo`, prestamos.`Fecha recibido`, prestamos.Sancion from prestamos join usuarios on prestamos.`ID cliente` = usuarios.ID;";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			int i=0;
			while (rs.next()){
				prestamos[i] = new Prestamo(rs.getInt("Id"), rs.getInt("DNI"), rs.getString("ISBN libro"), rs.getString("Fecha Prestamo"), rs.getString("Fecha Recibido"), rs.getInt("Sancion"));
				i++;
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {} 
		return prestamos;
	}
	
	public void showPrestamos(){
		Prestamo prestamos[] = this.getPrestamos();
		for (int i=0; i < prestamos.length; i++){
			System.out.println(i +": " +prestamos[i].toString());
		}
	}
}
