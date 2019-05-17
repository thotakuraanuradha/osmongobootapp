package com.stackroute.mashupcontent.loggerclient;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogUtils{

    public static Logger getLogger()
    {
        return LogManager.getLogger();
    }

    public static void logDebug(Logger logger,String logString){
        if(logger.isDebugEnabled()){
            logger.debug(logString);
        }
    }

    public static void logInfo(Logger logger,String logString){
        if(logger.isInfoEnabled()){
            logger.info(logString);
        }
    }
    public static void logWarn(Logger logger,String logString){

        logger.warn(logString);
    }
    public static void logError(Logger logger,String logString){

        logger.error(logString);
    }

    public static void logFatal(Logger logger,String logString){

        logger.fatal(logString);
    }


    public static void main(String[] args) {

        LogUtils obj = new LogUtils();
        Logger logger = LogManager.getLogger();
        obj.runMe(logger,"MTSLog");

    }

    private void runMe(Logger logger, String logString){
        logDebug(logger,"This is debug : " + logString);
        logInfo(logger,"This is info : " + logString);
        logWarn(logger,"This is warn : " + logString);
        logError(logger,"This is error : " + logString);
        logFatal(logger,"This is fatal : " + logString);
    }



}