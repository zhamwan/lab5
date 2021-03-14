package com.command;


import com.exception.IncorrectInputInScriptException;
import com.model.*;
import com.util.CollectionManager;
import com.util.Console;
import com.util.Interactor;

/**
 * 'remove_key' command. Removes elements by key.
 */
public class RemoveKeyCommand extends Command {
    private CollectionManager collectionManager;
    private Interactor interactor;

    public RemoveKeyCommand(CollectionManager collectionManager, Interactor interactor) {
        super("remove_key null", " удалить элемент из коллекции по его ключу");
        this.collectionManager = collectionManager;
        this.interactor = interactor;
    }


    @Override
    public boolean execute(String argument) {
        if (argument.isEmpty()) {
            Console.printerror("нет аргумента");
            return false;
        }
        if (collectionManager.collectionSize() == 0) {
            Console.printerror("Коллекция пуста!");
            return false;
        }
        if (!argument.matches("-?\\d+(\\.\\d+)?")) {
            Console.printerror("key не число");
            return false;
        }
        int key = Integer.parseInt(argument);
        if (!collectionManager.checkKey(key)) {
            Console.printerror("такого key нет");
        }
        collectionManager.removeKey(key);
        Console.println("удалено");
        return true;
    }
}
