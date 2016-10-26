/**
 * 
 */
package by.home.grigoryev.train.view.controllers;

import java.util.List;

import by.home.grigoryev.train.entities.Ticket;
import by.home.grigoryev.train.entities.Train;
import by.home.grigoryev.train.service.menegers.passenger.IPassengerManager;
import by.home.grigoryev.train.service.menegers.passenger.PassengerManagerImpl;
import by.home.grigoryev.train.service.utils.CheckUser;
import by.home.grigoryev.train.view.io.InputInfo;
import by.home.grigoryev.train.view.io.OutputInfo;

/**
 * 
 * @author Maksim
 *
 */
public class PassengerController extends Controller{
	
	@Override
	public void shooseOperation(int operationNumber) {
		
		InputInfo inputInfo = new InputInfo();
		OutputInfo outputInfo = new OutputInfo();
		IPassengerManager passManager = new PassengerManagerImpl();
		
		switch(operationNumber){
			case 1:{
				
				List<Train> suitableTrainList = 
						passManager.getSuitableTrains(inputInfo.inputSuitableTrainInfo());
				
				if(suitableTrainList.isEmpty()){
					OutputInfo.showMessage("No suitable trains");
				} else {
					outputInfo.showTrains(suitableTrainList);
					passManager.bookATicket(inputInfo.inputId());
				}
					
			}break;
			case 2:{
							
				List<Ticket> tickets = passManager.getAllTicket();
				outputInfo.showTickets(tickets);
					
			}break;
			case 3:{
				
				
				
			}break;
			
			case 4:{
				
				passManager.logout();
				
			}break;
		}
	}
}
