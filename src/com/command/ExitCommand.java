package com.command;

import com.util.Console;

/**
 * 'exit' command. Closes the program.
 */
public class ExitCommand extends Command {

    public ExitCommand() {
        super("exit", " завершить программу (без сохранения в файл)");
    }


    @Override
    public boolean execute(String argument) {
        if (!argument.isEmpty()) {
            Console.printerror("у команды exit нет аргумента");
            return false;
        }
        return true;
    }
}
