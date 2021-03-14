package com.command;


import com.exception.IncorrectInputInScriptException;
import com.model.*;
import com.util.CollectionManager;
import com.util.Console;
import com.util.Interactor;

/**
 * 'remove_greater' command. Removes elements greater than user entered.
 */
public class RemoveGreaterCommand extends Command {
    private CollectionManager collectionManager;
    private Interactor interactor;

    public RemoveGreaterCommand(CollectionManager collectionManager, Interactor interactor) {
        super("remove_greater {element}", "удалить из коллекции все элементы, превышающие заданный");
        this.collectionManager = collectionManager;
        this.interactor = interactor;
    }


    @Override
    public boolean execute(String argument) {
        try{
        if (!argument.isEmpty()) {
            Console.printerror("введите аргумент в другой строке");
            return false;
        }
        if (collectionManager.collectionSize() == 0) {
            Console.printerror("Коллекция пуста!");
            return false;
        }
        Flat flatfing = new Flat(
                -1,
                interactor.askName(), new Coordinates(
                interactor.askX(),
                interactor.askY()),
                interactor.askArea(),
                interactor.askNumberOfRooms(),
                interactor.askFloor(),
                interactor.askFurnish(),
                interactor.askTransport(),
                new House(interactor.askName(), interactor.askYear(), interactor.askNumberOfFloors())
        );
        if (collectionManager.checkFlat(flatfing)) {
            Console.printerror("Группы с такими параметрами в коллекции нет!");
            return false;
        }
        int collectionSize = collectionManager.collectionSize();
        collectionManager.removeGreater(flatfing);
        Console.println("Удалено квартир: " + (collectionManager.collectionSize() - collectionSize));
        return true;
    }
            catch (
    IncorrectInputInScriptException exception) {
        Console.printerror("Не удалось выполнить скрипт.");
        return false;
    }
    }
}
