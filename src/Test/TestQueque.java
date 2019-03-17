package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import EstructurasDeOrdenamiento.Queque;
import modelo.Client;

class TestQueque {
Queque<Client> queque;

	public void escenario1() {
queque= new Queque<>();



	}

	
	@Test
	public void TestEnqueque() {
		escenario1();
		Client clientOne= new Client("123");
		Client clientTwo= new Client("456");
		Client clientThree= new Client("789");

		int timeOne=4;
		int timetwo=3;
		int tomeThree=7;
		clientOne.setTime(timetwo);
		clientThree.setTime(timeOne);
		clientTwo.setTime(tomeThree);
		ArrayList<Client> clients= new ArrayList<>();
		clients.add(clientThree);
		clients.add(clientTwo);
		clients.add(clientOne);
		
		
		for(int i=0;i<clients.size();i++) {
			Client clientForInsert= clients.get(i);
			boolean find=false;
			for(int j=i;j>0&&!find;j--) {
				Client clientActually=clients.get(j-1);
				if(clientActually.getTime()>clientForInsert.getTime()) {
					clients.set(j, clientActually);
					clients.set(j-1, clientForInsert);
					
				}else {
					find=true;				}
			}
			
			
		}
		
		for(int i=0;i<clients.size();i++) {
			queque.enqueque(clients.get(i));
		}
		assertEquals(clients.get(0).getId(), queque.dequeque().getId());
		
		
		
		
		
	}
	
	@Test
	public void TestPeek() {
		escenario1();
		Client clientOne= new Client("123");
		Client clientTwo= new Client("456");
		Client clientThree= new Client("789");

		
		
		int timeOne=4;
		int timetwo=3;
		int tomeThree=7;
		clientOne.setTime(timetwo);
		clientThree.setTime(timeOne);
		clientTwo.setTime(tomeThree);
		ArrayList<Client> clients= new ArrayList<>();
		clients.add(clientThree);
		clients.add(clientTwo);
		clients.add(clientOne);
		
		
		for(int i=0;i<clients.size();i++) {
			Client clientForInsert= clients.get(i);
			boolean find=false;
			for(int j=i;j>0&&!find;j--) {
				Client clientActually=clients.get(j-1);
				if(clientActually.getTime()>clientForInsert.getTime()) {
					clients.set(j, clientActually);
					clients.set(j-1, clientForInsert);
					
				}else {
					find=true;				}
			}
			
			
		}
		
		for(int i=0;i<clients.size();i++) {
			queque.enqueque(clients.get(i));
		}
		assertEquals(clients.get(clients.size()-1).getId(), queque.peek().getId());
	}
	
	@Test
	public void TestDequeque() {
		escenario1();
		Client clientOne= new Client("123");
		Client clientTwo= new Client("456");
		Client clientThree= new Client("789");
		
		queque.enqueque(clientOne);
		queque.enqueque(clientThree);
		queque.enqueque(clientTwo);
		
		int size=0;
		while(queque.getSize()!=0) {
			queque.dequeque();
		}
		
		assertEquals(size, queque.getSize());
	}
	
	
	@Test
	public void borrar() {
		escenario1();
		Client cliente1= new Client("123");
		Client client2= new Client("34");
		Client client4= new Client("456");
queque.enqueque(cliente1);
queque.enqueque(client2);
queque.enqueque(client4);

assertEquals(cliente1.getId(), queque.peek().getId());
		
		
	}
	

}
