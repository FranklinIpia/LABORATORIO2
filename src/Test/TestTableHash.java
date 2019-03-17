package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import EstructurasDeOrdenamiento.HashTable;
import modelo.Book;

class TestTableHash {
HashTable<String, Book> has;

public void scnerario1() {
	has= new HashTable<>(7);
}

@Test
public void TestHasFuntion() {
	scnerario1();
	String key="123";
	int posReally=5;
	assertEquals(posReally, has.hashFuntion(key));
	
}

@Test
public void TestAdd() {
	scnerario1();
	Book book= new Book("123", 4, 4);
	has.add(book.getIsbn(), book);
	assertEquals(book.getIsbn(), has.getNodos()[has.hashFuntion(book.getIsbn())].getTOffNode().getIsbn());
}

	



}
