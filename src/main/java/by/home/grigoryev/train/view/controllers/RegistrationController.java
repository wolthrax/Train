/**
 * 
 */
package by.home.grigoryev.train.view.controllers;

import by.home.grigoryev.train.entities.User;
import by.home.grigoryev.train.exceptions.IncorrectLoginOrPass;
import by.home.grigoryev.train.service.menegers.IManager;
import by.home.grigoryev.train.service.menegers.ManagerImpl;
import by.home.grigoryev.train.service.menegers.passenger.IPassengerManager;
import by.home.grigoryev.train.service.menegers.passenger.PassengerManagerImpl;
import by.home.grigoryev.train.view.io.InputInfo;
import by.home.grigoryev.train.view.io.OutputInfo;
import by.home.grigoryev.train.view.io.utils.Validator;

/**
 * @author Maksim
 *
 */
public class RegistrationController extends Controller{

	@Override
	public void shooseOperation(int operationNumber) {
		
		InputInfo inputInfo = new InputInfo();
		OutputInfo outputInfo = new OutputInfo();
		
		switch(operationNumber){
			case 1:{
				
				IPassengerManager passengerManager =  new PassengerManagerImpl();
				User user = inputInfo.inputUserInfo();
				if(Validator.messageMap.isEmpty())
					passengerManager.addPassenger(user);
				else outputInfo.showErrorMessages();
				
			}break;
			case 2:{
				
				IManager meneger = new ManagerImpl();
				try {
					meneger.checkCredential(inputInfo.inputCredential());
				} catch (IncorrectLoginOrPass e) {
					System.err.println(e.getMessage());
				}
					
			}break;
			case 3:{
				
			}break;
		}
	}
}
