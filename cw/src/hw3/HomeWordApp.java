package hw3;

import java.util.Calendar;
import java.util.Date;

public class HomeWordApp {
    public static void main(String[] args) {
        // String[] arr = {"Orange", "Banana", "Apple"};
        printThreeWords();
        System.out.println("-------------");
        checkSumSign();
        System.out.println("-------------");
        printColor();
        System.out.println("-------------");
        compareNumbers();
        System.out.println("-------------");
        int a = 8;
        int b = 5;
        int c = 78;
        System.out.println(checkNumbers(a, b));
        System.out.println("-------------");
        positiveNumber(a);
        System.out.println("-------------");
        System.out.println(negativeNumber(c));
        System.out.println("-------------");
        printCount("Meow", a);
        System.out.println("-------------");

        Calendar calendar = Calendar.getInstance();
        calendar.set(2026, Calendar.OCTOBER, 19);
        Date date = calendar.getTime();
        leapYear(date);
        System.out.println("-------------");
        calendar.set(2024, Calendar.MARCH, 23);
        Date date1 = calendar.getTime();
        leapYear(date1);

    }

    private static void printThreeWords() {
        String[] arr = {"Orange", "Banana", "Apple"};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + ":" + arr[i]);
        }
    }

    private static void checkSumSign() {
        int a = 15;
        int b = 20;
        int sum = a + b;
        System.out.println(sum > 0 ? "Сума позитивна" : "Сума негативна");
    }

    private static void printColor() {
        int value = 234;
        if (value <= 0) {
            System.out.println("Червоний");
        } else if (value > 0 && value <= 100) {
            System.out.println("Жовтий");
        } else {
            System.out.println("Зелений");
        }
    }

    private static void compareNumbers() {
        int a = 13;
        int b = 19;
        System.out.println(a >= b ? "a>= b" : "a < b");
    }

    private static boolean checkNumbers(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    private static void positiveNumber(int num) {
        System.out.println(num >= 0 ? "Передано додатнє число" : "Передано відʼємне число");
    }

    private static boolean negativeNumber(int num) {
        return num < 0;
    }

    private static void printCount(String str, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(str);
        }
    }

    private static boolean leapYear(Date date) {
        int year = date.getYear();
        if (year % 4 == 0 && year % 100 != 0) {
            System.out.println("високосний");
            return true;
        } else {
            System.out.println("не високосний");
            return false;
        }
    }
}
