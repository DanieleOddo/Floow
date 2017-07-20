/**
 * 
 */
package com.test.floow.service;

import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.test.floow.dao.mongodb.ManageCollectionServiceImpl;
import com.test.floow.read.local.ReadLocalFileServiceImpl;
import com.test.floow.read.remote.ReadRemoteFileServiceImpl;
import com.test.floow.utility.FloowConstants;

/**
 * @author 502655011
 *
 */
public class MyRunnable implements Runnable{
	
	private static final String SERVER_LOCAL = "local";
	private static final String sourceClass = MyRunnable.class.getName();
	private Logger logger = Logger.getLogger(sourceClass);

	private String[] args = null;
	
	public MyRunnable(String...args) {
		this.args = args;
	}
	
	public void exec(String...args) {
		final String sourceMethod = "createCollection";
		logger.entering(sourceClass, sourceMethod);
		try {
			ConfigRemoteParameterService config = new ConfigRemoteParameterService();
	        Map<String, String> configArgs = config.getMapCongi(args);
	        System.out.println("--------------------Start Thread at Date: " + new Date());
			if (configArgs.get(FloowConstants.ID_SERVER).equals(SERVER_LOCAL)) {
	        	ReadLocalFileServiceImpl read = new ReadLocalFileServiceImpl();
	        	if (!read.isFilePresent(configArgs)) {    	
	    			System.out.println("File not present: " + configArgs.get(FloowConstants.SOURCE_FILENAME));
	        	} else {
	        		Long result = read.readFileLocal(configArgs);
	        		configArgs.put("qta", result.toString());
	        		System.out.println("-----------------------------------------------------------------------------------------");
	        		System.out.println("-- Report ");
	        		System.out.println("-- I Found the string: " +configArgs.get(FloowConstants.ID_STRING) +" inside file Total :"  +result);
	        		System.out.println("-----------------------------------------------------------------------------------------");
	        		ManageCollectionServiceImpl collection = new ManageCollectionServiceImpl();
	        		collection.updateMongo(configArgs);
	        	}
	        } else {
	        	ReadRemoteFileServiceImpl readRemote = new ReadRemoteFileServiceImpl();
	        	if (!readRemote.isFileRemotePresent(configArgs)) {
	        		System.out.println("File not present: " + configArgs.get(FloowConstants.SOURCE_FILENAME));
	        	} else {
	        		Long result = readRemote.readFileRemote(configArgs);
	        		configArgs.put("qta", result.toString());
	        		System.out.println("-----------------------------------------------------------------------------------------");
	        		System.out.println("-- Report ");
	        		System.out.println("-- I Found the string: " +configArgs.get(FloowConstants.ID_STRING) +" inside file Total :"  +result);
	        		System.out.println("-----------------------------------------------------------------------------------------");
	        		ManageCollectionServiceImpl collection = new ManageCollectionServiceImpl();
	        		collection.updateMongo(configArgs);
	        	}
	        		
	        }
			System.out.println("--------------------End   Thread at Date: "  + new Date());
	        
		} catch (Exception e) {
			logger.logp(Level.SEVERE, sourceClass, sourceMethod, "Unable to execute:  ", e);
		}
		
	}

	public void run() {
		// TODO Auto-generated method stub
		
	}

}
