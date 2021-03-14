package com;

import java.util.Scanner;

import com.command.*;
import com.util.*;


/**
 * Main application class. Creates all instances and runs the program.
 */
public class Main {


    public static void main(String[] args) {
        try (Scanner userScanner = new Scanner(System.in)) {
            final String envVariable = "lab5.2";
            Interactor interactor = new Interactor(userScanner);
            FileManager fileManager = new FileManager(envVariable);
            CollectionManager collectionManager = new CollectionManager(fileManager);
            fileManager.setCollectionManager(collectionManager);
            fileManager.setCollection();
            collectionManager.setFileManager(fileManager);
            CommandManager commandManager = new CommandManager(
                    new HelpCommand(),
                    new InfoCommand(collectionManager),
                    new ShowCommand(collectionManager),
                    new InsertCommand(collectionManager, interactor),
                    new UpdateCommand(collectionManager, interactor),
                    new RemoveKeyCommand(collectionManager, interactor),
                    new ClearCommand(collectionManager),
                    new SaveCommand(collectionManager),
                    new ExitCommand(),
                    new ExecuteScriptCommand(),
                    new RemoveGreaterCommand(collectionManager, interactor),
                    new ReplaceIfLoweCommand(collectionManager, interactor),
                    new RemoveAllByFurnishCommand(collectionManager, interactor),
                    new RemoveAnyByFurnishCommand(collectionManager, interactor),
                    new CountByTransportCommand(collectionManager, interactor),
                    new HistoryCommand()
            );
            Console console = new Console(commandManager, userScanner, interactor);
            console.interactivmode();
        }
    }
}
