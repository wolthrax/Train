/**
 * 
 */
package by.home.grigoryev.train.view.io.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.home.grigoryev.train.entities.Station;
import by.home.grigoryev.train.entities.User;
import by.home.grigoryev.train.service.menegers.admin.AdminManagerImpl;
import by.home.grigoryev.train.service.menegers.admin.IAdminManager;
import by.home.grigoryev.train.view.io.OutputInfo;



/**
 * @author Maksim
 *
 */
public class Validator {
	
	public static Map<String, String> messageMap = new HashMap<>();
	private Utils utils = new Utils();

	public void validationNumbersOfMenu(int menuItem, int maxMenuItem){
		
		if(menuItem < 1 || menuItem > maxMenuItem){
			OutputInfo.showMessage("No menu item");
		}
	}
	
	public boolean checkRegexp(String inputValue, String property){
		
		String regex = utils.getPropsRegex(property);
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(inputValue);
		
		if(!matcher.matches())
			messageMap.put(property, utils.getPropsMessage(property));
		
		return matcher.matches();
	}
	
	public void checkLogin(String login){
		
		IAdminManager adminManager = new AdminManagerImpl();
		List<User> userList = adminManager.getUserList();
		for(User user : userList){
			if(login.equals(user.getLogin()))
				messageMap.put("user.login.exist", utils.getPropsMessage("user.login.exist"));
		}
	}
	
	public boolean checkStation(int id){
		
		boolean checkStation = false;
		IAdminManager adminManager = new AdminManagerImpl();
		Set<Station> stations = adminManager.getStationList();
		
		if(!stations.isEmpty() && !(stations.size() < 2)){
			if(!(id < 1) && !(id > stations.size())){
				checkStation = true;
			} else messageMap.put("station.name.exist", utils.getPropsMessage("station.name.exist"));
		} else messageMap.put("station.empty", utils.getPropsMessage("station.empty"));
		
		return checkStation;
	}
}
