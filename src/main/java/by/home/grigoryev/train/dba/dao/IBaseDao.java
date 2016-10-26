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
 * @param <T>
 * @param <PK>
 */
public interface IBaseDao<T, PK extends Serializable> {
	
	List<T> getAll();
	T get(PK id);
	void add(T object) throws IOException;
	void update(List<T> object);
	void delete(T object);
	boolean fileIsEmpty();
	
}