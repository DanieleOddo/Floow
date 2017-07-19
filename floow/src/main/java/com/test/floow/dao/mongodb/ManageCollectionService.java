/**
 * 
 */
package com.test.floow.dao.mongodb;

import java.util.Map;

/**
 * @author danie
 *
 */
public interface ManageCollectionService {
	
	public boolean IsDBPresent(Map<String, String> configArgs);
	
	public boolean updateMongo(Map<String, String> configArgs);
	
	public boolean isCollectionPresent(Map<String, String> configArgs);
	
	public boolean createCollection(Map<String, String> configArgs);
	
	public boolean updateCollection(Map<String, String> configArgs);
	

}
