package com.util;

import java.util.Scanner;
import java.util.regex.Pattern;
import com.exception.IncorrectInputInScriptException;
import com.model.*;

/**
 * Asks a user a flat's value.
 */
public class Interactor {
    private final int MAX_X = 750;
    private final int MIN_year = 0;
    private final int MIN_numberOfFloors = 0;
    private final int MAX_numberOfRooms = 17;
    private final int MIN_numberOfRooms = 0;
    private final int MIN_floor = 0;
    private final int MIN_area = 0;
    private Pattern patternNumber = Pattern.compile("-?\\d+(\\.\\d+)?");

    private boolean fileMode;
    private Scanner userScanner;

    public Interactor(Scanner userScanner) {
        this.userScanner = userScanner;
        fileMode = false;
    }

    public void setFileMode() {
        fileMode = true;
    }
    public void setUserMode() {
        fileMode = false;
    }

    public boolean isFileMode() {
        return fileMode;
    }

    /**
     * Sets a scanner to scan user input.
     *
     * @param userScanner Scanner to set.
     */
    public void setUserScanner(Scanner userScanner) {
        this.userScanner = userScanner;
    }

    /**
     * @return Scanner, which uses for user input.
     */
    public Scanner getUserScanner() {
        return userScanner;
    }


    public String askName() throws IncorrectInputInScriptException{
        String name;
        Console.println("Введите имя");
        while (true) {
            if(userScanner.hasNext()){
                name = userScanner.next().trim();
                if (!name.isEmpty()){
                    if(fileMode){
                        Console.println("name:" + name);
                    }
                    return name;
                }
                Console.printerror("Имя не может быть пустым!");
                if (fileMode) throw new IncorrectInputInScriptException();
                Console.println("Введите имя");}}
    }

    public int askX () throws IncorrectInputInScriptException{
        int x;
        Console.println("Введите координату X < " + MAX_X + ":");
        while (true) {
            if (userScanner.hasNext()) {
                if (userScanner.hasNextInt()) {
                    x = userScanner.nextInt();
                    if (x < MAX_X) {
                        if(fileMode){
                            Console.println("x:" + x);
                        }
                        return x;
                    } else {
                        Console.printerror("x не вошел в диапозон ");
                        if (fileMode) throw new IncorrectInputInScriptException();
                    }
                } else {
                    userScanner.next();
                    Console.printerror("вы ввели не число ");
                    if (fileMode) throw new IncorrectInputInScriptException();
                    Console.println("Введите координату X < " + MAX_X + ":");
                }
            }
            /*else {
                userScanner.nextLine();
                Console.printerror("вы ввели не число ");
            }*/
        }
    }


    public float askY() throws IncorrectInputInScriptException {
        float y;
        Console.println("Введите координату y:");
        while (true) {
            if (userScanner.hasNext()) {
                if (userScanner.hasNextFloat()) {
                    y = userScanner.nextFloat();
                    if(fileMode){
                        Console.println("y:" + y);
                    }
                    return y;
                } else {
                    userScanner.next();
                    Console.printerror("вы ввели не число");
                    if (fileMode) throw new IncorrectInputInScriptException();
                    Console.println("Введите координату y:");
                }
            }
        }
    }




    public int askArea() throws IncorrectInputInScriptException{
        int area;
        Console.println("Введите area > " + MIN_area + ":");
        while (true) {
                if (userScanner.hasNext()) {
                if(userScanner.hasNextInt()){
                area = userScanner.nextInt();
                if (area > MIN_area) {
                    if(fileMode){
                        Console.println("area:" + area);
                    }
                    return area;
                } else {
                    Console.printerror("area не вошел в диапозон");
                    if (fileMode) throw new IncorrectInputInScriptException();
                }
            }else {
                userScanner.next();
                Console.printerror("вы ввели не число");
                if (fileMode) throw new IncorrectInputInScriptException();
                Console.println("Введите area > " + MIN_area + ":");
            }}
        }
    }
    public int askKey() throws IncorrectInputInScriptException {
        int key;
        Console.println("Введите key :");
        while (true) {
            if (userScanner.hasNext()) {
                if(userScanner.hasNextInt()){
                key = userScanner.nextInt();
                    if(fileMode){
                        Console.println("key:" + key);
                    }
                return key;
                }}
            else {
                userScanner.next();
                Console.printerror("вы ввели не число");
                if (fileMode) throw new IncorrectInputInScriptException();
                Console.println("Введите key :");
            }
        }
    }

    public int askNumberOfRooms()throws IncorrectInputInScriptException {
        int numbarOfRooms;
        Console.println("Введите  " + MAX_numberOfRooms + " > Number Of Rooms > " + MIN_numberOfRooms + ":");
        while (true) {
            if (userScanner.hasNext()) {
                if(userScanner.hasNextInt()){
                    numbarOfRooms = userScanner.nextInt();
                    if ((numbarOfRooms > MIN_numberOfRooms) & (numbarOfRooms < MAX_numberOfRooms)) {
                        if(fileMode){
                            Console.println("numbarOfRooms:" + numbarOfRooms);
                        }
                        return numbarOfRooms;
                    } else {
                        Console.printerror("numbarOfRooms не вошел в диапозон");
                        if (fileMode) throw new IncorrectInputInScriptException();
                    }
                } else {
                    userScanner.next();
                Console.printerror("вы ввели не число");
                    if (fileMode) throw new IncorrectInputInScriptException();
                Console.println("Введите  " + MAX_numberOfRooms + " > Number Of Rooms > " + MIN_numberOfRooms + ":");
            }}
        }
    }

