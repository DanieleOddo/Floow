package com.test.floow;

import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.test.floow.dao.mongodb.ManageCollectionServiceImpl;
import com.test.floow.read.local.ReadLocalFileServiceImpl;
import com.test.floow.read.remote.ReadRemoteFileServiceImpl;
import com.test.floow.service.ConfigRemoteParameterService;
import com.test.floow.service.ExecThreadService;
import com.test.floow.utility.FloowConstants;

/**
 * Hello world!
 *
 */
public class App 
{
	private static final String SERVER_LOCAL = "local";
	
    public static void main( String[] args )
    {
    	
        System.out.println( "Hello World!" );
        System.out.println("----------- Start Elaboration : " + new Date());
        ConfigRemoteParameterService config = new ConfigRemoteParameterService();
        Map<String, String> configArgs = config.getMapCongi(args);
        ExecThreadService exec = new ExecThreadService();
        Runnable r = () -> exec.execThread(configArgs);
        Thread th = new Thread(r);
        th.start();
        th.setName(configArgs.get(FloowConstants.ID_SERVER));  
        System.out.println("Name of Thread Runnig is:  "+th.getName()); 
        System.out.println("----------- End   Elaboration : " + new Date());
    }
}
