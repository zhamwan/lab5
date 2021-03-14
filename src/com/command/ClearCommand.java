package com.command;

import com.util.CollectionManager;
import com.util.Console;

/**
 *  'clear' command. Clears the collection.
 */
public class ClearCommand extends Command {
    private final CollectionManager collectionManager;

    public ClearCommand(CollectionManager collectionManager) {
        super("clear", " очистить коллекцию");
        this.collectionManager = collectionManager;
    }


    @Override
    public boolean execute(String argument) {
        if (!argument.isEmpty()){
        collectionManager.clear();
        Console.println("Коллекция очищена!");
        return true;
        }else{
            Console.printerror("у команды clear нет аргумента");
            return false;
        }
    }
}