    public int askFloor() throws IncorrectInputInScriptException {
        int floor;
        Console.println("Введите floor > "  + MIN_floor + ":");
        while (true) {
            if (userScanner.hasNext()) {
                if(userScanner.hasNextInt()){
                floor = userScanner.nextInt();
                if (floor > MIN_floor) {
                    if(fileMode){
                        Console.println("floor:" + floor);
                    }
                    return floor;
                } else {
                    Console.printerror("floor не вошел в диапозон");
                    if (fileMode) throw new IncorrectInputInScriptException();
                }
             }else {
                userScanner.next();
                Console.printerror("вы ввели не число");
                    if (fileMode) throw new IncorrectInputInScriptException();
                Console.println("Введите floor > "  + MIN_floor + ":");
            }
        }}
    }

    public int askYear()throws IncorrectInputInScriptException {
        int year;
        Console.println("Введите year > " + MIN_year + ":");
        while (true) {
                if (userScanner.hasNext()) {
                if(userScanner.hasNextInt()){
                year = userScanner.nextInt();
                if (year > MIN_year) {
                    if(fileMode){
                        Console.println("year:" + year);
                    }
                    return year;
                } else {
                    Console.printerror("year не вошел в диапозон");
                    if (fileMode) throw new IncorrectInputInScriptException();
                }
            } else {
                userScanner.next();
                Console.printerror("вы ввели не число");
                    if (fileMode) throw new IncorrectInputInScriptException();
                Console.println("Введите year > " + MIN_year + ":");
            }
        }}
    }

    public int askNumberOfFloors() throws IncorrectInputInScriptException{
        int numberOfFloors;
        Console.println("Введите numberOfFloors > " + MIN_numberOfFloors + ":");
        while (true) {
                if (userScanner.hasNext()) {
                if(userScanner.hasNextInt()){
                numberOfFloors = userScanner.nextInt();
                if (numberOfFloors > MIN_numberOfFloors) {
                    if(fileMode){
                        Console.println("numberOfFloors:" + numberOfFloors);
                    }
                    return numberOfFloors;
                } else {
                    Console.printerror("numberOfFloors не вошел в диапозон");
                    if (fileMode) throw new IncorrectInputInScriptException();
                }
            } else {
                userScanner.next();
                Console.printerror("вы ввели не число");
                    if (fileMode) throw new IncorrectInputInScriptException();
                Console.println("Введите numberOfFloors > " + MIN_numberOfFloors + ":");
            }}
        }
    }
    public Furnish askFurnish() throws IncorrectInputInScriptException {
        String strFurnish;
        Furnish furnish;
        Console.println("Выберете состояние мебели - " + Furnish.nameList());
        Console.println("Введите состояние мебели:");
        while (true) {
            if (userScanner.hasNext()) {
                strFurnish = userScanner.next().trim();
                strFurnish = strFurnish.toUpperCase().trim();
                if ((strFurnish.equals("NONE")) | (strFurnish.equals("FINE")) | (strFurnish.equals("BAD")) | (strFurnish.equals("LITTLE"))) {
                    furnish = Furnish.valueOf(strFurnish);
                    if(fileMode){
                        Console.println("furnish:" + furnish);
                    }
                    return furnish;
                } else {
                    Console.println("неверный формат");
                    if (fileMode) throw new IncorrectInputInScriptException();
                    Console.println("Выберете состояние мебели - " + Furnish.nameList());
                    Console.println("Введите состояние мебели:");
                }
            }
            /*else {
            userScanner.next();
            } */
        }
    }
    public Transport askTransport() throws IncorrectInputInScriptException{
        String strTransport;
        Transport transport;
        Console.println("Выберете состояние мебели - " + Transport.nameList());
        Console.println("Введите состояние мебели:");
        while (true) {
            if (userScanner.hasNext()) {
                strTransport = userScanner.next().trim();
                strTransport = strTransport.toUpperCase().trim();
                if ((strTransport.equals("NONE")) | (strTransport.equals("FEW")) | (strTransport.equals("NORMAL")) | (strTransport.equals("LITTLE")) | (strTransport.equals("ENOUGH"))){
                    transport = Transport.valueOf(strTransport);
                    if(fileMode){
                        Console.println("transport:" + transport);
                    }
                    return transport;
                } else {
                    Console.println("неверный формат");
                    if (fileMode) throw new IncorrectInputInScriptException();
                    Console.println("Выберете состояние мебели - " + Transport.nameList());
                    Console.println("Введите состояние мебели:");
                }
            }
            /*else {
            userScanner.next();
            } */
        }
    }
    public  void repair(){
        userScanner.nextLine();
    }
}
