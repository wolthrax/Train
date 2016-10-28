/**
 * 
 */
package by.home.grigoryev.train.dba.dao.station;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;
import java.util.TreeSet;

import by.home.grigoryev.train.dba.dao.BaseDaoImpl;
import by.home.grigoryev.train.dba.utils.StationComparator;
import by.home.grigoryev.train.entities.Station;
import by.home.grigoryev.train.utils.FilePath;
import by.home.grigoryev.train.view.io.OutputInfo;

/**
 * @author Maksim
 *
 */
public class StationDaoImpl extends BaseDaoImpl<Station, Serializable> implements IStationDao{

	public StationDaoImpl() {
		super();
	}
	
	private FilePath filePath = new FilePath();
	
	@Override
	public TreeSet<Station> getStationList() {
		
		
		TreeSet<Station> stationList = new TreeSet<>(new StationComparator());
		
		File file = new File(filePath.getFilePath("file.station"));
		
			
			Scanner scanner = null;
			try {
				scanner = new Scanner(file);
			} catch (FileNotFoundException e) {
				OutputInfo.showMessage("File " + file.getName() + " not found");
			}
			
			while(scanner.hasNextLine()){
				Station station = new Station();
				station.setStation(scanner.nextLine());
				stationList.add(station);	
			}
			
			scanner.close();
			
		
		return stationList;
	}

	@Override
	public void addStation(Station station) {
		
		try(FileWriter fileWriter = new FileWriter(filePath.getFilePath("file.station"), true)){
			
			fileWriter.write(station.getStation() + "\n");
			
		} catch (IOException e) {
			OutputInfo.showMessage("IOException");
		}
	}
}
