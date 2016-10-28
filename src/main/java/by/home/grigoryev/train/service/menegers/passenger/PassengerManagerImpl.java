/**
 * 
 */
package by.home.grigoryev.train.service.menegers.passenger;

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import by.home.grigoryev.train.dba.dao.BaseDaoImpl;
import by.home.grigoryev.train.dba.dao.IBaseDao;
import by.home.grigoryev.train.entities.Station;
import by.home.grigoryev.train.entities.Ticket;
import by.home.grigoryev.train.entities.Train;
import by.home.grigoryev.train.entities.User;
import by.home.grigoryev.train.entities.enums.UserRole;
import by.home.grigoryev.train.service.menegers.ManagerImpl;
import by.home.grigoryev.train.service.utils.Session;
import by.home.grigoryev.train.view.io.OutputInfo;

/**
 * 
 * @author Maksim
 *
 */
public class PassengerManagerImpl extends ManagerImpl implements IPassengerManager{
	
	@Override
	public void addPassenger(User user) {
		IBaseDao<User, Serializable> dao = new BaseDaoImpl<>(User.class);
		
		List<User> passList = dao.getAll();
		int maxId = 0;
		if(!passList.isEmpty()){
			for(int i = 0; i < passList.size(); i++){
				if(passList.get(i).getId() > maxId)
					maxId = passList.get(i).getId();
			}
		}
		user.setId(maxId + 1);
		
		if(!dao.fileIsEmpty())
			user.setRole(UserRole.ADMIN);
		try {
			dao.add(user);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Train> getSuitableTrains(Object[] objects) {
		
		Station depStation = (Station) objects[0];
		Station arrivalStation = (Station) objects[1];
		String time = (String) objects[2];
		
		IBaseDao<Train, Serializable> dao = new BaseDaoImpl<>(Train.class);
		
		List<Train> suitableTrains = new ArrayList<>();
		List<Train> trainList = dao.getAll();
		
		GregorianCalendar before = new GregorianCalendar();
		GregorianCalendar after = new GregorianCalendar();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
		try {
			before.setTime(sdf.parse(time));
			after.setTime(sdf.parse(time));
		} catch (ParseException e) {
			System.err.println("Incorrect time");
		}
		
		before.add(GregorianCalendar.DAY_OF_YEAR, -1);
		after.add(GregorianCalendar.DAY_OF_YEAR, 1);
		
		
		for(Train train : trainList){
			if(train.getSchedule().getDepatureStation().getStation().equals(depStation.getStation()) && 
					train.getSchedule().getArrivalStation().getStation().equals(arrivalStation.getStation()) && 
					!train.getSchedule().getDepatureTime().before(before) && 
					!train.getSchedule().getDepatureTime().after(after)){
				
				suitableTrains.add(train);
			}
		}
		return suitableTrains;	
	}

	@Override
	public void bookATicket(int id) {
		
		IBaseDao<Train, Serializable> trainDao = new BaseDaoImpl<>(Train.class);
		IBaseDao<User, Serializable> userDao = new BaseDaoImpl<>(User.class);
		
		Train train = trainDao.get(id);
		User user = new User();
		
		List<Train> trainList = trainDao.getAll();
		List<User> userList = userDao.getAll();
		List<User> usersInTrain = train.getUserList();
		
		Ticket ticket = new Ticket();
		List<Ticket> ticketList = new ArrayList<>();
		
		int indexTrain = trainList.indexOf(train);
		
		for(User currentUser : userList){
			if(Session.userId == currentUser.getId()){
				user = currentUser;
				break;
			}
		}
		
		boolean money = false;
		boolean place = false;
		
		if(train.getId() != 0 && train.getNumberOfSeats() > 0)
			place = true;
		else OutputInfo.showMessage("No places");
		
		if(user.getMoney() > train.getPrice())
			money = true;
		else OutputInfo.showMessage("No money");
		
		if(money && place){
			ticket.setId(train.getId());
			ticket.setSchedule(train.getSchedule());
			ticket.setPrice(train.getPrice());
			ticket.setPlaceNumber(train.getNumberOfSeats());		
			ticketList = user.getTicketList();
			ticketList.add(ticket);
			
			user.setMoney(user.getMoney() - train.getPrice());
			user.setTicketList(ticketList);			
			usersInTrain.add(user);
			
			train.setNumberOfSeats(train.getNumberOfSeats() - 1);
			train.setUserList(usersInTrain);
			trainList.remove(indexTrain);
			trainList.add(indexTrain, train);
			
			trainDao.update(trainList);
			userDao.update(userList);
			
			OutputInfo.showMessage("Money: " + user.getMoney());
		} 
	}

	@Override
	public List<Ticket> getAllTicket() {
		
		IBaseDao<User, Serializable> dao = new BaseDaoImpl<>(User.class);
		List<User> users = dao.getAll();
		User user = new User();
		for(User currentUser : users){
			if(currentUser.getId() == Session.userId){
				user = currentUser;
				break;
			}
		}
		
		int index = users.indexOf(user);
		
		List<Ticket> tickets = dao.getAll().get(index).getTicketList();
		
		return tickets;
	}
}