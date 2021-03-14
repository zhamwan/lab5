package com.command;


import com.exception.IncorrectInputInScriptException;
import com.model.*;
import com.util.CollectionManager;
import com.util.Console;
import com.util.Interactor;

/**
 * 'remove_all_by_furnish' command. Removes all elements by furnish.
 */
public class RemoveAllByFurnishCommand extends Command {
    private CollectionManager collectionManager;
    private Interactor interactor;

    public RemoveAllByFurnishCommand(CollectionManager collectionManager, Interactor interactor) {
        super("remove_all_by_furnish furnish", " удалить из коллекции все элементы, значение поля furnish которого эквивалентно заданному");
        this.collectionManager = collectionManager;
        this.interactor = interactor;
    }

    /**
     * Executes the command.
     * @return Command execute status.
     */
    @Override
    public boolean execute(String argument) {
        try{
        if (!argument.isEmpty()){
            Console.printerror("введите аргумент в другой строке");
            return false;
        }
        if (collectionManager.collectionSize() == 0){
            Console.printerror("Коллекция пуста!");
            return false;
        }
        int collectionSize = collectionManager.collectionSize();
        collectionManager.removeAllByFurnish(interactor.askFurnish());
        Console.println("Удалено квартир: " + (collectionManager.collectionSize() - collectionSize));
        return true;}
                catch (IncorrectInputInScriptException exception) {
            Console.printerror("Не удалось выполнить скрипт.");
            return false;
        }
    }
}
