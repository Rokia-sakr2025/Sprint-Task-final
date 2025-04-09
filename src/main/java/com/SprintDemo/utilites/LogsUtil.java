package com.SprintDemo.utilites;

//import java.util.logging.LogManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.logging.Logger;

public class LogsUtil {
    public LogsUtil()
    {
        super();
    }
    public  static Logger logger(){
        return LogManager.getLogger(Thread.currentThread().getStackTrace()[3].getClassName());
       // return LogManager.getLo(Thread.currentThread().getStackTrace()[3].getClassName());
       // return  LogManager.getLogManager().getLogger(Thread.currentThread().getStackTrace()[3].getClassName());
    }
    public  static void trace(String... message)
    {
       logger().trace(String.join("",message));

    }
    public  static void error(String... message)
    {
        logger().error(String.join("",message));

    }
    public  static void debug(String... message)
    {
        logger().debug(String.join("",message));

    }
    public  static void info(String... message)
    {
        logger().info(String.join("",message));

    }
    public  static void warn(String... message)
    {
        logger().warn(String.join("",message));

    }


}
