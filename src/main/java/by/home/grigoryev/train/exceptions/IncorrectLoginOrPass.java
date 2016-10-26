/**
 * 
 */
package by.home.grigoryev.train.exceptions;

/**
 * @author Maksim
 *
 */
public class IncorrectLoginOrPass extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IncorrectLoginOrPass(String message) {
		super(message);
	}
}