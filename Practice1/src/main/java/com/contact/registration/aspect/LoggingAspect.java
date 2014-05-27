package com.contact.registration.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.io.FileWriter;
import java.util.Date;

/**
 * User: iason
 * Date: 27.05.14
 */
@Aspect
public class LoggingAspect {
    @Pointcut("execution(* com.contact.registration.command.Command.processPage(..))")
    private void logExecution() { }

    @Before("logExecution()")
    public void log() throws Throwable {
        FileWriter fw = new FileWriter("app.log", true);
        String strToWrite = new Date()+" method call\n";
        fw.write(strToWrite);
        fw.close();
    }


}
