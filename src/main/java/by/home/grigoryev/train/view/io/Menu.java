/**
 * 
 */
package by.home.grigoryev.train.view.io;

import by.home.grigoryev.train.view.controllers.AdminController;
import by.home.grigoryev.train.view.controllers.Controller;
import by.home.grigoryev.train.view.controllers.PassengerController;
import by.home.grigoryev.train.view.controllers.RegistrationController;
import by.home.grigoryev.train.view.io.utils.Scanner;
import by.home.grigoryev.train.view.io.utils.Validator;

/**
 * 
 * @author Maksim
 *
 */
public class Menu {
	
	private Validator validator = new Validator();
	
	public void showRegistrationMenu(){
		System.out.println("1. Registration");
		System.out.println("2. LogIn");
		System.out.println("3. Exit");
		System.out.print("Enter number(1-3):");
		Controller controller = new RegistrationController();
		
		Scanner scanner = new Scanner();
		int operation = scanner.getInt();
		validator.validationNumbersOfMenu(operation, 3);
		controller.shooseOperation(operation);
	}
	
	public void showPassengerMenu(){
		System.out.println("1. Book a ticket");
		System.out.println("2. Show all tickets");
		System.out.println("3. Get objects number");
		System.out.println("4. Logout");
		System.out.print("Enter number(1-4):");
		Controller controller = new PassengerController();
		
		Scanner scanner = new Scanner();
		int operation = scanner.getInt();
		validator.validationNumbersOfMenu(operation, 4);
		controller.shooseOperation(operation);
	}
	
	public void showAdminMenu(){
		System.out.println("1. Add train");
		System.out.println("2. Add Station");
		System.out.println("3. Show the passengers on the train");
		System.out.println("4. Remove Departed Trains");
		System.out.println("5. Logout");
		System.out.print("Enter number(1-5):");
		Controller controller = new AdminController();
		
		Scanner scanner = new Scanner();
		int operation = scanner.getInt();
		validator.validationNumbersOfMenu(operation, 5);
		controller.shooseOperation(operation);
	}
}