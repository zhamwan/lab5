package com.command;

import com.util.CollectionManager;
import com.util.Console;

/**
 * 'save' command. Saves the collection to the file.
 */
public class SaveCommand extends Command {
    private final CollectionManager collectionManager;

    public SaveCommand(CollectionManager collectionManager) {
        super("save", " сохранить коллекцию в файл");
        this.collectionManager = collectionManager;
    }


    @Override
    public boolean execute(String argument) {
        if (!argument.isEmpty()){
            Console.printerror("у команды save не должно быть аргумента");
            return false;
        }
        collectionManager.saveCollection();
        Console.println("коллекция сохранена");
        return true;
    }
}