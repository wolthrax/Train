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
	
	/**
	 * Get list of stations.
	 * 
	 * @return List of station
	 */
	TreeSet<Station> getStationList();
	
	/**
	 * Add new station in file Stations.txt
	 * 
	 * @param station entity Station
	 */
	void addStation(Station station);

}
