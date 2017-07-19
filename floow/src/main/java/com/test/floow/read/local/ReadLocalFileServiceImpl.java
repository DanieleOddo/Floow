/**
 * 
 */
package com.test.floow.read.local;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

import com.test.floow.utility.FloowConstants;

/**
 * @author 502655011
 *
 */
public class ReadLocalFileServiceImpl implements ReadLocalFileService {

	private static final String sourceClass = ReadLocalFileServiceImpl.class.getName();
	private Logger logger = Logger.getLogger(sourceClass);

	/* (non-Javadoc)
	 * @see com.test.floow.read.local.ReadLocalFileService#isFilePresent(java.util.Map)
	 */
	public boolean isFilePresent(Map<String, String> configArgs) {
		// TODO Auto-generated method stub
		final String sourceMethod = "isFilePresent";
		logger.entering(sourceClass, sourceMethod);
		
		String sourceFile = configArgs.get(FloowConstants.SOURCE_FILENAME);
		String fileName = "C:/Floow/local/" + sourceFile;
		try {
			if (Files.isReadable(Paths.get(fileName))) {
				return true;
			}
			return false;
		} catch (Exception e) {
			logger.logp(Level.SEVERE, sourceClass, sourceMethod, "Unable to read file local: ", e);
			return false;
		}
		
	}

	/* (non-Javadoc)
	 * @see com.test.floow.read.local.ReadLocalFileService#readFileLocal(java.util.Map)
	 */
	public Long readFileLocal(Map<String, String> configArgs) {
		// TODO Auto-generated method stub
		final String sourceMethod = "readFileLocal";
		logger.entering(sourceClass, sourceMethod);
		
		Long result = (long) 0;
		
		String sourceFile = configArgs.get(FloowConstants.SOURCE_FILENAME);
		String searchString = configArgs.get(FloowConstants.ID_STRING);
		String fileName = "C:/Floow/local/" + sourceFile;
		try {
			Stream<String> stream = Files.lines(Paths.get(fileName));
			result = stream
					.filter(line -> line.contains(searchString))
					.count();
			
			return result;
		} catch (IOException ioe) {
			logger.logp(Level.SEVERE, sourceClass, sourceMethod, "Unable to read file local: ", ioe);
			return result;
		} catch (Exception e) {
			logger.logp(Level.SEVERE, sourceClass, sourceMethod, "Unable to read file local: ", e);
			return result;
		}
		
	}

}
