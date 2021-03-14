package com.command;



import com.exception.IncorrectInputInScriptException;
import com.model.*;
import com.util.CollectionManager;
import com.util.Console;
import com.util.Interactor;

/**
 * 'count_by_transport' command. Count elevents by transport.
 */
public class CountByTransportCommand extends Command{
    private final CollectionManager collectionManager;
    public  Interactor interactor;
    public CountByTransportCommand(CollectionManager collectionManager, Interactor interactor) {
        super("count_by_transport transport",
                " посчитать кол-во транспорта");
        this.collectionManager = collectionManager;
        this.interactor = interactor;
    }


    @Override
    public boolean execute(String argument) {
        try{
        if (!argument.isEmpty()){
            Console.printerror("ввод аргумента следующей строкой");
            return false;
        }
        if (collectionManager.collectionSize() == 0){
            Console.printerror("Коллекция пуста!");
            return false;
        }
        Transport tranposrt = interactor.askTransport();
        int l = collectionManager.countByTransport(tranposrt);
        Console.println(l);}
        catch (IncorrectInputInScriptException exception) {
            Console.printerror("Не удалось выполнить скрипт.");
            return false;
        }
        return true;
    }
}