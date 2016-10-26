/**
 * 
 */
package by.home.grigoryev.train.view.io.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 * @author Maksim
 *
 */
public class Validator {
	
	public static Map<String, String> messageMap = new HashMap<>();
	Utils utils = new Utils();

	public int validationNumbersOfMenu(String number, int maxMenuItem){
		
		Scanner scanner = new Scanner(number);
		
		int operation = 0;
		
		if(scanner.hasNextInt()){
			operation = scanner.nextInt();
			scanner.close();
		} else {
			System.out.println("¬веден недопустимый символ");
		}
		
		if(operation < 1 || operation > maxMenuItem)
			System.out.println("¬веден недопустимый символ");
		
		return operation;
	}
	
	public boolean checkRegexp(String inputValue, String property){
		
		String regex = utils.getPropsRegex(property);
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(inputValue);
		
		if(!matcher.matches())
			messageMap.put(property, utils.getPropsMessage(property));
		
		return matcher.matches();
	}
}
