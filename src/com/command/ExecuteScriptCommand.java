package com.command;

import com.util.Console;

/**
 * 'execute_script' command. Executes scripts from a file.
 */
public class ExecuteScriptCommand extends Command {
    public ExecuteScriptCommand() {
        super("execute_script <file_name>", " исполнить скрипт из указанного файла");
    }


    @Override
    public boolean execute(String argument) {
            if (argument.isEmpty()){
                Console.printerror("нет аргумента");
                return false;
            }
            Console.println("Выполняю скрипт '" + argument + "'...");
            return true;
    }
}
