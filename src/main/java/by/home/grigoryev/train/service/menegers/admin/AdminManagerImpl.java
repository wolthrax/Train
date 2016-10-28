/**
 * 
 */
package by.home.grigoryev.train.service.menegers.admin;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import by.home.grigoryev.train.dba.dao.BaseDaoImpl;
import by.home.grigoryev.train.dba.dao.IBaseDao;
import by.home.grigoryev.train.dba.dao.station.IStationDao;
import by.home.grigoryev.train.dba.dao.station.StationDaoImpl;
import by.home.grigoryev.train.entities.Station;
import by.home.grigoryev.train.entities.Train;
import by.home.grigoryev.train.entities.User;
import by.home.grigoryev.train.service.menegers.ManagerImpl;

/**
 * 
 * @author Maksim
 *
 */
public class AdminManagerImpl extends ManagerImpl implements IAdminManager{

	@Override
	public List<User> getUserList() {
		
		IBaseDao<User, Serializable> dao = new BaseDaoImpl<>(User.class);
		List<User> userList = dao.getAll();
		return userList;
	}
	
	@Override
	public List<Train> getTrainList() {
		
		IBaseDao<Train, Serializable> dao = new BaseDaoImpl<>(Train.class);
		List<Train> trainList = dao.getAll();
		
		return trainList;
	}
	
	@Override
	public void addTrain(Train train) {
		IBaseDao<Train, Serializable> dao = new BaseDaoImpl<>(Train.class);
		
		List<Train> trainList = getTrainList();
		int maxId = 0;
		if(!trainList.isEmpty()){
			for(int i = 0; i < trainList.size(); i++){
				if(trainList.get(i).getId() > maxId)
					maxId = trainList.get(i).getId();
			}
		}
		train.setId(maxId + 1);
		
		try {
			dao.add(train);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void addStation(Station station) {
		
		IStationDao stationDao = new StationDaoImpl();
		stationDao.addStation(station);
		
	}

	@Override
	public List<User> getUsersOnTrain(int trainId) {
		
		IBaseDao<Train, Serializable> dao = new BaseDaoImpl<>(Train.class);
		Train train = dao.get(trainId);
		
		return train.getUserList();
	}

	@Override
	public void removeDepartedTrains() {
		
		IBaseDao<Train, Serializable> dao = new BaseDaoImpl<>(Train.class);
		List<Train> trainList = dao.getAll();
		List<Train>	newTrainList = new ArrayList<>();
		GregorianCalendar now = new GregorianCalendar();
		
		for(Train currentTrain : trainList){
			if(!currentTrain.getSchedule().getDepatureTime().getTime().before(now.getTime())){
				newTrainList.add(currentTrain);
			}
		}
		
		dao.update(newTrainList);
	}
}
