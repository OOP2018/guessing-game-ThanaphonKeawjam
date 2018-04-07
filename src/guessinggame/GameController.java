package guessinggame;
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
	
	private NumberGame game;
	
	public void setGame(NumberGame game) {
		this.game = game;
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
		}catch(NumberFormatException e) {
			label3.setTextFill(Color.RED);
			label3.setText("Please input only number");
		}
		textField.clear();
	}
	
	/**
	 * Exit guessing game
	 */
	public void exitGame() {
		System.exit(1);
	}

}
