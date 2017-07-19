package com.test.floow.read.local;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.test.floow.utility.FloowConstants;

public class ReadLocalFileServiceImplTest {

	@Test
	public void testIsFilePresent() {
		Map<String, String> configMap = new HashMap<String, String>();
		configMap.put(FloowConstants.SOURCE_FILENAME, "prova.txt");
	   	configMap.put(FloowConstants.MONGO_HOSTNAME, "localhost");
		configMap.put(FloowConstants.MONGO_PORT, "27017");
		configMap.put(FloowConstants.ID_SERVER, "serverFTP");
		configMap.put(FloowConstants.ID_STRING, "Daniele");
		configMap.put(FloowConstants.ID_HOSTNAME, "localhost");
		configMap.put(FloowConstants.ID_ID, "user");
		ReadLocalFileServiceImpl readLocal = new ReadLocalFileServiceImpl();
		assertTrue(readLocal.isFilePresent(configMap));
	}

	
	@Test
	public void testReadFileLocal() {
		Map<String, String> configMap = new HashMap<String, String>();
		configMap.put(FloowConstants.SOURCE_FILENAME, "prova.txt");
	   	configMap.put(FloowConstants.MONGO_HOSTNAME, "localhost");
		configMap.put(FloowConstants.MONGO_PORT, "27017");
		configMap.put(FloowConstants.ID_SERVER, "serverFTP");
		configMap.put(FloowConstants.ID_STRING, "Daniele");
		configMap.put(FloowConstants.ID_HOSTNAME, "localhost");
		configMap.put(FloowConstants.ID_ID, "user");
		ReadLocalFileServiceImpl readLocal = new ReadLocalFileServiceImpl();
		Long expetected = (long) 2;
		assertEquals(expetected, (readLocal.readFileLocal(configMap)));

	}
	

}
