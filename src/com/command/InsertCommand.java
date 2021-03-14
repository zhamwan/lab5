package com.command;



import com.model.*;
import com.util.CollectionManager;
import com.util.Console;
import com.util.Interactor;
import com.exception.IncorrectInputInScriptException;

/**
 * 'insert' command. Adds a new element to the collection.
 */
public class InsertCommand extends Command {
    private final CollectionManager collectionManager;
    private final Interactor interactor;

    public InsertCommand(CollectionManager collectionManager, Interactor interactor) {
        super("insert null {element}", " добавить новый элемент в коллекцию");
        this.collectionManager = collectionManager;
        this.interactor = interactor;
    }


    @Override
    public boolean execute(String argument) {
        try {
            if (argument.isEmpty()){
                Console.println("введите аргумент");
                return false;
            }
            if(!argument.matches("-?\\d+(\\.\\d+)?")){
                Console.println("key не число");
                return false;
            }
            int key = Integer.parseInt(argument);
            if(!collectionManager.checkKey(key)){
                collectionManager.insertNull(
                        new Flat(
                                collectionManager.generateNextId(),
                                interactor.askName(), new Coordinates(
                                interactor.askX(),
                                interactor.askY()),
                                interactor.askArea(),
                                interactor.askNumberOfRooms(),
                                interactor.askFloor(),
                                interactor.askFurnish(),
                                interactor.askTransport(),
                                new House(interactor.askName(), interactor.askYear(), interactor.askNumberOfFloors() )
                        ), key
                );
                Console.println("Группа успешно добавлена!");
                interactor.repair();
                return true;}
            else{
                Console.println("такой ключ использован");
                return false;
            }
        }
        catch (IncorrectInputInScriptException exception) {
            Console.printerror("Не удалось выполнить скрипт.");
            return false;
        }
}
}
