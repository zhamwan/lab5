package com.model;

/**
 * Furnish enum class. Contains 4 values.
 */


/**
 * Coordinates data class
 */

public  enum Furnish {
    NONE,
    FINE,
    BAD,
    LITTLE;


    public static String nameList() {
        StringBuilder nameList = new StringBuilder();
        for (Furnish furnish: values()) {
        nameList.append(furnish.name()).append(", ");
        }
        return nameList.substring(0, nameList.length() - 2);
    }
}