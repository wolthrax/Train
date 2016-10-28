/**
 * 
 */
package by.home.grigoryev.train.dba.utils;

import java.util.Comparator;

import by.home.grigoryev.train.entities.Station;

/**
 * @author Maksim
 *
 */
public class StationComparator implements Comparator<Station>{

	@Override
	public int compare(Station o1, Station o2) {
		return o1.getStation().compareTo(o2.getStation());
	}

}
