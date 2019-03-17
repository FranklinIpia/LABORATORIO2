package modelo;
import EstructurasDeOrdenamiento.Stack;

public class Cajera {
	
	
	private int id;
	
	
	public Cajera(int id) {
		this.id=id;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	public void procesarCompra(Client cliente, long timeStamp) {

		System.out.println("La cajera " + this.id + 
				" COMIENZA A PROCESAR LA COMPRA DEL CLIENTE " + cliente.getId() + 
				" EN EL TIEMPO: " + (System.currentTimeMillis() - timeStamp) / 1000	+
				"seg");
		
		Stack<Book> desempacar= new Stack<>();
		while(cliente.sacarLibroDelCarrito().getSize()!=0) {
			this.esperarXsegundos(1);
			System.out.println("Procesado el producto " + cliente.sacarLibroDelCarrito().getTop().getTOffNode().getIsbn() +  
					" ->Tiempo: " + (System.currentTimeMillis() - timeStamp) / 1000 + 
					"seg");
			desempacar.push(cliente.sacarLibroDelCarrito().pop());
			
		}
		System.out.println("La cajera " + this.id+ " HA TERMINADO DE DESEMPACAR " + 
				cliente.getId() + " EN EL TIEMPO: " + 
				(System.currentTimeMillis() - timeStamp) / 1000 + "seg");
		
		Stack<Book> empacarLibros= new Stack<>();
		while(desempacar.getSize()!=0) {
			this.esperarXsegundos(1);
			System.out.println("Empacando el producto " + desempacar.getTop().getTOffNode().getIsbn() +  
					" ->Tiempo: " + (System.currentTimeMillis() - timeStamp) / 1000 + 
					"seg");
			empacarLibros.push(desempacar.pop());
		}


	}
		
	
		
	
	
	private void esperarXsegundos(int segundos) {
		try {
			Thread.sleep(segundos * 1000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
	
	
}
