/**
 * 
 */
package by.home.grigoryev.train.view.io.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import by.home.grigoryev.train.entities.Station;
import by.home.grigoryev.train.view.io.OutputInfo;

/**
 * @author Maksim
 *
 */
public class Utils {

	public Station getStatonOfSet(Set<Station> stationSet, int stationIndex){
		
		Station station = new Station();
		
		int currentStationIndex = 0;
		Iterator<Station> iterator = stationSet.iterator();
		while(iterator.hasNext()){
			currentStationIndex++;
			station = iterator.next();
			if(currentStationIndex == stationIndex)
				break;
		}
		return station;
	}
	
	public String getPropsMessage(String key){
		String value = "";
		
		Properties props = new Properties();
		
		try(InputStream is = getClass().getResourceAsStream("/validator/messages.properties")){
			props.load(is);
		} catch (IOException e) {
			OutputInfo.showMessage("Can`t found message.properties");
		}
		
		value = props.getProperty(key);
		
		return value;
	}
	
	public String getPropsRegex(String key){
		String value = "";
		
		Properties props = new Properties();
		
		try(InputStream is = getClass().getResourceAsStream("/validator/regex.properties")){
			props.load(is);
		} catch (IOException e) {
			OutputInfo.showMessage("Can`t found regex.properties");
		}
		
		value = props.getProperty(key);
		
		return value;
	}
	
}
