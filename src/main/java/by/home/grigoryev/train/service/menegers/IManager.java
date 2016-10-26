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

	void checkCredential(String[] credential) throws IncorrectLoginOrPass;
	TreeSet<Station> getStationList();
	void logout();
	
}