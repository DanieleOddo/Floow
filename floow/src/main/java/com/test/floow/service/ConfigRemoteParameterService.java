/**
 * 
 */
package com.test.floow.service;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.lang3.StringUtils;

import com.test.floow.utility.FloowConstants;

/**
 * @author danie
 *
 */
public class ConfigRemoteParameterService {
	
	private static final String sourceClass = ConfigRemoteParameterService.class.getName();
	private Logger logger = Logger.getLogger(sourceClass);
	private static final String SOURCE = "-source";
	private static final String MONGODB = "-mongo";
	private static final String ID = "-id";
	
	public Map<String, String> getMapCongi(String[] args) {
		final String sourceMethod = "SendAvanzamentoRTV";
		logger.entering(sourceClass, sourceMethod);
		
		Map<String, String> configMap = new HashMap<String, String>();
		try {
			 for (int i=0; i<args.length; i++) {
				String test = args[i];
		        if(StringUtils.contains(test, SOURCE)) {
		        	String value = args[i +1];
		        	configMap.put(FloowConstants.SOURCE_FILENAME, value);
		        }
		        if(StringUtils.contains(test, MONGODB)) {
		        	String mongo = args[i +1];
		        	String[] output = mongo.split(":");
		        	String mongoHost = output[0];
		        	String mongoPort = output[1];
		        	configMap.put(FloowConstants.MONGO_HOSTNAME, mongoHost);
		        	configMap.put(FloowConstants.MONGO_PORT, mongoPort);
		        }
		        if(StringUtils.contains(test, ID)) {
		        	String server = args[i +1];
		        	String hostNameID = args[i +2];
		        	String[] output = hostNameID.split("/");
		        	String hostname = output[0];
		        	String id = output[1];
		        	String strigToCheck = args[i +3];
		        	
		        	configMap.put(FloowConstants.ID_SERVER, server);
		        	configMap.put(FloowConstants.ID_STRING, strigToCheck);
		        	configMap.put(FloowConstants.ID_HOSTNAME, hostname);
		        	configMap.put(FloowConstants.ID_ID, id);
		        }
		        
		     }
			 return configMap;
		} catch (Exception e) {
			logger.logp(Level.SEVERE, sourceClass, sourceMethod, "Unable to read arguments : ", e);
			return null;
			
		}
		
	}

}
