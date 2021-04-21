/*This class reads data from config.properties file using Properties.
 * Properties is a key-value collection where key is string and value is also string.
 * By doing this, we have reduced code dependency.
 * similar approach is used in hibernate (DbUtils -> HbUtils) and (config.properties -> hibernate.cfg.xml)
*/

package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DbUtils {
	static Properties p;
	static {
		try (InputStream inputStream = DbUtils.class.getResourceAsStream("/config.properties")) {
			
			p = new Properties();
			p.load(inputStream);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public static Connection getConnection( ) throws Exception {
		System.out.println("inside getConnection()");
		return DriverManager.getConnection(p.getProperty("URL"), p.getProperty("USER"), p.getProperty("PASSWORD"));
	}
}