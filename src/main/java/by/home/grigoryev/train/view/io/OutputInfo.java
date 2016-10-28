/**
 * 
 */
package by.home.grigoryev.train.view.io;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import by.home.grigoryev.train.entities.Station;
import by.home.grigoryev.train.entities.Ticket;
import by.home.grigoryev.train.entities.Train;
import by.home.grigoryev.train.entities.User;
import by.home.grigoryev.train.view.io.utils.Validator;

/**
 * 
 * @author Maksim
 *
 */
public class OutputInfo {
	
	public static void showMessage(String message){
		System.out.println();
		System.out.println(message);
	}
	
	public void showStations(Set<Station> stationList){
		
		Iterator<Station> iterator = stationList.iterator();
		Station station = new Station();
		
		int i = 0;
		
		while(iterator.hasNext()){
			i++;
			station = iterator.next();
			System.out.println(i + ". " + station.getStation());
		}
	}
	
	public void showTrains(List<Train> trainList){
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
		System.out.println();
		System.out.println(String.format("%5s%13s%20s%20s%20s%6s%12s", "id" + "|", "Dep. station" + "|", 
				"Arrival station" + "|", "Dep. time" + "|", "Arrival time" + "|", 
				"Places" + "|", "Ticket price" + " "));
		for(Train train : trainList){
			System.out.println(String.format("%5s%13s%20s%20s%20s%6s%12s", train.getId() + "|", 
					train.getSchedule().getDepatureStation().getStation() + "|", 
					train.getSchedule().getArrivalStation().getStation() + "|", 
					sdf.format(train.getSchedule().getDepatureTime().getTime()) + "|", 
					sdf.format(train.getSchedule().getArrivalTime().getTime()) + "|", 
					train.getNumberOfSeats() + "|", train.getPrice() + " "));
		}
	}
	
	public void showTickets(List<Ticket> tickets){
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
		System.out.println();
		System.out.println(String.format("%5s%13s%20s%20s%20s%6s%12s", "id" + "|", "Dep. station" + "|", 
				"Arrival station" + "|", "Dep. time" + "|", "Arrival time" + "|", 
				"Place" + "|", "Ticket price" + " "));
		
		for(Ticket ticket : tickets){
			System.out.println(String.format("%5s%13s%20s%20s%20s%6s%12s", ticket.getId() + "|", 
					ticket.getSchedule().getDepatureStation().getStation() + "|", 
					ticket.getSchedule().getArrivalStation().getStation() + "|", 
					sdf.format(ticket.getSchedule().getDepatureTime().getTime()) + "|", 
					sdf.format(ticket.getSchedule().getArrivalTime().getTime()) + "|", 
					ticket.getPlaceNumber() + "|", ticket.getPrice() + " "));
		}
	}
	
	public void showUsers(List<User> users){
		if(users != null){
			System.out.println();
			System.out.println(String.format("%5s%13s%13s%13s%20s%15s", "id" + "|", "Login" + "|", "Name" + "|",
					"Surname" + "|", "Email" + "|", "Phone" + " "));
			
			for(User user : users){
				System.out.println(String.format("%5s%13s%13s%13s%20s%15s", user.getId() + "|", user.getLogin() + "|", 
						user.getName() + "|", user.getSurname() + "|", user.getEmail() + "|", user.getPhone() + " "));
			}
		}
	}
	
	public void showErrorMessages(){
		
		System.out.println();
		Map<String, String> map = Validator.messageMap;
		
		for(Map.Entry<String, String> entry : map.entrySet()){
			System.out.println(entry.getValue());
		}
		
	}
}
