package modelo;

import java.util.ArrayList;
import java.util.Random;

import EstructurasDeOrdenamiento.NodeGeneric;

import EstructurasDeOrdenamiento.Stack;

public class Client {
	
		private String id;
		private Book[] booksSelected;
		private Stack<Book> basket;
		private int time;
		
		
		public Client(String id) {
			this.id=id;
			basket= new Stack<Book>();
			time=0;
		}
		public void selectedBooks(ArrayList<Book> books) {
			Random r=new Random();
			int numberBook=r.nextInt(books.size())+1;
			booksSelected=new Book[numberBook];
			for (int i = 0; i < numberBook; i++) {
				int indice=r.nextInt(books.size()-1);
				booksSelected[i]=books.get(indice);
			}
//			agregarLibroACanasta(LibrosSeleccionados);
		}
		
		public String getId() {
			return id;
		}
		
		
		public void setId(String id) {
			this.id = id;
		}
		
		
		public Stack<Book> getCarrito() {
			return basket;
		}
		
		
		public void setCarrito(Stack<Book> carrito) {
			this.basket = carrito;
		}
		
		
//		public void agregarLibroACanasta(Book[] librosEscogidos) {
//			for(int i=0;i<librosEscogidos.length;i++) {
//				NodeGeneric<Book> librito = new NodeGeneric<Book>(librosEscogidos[i]);
//				basket.push(librito);
//			}
//		}
		
		public void addBookAtBasket(Book libro) {
			NodeGeneric<Book> librito = new NodeGeneric<Book>(libro);
			basket.push(librito);

		}
		public Stack<Book> sacarLibroDelCarrito() {
			Stack<Book> nuevaCanasta=new Stack<Book>();
			while(basket.getSize()!=0) {
				System.out.println("Entro");
			nuevaCanasta.push(basket.pop());	
			}
			
			return nuevaCanasta;
		}
		public Book[] getLibrosSeleccionados() {
			return booksSelected;
		}
		public void setLibrosSeleccionados(Book[] booksSelected) {
			this.booksSelected = booksSelected;
		}
		public int getTime() {
			return time;
		}
		public void setTime(int time) {
			this.time = time;
		}
		
		public int compareTo(Client c1) {
			if(this.time>c1.getTime()) {
				return 1;
			}else if(this.time<c1.getTime()) {
				return -1;
			}else {
				return 0;
			}
			// TODO Auto-generated method stub
		}
		
		
		
		
		
		}
