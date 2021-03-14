package com.command;

import com.util.Console;

/**
 * 'help' command. Just for logical structure. Does nothing.
 */
public class HelpCommand extends Command {

    public HelpCommand() {
        super("help", " вывести справку по доступным командам");
    }


    @Override
    public boolean execute(String argument) {
            if (!argument.isEmpty()){
                Console.printerror("у команды help нет аргумента");
                return false;
            }
            return true;
    }
}
