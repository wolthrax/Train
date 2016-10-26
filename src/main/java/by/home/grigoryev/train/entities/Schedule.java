/**
 * 
 */
package by.home.grigoryev.train.entities;

import java.io.Serializable;
import java.util.GregorianCalendar;

/**
 * @author Maksim
 *
 */
public class Schedule extends Entity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Station depatureStation;
	private Station arrivalStation;
	private GregorianCalendar depatureTime;
	private GregorianCalendar arrivalTime;
	
	public Station getDepatureStation() {
		return depatureStation;
	}
	public void setDepatureStation(Station depatureStation) {
		this.depatureStation = depatureStation;
	}
	public Station getArrivalStation() {
		return arrivalStation;
	}
	public void setArrivalStation(Station arrivalStation) {
		this.arrivalStation = arrivalStation;
	}
	public GregorianCalendar getDepatureTime() {
		return depatureTime;
	}
	public void setDepatureTime(GregorianCalendar depatureTime) {
		this.depatureTime = depatureTime;
	}
	public GregorianCalendar getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(GregorianCalendar arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
	@Override
	public String toString() {
		return "Schedule [depatureStation=" + depatureStation + ", arrivalStation=" + arrivalStation + ", depatureTime="
				+ depatureTime + ", arrivalTime=" + arrivalTime + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((arrivalStation == null) ? 0 : arrivalStation.hashCode());
		result = prime * result + ((arrivalTime == null) ? 0 : arrivalTime.hashCode());
		result = prime * result + ((depatureStation == null) ? 0 : depatureStation.hashCode());
		result = prime * result + ((depatureTime == null) ? 0 : depatureTime.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Schedule other = (Schedule) obj;
		if (arrivalStation == null) {
			if (other.arrivalStation != null)
				return false;
		} else if (!arrivalStation.equals(other.arrivalStation))
			return false;
		if (arrivalTime == null) {
			if (other.arrivalTime != null)
				return false;
		} else if (!arrivalTime.equals(other.arrivalTime))
			return false;
		if (depatureStation == null) {
			if (other.depatureStation != null)
				return false;
		} else if (!depatureStation.equals(other.depatureStation))
			return false;
		if (depatureTime == null) {
			if (other.depatureTime != null)
				return false;
		} else if (!depatureTime.equals(other.depatureTime))
			return false;
		return true;
	}
}
