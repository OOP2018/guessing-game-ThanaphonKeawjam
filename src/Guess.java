/**
 * A Controller for guess number.
 * @author Thanaphon Keawjam
 */
public class Guess extends java.util.Observable{
	
	private int guess;
	
	/**
	 * Initialize.
	 */
	public Guess() {
		this.guess = 0;
	}
	
	/**
	 * Add guess number to window after guess.
	 * @param number is guess number.
	 */
	public void add(int number) {
		guess = number;
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Get guess number
	 * @return guess number.
	 */
	public int getGuess() {
		return guess;
	}

}
