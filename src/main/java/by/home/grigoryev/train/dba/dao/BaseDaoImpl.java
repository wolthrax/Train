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
import by.home.grigoryev.train.utils.FilePath;
import by.home.grigoryev.train.view.io.OutputInfo;

/**
 * 
 * @author Maksim
 *
 * @param <T> T
 * @param <PK> PK
 */
public class BaseDaoImpl<T, PK extends Serializable> implements IBaseDao<T, PK>{
	
	private Class<T> clazz;
	private FilePath filePath = new FilePath();
	
	public BaseDaoImpl() {
		super();
	}
	
	public BaseDaoImpl(Class<T> clazz) {
		this.clazz = clazz;
	}

	/**
	 * Get all objects from file.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll() {
		
		String path = "";
		if(clazz.equals(User.class)){
			path = filePath.getFilePath("file.user");
		}else if(clazz.equals(Train.class)){
			path = filePath.getFilePath("file.train");
		}
		List<T> objList = new ArrayList<>();
		
		if(fileIsEmpty()){
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))){
				
				objList = (List<T>) ois.readObject();
				
			} catch (FileNotFoundException e) {
				OutputInfo.showMessage("File " + path + " not found");
			} catch (IOException e) {
				OutputInfo.showMessage("IOException");
			} catch (ClassNotFoundException e) {
				OutputInfo.showMessage("ClassNotFoundException");
			}
		}
		return objList;
	}

	/**
	 * Get object by id.
	 */
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
			
			if(user.getId() == 0)
				OutputInfo.showMessage("User: " + id + " does not exist");
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
			
			if(train.getId() == 0)
				OutputInfo.showMessage("Train: " + id + " does not exist");
			return (T) train;
		}		
		return null;
	}

	/**
	 * Add new object.
	 */
	@Override
	public void add(T object) throws IOException {
		String path = "";
		if(clazz.equals(User.class)){
			path = filePath.getFilePath("file.user");
		}else if(clazz.equals(Train.class)){
			path = filePath.getFilePath("file.train");
		}
		
		List<T> objList;
		objList = getAll();
		objList.add(object);
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))){
			
			oos.writeObject(objList);
			OutputInfo.showMessage("Entity added");
			
		} catch (Exception e) {
			OutputInfo.showMessage("Error write object");
		}
	}

	/**
	 * Update data in file.
	 */
	@Override
	public void update(List<T> object) {
		
		String path = "";
		if(clazz.equals(User.class)){
			path = filePath.getFilePath("file.user");
		}else if(clazz.equals(Train.class)){
			path = filePath.getFilePath("file.train");
		}
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))){
			
			oos.writeObject(object);
			
		} catch (Exception e) {
			OutputInfo.showMessage("Error write object");
		}
		
	}

	/**
	 * Delete object by id
	 */
	@Override
	public void delete(T object) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Check file.
	 */
	@Override
	public boolean fileIsEmpty() {
		
		File file = new File("");
		if(clazz.equals(User.class)){
			file = new File(filePath.getFilePath("file.user"));
		}else if(clazz.equals(Train.class)){
			file = new File(filePath.getFilePath("file.train"));
		}

		return file.length() != 0;
	}
}
