/**
 * 
 */
package com.test.floow.read.remote;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.lang3.StringUtils;

import com.test.floow.utility.FloowConstants;


/**
 * @author danie
 *
 */
public class ReadRemoteFileServiceImpl implements ReadRemoteFileService {
	
	private static final String sourceClass = ReadRemoteFileServiceImpl.class.getName();
	private Logger logger = Logger.getLogger(sourceClass);


	/* (non-Javadoc)
	 * @see com.test.floow.remote.service.ReadRemoteFileService#connectionRemoteActive(java.util.Map)
	 */
	public boolean isFileRemotePresent(Map<String, String> configArgs) {
		// TODO Auto-generated method stub
		final String sourceMethod = "connectionRemoteActive";
		logger.entering(sourceClass, sourceMethod);
		boolean result = false;
		try {
			
			String strFtpUrl = getStrConnection(configArgs); 
			String fileName = configArgs.get(FloowConstants.SOURCE_FILENAME);
			URL ftpUrl = new URL(strFtpUrl);
			URLConnection conn = ftpUrl.openConnection();
            InputStream inputStream = conn.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
 
            String line = null;
            while ((line = reader.readLine()) != null) {
            	
            	if (line.contains(fileName)) {
            		 result = true;
            	}
                
            }
            
            inputStream.close();
			return result;
		} catch (Exception e) {
			logger.logp(Level.SEVERE, sourceClass, sourceMethod, "Unable to connect FTP Remote", e);
			return false;
		}
		
	}

	public Long readFileRemote(Map<String, String> configArgs) {
		// TODO Auto-generated method stub
		final String sourceMethod = "readFileRemote";
		logger.entering(sourceClass, sourceMethod);
		Long result = (long) 0;
		try {
			String strFtpUrl = getStrConnection(configArgs) +  "/" + configArgs.get(FloowConstants.SOURCE_FILENAME);
			
			
			URL ftpUrl = new URL(strFtpUrl);
			URLConnection conn = ftpUrl.openConnection();
            InputStream inputStream = conn.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
           
            String line = null;
           
            while ((line = reader.readLine()) != null) {
            	if (StringUtils.contains(line, configArgs.get(FloowConstants.ID_STRING))) {
            		
            		result = result + 1;
              	}          	
            }
            
            inputStream.close();
			return result;
		} catch (Exception e) {
			logger.logp(Level.SEVERE, sourceClass, sourceMethod, "Unable to connect FTP Remote", e);
			return result;
		}
	}

	private String getStrConnection (Map<String, String> configArgs) {
		final String sourceMethod = "readFileRemote";
		logger.entering(sourceClass, sourceMethod);
		try {
			StringBuilder strBuild = new StringBuilder();
			strBuild.append("ftp://");
			strBuild.append(configArgs.get(FloowConstants.ID_ID));
			strBuild.append(":");
			strBuild.append(configArgs.get(FloowConstants.ID_ID));
			strBuild.append("@");
			strBuild.append(configArgs.get(FloowConstants.ID_HOSTNAME));
			return strBuild.toString();
		} catch (Exception e) {
			logger.logp(Level.SEVERE, sourceClass, sourceMethod, "Unable to read config Connect FTP Remote", e);
			return null;
		}
	}
}
