package modelo;

public class Book {

	
	

	private String isbn;
	private int shelfNumber;
	private int numberOfCopies;
	
	public Book(String isbn, int price, int numberOfCopies) {
		this.isbn=isbn;
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public int getShelfNumber() {
		return shelfNumber;
	}


	public void setNumberShelve(int shelfNumber) {
		this.shelfNumber = shelfNumber;
	}


	public int getNumberOfCopies() {
		return numberOfCopies;
	}


	public void setNumberOfCopies(int numberOfCopies) {
		this.numberOfCopies = numberOfCopies;
	}


	
	
	
}
