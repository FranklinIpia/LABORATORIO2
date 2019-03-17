package EstructurasDeOrdenamiento;


public class HashTable<K,T> {
	private K key;
	private T object;
	private int sizeHash;
	
	private NodeGeneric<T>[]  nodos;

	public HashTable(int sizeHash){
		this.sizeHash=sizeHash;
		nodos= new NodeGeneric[sizeHash];

	}

	
	
	public boolean add(K key, T objeto) {
		boolean seAgrego=false;
		int posicion= hashFuntion(key);
		NodeGeneric<T> nodoAgregar= new NodeGeneric<>(objeto);
		if(nodos[posicion]==null) {
			nodos[posicion]=nodoAgregar;
			seAgrego=true;
		}else {
			NodeGeneric<T> nodo1=nodos[posicion];
			NodeGeneric<T> actual= nodo1;
			boolean agrego=false;
			while(actual!=null&&!agrego) {
				if(actual.getNext()==null) {
					actual.sentNext(nodoAgregar);
					agrego=true;
					seAgrego=agrego;
				}else {
					actual=actual.getNext();
				}
			}
			
		}
		return seAgrego;
	}
	

	

	public int hashFuntion(K key){
		int r= key.hashCode();
		int resultado = (r%sizeHash);
		return resultado;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public T getObject() {
		return object;
	}

	public void setObject(T object) {
		this.object = object;
	}

	public int getSizeHash() {
		return sizeHash;
	}

	public void setSizeHash(int sizeHash) {
		this.sizeHash = sizeHash;
	}

	public NodeGeneric<T>[] getNodos() {
		return nodos;
	}

	public void setNodos(NodeGeneric<T>[] nodos) {
		this.nodos = nodos;
	}



//	public Object[] getList() {
//		return list;
//	}

//	public void agregar(K key, T object) {
//	
//	
//	
//}


//public void hashInsert(K Key,T objecto) {
//	int i=0;
//	
//	
//	
//	
//}

//public int sondeoLineal(K key,int i) {
//	int numero=hashFuntion(key);
//	return ((numero+i)%sizeHash);
//}


//public int sondeoCuadratico(K Key,int i) {
//	int numero=hashFuntion(Key);
//	return (int) ((numero+1*i+1*Math.pow(i, 2))%sizeHash);
//}
//

	

}
