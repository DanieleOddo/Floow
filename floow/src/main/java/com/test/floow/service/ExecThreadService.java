/**
 * 
 */
package com.test.floow.service;

import java.util.Date;
import java.util.Map;
import java.util.logging.Logger;

import com.test.floow.dao.mongodb.ManageCollectionServiceImpl;
import com.test.floow.read.local.ReadLocalFileServiceImpl;
import com.test.floow.read.remote.ReadRemoteFileServiceImpl;
import com.test.floow.utility.FloowConstants;

/**
 * @author 502655011
 *
 */
public class ExecThreadService {
	
	private static final String SERVER_LOCAL = "local";
	private static final String sourceClass = ExecThreadService.class.getName();
	private Logger logger = Logger.getLogger(sourceClass);

	
	public void execThread(Map<String, String> configArgs) {
		final String sourceMethod = "createCollection";
		logger.entering(sourceClass, sourceMethod);
		
		System.out.println("--------------------Start Thread at Date: " + new Date());
		if (configArgs.get(FloowConstants.ID_SERVER).equals(SERVER_LOCAL)) {
        	ReadLocalFileServiceImpl read = new ReadLocalFileServiceImpl();
        	if (!read.isFilePresent(configArgs)) {    	
    			System.out.println("File not present: " + configArgs.get(FloowConstants.SOURCE_FILENAME));
        	} else {
        		Long result = read.readFileLocal(configArgs);
        		configArgs.put("qta", result.toString());
        		System.out.println("I Found the string: " +configArgs.get(FloowConstants.ID_STRING) +" -inside file for Total :"  +result);
        		ManageCollectionServiceImpl collection = new ManageCollectionServiceImpl();
        		collection.updateMongo(configArgs);
        	}
        } else {
        	ReadRemoteFileServiceImpl readRemote = new ReadRemoteFileServiceImpl();
        	if (!readRemote.isFileRemotePresent(configArgs)) {
        		System.out.println("File not present: " + configArgs.get(FloowConstants.SOURCE_FILENAME));
        	} else {
        		Long result = readRemote.readFileRemote(configArgs);
        		System.out.println("I Found the string: " +configArgs.get(FloowConstants.ID_STRING) +" -inside file for Total :"  +result);
        		configArgs.put("qta", result.toString());
        		ManageCollectionServiceImpl collection = new ManageCollectionServiceImpl();
        		collection.updateMongo(configArgs);
        	}
        		
        }
		System.out.println("--------------------End   Thread at Date: "  + new Date());
	}

}
