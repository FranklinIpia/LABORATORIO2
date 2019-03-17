package application;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import EstructurasDeOrdenamiento.Queque;
import EstructurasDeOrdenamiento.HashTable;
import EstructurasDeOrdenamiento.NodeGeneric;
import EstructurasDeOrdenamiento.Stack;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import modelo.Client;
import modelo.Shelving;
import modelo.Book;

public class ControlVista {


	
	//Panel en donde se crea la libreria
	@FXML
	private VBox CreateLibrary;
		//cantidad de cajas registradoras
		@FXML
		private TextField caseTest;
		//cantidad de cajas registradoras
		@FXML
		private TextField amountCashR;
		//Cantidad de clientes
		@FXML
		private TextField amountC;
		//Cantidad de Estanterias
		@FXML
		private TextField amountS;
	
		
//		
//		
//	//Panel que se muestra la estanteria
//		@FXML
//	private VBox Shelves;	
//		@FXML
//		//Panel que muestra los estanteres con sus respectivos libros
//		private GridPane libraryShelves;
//		
//		
//		
		
		
	//Panel que muestra los libros que seleccionados
	@FXML
	private VBox selectedBooks;
		//Panel que muestra la lista de libros seleccionado poe los clientes
		@FXML
		private GridPane ClientSelectedBooks;

	
		
		
		
		
	//Panel que muestra los libros dentro de la canasta
	@FXML
	private VBox basket;
		//Panel que muestra la canasta de cada cliente
		@FXML
		private GridPane ClientBasket;
			
		
		
		
		
	//Panel que muestra la cola de clientes		
	@FXML
	private VBox LineUp;
		//Panel que muestra la cola desde el primero hasta el ultimo
		@FXML
		private GridPane clientLineUp;
	
	
		
		
		
	//Panel que muestra la salida de clientes	
	@FXML
	private VBox exit;
		//Panel que muestra la lista de la salida de clientes
		@FXML
		private GridPane ClientExit;		
		
	
		
//-------------------------------------------------------------------		
		private Main m;
		@FXML
		private ImageView i1;
		
		public ControlVista() {
			m=new Main();
		
		}


		//muestra el panel de estanterias
		public void buttonCreateLibrary() {
			
			int acr=Integer.parseInt(amountCashR.getText());
			int ac=Integer.parseInt(amountC.getText());
			int as=Integer.parseInt(amountS.getText());
			
			m.CreateLibrary(acr, ac, as);
			m.getLibrary().createShelves();
			m.getLibrary().addBookAtShelve();
			ChooseBooks();
		}
		
		
		public void ChooseBooks() {
			CreateLibrary.setVisible(false);
			m.getLibrary().createCoustomers();
			File ruta=new File("img/fin1.gif");
			Image im=new Image(ruta.toURI().toString());
			i1.setImage(im);
			
			for (int i = 0; i < m.getLibrary().getAmountClients(); i++) {
				
				ClientSelectedBooks.add(new Label(m.getLibrary().getCoustumers()[i].getId() +"          " ), i, 0);

			}
			for (int i = 0; i < m.getLibrary().getAmountClients(); i++) {
				for (int j = 0; j < m.getLibrary().getCoustumers()[i].getLibrosSeleccionados().length; j++) {
					System.out.println("Cliente :" + m.getLibrary().getCoustumers()[i].getId() + "Libro: " + m.getLibrary().getCoustumers()[i].getLibrosSeleccionados()[j].getIsbn());
					ClientSelectedBooks.add(new Label(   m.getLibrary().getCoustumers()[i].getLibrosSeleccionados()[j].getIsbn() +":DD"), i, j+1);

				}
			}
//				for (int j = 0; j < m.getLibrary().getClientes().length; j++) {
//					ClientSelectedBooks.add(new Label(   m.getLibrary().getClientes()[i].getId() +"" ), 0, i);
//				//	ClientSelectedBooks.add(new Label(), j, i);
//
//				//	m.getLibrary().getAllBooksLibrary()
//					
//				}
			
		
			
			selectedBooks.setVisible(true);
			
			
			
		}

