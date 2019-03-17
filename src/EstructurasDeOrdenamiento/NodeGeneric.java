package EstructurasDeOrdenamiento;


public class NodeGeneric<T> {

	private NodeGeneric<T> objectNext;;
	private NodeGeneric<T> objectPrevious;
	private T object;
	
	public NodeGeneric(T nObjeto){
        object = nObjeto;
		objectNext = null;
		objectPrevious = null;
	}

	public NodeGeneric<T> getNext() {
		return objectNext;
	}

	public NodeGeneric<T> getPreviuos() {
		return objectPrevious;
	}

	public void sentNext(NodeGeneric<T> node) {
		objectNext = node;
	}

	public void setPrevious(NodeGeneric<T> node) {
		objectPrevious = node;
	}
	
	public T getTOffNode(){
		return object;
	}
	
	public void setTOffNode(T object){
		this.object = object;
	}
	

}
