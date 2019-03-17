package EstructurasDeOrdenamiento;

public class Queque<T> {
	
	private NodeGeneric<T> latestQueque;

	private int sizeQueque;

	
	public Queque(){
		latestQueque = null;
		sizeQueque = 0;
	}


	public int getSize() {
		// TODO Auto-generated method stub
		return sizeQueque;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return latestQueque == null;
	}

	public void enqueque(T t) {
		// TODO Auto-generated method stub

		NodeGeneric<T> node = new NodeGeneric<T>(t);
		
		if (isEmpty()) {
			latestQueque = node;
			sizeQueque++;
		}else{

			NodeGeneric<T> current = latestQueque;

			while(current.getPreviuos()!=null){
				current = current.getPreviuos();
			}

			current.setPrevious(node);
			node.sentNext(current);
			node.setPrevious(null);
			sizeQueque++;
		}

	}

	public T dequeque() {


		NodeGeneric<T> nodeRemoved = null;
		
		if (!isEmpty()) {
		   	
			if (sizeQueque==1) {
				nodeRemoved = latestQueque;
				latestQueque =  null;
				sizeQueque--;
			}else {
				NodeGeneric<T> nodeToBeRemoved = latestQueque;
				nodeToBeRemoved.getPreviuos().sentNext(null);
				latestQueque = nodeToBeRemoved.getPreviuos();
				nodeToBeRemoved.setPrevious(null);
				nodeRemoved = nodeToBeRemoved;
				sizeQueque--;
			}

		}
		

		return nodeRemoved.getTOffNode();
	}

	
	public T peek() {
		// TODO Auto-generated method stub
		
		NodeGeneric<T> front = null;
		
		if (!isEmpty()) {
			
			NodeGeneric<T> current = latestQueque;
			
			while(current.getPreviuos()!=null){
				current = current.getPreviuos();
			}
	        front= current;
		}
		
		
		return front.getTOffNode();
	}




}
