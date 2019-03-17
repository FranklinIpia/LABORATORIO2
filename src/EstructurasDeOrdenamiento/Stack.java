package EstructurasDeOrdenamiento;


public class Stack<T> {
	
	
	/**
	 * First element of list of nodes
	 */
	private NodeGeneric<T> firstStack;
	
	/**
	 * number of objects on off stack
	 */
	private int size;

	/**
	 * methode constructor
	 */
	public Stack() {
		size = 0;
		firstStack = null;
	}
/**
 * this methode return the size of stack
 * @return size
 */
	public int getSize() {
		return size;
	}
/**
 */
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return firstStack == null;
	}

	
	//Ultimo en entrar, primero en salir
	public void push(NodeGeneric<T> node) {
		// TODO Auto-generated method stub
		
		if (isEmpty()) {
			firstStack = node;
			size++;
		}else{
			
			NodeGeneric<T> current = firstStack;
			
			while(current.getNext()!=null){
				current = current.getNext();
			}
			
			//Hasta el moemnto llegué hasta la Ultima posicion de la lista
			//Apilo o  agrego el elemento a la pila
			
			current.sentNext(node);
			node.setPrevious(current);
			node.sentNext(null);
			
			size++;
		}
		
	}

	//Se elimina el elemento que esta en el tope de la pila
	public NodeGeneric<T> pop() {
		// TODO Auto-generated method stub
		
		NodeGeneric<T> nodeRemoved= null;
		
		if (!isEmpty()) {

			if (size==1) {
				nodeRemoved = firstStack;
				firstStack = null;
				size--;
			}else {
				NodeGeneric<T> nodeToBeRemove = getTop();
				nodeToBeRemove.getPreviuos().sentNext(null);
				nodeToBeRemove.setPrevious(null);
				nodeRemoved = nodeToBeRemove;
				size--;
			}
			
		}
		
		
		return nodeRemoved;
	}

	//El ultimo elemento de la lista enlazada es el tope de la pila
	public NodeGeneric<T> getTop() {
		// TODO Auto-generated method stub
		//Recorro toda la pila y el que esté en la ultima posicion va a ser el TOP de la pila
		
		NodeGeneric<T> top = null;

		if (!isEmpty()) {
			NodeGeneric<T> actual = firstStack;
			
			while(actual.getNext()!=null){
				actual = actual.getNext();
			}
			top = actual;
		}
		
		return top;
	}


//	public Cola<T> darCola(){
//		return cola;
//	}
	
	
	
	

}