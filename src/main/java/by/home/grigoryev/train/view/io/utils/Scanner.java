/**
 * 
 */
package by.home.grigoryev.train.view.io.utils;

import java.util.Locale;

/**
 * @author Maksim
 *
 */
public class Scanner {

	public int getInt(){
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		int value = -1;
		if(scanner.hasNextInt()){
			value = scanner.nextInt();
		} else Validator.messageMap.put("getInt", "Entered an invalid characters");
		
		return value;
	}
	
	public String getString(){
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		String value = "";
		if(scanner.hasNextLine()){
			value = scanner.nextLine();
		} else Validator.messageMap.put("getString", "Entered an invalid characters");
		
		return value;
	}
	
	public double getDouble(){
		Locale locale = new Locale("ru", "RU");
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		scanner.useLocale(locale);
		double value = -1d;
		if(scanner.hasNextDouble()){
			value = scanner.nextDouble();
		} else Validator.messageMap.put("getDouble", "Entered an invalid characters");
		
		return value;
	}
}
