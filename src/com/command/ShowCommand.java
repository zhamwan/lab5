package com.command;


import com.util.CollectionManager;
import com.util.Console;

/**
 * 'show' command. Shows information about all elements of the collection.
 */
public class ShowCommand extends Command {
    private CollectionManager collectionManager;

    public ShowCommand(CollectionManager collectionManager) {
        super("show", " вывести все элементы коллекции");
        this.collectionManager = collectionManager;
    }


    @Override
    public boolean execute(String argument) {
        if (!argument.isEmpty()){
            Console.printerror("у команды show нет аргумента");
            return false;
        }
        Console.println("объекты в коллекции");
        collectionManager.show();
        return true;
    }
}
