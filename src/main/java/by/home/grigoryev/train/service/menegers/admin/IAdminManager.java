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
	
	List<User> getUserList();
	List<Train> getTrainList();
	void addTrain(Train train);
	void addStation(Station station);
	List<User> getUsersOnTrain(int trainId);
	void removeDepartedTrains();
	
}
