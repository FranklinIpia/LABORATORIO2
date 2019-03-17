 package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import EstructurasDeOrdenamiento.NodeGeneric;
import EstructurasDeOrdenamiento.Stack;
import modelo.Book;

class TestStack {
Stack<Book> stack;

public void scenario1() {
	stack= new Stack<>();
}

@Test
public void TestPush() {
	scenario1();
	Book book1= new Book("123", 1244, 5);
	Book book2= new Book("125", 1244, 5);
	Book book3= new Book("126", 1244, 5);
stack.push(new NodeGeneric<Book>(book1));
stack.push(new NodeGeneric<Book>(book2));
stack.push(new NodeGeneric<Book>(book3));


assertEquals(stack.getTop().getTOffNode().getIsbn(), book3.getIsbn());
	
	
}


@Test
public void TestPop() {
scenario1();
Book book1= new Book("123", 1244, 5);
Book book2= new Book("125", 1244, 5);
Book book3= new Book("126", 1244, 5);
stack.push(new NodeGeneric<Book>(book1));
stack.push(new NodeGeneric<Book>(book2));
stack.push(new NodeGeneric<Book>(book3));

int size=0;

while(stack.getSize()!=0) {
	stack.pop();
}

assertEquals(size, stack.getSize());

}




}
