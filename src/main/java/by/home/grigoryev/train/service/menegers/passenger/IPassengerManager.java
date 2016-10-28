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
	 * Write a new train in file UserList.txt
	 * 
	 * @param user entity User
	 */
	void addPassenger(User user);
	
	/**
	 * Getting trains suitable time.
	 * 
	 * @param objects array of options for getting a suitable trains.
	 */
	List<Train> getSuitableTrains(Object[] objects);
	
	/**
	 * Ticket booking for a suitable train.
	 * 
	 * @param id id suitable train.
	 */
	void bookATicket(int id);
	
	/**
	 * Getting all the tickets are booked passenger.
	 * 
	 * @return list of tickets are booked passenger
	 */
	List<Ticket> getAllTicket();
	
}
