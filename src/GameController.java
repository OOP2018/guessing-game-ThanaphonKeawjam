import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

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
		view.displayCount();
		textField.clear();
	}
	
	public void newGame() {
		game = new ThanaphonGame(upperbound);
		label3.setText(" ");
	}
	
	public void exitGame() {
		System.exit(1);
	}

}
