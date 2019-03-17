package modelo;

import EstructurasDeOrdenamiento.HashTable;

//Estanteria tiene un String y un numero que representa la cant de libros
	public class Shelving <K,T>{

	private String Id;
	private int amountL;
	private int totalOfBooks;
	
	private HashTable<String,Book> hash;
	
	//Aqui me agrega el id de la estateria
	public Shelving(String K,Integer T) {
		Id= K;
		amountL= T;
		hash= new HashTable<>(amountL);

	}

public void addBookAtHash(Book book) {
		
		hash.add(book.getIsbn(), book);
		
	}
	
	
	public String getId() {
		return Id;
	}



	public void setId(String id) {
		Id = id;
	}



	public int getAmountL() {
		return amountL;
	}



	public void setAmountL(int amountL) {
		this.amountL = amountL;
	}

	public HashTable<String, Book> getHash() {
		return hash;
	}

	public void setHash(HashTable<String, Book> hash) {
		this.hash = hash;
	}






}