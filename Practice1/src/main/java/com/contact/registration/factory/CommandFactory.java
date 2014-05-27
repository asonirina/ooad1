package com.contact.registration.factory;

import com.contact.registration.command.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * User: iason
 * Date: 17.03.14
 */
public class CommandFactory {
    private static CommandFactory instance;
    private ApplicationContext context =
            new FileSystemXmlApplicationContext("context.xml");


    private CommandFactory() {
    }

    public static CommandFactory getInstance() {
        if (instance == null) {
            instance = new CommandFactory();
        }
        return instance;
    }

    public Command getCommandByAction(String action) {
        if (StringUtils.isBlank(action)) {
            action = "aName";
        }
        return (Command) context.getBean(action);
    }
}
