/**
 * 
 */
package by.home.grigoryev.train.dba.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import by.home.grigoryev.train.entities.Train;
import by.home.grigoryev.train.entities.User;
import by.home.grigoryev.train.view.io.OutputInfo;

/**
 * 
 * @author Maksim
 *
 * @param <T>
 * @param <PK>
 */
public class BaseDaoImpl<T, PK extends Serializable> implements IBaseDao<T, PK>{
	
	Class<T> clazz;
	
	public BaseDaoImpl() {
		super();
	}
	
	public BaseDaoImpl(Class<T> clazz) {
		this.clazz = clazz;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll() {
		
		String path = "";
		if(clazz.equals(User.class)){
			path = "C:\\Railway\\UserList.txt";
		}else if(clazz.equals(Train.class)){
			path = "C:\\Railway\\TrainList.txt";
		}
		List<T> objList = new ArrayList<>();
		
		if(fileIsEmpty()){
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))){
				
				objList = (List<T>) ois.readObject();
				
			} catch (FileNotFoundException e) {
				System.err.println("File " + path + "not found");
			} catch (IOException e) {
				System.err.println("IOException");
			} catch (ClassNotFoundException e) {
				System.err.println("ClassNotFoundException");
			}
		}
		return objList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(PK id) {
		
		if(clazz.equals(User.class)){
			
			User user = new User();
			List<User> userList = (List<User>) getAll();
			
			for(User currentUser : userList){
				if(currentUser.getId() == (Integer)id){
					user = currentUser;
					break;
				}
			}
			return (T) user;
			
		}else if(clazz.equals(Train.class)){
			
			Train train = new Train();
			List<Train> trainList = (List<Train>) getAll();
			
			for(Train currentTrain : trainList){
				if(currentTrain.getId() == (Integer)id){
					train = currentTrain;
					break;
				}
			}
			return (T) train;
		}		
		return null;
	}

	@Override
	public void add(T object) throws IOException {
		String path = "";
		if(clazz.equals(User.class)){
			path = "C:\\Railway\\UserList.txt";
		}else if(clazz.equals(Train.class)){
			path = "C:\\Railway\\TrainList.txt";
		}
		
		List<T> objList = new ArrayList<>();
		objList = getAll();
		objList.add(object);
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))){
			
			oos.writeObject(objList);
			
		} catch (Exception e) {
			OutputInfo.showMessage("Error write object");
		}
		System.out.println("Файл записан");
	}

	@Override
	public void update(List<T> object) {
		
		String path = "";
		if(clazz.equals(User.class)){
			path = "C:\\Railway\\UserList.txt";
		}else if(clazz.equals(Train.class)){
			path = "C:\\Railway\\TrainList.txt";
		}
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))){
			
			oos.writeObject(object);
			
		} catch (Exception e) {
			OutputInfo.showMessage("Error write object");
		}
		
	}

	@Override
	public void delete(T object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean fileIsEmpty() {
		
		File file = new File("");
		if(clazz.equals(User.class)){
			file = new File("C:\\Railway\\UserList.txt");
		}else if(clazz.equals(Train.class)){
			file = new File("C:\\Railway\\TrainList.txt");
		}
		
		if(file.length() == 0)
			return false;
		else return true;
	}
}
