package com.test.floow.dao.mongodb;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.test.floow.utility.FloowConstants;

public class ManageCollectionServiceImplTest {

	@Test
	public void testIsDBPresentPresent() {
		Map<String, String> configMap = new HashMap<String, String>();
		configMap.put(FloowConstants.SOURCE_FILENAME, "prova.txt");
	   	configMap.put(FloowConstants.MONGO_HOSTNAME, "localhost");
		configMap.put(FloowConstants.MONGO_PORT, "27017");
		configMap.put(FloowConstants.ID_SERVER, "serverFTP");
		configMap.put(FloowConstants.ID_STRING, "pippo");
		configMap.put(FloowConstants.ID_HOSTNAME, "localhost");
		configMap.put(FloowConstants.ID_ID, "user");
		ManageCollectionServiceImpl collService = new ManageCollectionServiceImpl();
		assertTrue(collService.IsDBPresent(configMap));
	}

	@Test
	public void testIsCollectionPresent() {
		Map<String, String> configMap = new HashMap<String, String>();
		configMap.put(FloowConstants.SOURCE_FILENAME, "prova.txt");
	   	configMap.put(FloowConstants.MONGO_HOSTNAME, "localhost");
		configMap.put(FloowConstants.MONGO_PORT, "27017");
		configMap.put(FloowConstants.ID_SERVER, "serverFTP");
		configMap.put(FloowConstants.ID_STRING, "pippo");
		configMap.put(FloowConstants.ID_HOSTNAME, "localhost");
		configMap.put(FloowConstants.ID_ID, "user");
		ManageCollectionServiceImpl collService = new ManageCollectionServiceImpl();
		assertFalse(collService.isCollectionPresent(configMap));
	}
	
	@Test
	public void testUpdateCollection() {
		Map<String, String> configMap = new HashMap<String, String>();
		configMap.put(FloowConstants.SOURCE_FILENAME, "prova.txt");
	   	configMap.put(FloowConstants.MONGO_HOSTNAME, "localhost");
		configMap.put(FloowConstants.MONGO_PORT, "27017");
		configMap.put(FloowConstants.ID_SERVER, "local");
		configMap.put(FloowConstants.ID_STRING, "Daniele");
		configMap.put(FloowConstants.ID_HOSTNAME, "localhost");
		configMap.put(FloowConstants.ID_ID, "user");
		configMap.put("qta", "2");
		ManageCollectionServiceImpl collService = new ManageCollectionServiceImpl();
		assertFalse(collService.updateCollection(configMap));
	}
	
	@Test
	public void testCreateCollection() {
		Map<String, String> configMap = new HashMap<String, String>();
		configMap.put(FloowConstants.SOURCE_FILENAME, "prova.txt");
	   	configMap.put(FloowConstants.MONGO_HOSTNAME, "localhost");
		configMap.put(FloowConstants.MONGO_PORT, "27017");
		configMap.put(FloowConstants.ID_SERVER, "local");
		configMap.put(FloowConstants.ID_STRING, "Daniele");
		configMap.put(FloowConstants.ID_HOSTNAME, "localhost");
		configMap.put(FloowConstants.ID_ID, "user");
		configMap.put("qta", "3");
		ManageCollectionServiceImpl collService = new ManageCollectionServiceImpl();
		assertFalse(collService.createCollection(configMap));
	}
		
}
