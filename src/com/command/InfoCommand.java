package com.command;


import com.util.CollectionManager;
import com.util.Console;

/**
 * 'info' command. Prints information about the collection.
 */
public class InfoCommand extends Command {
    private final CollectionManager collectionManager;

    public InfoCommand(CollectionManager collectionManager) {
        super("info", " вывести информацию о коллекции");
        this.collectionManager = collectionManager;
    }


    @Override
    public boolean execute(String argument) {
        if (!argument.isEmpty()){
            Console.printerror("у команды info нет аргумента" );
            return false;
        }
        Console.println(collectionManager.info());
        return true;
    }
}
