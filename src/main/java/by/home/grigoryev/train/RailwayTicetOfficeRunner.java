package by.home.grigoryev.train;

import java.io.IOException;

import by.home.grigoryev.train.entities.enums.UserRole;
import by.home.grigoryev.train.service.utils.CheckUser;
import by.home.grigoryev.train.view.io.Menu;

public class RailwayTicetOfficeRunner {
	public static void main(String[] args) throws IOException{
		while(true){
			Menu menu = new Menu();
			if(CheckUser.currentRole.equals(UserRole.NO))
				menu.showRegistrationMenu();
			if(CheckUser.currentRole.equals(UserRole.PASSENGER))
				menu.showPassengerMenu();
			if(CheckUser.currentRole.equals(UserRole.ADMIN))
				menu.showAdminMenu();
			
			System.out.println();
		}	
		
		
//		List<Train> trains = new ArrayList<>();
//		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
//		IBaseDao<Train, Serializable> dao = new BaseDaoImpl<>(Train.class);
//		trains = dao.getAll();
//		for(Train train : trains){
//			System.out.println(train.getId());
//			System.out.println(train.getSchedule().getArrivalStation().getStation());
//			System.out.println(train.getSchedule().getDepatureStation().getStation());
//			System.out.println(sdf.format(train.getSchedule().getDepatureTime().getTime()));
//			System.out.println(sdf.format(train.getSchedule().getArrivalTime().getTime()));
//		}
		
//		List<User> users = new ArrayList<>();
//		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
//		IBaseDao<User, Serializable> dao = new BaseDaoImpl<>(User.class);
//		users = dao.getAll();
//		for(User user : users){
//			System.out.println(user.getId());
//			System.out.println(user.getLogin());
//			System.out.println(user.getPassword());
//			System.out.println(user.getMoney());
//		}
//		
	}
}
