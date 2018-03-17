import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

/**
 * Game controller for guessing game.
 * @author Thanaphon Keawjam
 */
public class GameController {
	
	@FXML
	Label label1;
	@FXML
	Label label2;
	@FXML
	Label label3;
	@FXML
	TextField textField;
	
	private int upperbound = 100;
	private NumberGame game;
	private CounterView view;
	private GuessView view2;
	private Guess guess;
	
	/**
	 * Initialize.
	 */
	public GameController() {
		game = new ThanaphonGame(upperbound);
		guess = new Guess();
		view = new CounterView(game);
		view2 = new GuessView(guess);
	}
	
	/**
	 * avaFX calls the initialize() method of your controller when
	 * it creates the UI form, after the components have been created
	 * and @FXML annotated attributes have been set.
	 */
	@FXML
	public void initialize() {
		guess.addObserver(view2);
		view.run();
		view2.run();
	}
	
	/**
	 * Guess a number.
	 * @param event is action event for guess a number.
	 */
	public void handleGuess(ActionEvent event) {
		String answer = textField.getText().trim();
		int number;
		boolean correct;
		try {
			number = Integer.parseInt(answer);
			correct = game.guess(number);
			if(correct) label3.setTextFill(Color.LIMEGREEN);
			else label3.setTextFill(Color.BLUE);
			label3.setText(game.getMessage());
			guess.add(number);
		}catch(NumberFormatException e) {
			label3.setTextFill(Color.RED);
			label3.setText("Please input only number");
		}
		view.displayCount();
		view2.displayGuess();
		textField.clear();
	}
	
	/**
	 * New Game.
	 */
	public void newGame() {
		game = new ThanaphonGame(upperbound);
		label3.setText(" ");
	}
	
	/**
	 * Exit guessing game
	 */
	public void exitGame() {
		System.exit(1);
	}

}
