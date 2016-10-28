/**
 * 
 */
package by.home.grigoryev.train.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import by.home.grigoryev.train.view.io.OutputInfo;

/**
 * @author Maksim
 *
 */
public class FilePath {

	public String getFilePath(String key){
		
		Properties props = new Properties();
		
		try(InputStream is = getClass().getResourceAsStream("/FilePath.properties")){
			props.load(is);
		} catch (IOException e) {
			OutputInfo.showMessage("Can`t found FilePath.properties");
		}
		
		return props.getProperty(key);
	}
	
}
