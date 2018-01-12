import java.util.Random;

/**
 * Automatically find the secret to any NumberGame.
 * @author Thanaphon Keawjam
 *
 */
public class GameSolver {
	
	/**
	 * Play a NumberGame and return the solution.
	 * The NumberGame object must provide messages(getMessage)
	 * containing the phrase "too small" if a guess is too small
	 * and "too large" if a guess is too large, for efficient solution.
	 * 
	 * @param game is the NumberGame to solve
	 * @return guess return the correct answer
	 */
	public int play(NumberGame game){
		// describe the game
		System.out.println( game.toString() );
		
		int guess;
		boolean correct;
		Random random = new Random();
		do{
//		System.out.print("Your answer? ");
		guess = random.nextInt(100)+1;
		correct = game.guess(guess);
//		System.out.println( game.getMessage() );
		}while(correct == false);
		return guess;
	}

}
