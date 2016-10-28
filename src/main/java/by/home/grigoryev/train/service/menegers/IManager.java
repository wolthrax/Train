/**
 * 
 */
package by.home.grigoryev.train.service.menegers;

import java.util.TreeSet;

import by.home.grigoryev.train.entities.Station;
import by.home.grigoryev.train.exceptions.IncorrectLoginOrPass;

/**
 * @author Maksim
 *
 */
public interface IManager {

	/**
	 * Check the login and password, initializes the fields in the class Session.
	 * 
	 * @param credential an array of strings consisting of a login and password.
	 * @throws IncorrectLoginOrPass If login and password were not found.
	 */
	void checkCredential(String[] credential) throws IncorrectLoginOrPass;
	
	/**
	 * Get a list of sorted stations.
	 * 
	 * @return list of sorted stations.
	 */
	TreeSet<Station> getStationList();
	
	/**
	 * Logout and reset values of class Session.
	 * 
	 */
	void logout();
	
}