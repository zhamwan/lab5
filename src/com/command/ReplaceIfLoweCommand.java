package com.command;



import com.exception.IncorrectInputInScriptException;
import com.model.*;
import com.util.CollectionManager;
import com.util.*;


/**
 * 'replace_if_lowe' command. Removes elements greater than user entered.
 */
public class ReplaceIfLoweCommand extends Command {
    private CollectionManager collectionManager;
    private Interactor interactor;

    public ReplaceIfLoweCommand(CollectionManager collectionManager, Interactor interactor) {
        super("replace_if_lowe {element}", " заменить значение по ключу, если новое значение меньше старого");
        this.collectionManager = collectionManager;
        this.interactor = interactor;
    }


    @Override
    public boolean execute(String argument) {
        try{
            if (!argument.isEmpty()){
                Console.printerror("нет аргумента");
            }
            if (collectionManager.collectionSize() == 0){
                Console.printerror("коллекция пуста");
                return false;
            };
            int key = interactor.askKey();
            if (collectionManager.checkKey(key)){
                Flat flat = new Flat(
                        -1,
                        interactor.askName(), new Coordinates(
                        interactor.askX(),
                        interactor.askY()),
                        interactor.askArea(),
                        interactor.askNumberOfRooms(),
                        interactor.askFloor(),
                        interactor.askFurnish(),
                        interactor.askTransport(),
                        new House(interactor.askName(), interactor.askYear(), interactor.askNumberOfFloors() )
                );
                if(collectionManager.replaceIfLowe(key, flat)){
                    Console.println("Произошла замена");
                }else{
                    Console.println("Не произошла замена");
                }
                return true;
            }else{
                Console.printerror("нет key в коллекции");
                return false;
            }}
                    catch (IncorrectInputInScriptException exception) {
                Console.printerror("Не удалось выполнить скрипт.");
                return false;
            }
    }
}
