/**
 * 
 */
package by.home.grigoryev.train.view.io;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

import by.home.grigoryev.train.entities.Schedule;
import by.home.grigoryev.train.entities.Station;
import by.home.grigoryev.train.entities.Ticket;
import by.home.grigoryev.train.entities.Train;
import by.home.grigoryev.train.entities.User;
import by.home.grigoryev.train.entities.enums.UserRole;
import by.home.grigoryev.train.service.menegers.IManager;
import by.home.grigoryev.train.service.menegers.ManagerImpl;
import by.home.grigoryev.train.view.io.utils.Utils;
import by.home.grigoryev.train.view.io.utils.Validator;

/**
 * 
 * @author Maksim
 *
 */
public class InputInfo {
	
	Utils utils = new Utils();
	Validator validator = new Validator();
	
	public User inputUserInfo(){
		User user = new User();
		Scanner scanner =  new Scanner(System.in);
		Validator.messageMap.clear();
		String inputValue = "";
		
		System.out.print("Enter login: ");
		inputValue = scanner.nextLine();
		if(validator.checkRegexp(inputValue, "user.login"))
			user.setLogin(inputValue);
		
		System.out.print("Enter password: ");
		inputValue = scanner.nextLine();
		if(validator.checkRegexp(inputValue, "user.password"))
			user.setPassword(scanner.nextLine());
		
		System.out.print("Enter name: ");
		inputValue = scanner.nextLine();
		if(validator.checkRegexp(inputValue, "user.name"))
			user.setName(inputValue);
		
		System.out.print("Enter surname: ");
		inputValue = scanner.nextLine();
		if(validator.checkRegexp(inputValue, "user.surname"))
			user.setSurname(inputValue);
		
		System.out.print("Enter email: ");
		inputValue = scanner.nextLine();
		if(validator.checkRegexp(inputValue, "user.email"))
			user.setEmail(inputValue);
		
		System.out.print("Enter phone: ");
		inputValue = scanner.nextLine();
		if(validator.checkRegexp(inputValue, "user.phone"))
			user.setPhone(inputValue);
		
		user.setMoney(1000);
		user.setRole(UserRole.PASSENGER);
		user.setTicketList(new ArrayList<Ticket>());
		
		return user;
	}
	
	public String[] inputCredential(){
		String[] cridential = new String[2];
		Scanner scanner =  new Scanner(System.in);
		
		System.out.print("Enter login: ");
		cridential[0] = scanner.nextLine();
		System.out.print("Enter password: ");
		cridential[1] = scanner.nextLine();
		
		return cridential;
	}
	
	public Station inputStaionInfo(){
		
		Station station = new Station();
		Scanner scanner =  new Scanner(System.in);
		
		System.out.print("Enter station: ");
		station.setStation(scanner.nextLine());
		
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
		
		Scanner scanner = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
		
		System.out.print("Enter depature time(dd.MM.yyyy HH:mm): ");
		try {
			depatureTime.setTime(sdf.parse(scanner.nextLine()));
		} catch (ParseException e) {
			System.err.println("Incorrect time");
		}
		schedule.setDepatureTime(depatureTime);
		
		System.out.print("Enter arrival time(dd.MM.yyyy HH:mm): ");
		try {
			arrivalTime.setTime(sdf.parse(scanner.nextLine()));
		} catch (ParseException e) {
			System.err.println("Incorrect time");
		}
		schedule.setArrivalTime(arrivalTime);
		
		
		Set<Station> stationSet = manager.getStationList();
		
		outputInfo.showStations(stationSet);
		
		System.out.print("Enter depature station(1-" + stationSet.size() + "): ");	
		schedule.setDepatureStation(utils.getStatonOfSet(stationSet, scanner.nextInt()));
		
		scanner.nextLine();
		
		System.out.print("Enter arrival station(1-" + stationSet.size() + "): ");	
		schedule.setArrivalStation (utils.getStatonOfSet(stationSet, scanner.nextInt()));
		
		System.out.print("Enter number of seats: ");
		train.setNumberOfSeats(scanner.nextInt());
		
		System.out.print("Enter ticket price: ");
		train.setPrice(scanner.nextDouble());
		
		train.setUserList(new ArrayList<User>());
		train.setSchedule(schedule);
		
		return train;
	}
	
	public Object[] inputSuitableTrainInfo(){
		
		IManager manager = new ManagerImpl();
		Object[] objects = new Object[3];
		
		OutputInfo outputInfo = new OutputInfo();	
		Scanner scanner = new Scanner(System.in);
		
		Set<Station> stationSet = manager.getStationList();
		
		outputInfo.showStations(stationSet);
		
		System.out.print("Enter depature station(1-" + stationSet.size() + "): ");	
		objects[0] = utils.getStatonOfSet(stationSet, scanner.nextInt());	
		
		scanner.nextLine();
		
		System.out.print("Enter arrival station(1-" + stationSet.size() + "): ");		
		objects[1] = utils.getStatonOfSet(stationSet, scanner.nextInt());
		
		scanner.nextLine();
		
		System.out.print("Enter time(dd.MM.yyyy HH:mm): ");
		objects[2] = scanner.nextLine();
		
		return objects;
	}
	
	public int inputId(){
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter train id: ");
		int id = scanner.nextInt();
		
		return id;
		
	}
}