/**

 * 
 */
package by.home.grigoryev.train.service.menegers.passenger;

import java.util.List;

import by.home.grigoryev.train.entities.Ticket;
import by.home.grigoryev.train.entities.Train;
import by.home.grigoryev.train.entities.User;
import by.home.grigoryev.train.service.menegers.IManager;

/**
 * 
 * @author Maksim
 *
 */
public interface IPassengerManager extends IManager{
	
	/**
	 * 
	 * @param user
	 */
	void addPassenger(User user);
	
	/**
	 * 
	 * @param objects
	 */
	List<Train> getSuitableTrains(Object[] objects);
	
	/**
	 * 
	 * @param train
	 */
	void bookATicket(int id);
	
	/**
	 * 
	 * @return
	 */
	List<Ticket> getAllTicket();
	
}
