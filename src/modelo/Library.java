package modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

import EstructurasDeOrdenamiento.Queque;
import EstructurasDeOrdenamiento.HashTable;
import EstructurasDeOrdenamiento.NodeGeneric;

public class Library{

	//Cantida de cajas registradoras
	private int amountCashRegister;
	
	//Cantidad de clientes
	private int amountClients;
	
	//Cantidad de Estanterias
	private int amountShelves;
	
	private Shelving<String,Integer>[] shelves;
	private Cajera[] cajeras;
	private ArrayList<Book> AllBooksLibrary;
	private Client[] coustumers;
	private Queque<Client> rowCoustomers;
	 
	public Library(int amountCashRegister, int amountClients, int amountShelves) {

		this.amountCashRegister = amountCashRegister;
		this.amountClients = amountClients;
		this.amountShelves = amountShelves;
		rowCoustomers= new Queque<>();
	}

	
	public int getAmountCashRegister() {
		return amountCashRegister;
	}

	public void setAmountCashRegister(int amountCashRegister) {
		this.amountCashRegister = amountCashRegister;
	}

	public int getAmountClients() {
		return amountClients;
	}

	public void setAmountClients(int amountClients) {
		this.amountClients = amountClients;
	}

	public int getAmountShelves() {
		return amountShelves;
	}

	public void setAmountShelves(int amountShelves) {
		this.amountShelves = amountShelves;
	}
	
	

	
	public void createShelves() {
		shelves =new Shelving[amountShelves];	
		coustumers=new Client[amountClients];
		Random r = new Random();

		int i=0;
		for (int a = 'A'; a < 'Z'&&i<amountShelves; a++) {
			int cant = r.nextInt(12)+1;
			String code=a+"";
			shelves[i]=new Shelving<String,Integer>(code,cant);
			i++;
		}
		

	}
	

	int indicadorposicionlibrotexto=0;
	int fin=0;

	public void addBookAtShelve() {
		AllBooksLibrary=new ArrayList<Book>();
		for (int i = 0; i < shelves.length; i++) {
			
			int  amountBook=shelves[i].getAmountL();
	        fin+=amountBook;
			readFile(fin,i);
		}
	}
	

	private void readFile(int amountBook, int i) {
		int lineaactual=0;
  
			 BufferedReader br = null;
		      try {
		         
		         br =new BufferedReader(new FileReader("archivos/libros.txt"));
		         String line ="";
		         
		         while ((line=br.readLine())!=null ) {
		        	 lineaactual++;

		        	 if(indicadorposicionlibrotexto<lineaactual&&lineaactual<=(amountBook)) {

		        		 String [] infoLibro = line.split(",");
		        		 Book libro=new Book(infoLibro[0], Integer.parseInt(infoLibro[1]), Integer.parseInt(infoLibro[2]));
		        		 AllBooksLibrary.add(libro);
			             shelves[i].addBookAtHash(libro);

		            		if(lineaactual==amountBook) {
		            			indicadorposicionlibrotexto=amountBook;
		            		}
		        	 }
		         }
		            br.close();
		         
		      } catch (Exception e) {
		     
		      			
		}
	}
	
	
	
