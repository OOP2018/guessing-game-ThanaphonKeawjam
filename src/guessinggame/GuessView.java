package guessinggame;
import java.util.Observable;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * A Controller for a window that shows the value of a Guess.
 * @author Thanaphon Keawjam
 *
 */
public class GuessView implements java.util.Observer{
	
	private NumberGame game;
	private Label label;
	private Stage stage;
	
	/**
	 * Initialize.
	 * @param game is NumberGame object.
	 */
	public GuessView(NumberGame game) {
		this.game = game;
		initComponents();
	}
	
	/**
	 * Create a window for guess view.
	 */
	public void initComponents() {
		stage = new Stage();
		HBox root = new HBox();
		root.setPadding(new Insets(10));
		root.setAlignment(Pos.CENTER);
		label = new Label(" ");
		label.setPrefWidth(280);
		label.setFont(new Font("Arial", 80.0));
		label.setAlignment(Pos.CENTER);
		root.getChildren().add(label);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Guess");
		stage.sizeToScene();
	}
	
	/**
	 * Run guess view window.
	 */
	public void run() {
		stage.show();
		displayGuess();
	}
	
	/**
	 * Show guess number on window.
	 */
	public void displayGuess() {
		label.setText(String.format("%2d", game.getGuess()));
	}

	/**
	 * Update displayGuess() method.
	 */
	@Override
	public void update(Observable o, Object arg) {
		displayGuess();
	}

}
