/**
 * 
 */
package by.home.grigoryev.train.service.menegers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import by.home.grigoryev.train.dba.dao.BaseDaoImpl;
import by.home.grigoryev.train.dba.dao.IBaseDao;
import by.home.grigoryev.train.dba.dao.station.IStationDao;
import by.home.grigoryev.train.dba.dao.station.StationDaoImpl;
import by.home.grigoryev.train.entities.Station;
import by.home.grigoryev.train.entities.User;
import by.home.grigoryev.train.entities.enums.UserRole;
import by.home.grigoryev.train.exceptions.IncorrectLoginOrPass;
import by.home.grigoryev.train.service.utils.Session;

/**
 * @author Maksim
 *
 */
public class ManagerImpl implements IManager{

	/**
	 * Check the login and password, initializes the fields in the class Session.
	 */
	
	@Override
	public void checkCredential(String[] credential) throws IncorrectLoginOrPass{
		
		IBaseDao<User, Serializable> dao = new BaseDaoImpl<>(User.class);
		
		List<User> userList = new ArrayList<>();
		userList = dao.getAll();
		
		for(User user : userList){	
			if(user.getLogin().equals(credential[0]) && 
					user.getPassword().equals(credential[1])){
				Session.currentRole = user.getRole();
				Session.userId = user.getId();
				break;
			}
		}
		
		if(Session.currentRole.equals(UserRole.NO)){
			throw new IncorrectLoginOrPass("Incorrect login or password");
			//System.out.println("Incorrect login or password");
		}	
	}

	/**
	 * Get a list of sorted stations.
	 */
	@Override
	public TreeSet<Station> getStationList() {
		
		IStationDao stationDao = new StationDaoImpl();
		TreeSet<Station> stationList = stationDao.getStationList();
		
		return stationList;
	}

	/**
	 * Logout and reset values of class Session.
	 */
	@Override
	public void logout() {
		Session.userId = -1;
		Session.currentRole = UserRole.NO;
	}
}
