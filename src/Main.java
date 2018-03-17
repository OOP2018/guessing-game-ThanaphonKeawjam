import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * A main class for the GuessingGame.
 * It is responsible for creating objects, 
 * connecting objects, and running the game UI.
 * @author Thanaphon Keawjam
 */
public class Main extends Application{
	
	/**
	 * Initialize.
	 * @param args is use for run Application.
	 */
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * Start Program
	 * @param stage is stage of Application.
	 */
	@Override
	public void start(Stage stage){
		try {
			Parent root = (Parent)FXMLLoader.load(getClass().getResource("GuessingGameUI.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Guessing Game");
			stage.sizeToScene();
			stage.setResizable(false);
			stage.show();
		}catch(Exception e) {
			System.out.println("Exception creating scene: " + e.getMessage());
		}
		
	}
}
