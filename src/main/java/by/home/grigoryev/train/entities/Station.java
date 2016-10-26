/**
 * 
 */
package by.home.grigoryev.train.entities;

import java.io.Serializable;

/**
 * @author Maksim
 *
 */
public class Station implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String Station;

	public String getStation() {
		return Station;
	}

	public void setStation(String station) {
		Station = station;
	}

	@Override
	public String toString() {
		return "Station [Station=" + Station + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Station == null) ? 0 : Station.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Station other = (Station) obj;
		if (Station == null) {
			if (other.Station != null)
				return false;
		} else if (!Station.equals(other.Station))
			return false;
		return true;
	}
}
