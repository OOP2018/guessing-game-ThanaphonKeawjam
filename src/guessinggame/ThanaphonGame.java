package guessinggame;
import java.util.Random;

/**
 * Game of guessing a secret number.
 * @author Thanaphon Keawjam
 *
 */
public class ThanaphonGame extends NumberGame{
	
	private int upperBound;
	private int secret;
	private int count = 0;
	private int guess;
	
	/**
	 * Initialize a new default game.
	 */
	public ThanaphonGame(){
		this(100);
	}
	
	/**
	 * Initialize a new default game.
	 * @param upperbound is the max value for secret number.
	 */
	public ThanaphonGame(int upperbound){
		this.upperBound = upperbound;
		long seed = System.nanoTime();
		Random rand = new Random(seed);
		secret = rand.nextInt(upperBound) + 1;
		//show secret number for test
	    //System.out.println("secret number " + secret);
		super.setMessage("What secret number?");
	}
	
	/**
	 * Evaluate a user's guess.
	 * @param number is value from guess.
	 * @return true if it correct, false if it incorrect.
	 */
	public boolean guess(int number){
		guess = number;
		
		if(number == secret){
			setMessage("Correct! The value is " + secret);
			count++;
			setChanged();
			notifyObservers();
			return true;
		}else if(number < 0 || number > 100){
			setMessage("The value is between 1 to 100");
			count++;
			setChanged();
			notifyObservers();
			return false;
		}else if(number > secret){
			setMessage("No! " + number + " is too large.");
			count++;
			setChanged();
			notifyObservers();
			return false;
		}else if(number < secret){
			setMessage("No! " + number + " is too small.");
			count++;
			setChanged();
			notifyObservers();
			return false;
		}
		return false;
	}
	
	/**
	 * Return the upperbound for the solution to this game.
	 * @return upperBound is the max value for secret number.
	 */
	public int getUpperBound(){
		return upperBound;
	}
	
	/**
	 * Return the count time for guess.
	 * @return count is time of guess number.
	 */
	public int getCount(){
		return count;
	}
	
	/**
	 * Describe the game.
	 * @return Sentence for describe the game.
	 */
	@Override
	public String toString() {
		return String.format("Guess a secret number between 1 to 100.");
	}
	
	/**
	 * Return number from guessing.
	 * @return vale of guess.
	 */
	public int getGuess() {
		return guess;
	}
}
