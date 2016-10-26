/**
 * 
 */
package by.home.grigoryev.train.dba.dao.station;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;
import java.util.TreeSet;

import by.home.grigoryev.train.dba.dao.BaseDaoImpl;
import by.home.grigoryev.train.dba.utils.Order;
import by.home.grigoryev.train.entities.Station;

/**
 * @author Maksim
 *
 */
public class StationDaoImpl extends BaseDaoImpl<Station, Serializable> implements IStationDao{

	public StationDaoImpl() {
		super();
	}
	
	@Override
	public TreeSet<Station> getStationList() {
		
		
		TreeSet<Station> stationList = new TreeSet<>(new Order());
		
		File file = new File("C:\\Railway\\Station.txt");
		try(FileReader fileReader = new FileReader(file)){
			
			Scanner scanner = new Scanner(file);
			
			while(scanner.hasNextLine()){
				Station station = new Station();
				station.setStation(scanner.nextLine());
				stationList.add(station);	
			}
			
			scanner.close();
			
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return stationList;
	}

	@Override
	public void addStation(Station station) {
		
		try(FileWriter fileWriter = new FileWriter("C:\\Railway\\Station.txt", true)){
			
			fileWriter.write(station.getStation() + "\n");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
