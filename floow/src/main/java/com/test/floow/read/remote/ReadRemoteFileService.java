package com.test.floow.read.remote;
import java.math.BigDecimal;
import java.util.Map;

/**
 * 
 */

/**
 * @author danie
 *
 */
public interface ReadRemoteFileService {
	
	public boolean isFileRemotePresent(Map<String, String> configArgs);
	
	public Long readFileRemote(Map<String, String> configArgs);

}