	public void createCoustomers() {
		Random r=new Random();
		for (int i = 0; i < coustumers.length; i++) {
			int id=r.nextInt(9999)+1000;

			coustumers[i]=new Client("C"+id);
			System.out.println("Id cliente: " + coustumers[i].getId());
			long t1 = System.nanoTime();
			coustumers[i].selectedBooks(AllBooksLibrary);	
			long t2 = System.nanoTime();
			int timeTotal=(int) ((t2-t1));
			coustumers[i].setTime(coustumers[i].getTime()+timeTotal);

		}
	}
	
	
	
	
//	int indicadorposicionlibrotexto=0;
//	int fin=0;
//
//	public void agregarLibroEstanteria() {
//		AllBooksLibrary=new ArrayList<Libro>();
//		for (int i = 0; i < estanterias.length; i++) {
//			
//			int  amountBook=estanterias[i].getAmountL();
//		//	indicadorposicionlibrotexto+=amountBook;
//			
//			System.out.println("total libros estanteria"+amountBook+"     -------------------------");
//		
//	         fin+=amountBook;
//
//			leerArchivo(fin,i);
//
////			System.out.println("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
////			System.out.println(amountBook+"  prueba");
//		}
//	}
//	
//
//	private void leerArchivo(int amountBook, int i) {
//		int lineaactual=0;
//		boolean terminar=false;
//		//for (int i = 0; i < amountBook; i++) {
//  
//			 BufferedReader br = null;
//		      try {
//		         
//		         br =new BufferedReader(new FileReader("archivos/libros.txt"));
//		         String line ="";
//		         
//		         while ((line=br.readLine())!=null &&!terminar) {
//		        	 lineaactual++;
//		        //	 System.out.println(indicadorposicionlibrotexto+" < "+lineaactual+" && "+lineaactual+" <= "+(amountBook));
//
//		        	 if(indicadorposicionlibrotexto<lineaactual&&lineaactual<=(amountBook)) {
//			        	 System.out.println(indicadorposicionlibrotexto+" < "+lineaactual+" && "+lineaactual+" <= "+(amountBook));
//
//		            String [] infoLibro = line.split(",");
//		            	Libro libro=new Libro(infoLibro[0], Integer.parseInt(infoLibro[1]), Integer.parseInt(infoLibro[2]));
//		            	System.out.println(libro.getIsbn());
//		            	estanterias[i].agregarLibroAHash(libro);
//		            	AllBooksLibrary.add(libro);
//		            		if(lineaactual==amountBook) {
//		       		         indicadorposicionlibrotexto=amountBook;
//		       		         terminar=true;
//		            		}
//
//		         }
//
//		         }
//		 //        System.out.println("Aumenta el inicio");
//		 //        amountBook+=amountBook;
//		            br.close();
//		          
//		         
//		      } catch (Exception e) {
//		     
//		      
//		  //    }
//			
//		}
//	}

	public ArrayList<Book> getAllBooksLibrary() {
		return AllBooksLibrary;
	}


	public void setAllBooksLibrary(ArrayList<Book> allBooksLibrary) {
		AllBooksLibrary = allBooksLibrary;
	}


	public Shelving<String, Integer>[] getShelves(){
		return shelves;
	}


	public Client[] getCoustumers() {
		return coustumers;
	}


	public void setCoustumers(Client[] coustumers) {
		this.coustumers = coustumers;
	}


	public Queque<Client> getRowCoustomers() {
		return rowCoustomers;
	}


	public void setRowCoustomers(Queque<Client> rowCoustomers) {
		this.rowCoustomers = rowCoustomers;
	}
	
	//ordena ls cliente utilizando un metodo de ordenamiento
	//basado en el tiempo total de los clientes
	public ArrayList<Client> sortCustomersByTime() {
		
ArrayList<Client> coustumersSort= new ArrayList<>();
for(int i=0;i<this.coustumers.length;i++) {
	coustumersSort.add(i,coustumers[i]);
}
		
for(int i=0;i<coustumersSort.size();i++) {
	Client clientForInsert= coustumersSort.get(i);
	boolean find=false;
	for(int j=i;j>0&&!find;j--) {
		Client clientActually=coustumersSort.get(j-1);
		if(clientActually.getTime()>clientForInsert.getTime()) {
			coustumersSort.set(j, clientActually);
			coustumersSort.set(j-1, clientForInsert);
			
		}else {
			find=true;
		}
	}
	
	
}
return coustumersSort;
	}
	         

	
	
	
	public void collectBooksFromTheShelves() {
		for(int i=0;i<coustumers.length;i++) {
			Client c1= coustumers[i];
			long t1= System.nanoTime();
			
			for(int j=0;j<shelves.length;j++) {
				Book[] booksSelected=c1.getLibrosSeleccionados();
				
				for(int k=0;k<booksSelected.length;k++) {
					Book book=booksSelected[k];
					HashTable<String, Book> has=shelves[j].getHash();
					int posBook=has.hashFuntion(book.getIsbn());
					NodeGeneric<Book> nodo1=has.getNodos()[posBook];
					boolean add=false;
					while(nodo1!=null&&!add) {
						if(nodo1.getTOffNode().getIsbn().equalsIgnoreCase(book.getIsbn())) {
							c1.addBookAtBasket(book);
							add=true;
						}else {
							nodo1=nodo1.getNext();
						}
					}
				}
				
			}
			long t2 = System.nanoTime();
			int totalTime=(int) ((t2-t1));
			c1.setTime(totalTime+c1.getTime());
			
			
		}
	}
	
	//agregar clienes a la fila//
	public void addCoustumersAtRow() {
		ArrayList<Client> coustumersSort=sortCustomersByTime();

		for(int i=0;i<coustumersSort.size();i++) {
			rowCoustomers.enqueque(coustumersSort.get(i));
		}
	}
	
	
	
	
}
