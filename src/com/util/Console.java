package com.util;

import com.exception.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import com.util.Interactor;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.ArrayList;

/**
 * Operates command input.
 */
public class Console{
        private final List<String> scriptStack = new ArrayList<>();
        Scanner scanner;
        CommandManager commandManager;
        Interactor interactor;
        public Console(CommandManager commandManager, Scanner userScanner, Interactor interactor) {
        this.commandManager = commandManager;
        this.scanner = userScanner;
        this.interactor = interactor;
    }
        public void interactivmode(){
            String[] command = {"", ""};
            int commandStatus = 1;
            while (commandStatus != 2){
                    command = (scanner.nextLine().trim() + " ").split(" ", 2);
                    command[1] = command[1].trim();
                    commandStatus = launchCommand(command);
            }
        }
    public int scriptMode(String argument) {
        String[] userCommand = {"", ""};
        int commandStatus;
        scriptStack.add(argument);
        try {
            File file = new File(argument);
            if (file.exists() && !file.canRead()) throw new NoAccessToFileException();
            Scanner scriptScanner = new Scanner(file);
            if (!scriptScanner.hasNext()) throw new NoSuchElementException();
            Scanner tmpScanner = interactor.getUserScanner();
            interactor.setUserScanner(scriptScanner);
            interactor.setFileMode();
            do {
                userCommand = (scriptScanner.nextLine().trim() + " ").split(" ", 2);
                userCommand[1] = userCommand[1].trim();
                while (scriptScanner.hasNextLine() && userCommand[0].isEmpty()) {
                    userCommand = (scriptScanner.nextLine().trim() + " ").split(" ", 2);
                    userCommand[1] = userCommand[1].trim();
                }
                Console.println(String.join(" ", userCommand));
                if (userCommand[0].equals("execute_script")) {
                    for (String script : scriptStack) {
                        if (userCommand[1].equals(script)) throw new ScriptRecursionException();
                    }
                }
                commandStatus = launchCommand(userCommand);
            } while (commandStatus == 0 && scriptScanner.hasNextLine());
            interactor.setUserScanner(tmpScanner);
            interactor.setUserMode();
            if (commandStatus == 1 && !(userCommand[0].equals("execute_script") && !userCommand[1].isEmpty()))
                Console.println("Проверьте скрипт на корректность введенных данных!");
            return commandStatus;
        } catch (FileNotFoundException exception) {
            Console.printerror("Файл со скриптом не найден!");
        } catch (NoSuchElementException exception) {
            Console.printerror("Файл со скриптом пуст!");
        } catch (ScriptRecursionException exception) {
            Console.printerror("Скрипты не могут вызываться рекурсивно!");
        } catch (IllegalStateException exception) {
            Console.printerror("Непредвиденная ошибка!");
            System.exit(0);
        } catch (NoAccessToFileException e) {
            Console.printerror("Нет доступа к файлу");
        } finally {
            scriptStack.remove(scriptStack.size()-1);
        }
        return 1;
    }


    public int launchCommand(String[] commands){
                String command = commands[0];
                String argument = commands[1];
        switch (command) {
            case "":
                break;
            case "help":
                if (!commandManager.help(argument)) return 1;
                break;
            case "info":
                if (!commandManager.info(argument)) return 1;
                break;
            case "show":
                if (!commandManager.show(argument)) return 1;
                break;
            case "insert":
                if (!commandManager.insert(argument)) return 1;
                break;
            case "update":
                if (!commandManager.update(argument)) return 1;
                break;
            case "remove_key":
                if (!commandManager.removeKey(argument)) return 1;
                break;
            case "clear":
                if (!commandManager.clear(argument)) return 1;
                break;
            case "save":
                if (!commandManager.save(argument)) return 1;
                break;
            case "execute_script":
                if (!commandManager.executeScript(argument)) return 1;
                else return scriptMode(argument);
            case "history":
                if (!commandManager.history(argument)) return 1;
                break;
            case "remove_greater":
                if (!commandManager.removeGreater(argument)) return 1;
                break;
            case "remove_all_by_furnish":
                if (!commandManager.removeAllByFurnish(argument)) return 1;
                break;
            case "remove_any_by_furnish":
                if (!commandManager.removeAnyByFurnish(argument)) return 1;
                break;
            case "replace_if_lowe":
                if (!commandManager.replaceIflowe(argument)) return 1;
                break;
            case "count_by_transport":
                if (!commandManager.countByTransprot(argument)) return 1;
            case "exit":
                if (!commandManager.exit(argument)) return 1;
                else return 2;
            default:
                if (!commandManager.noSuchCommand(command)) return 1;
        }
        return 0;
    }
    public static void println(Object toOut) {
        System.out.println(toOut);
    }


    public static void printerror(Object toOut) {
        System.out.println("error: " + toOut);
    }
}