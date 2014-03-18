package com.contact.registration.factory;

import com.contact.registration.command.*;
import org.apache.commons.lang3.StringUtils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * User: iason
 * Date: 17.03.14
 */
public class CommandFactory {
    private Properties prop = new Properties();
    private static CommandFactory instance;

    private CommandFactory() {
        try {
            prop.load(CommandFactory.class.getClassLoader().getResourceAsStream("command.properties"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static CommandFactory getInstance() {
        if (instance == null) {
            instance = new CommandFactory();
        }
        return instance;
    }

    public Command getCommandByAction(String action) {
        Command command = null;
        if (StringUtils.isBlank(action)) {
            action = "aName";
        }
        String className = prop.getProperty(action);
        try {
            command = (Command) Class.forName(className).newInstance();
        } catch (Exception ex) {

        }

        return command;
    }
}
