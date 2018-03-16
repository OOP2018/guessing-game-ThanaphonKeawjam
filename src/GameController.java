import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
	
	public GameController() {
		game = new ThanaphonGame(upperbound);
		view = new CounterView(game);
	}
	
	@FXML
	public void initialize() {
		view.run();
	}
	
	public void handleGuess(ActionEvent event) {
		String answer = textField.getText().trim();
		int number;
		try {
			number = Integer.parseInt(answer);
			game.guess(number);
			label3.setText(game.getMessage());
		}catch(NumberFormatException e) {
			label3.setText("Please input only number");
		}
		view.displayCount();
	}

}
