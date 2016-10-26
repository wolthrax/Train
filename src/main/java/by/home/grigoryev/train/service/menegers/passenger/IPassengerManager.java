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
	public void addPassenger(User user);
	
	/**
	 * 
	 * @param objects
	 */
	public List<Train> getSuitableTrains(Object[] objects);
	
	/**
	 * 
	 * @param train
	 */
	public void bookATicket(int id);
	
	/**
	 * 
	 * @return
	 */
	public List<Ticket> getAllTicket();
	
}
