/**
 * 
 */
package by.home.grigoryev.train.dba.dao.station;

import java.io.Serializable;
import java.util.TreeSet;

import by.home.grigoryev.train.dba.dao.IBaseDao;
import by.home.grigoryev.train.entities.Station;

/**
 * @author Maksim
 *
 */
public interface IStationDao extends IBaseDao<Station, Serializable>{
	
	TreeSet<Station> getStationList();
	void addStation(Station station);

}
