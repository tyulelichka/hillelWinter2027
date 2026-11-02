package hm7;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String text = "Hello, my name's Vika";
        char symbol = 'e';
        System.out.println(findSymbolOccurance(text, symbol));
        char symbol1 = 'е'; // українська мова
        System.out.println(findSymbolOccurance(text, symbol1));
        System.out.println("-------");

        String source = "Hello wordl";
        String target = "ell";
        System.out.println(findWordPosition(source, target));
        String source1 = "Egg";
        String target1 = "Ell";
        System.out.println(findWordPosition(source1, target1));
        System.out.println("-------");

        String original = "Java";
        String reversed = stringReverse(original);
        System.out.println(reversed);
        System.out.println("-------");
        System.out.println(isPalindrome("Oko")); // Виведе: true
        System.out.println(isPalindrome("Hello"));
        System.out.println("-------");
        
        game();
    }

    protected static int findSymbolOccurance(String str, char symbol) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == symbol) {
                count++;
            }
        }
        return count;
    }

    protected static int findWordPosition(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }
        return source.indexOf(target);
    }

    protected static String stringReverse(String str) {
        if (str == null) {
            return null;
        }
        return new StringBuilder(str).reverse().toString();
    }

    protected static boolean isPalindrome(String str) {
        if (str == null) {
            return false;
        }
        String cleanText = str.replaceAll("\\s+", "").toLowerCase();
        String reversedText = new StringBuilder(cleanText).reverse().toString();
        return cleanText.equals(reversedText);
    }
    public static void game(){
        String[] words = {
                "apple", "orange", "lemon", "banana", "apricot", "avocado",
                "broccoli", "carrot", "cherry", "garlic", "grape", "melon",
                "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
                "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"
        };

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String secretWord = words[random.nextInt(words.length)];

        System.out.println("The computer has chosen a word. Try to guess it!");

        while (true) {
            System.out.print("Your answer: ");
            String guess = scanner.nextLine().trim().toLowerCase();
            if (guess.equals(secretWord)) {
                System.out.println("Hello! You guessed the word correctly: " + secretWord);
                break;
            } else {
                System.out.println("Incorrect. Try again.");

                StringBuilder hint = new StringBuilder();
                int totalLength = 15;

                for (int i = 0; i < totalLength; i++) {
                    if (i < secretWord.length() && i < guess.length() && secretWord.charAt(i) == guess.charAt(i)) {
                        hint.append(secretWord.charAt(i));
                    } else {
                        hint.append('#');
                    }
                }
                System.out.println("Hint:" + hint.toString());
            }
        }
        scanner.close();
    }


}