		//busca los libros del arreglo en el primer estante
		//si no estan los libros en el primer estante pasa al siguiente y etc.
		//este metodo coge el pirmer libro del arreglo del cliente y busca en el priemr estante
		//si no lo encientra, avanza al siguente libro del arreglo y busca en el mismo estante y asi
		// con todos los libros, de esta manera me aseguro que los libros que esten en el primer estante
		//se apilen primero.
		
//		public void recogerLibrosDeEstantes() {
//			for(int i=0;i<m.getLibrary().getCoustumers().length;i++) {
//				Client c1= m.getLibrary().getCoustumers()[i];
//				long t1 = System.nanoTime();
//
//				Estanteria<String, Integer>[] estanterias= m.getLibrary().getShelves();
//				for(int j=0;j<estanterias.length;j++) {
//					Libro[] librosSelected=c1.getLibrosSeleccionados();
//					for(int k=0;k<librosSelected.length;k++) {
//						Libro libro= librosSelected[k];
//						HashTable<String, Libro> has=estanterias[j].getHash();
//						int pos=has.hashFuntion(libro.getIsbn());
//						NodoGenerico<Libro> nodo1=has.getNodos()[pos];
//						boolean agrego=false;
//						while(nodo1!=null&&!agrego) {
//							if(nodo1.darTdelNodo().getIsbn().equalsIgnoreCase(libro.getIsbn())) {
//								c1.agregarLibroACanasta(libro);
//								agrego=true;
//							}else {
//								nodo1=nodo1.darSiguiente();
//							}
//						}
//					}	
//				}
//				long t2 = System.nanoTime();
//				int totalTime=(int) ((t2-t1));
//				c1.setTime(totalTime+c1.getTime());
//
//			}
//		}
		
		
		
		
		public void mostrarSiQuedo() {
			for(int i=0;i<m.getLibrary().getCoustumers().length;i++) {
				
				Stack<Book> suPila= m.getLibrary().getCoustumers()[i].getCarrito();
				System.out.println("  Cliente numer :" +  m.getLibrary().getCoustumers()[i].getId());
				System.out.println("Su carrito");
				while(suPila.getSize()!=0) {
					NodeGeneric<Book> libro=suPila.pop();
					System.out.println("Libro " + libro.getTOffNode().getIsbn());
				}
				
				
			}
		}
		
		//Muestra en el pane las cajas de lso clientes
		public void showcustomersBoxes() {
	     for (int i = 0; i < m.getLibrary().getAmountClients(); i++) {
	    	 
				
				ClientBasket.add(new Label(m.getLibrary().getCoustumers()[i].getId() +"           " ), i, 0);

			}
			for (int i = 0; i < m.getLibrary().getAmountClients(); i++) {
				Stack<Book> clonePila=m.getLibrary().getCoustumers()[i].getCarrito();	
               System.out.println("Tam pila "+ clonePila.getSize() + "Del cliente: " + m.getLibrary().getCoustumers()[i].getId() );
				for (int j = 0; j < clonePila.getSize(); j++) {
					ClientBasket.add(new Label( clonePila.pop().getTOffNode().getIsbn() +""), i, j+1);

				}
			}
			
		}
		
		

		public void buttonCollectBooks() {
			m.getLibrary().collectBooksFromTheShelves();
//			recogerLibrosDeEstantes() ;
			selectedBooks.setVisible(false);
			
			File ruta=new File("img/fin2.gif");
			Image im=new Image(ruta.toURI().toString());
			i1.setImage(im);
			
			basket.setVisible(true);
//			mostrarSiQuedo();
			showcustomersBoxes();
			for(int i=0;i<m.getLibrary().getCoustumers().length;i++) {
				System.out.println("Cliente: " + m.getLibrary().getCoustumers()[i].getId() +  "tiempo t: "+ m.getLibrary().getCoustumers()[i].getTime()+"");
			}
			
		}

		public void buttonStandInLine() {
			basket.setVisible(false);

			File ruta=new File("img/fin3.gif");
			Image im=new Image(ruta.toURI().toString());
			i1.setImage(im);
			
			LineUp.setVisible(true);
			m.getLibrary().sortCustomersByTime();
			m.getLibrary().addCoustumersAtRow();
//			ordenarPorPuntaje();
//			ArrayList<Client> clientesOrganizadosPorTiempo=ordenarPorPuntaje();
//			
//			
//			for(int i=0;i<clientesOrganizadosPorTiempo.size();i++) {
//				m.getLibrary().getFilaClientes().encolar(clientesOrganizadosPorTiempo.get(i));
//			}
			
			int i=0;
			while(m.getLibrary().getRowCoustomers().getSize()!=0) {
				clientLineUp.add(new Label(m.getLibrary().getRowCoustomers().dequeque().getId()+ "               "), i, 0);
				i++;
			}
			
		
			
			

		}

		public void buttonPayBooks() {
			exit.setVisible(true);
			
			File ruta=new File("img/fin4.gif");
			Image im=new Image(ruta.toURI().toString());
			i1.setImage(im);
		}


		public void hacerFila() {
			
			
			
	

			
			
			
		}
		
		
	
		


		
		
		
		
		
//		public ArrayList<Client> ordenarPorPuntaje() {
//			System.out.println("Entrooo");
//          ArrayList<Client> clientes= new ArrayList<>();
//			
//			for(int i=0;i<m.getLibrary().getCoustumers().length;i++) {
//				clientes.add(i,m.getLibrary().getCoustumers()[i]);
//			}
//			
//			
//			for(int i=0;i<clientes.size();i++) {
//				Client porInserta=clientes.get(i);
//				boolean termino=false;
//				
//				for(int j=i;j>0&&!termino;j--) {
//					Client actual=clientes.get(j-1);
//					if(actual.getTime()>porInserta.getTime()) {
//						clientes.set(j, actual);
//						clientes.set(j-1, porInserta);
//						
//						
//						
//					}else {
//						termino=true;
//					}
//				}
//			}
//			
//			return clientes;
//
//			
//		}
		
		
		
		
		
		
}
