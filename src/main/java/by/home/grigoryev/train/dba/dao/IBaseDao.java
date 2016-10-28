/**
 * 
 */
package by.home.grigoryev.train.dba.dao;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author Maksim
 *
 * @param <T> T
 * @param <PK> PK
 */
public interface IBaseDao<T, PK extends Serializable> {
	
	/**
	 * Get all objects from file.
	 * 
	 * @return list of objects
	 */
	List<T> getAll();
	
	/**
	 * Get object by id.
	 * 
	 * @param id object id
	 * @return object
	 */
	T get(PK id);
	
	/**
	 * Add object in file.
	 * 
	 * @param object object
	 * @throws IOException if IOException
	 */
	void add(T object) throws IOException;
	
	/**
	 * Update data in file.
	 * 
	 * @param object list of objects
	 */
	void update(List<T> object);
	
	/**
	 * Delete object by id
	 * 
	 * @param object object
	 */
	void delete(T object);
	
	/**
	 * Check file.
	 * 
	 * @return boolean
	 */
	boolean fileIsEmpty();
	
}