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
	
	private String station;

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	@Override
	public String toString() {
		return "Station [Station=" + station + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((station == null) ? 0 : station.hashCode());
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
		if (station == null) {
			if (other.station != null)
				return false;
		} else if (!station.equals(other.station))
			return false;
		return true;
	}
}
