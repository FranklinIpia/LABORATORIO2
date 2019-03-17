package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import modelo.Library;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	private Library library;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Vista.fxml"));
			Scene scene = new Scene(root,575,438);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void CreateLibrary(int acr ,int ac,int as) {
		library=new Library(acr, ac, as);
	}
	
	//Da la biblioteca 
	public Library getLibrary() {
		return library;
	}
	

	
	public static void main(String[] args) {
		
	//	Crea la biblioteca y da el nombre de una biblioteca( A1 )
//		Biblioteca biblioteca=new Biblioteca(2, 3, 3);
//		biblioteca.createShelves();
//		for (int i = 0; i < biblioteca.getShelves().length; i++) {
//			System.out.println(biblioteca.getShelves()[i].darn());
//
//		}
		
		
		
//		Biblioteca b=new Biblioteca(1, 1, 3);
//		
//		b.createShelves();
//		b.agregarLibroEstanteria();
//		for (int i = 0; i < b.getAllBooksLibrary().size(); i++) {
//		//	System.out.println(	b.getAllBooksLibrary().get(i).getIsbn());
//		}
//		
		
		
		launch(args);
		
	}
}
