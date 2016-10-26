	/**
 * 
 */
package by.home.grigoryev.train.view.controllers;

import by.home.grigoryev.train.service.menegers.admin.AdminManagerImpl;
import by.home.grigoryev.train.service.menegers.admin.IAdminManager;
import by.home.grigoryev.train.view.io.InputInfo;
import by.home.grigoryev.train.view.io.OutputInfo;

/**
 * @author Maksim
 *
 */
public class AdminController extends Controller{

	@Override
	public void shooseOperation(int operationNumber) {
		
		InputInfo inputInfo = new InputInfo();
		OutputInfo outputInfo = new OutputInfo();
		IAdminManager adminManager = new AdminManagerImpl();
		
		switch(operationNumber){
		
			// Add train
			case 1:{
				
				if(!adminManager.getStationList().isEmpty())
					adminManager.addTrain(inputInfo.inputTrainInfo());
				else OutputInfo.showMessage("No one station");
				
			} break;
			
			// Add station
			case 2:{
			
				adminManager.addStation(inputInfo.inputStaionInfo());
					
			} break;
			
			// Show users in train
			case 3:{
				
				outputInfo.showTrains(adminManager.getTrainList());
				outputInfo.showUsers(adminManager.getUsersOnTrain(inputInfo.inputId()));
				
			} break;
			
			// Logout
			case 4:{
				
				adminManager.logout();
				
			} break;
		}
		
	}

}
