package hm8;

import static hm8.ArrayValueCalculator.doCalc;

public class Main {
    public static void main(String[] args) {
        String[][] validArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] invalidDataArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "x", "y"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] invalidSizeArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"}
        };

        try {
            int result = doCalc(validArray);
            System.out.println("Sum = " + result);
        } catch (ArraySizeException | ArrayDataException e) {
            System.err.println(e.getMessage());
        }

        try {
            int result = doCalc(invalidDataArray);
            System.out.println("Sum = " + result);
        } catch (ArraySizeException e) {
            System.err.println("ArraySizeException: " + e.getMessage());
        } catch (ArrayDataException e) {
            System.err.println("ArrayDataException: " + e.getMessage());
            System.err.println("Row: " + e.getRow() + ", Col: " + e.getCol());
        }

        try {
            int result = doCalc(invalidSizeArray);
            System.out.println("Sum =  " + result);
        } catch (ArraySizeException e) {
            System.err.println("ArraySizeException: " + e.getMessage());
        } catch (ArrayDataException e) {
            System.err.println("ArrayDataException: " + e.getMessage());
        }
    }
}