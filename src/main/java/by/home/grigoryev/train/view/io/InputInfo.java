/**
 * 
 */
package by.home.grigoryev.train.view.io;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Set;

import by.home.grigoryev.train.entities.Schedule;
import by.home.grigoryev.train.entities.Station;
import by.home.grigoryev.train.entities.Ticket;
import by.home.grigoryev.train.entities.Train;
import by.home.grigoryev.train.entities.User;
import by.home.grigoryev.train.entities.enums.UserRole;
import by.home.grigoryev.train.service.menegers.IManager;
import by.home.grigoryev.train.service.menegers.ManagerImpl;
import by.home.grigoryev.train.view.io.utils.Scanner;
import by.home.grigoryev.train.view.io.utils.Utils;
import by.home.grigoryev.train.view.io.utils.Validator;

/**
 * 
 * @author Maksim
 *
 */
public class InputInfo {
	
	private Utils utils = new Utils();
	private Validator validator = new Validator();
	private String stringValue;
	private int intValue;
	private double doubleValue;
	
	public User inputUserInfo(){
		User user = new User();
		Scanner scanner =  new Scanner();
		Validator.messageMap.clear();
		
		System.out.print("Enter login: ");
		stringValue = scanner.getString();
		if(validator.checkRegexp(stringValue, "user.login")){
			validator.checkLogin(stringValue);
			user.setLogin(stringValue);
		}
		
		System.out.print("Enter password: ");
		stringValue = scanner.getString();
		if(validator.checkRegexp(stringValue, "user.password"))
			user.setPassword(stringValue);
		
		System.out.print("Enter name: ");
		stringValue = scanner.getString();
		if(validator.checkRegexp(stringValue, "user.name"))
			user.setName(stringValue);
		
		System.out.print("Enter surname: ");
		stringValue = scanner.getString();
		if(validator.checkRegexp(stringValue, "user.surname"))
			user.setSurname(stringValue);
		
		System.out.print("Enter email: ");
		stringValue = scanner.getString();
		if(validator.checkRegexp(stringValue, "user.email"))
			user.setEmail(stringValue);
		
		System.out.print("Enter phone: ");
		stringValue = scanner.getString();
		if(validator.checkRegexp(stringValue, "user.phone"))
			user.setPhone(stringValue);
		
		user.setMoney(1000);
		user.setRole(UserRole.PASSENGER);
		user.setTicketList(new ArrayList<Ticket>());
		
		return user;
	}
	
	public String[] inputCredential(){
		String[] cridential = new String[2];
		Scanner scanner =  new Scanner();
		
		System.out.print("Enter login: ");
		cridential[0] = scanner.getString();;
		System.out.print("Enter password: ");
		cridential[1] = scanner.getString();;
		
		return cridential;
	}
	
	public Station inputStaionInfo(){
		
		Station station = new Station();
		Scanner scanner =  new Scanner();
		Validator.messageMap.clear();
		
		System.out.print("Enter station: ");
		stringValue = scanner.getString();
		if(validator.checkRegexp(stringValue, "station.name"))
			station.setStation(stringValue);
		
		return station;
	}
	
	
	
	public Train inputTrainInfo(){
		
		IManager manager = new ManagerImpl();
		OutputInfo outputInfo = new OutputInfo();
		
		Train train = new Train();
		Schedule schedule = new Schedule();
		
		Locale locale = new Locale("ru", "RU");
		GregorianCalendar depatureTime = new GregorianCalendar(locale);
		GregorianCalendar arrivalTime = new GregorianCalendar(locale);
		
		Scanner scanner = new Scanner();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
		
		Validator.messageMap.clear();
		
		System.out.print("Enter depature time(dd.MM.yyyy HH:mm): ");
		stringValue = scanner.getString();
		if(validator.checkRegexp(stringValue, "train.time")){
			try {
				depatureTime.setTime(sdf.parse(stringValue));
			} catch (ParseException e) {
				System.err.println("Incorrect time");
			}
			schedule.setDepatureTime(depatureTime);
		}
		
		System.out.print("Enter arrival time(dd.MM.yyyy HH:mm): ");
		stringValue = scanner.getString();
		if(validator.checkRegexp(stringValue, "train.time")){
			try {
				arrivalTime.setTime(sdf.parse(stringValue));
			} catch (ParseException e) {
				System.err.println("Incorrect time");
			}
			schedule.setArrivalTime(arrivalTime);
		}
		
		
		Set<Station> stationSet = manager.getStationList();
		
		outputInfo.showStations(stationSet);
		
		System.out.print("Enter depature station(1-" + stationSet.size() + "): ");
		intValue = scanner.getInt();
		if(validator.checkStation(intValue))
			schedule.setDepatureStation(utils.getStatonOfSet(stationSet, intValue));
		
		System.out.print("Enter arrival station(1-" + stationSet.size() + "): ");
		intValue = scanner.getInt();
		if(validator.checkStation(intValue))
			schedule.setArrivalStation (utils.getStatonOfSet(stationSet, intValue));
		
		System.out.print("Enter number of seats: ");
		intValue = scanner.getInt();
		if(validator.checkRegexp(String.valueOf(intValue), "train.places"))
			train.setNumberOfSeats(intValue);
		
		
		System.out.print("Enter ticket price: ");
		doubleValue = scanner.getDouble();
		if(validator.checkRegexp(String.valueOf(doubleValue), "train.price"))
			train.setPrice(doubleValue);
		
		train.setUserList(new ArrayList<User>());
		train.setSchedule(schedule);
		
		return train;
	}
	
	public Object[] inputSuitableTrainInfo(){
		
		IManager manager = new ManagerImpl();
		Object[] objects = new Object[3];
		
		OutputInfo outputInfo = new OutputInfo();	
		Scanner scanner = new Scanner();
		
		Set<Station> stationSet = manager.getStationList();
		
		outputInfo.showStations(stationSet);
		
		Validator.messageMap.clear();
		
		System.out.print("Enter depature station(1-" + stationSet.size() + "): ");	
		objects[0] = utils.getStatonOfSet(stationSet, scanner.getInt());
		
		
		System.out.print("Enter arrival station(1-" + stationSet.size() + "): ");		
		objects[1] = utils.getStatonOfSet(stationSet, scanner.getInt());
		
		
		System.out.print("Enter time(dd.MM.yyyy HH:mm): ");
		objects[2] = scanner.getString();
		validator.checkRegexp(objects[2].toString(), "train.time");
		
		return objects;
	}
	
	public int inputId(){
		
		Scanner scanner = new Scanner();
		
		System.out.print("Enter train id: ");
		int id = scanner.getInt();
		
		return id;
		
	}
}