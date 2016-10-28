/**
 * 
 */
package by.home.grigoryev.train.service.menegers.admin;

import java.util.List;

import by.home.grigoryev.train.entities.Station;
import by.home.grigoryev.train.entities.Train;
import by.home.grigoryev.train.entities.User;
import by.home.grigoryev.train.service.menegers.IManager;

/**
 * 
 * @author Maksim
 *
 */
public interface IAdminManager extends IManager{
	
	/**
	 * Get all users from a file UserList.txt
	 * 
	 * @return list of users
	 */
	List<User> getUserList();
	
	/**
	 * Get all trains from a file TrainList.txt
	 * 
	 * @return list of trains
	 */
	List<Train> getTrainList();
	
	/**
	 * Write a new train in file TrainList.txt
	 * 
	 * @param train entity Train
	 */
	void addTrain(Train train);
	
	/**
	 * Write a new station in file Station.txt
	 * 
	 * @param station entity Station
	 */
	void addStation(Station station);
	
	/**
	 * Get all passengers, who booked a ticket on the train.
	 * 
	 * @param trainId train id
	 * @return list of passengers, who booked a ticket
	 */
	List<User> getUsersOnTrain(int trainId);
	
	/**
	 * 
	 * Train removal that have already gone.
	 * 
	 */
	void removeDepartedTrains();
	
}
