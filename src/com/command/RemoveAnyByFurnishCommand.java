package com.command;



import com.exception.IncorrectInputInScriptException;
import com.model.*;
import com.util.CollectionManager;
import com.util.Console;
import com.util.Interactor;

/**
 * 'remove_any_by_furnish' command. Removes 1 elements by furnish.
 */
public class RemoveAnyByFurnishCommand extends Command{
    public  CollectionManager collectionManager;
    public  Interactor interactor;
    public RemoveAnyByFurnishCommand(CollectionManager collectionManager, Interactor interactor) {
        super("remove_any_by_furnish furnish",
                " удалить из коллекции один элемент, значение поля furnish которого эквивалентно заданному");
        this.collectionManager = collectionManager;
        this.interactor = interactor;
    }


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
        if(collectionManager.removeAnyByFurnish(interactor.askFurnish())){
            Console.println("flat удаленн");
        }else{
            Console.println("flat неудаленн");
        }
        return true;
    }
    catch (
    IncorrectInputInScriptException exception) {
        Console.printerror("Не удалось выполнить скрипт.");
        return false;
    }}
}