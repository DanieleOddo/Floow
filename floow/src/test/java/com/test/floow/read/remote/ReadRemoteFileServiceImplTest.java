/**
 * 
 */
package com.test.floow.read.remote;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.test.floow.utility.FloowConstants;

/**
 * @author 502655011
 *
 */
public class ReadRemoteFileServiceImplTest {

	/**
	 * Test method for {@link com.test.floow.read.remote.ReadRemoteFileServiceImpl#connectionRemoteActive(java.util.Map)}.
	 */
	@Test
	public void testisFileRemotePresent_Positive() {
		Map<String, String> configMap = new HashMap<String, String>();
		configMap.put(FloowConstants.SOURCE_FILENAME, "prova.txt");
	   	configMap.put(FloowConstants.MONGO_HOSTNAME, "localhost");
		configMap.put(FloowConstants.MONGO_PORT, "27017");
		configMap.put(FloowConstants.ID_SERVER, "serverFTP");
		configMap.put(FloowConstants.ID_STRING, "pippo");
		configMap.put(FloowConstants.ID_HOSTNAME, "localhost");
		configMap.put(FloowConstants.ID_ID, "user");
		ReadRemoteFileServiceImpl readRemote = new ReadRemoteFileServiceImpl();
		assertTrue(readRemote.isFileRemotePresent(configMap));
	}
	/**
	 * Test method for {@link com.test.floow.read.remote.ReadRemoteFileServiceImpl#readFileRemote(java.util.Map)}.
	 */
	@Test
	public void testReadFileRemote() {
		Map<String, String> configMap = new HashMap<String, String>();
		configMap.put(FloowConstants.SOURCE_FILENAME, "prova.txt");
	   	configMap.put(FloowConstants.MONGO_HOSTNAME, "localhost");
		configMap.put(FloowConstants.MONGO_PORT, "27017");
		configMap.put(FloowConstants.ID_SERVER, "serverFTP");
		configMap.put(FloowConstants.ID_STRING, "Daniele");
		configMap.put(FloowConstants.ID_HOSTNAME, "localhost");
		configMap.put(FloowConstants.ID_ID, "user");
		ReadRemoteFileServiceImpl readRemote = new ReadRemoteFileServiceImpl();
		Long expected = (long) 2;
		assertEquals(expected, (readRemote.readFileRemote(configMap)));
	}

}
