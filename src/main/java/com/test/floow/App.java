package com.test.floow;

import java.util.Date;
import java.util.Map;
import com.test.floow.service.ConfigRemoteParameterService;
import com.test.floow.service.MyRunnable;
import com.test.floow.utility.FloowConstants;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
    {
    	
        System.out.println("----------- Start Elaboration : " + new Date());
        ConfigRemoteParameterService config = new ConfigRemoteParameterService();
        Map<String, String> configArgs = config.getMapCongi(args);
        MyRunnable exec = new MyRunnable();
        Runnable r = () -> exec.exec(args);
        Thread th = new Thread(r);
        th.start();
        th.setName(configArgs.get(FloowConstants.ID_SERVER));  
        System.out.println("Name of Thread Runnig is:  "+th.getName()); 
        System.out.println("----------- End   Elaboration : " + new Date());
    }
}
