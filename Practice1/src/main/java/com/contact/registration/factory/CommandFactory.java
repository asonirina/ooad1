package com.contact.registration.factory;

import com.contact.registration.command.*;

/**
 * User: iason
 * Date: 17.03.14
 */
public class CommandFactory {
    public static Command getCommandByAction(String action) {
        Command command = null;
        if (action != null && action.length() > 0) {
            if ("aCompany".equals(action)) {
                command = new CompanyCommand();
            } else if ("aPersonalInfo".equals(action)) {
                command =  new PersonalCommand();
            } else if ("aSave".equals(action)) {
               command = new FinalCommand();
            }

        } else {
           command = new NameCommand();
        }
        return command;
    }
}
