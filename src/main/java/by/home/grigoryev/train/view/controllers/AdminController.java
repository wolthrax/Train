	/**
 * 
 */
package by.home.grigoryev.train.view.controllers;

import by.home.grigoryev.train.entities.Station;
import by.home.grigoryev.train.entities.Train;
import by.home.grigoryev.train.service.menegers.admin.AdminManagerImpl;
import by.home.grigoryev.train.service.menegers.admin.IAdminManager;
import by.home.grigoryev.train.view.io.InputInfo;
import by.home.grigoryev.train.view.io.OutputInfo;
import by.home.grigoryev.train.view.io.utils.Validator;

/**
 * @author Maksim
 *
 */
public class AdminController implements Controller{

	@Override
	public void shooseOperation(int operationNumber) {
		
		InputInfo inputInfo = new InputInfo();
		OutputInfo outputInfo = new OutputInfo();
		IAdminManager adminManager = new AdminManagerImpl();
		
		switch(operationNumber){
		
			// Add train
			case 1:{
				
				Train train = inputInfo.inputTrainInfo();
				if(Validator.messageMap.isEmpty())
					adminManager.addTrain(train);
				else outputInfo.showErrorMessages();
				
			} break;
			
			// Add station
			case 2:{
			
				Station station = inputInfo.inputStaionInfo();
				if(Validator.messageMap.isEmpty())
					adminManager.addStation(station);
				else outputInfo.showErrorMessages();
				
					
			} break;
			
			// Show users in train
			case 3:{
				
				outputInfo.showTrains(adminManager.getTrainList());
				outputInfo.showUsers(adminManager.getUsersOnTrain(inputInfo.inputId()));
				
			} break;
			
			case 4:{
				
				adminManager.removeDepartedTrains();
				
			} break;
			
			// Logout
			case 5:{
				
				adminManager.logout();
				
			} break;
		}
		
	}

}
