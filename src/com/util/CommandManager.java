package com.util;

import java.util.ArrayList;
import java.util.List;

import com.command.*;

/**
 * Operates the com.commands.
 */
public class CommandManager {
    public List<Command> historyList = new ArrayList<>();
    private final List<Command> commands = new ArrayList<>();
    private final Command helpCommand;
    private final Command infoCommand;
    private final Command showCommand;
    private final Command insertCommand;
    private final Command updateCommand;
    private final Command removeKeyCommand;
    private final Command clearCommand;
    private final Command saveCommand;
    private final Command exitCommand;
    private final Command executeScriptCommand;
    private final Command removeGreaterCommand;
    private final Command replaceIfloweCommand;
    private final Command removeAllByFurnishCommand;
    private final Command removeAnyByFurnishCommand;
    private final Command countByTransprotCommand;
    private final Command historyCommand;

    public CommandManager(Command helpCommand, Command infoCommand, Command showCommand, Command insertCommand, Command updateCommand, Command removeKeyCommand, Command clearCommand, Command saveCommand, Command exitCommand, Command executeScriptCommand,  Command removeGreaterCommand,  Command replaceIfloweCommand, Command removeAllByFurnishCommand, Command removeAnyByFurnishCommand, Command countByTransprotCommand, Command historyCommand ) {
        this.helpCommand = helpCommand;
        this.infoCommand = infoCommand;
        this.showCommand = showCommand;
        this.insertCommand = insertCommand;
        this.updateCommand = updateCommand;
        this.removeKeyCommand = removeKeyCommand;
        this.clearCommand = clearCommand;
        this.saveCommand = saveCommand;
        this.exitCommand = exitCommand;
        this.executeScriptCommand = executeScriptCommand;
        this.removeGreaterCommand = removeGreaterCommand;
        this.historyCommand = historyCommand;
        this.countByTransprotCommand = countByTransprotCommand;
        this.removeAnyByFurnishCommand = removeAnyByFurnishCommand;
        this.removeAllByFurnishCommand = removeAllByFurnishCommand;
        this.replaceIfloweCommand = replaceIfloweCommand;

        commands.add(helpCommand);
        commands.add(infoCommand);
        commands.add(showCommand);
        commands.add(insertCommand);
        commands.add(updateCommand);
        commands.add(removeKeyCommand);
        commands.add(clearCommand);
        commands.add(saveCommand);
        commands.add(exitCommand);
        commands.add(executeScriptCommand);
        commands.add(historyCommand);
        commands.add(removeGreaterCommand);
        commands.add(countByTransprotCommand);
        commands.add(removeAnyByFurnishCommand);
        commands.add(removeAllByFurnishCommand);
        commands.add(replaceIfloweCommand);
    }

    /**
     * @return List of manager's com.commands.
     */
    public List<Command> getCommands() {
        return commands;
    }

    /**
     * Prints that command is not found.
     * @param command Comand, which is not found.
     * @return Command exit status.
     */
    public boolean noSuchCommand(String command) {
        Console.println("Команда '" + command + "' не найдена. Наберите 'help' для справки.");
        return false;
    }

    /**
     * Prints info about the all com.commands.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean help(String argument) {
        historyList.add(helpCommand);
        if (helpCommand.execute(argument)) {
            for (Command command : commands) {
                Console.println(command.getName() + command.getDescription());
            }
            return true;
        } else return false;
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean info(String argument) {
        historyList.add(infoCommand);
        return infoCommand.execute(argument);
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean show(String argument) {
        historyList.add(showCommand);
        return showCommand.execute(argument);
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean insert(String argument) {
        historyList.add(insertCommand);
        return insertCommand.execute(argument);
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean update(String argument) {
        historyList.add(updateCommand);
        return updateCommand.execute(argument);
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean removeKey(String argument) {
        historyList.add(removeKeyCommand);
        return removeKeyCommand.execute(argument);
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean clear(String argument) {
        historyList.add(clearCommand);
        return clearCommand.execute(argument);
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean save(String argument) {
        historyList.add(saveCommand);
        return saveCommand.execute(argument);
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean exit(String argument) {
        return exitCommand.execute(argument);
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean executeScript(String argument) {
        historyList.add(executeScriptCommand);
        return executeScriptCommand.execute(argument);
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean history(String argument) {
        if (historyList.size()==0) {
            Console.println("Ни одной команды еще не было использовано!");
            return true;
        }else{
            Console.println("Последние использованные команды:");
            int n;
            if (historyList.size()<12){
                n=0;
            }else{
                n=historyList.size()-12;
            }
            for (int i=n; i < historyList.size(); i++) {
                if (historyList.get(i) != null) Console.println(" " + historyList.get(i));
            }
            return true;
            }
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean removeGreater(String argument) {
        historyList.add(removeGreaterCommand);
        return removeGreaterCommand.execute(argument);
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean countByTransprot(String argument) {
        historyList.add(countByTransprotCommand);
        return countByTransprotCommand.execute(argument);
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean removeAnyByFurnish(String argument) {
        historyList.add(removeAnyByFurnishCommand);
        return removeAnyByFurnishCommand.execute(argument);
    }


    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean removeAllByFurnish(String argument) {
        historyList.add(removeAllByFurnishCommand);
        return removeAllByFurnishCommand.execute(argument);
    }

    /**
     * Executes needed command.
     * @param argument Its argument.
     * @return Command exit status.
     */
    public boolean replaceIflowe(String argument) {
        historyList.add(replaceIfloweCommand);
        return replaceIfloweCommand.execute(argument);
    }
}
