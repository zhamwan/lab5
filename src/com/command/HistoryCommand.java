package com.command;

import com.util.Console;

/**
 * Command 'history'. It's here just for logical structure.
 */
public class HistoryCommand extends Command {

    public HistoryCommand() {
        super("history", " вывести историю использованных команд");
    }


    @Override
    public boolean execute(String argument) {
        if (!argument.isEmpty()){
            Console.printerror("у команды history нет аргумента");
            return false;
        }
        return true;
    }
}
