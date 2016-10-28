package by.home.grigoryev.train;

import java.io.IOException;

import by.home.grigoryev.train.entities.enums.UserRole;
import by.home.grigoryev.train.service.utils.Session;
import by.home.grigoryev.train.view.io.Menu;

public class RailwayTicetOfficeRunner {
	public static void main(String[] args) throws IOException{
		
		while(true){
			Menu menu = new Menu();
			if(Session.currentRole.equals(UserRole.NO))
				menu.showRegistrationMenu();
			if(Session.currentRole.equals(UserRole.PASSENGER))
				menu.showPassengerMenu();
			if(Session.currentRole.equals(UserRole.ADMIN))
				menu.showAdminMenu();
			
			System.out.println();
		}	
		
	}
}
