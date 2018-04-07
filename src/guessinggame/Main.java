package guessinggame;
import java.net.URL;

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
	
	private int upperbound = 100;
	
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
		NumberGame game = new ThanaphonGame(upperbound);
		
		try {
			URL url = getClass().getResource("GuessingGameUI.fxml");
			if(url == null) {
				System.out.println("Could not find file: GuessingGameUI.fxml");
				return;
			}
			FXMLLoader loader = new FXMLLoader(url);
			Parent root = loader.load();
			
			GameController controller = loader.getController();
			controller.setGame(game);
			
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Guessing Game");
			stage.sizeToScene();
			stage.setResizable(false);
			stage.show();
		}catch(Exception e) {
			System.out.println("Exception creating scene: " + e.getMessage());
		}
		
		CounterView view = new CounterView(game);
		GuessView view2 = new GuessView(game);
		
		game.addObserver(view);
		game.addObserver(view2);
		
		view.run();
		view2.run();
	}
}
