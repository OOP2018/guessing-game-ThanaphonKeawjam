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
	
	public static void main(String[] args) {
		launch(args);
	}
		// upper limit for secret number in guessing game
/*		int upperBound = 100;
		NumberGame game = new ThanaphonGame(upperBound);
		GameConsole ui = new GameConsole( );
		
		int solution = ui.play( game );
		
		System.out.println("play() returned " + solution);
		
		System.out.println("Count guesses is " + game.getCount()); */

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
