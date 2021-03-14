package com.command;


import com.exception.IncorrectInputInScriptException;
import com.model.*;
import com.util.CollectionManager;
import com.util.Console;
import com.util.Interactor;

/**
 * 'update' command. Updates the information about selected studyGroup.
 */
public class UpdateCommand extends Command {
    private final CollectionManager collectionManager;
    private final Interactor interactor;

    public UpdateCommand(CollectionManager collectionManager, Interactor interactor) {
        super("update id {element}", " обновить значение элемента коллекции по ключу");
        this.collectionManager = collectionManager;
        this.interactor = interactor;
    }

    @Override
    public boolean execute(String argument) {
        try{
        if (argument.isEmpty()) {
            Console.printerror("ID должен быть представлен числом!");
            return false;
        }
        if (!argument.matches("-?\\d+(\\.\\d+)?")) {
            Console.printerror("ID должен быть представлен числом!");
        }
        int id = Integer.parseInt(argument);
        if (collectionManager.collectionSize() == 0) {
            Console.printerror("Коллекция пуста!");
            return false;
        }
        if (collectionManager.checkId(id)) {
            collectionManager.update(
                    new Flat(
                            id,
                            interactor.askName(), new Coordinates(
                            interactor.askX(),
                            interactor.askY()),
                            interactor.askArea(),
                            interactor.askNumberOfRooms(),
                            interactor.askFloor(),
                            interactor.askFurnish(),
                            interactor.askTransport(),
                            new House(interactor.askName(), interactor.askYear(), interactor.askNumberOfFloors())));
            Console.println("значение обновлено");
        } else {
            Console.printerror("такого id нет");
            return false;
        }
        return true;
    }
            catch (
    IncorrectInputInScriptException exception) {
        Console.printerror("Не удалось выполнить скрипт.");
        return false;
    }
    }
}
