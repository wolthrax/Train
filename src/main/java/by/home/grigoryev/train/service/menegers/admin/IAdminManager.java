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
	
	public List<Train> getTrainList();
	public void addTrain(Train train);
	public void addStation(Station station);
	public List<User> getUsersOnTrain(int trainId);
	
}
