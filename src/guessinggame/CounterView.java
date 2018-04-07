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
 * A Controller for a window that shows the value of a Counter.
 * @author Thanaphon Keawjam
 *
 */
public class CounterView implements java.util.Observer{

	private Stage stage;
	private Label label;
	private NumberGame game;
	
	/**
	 * Initialize.
	 * @param game is NumberGame object.
	 */
	public CounterView(NumberGame game) {
		this.game = game;
		initComponents();
	}
	
	/**
	 * Create a window for counter view.
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
		stage.setTitle("Counter");
		stage.sizeToScene();
	}
	
	/**
	 * Run counter view window.
	 */
	public void run() {
		stage.show();
		displayCount();
	}
	
	/**
	 * Show count on window.
	 */
	public void displayCount() {
		label.setText(String.format("%2d", game.getCount()));
	}
	
	/**
	 * Update displayCount() method.
	 */
	@Override
	public void update(Observable o, Object arg) {
		displayCount();
	}
	
	
	
}
