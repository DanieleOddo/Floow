/**
 * 
 */
package com.test.floow.read.local;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @author 502655011
 *
 */
public interface ReadLocalFileService {
	
	public boolean isFilePresent(Map<String, String> configArgs);
	
	public Long readFileLocal(Map<String, String> configArgs);
	
}
