package hm9;

import hm9.phonebook.Entry;
import hm9.phonebook.TelephoneDirectory;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> list = List.of("apple",
                "autumn",
                "avocado",
                "almond",
                "animal",//
                "autumn",
                "autumn",
                "animal",//
                "action",
                "advice",
                "animal",//
                "author",
                "author",
                "amount",
                "answer");
        String row = "animal";


        System.out.println(countOccurrence(list, row));

        Integer[] integers = {1, 1, 3, 4};
        int[] ints = {1, 1, 3, 4, 5, 6, 6};
        System.out.println(toList(integers));
        System.out.println(toList(ints));

        List<Integer> numbers = List.of(1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 5, 5, 6, 7, 8, 9, 0, 9);
        System.out.println(findUnique(numbers));

        System.out.println(findOccurance(list, row));

        Entry entry1 = new Entry("Vika", "123456789");
        Entry entry2 = new Entry("Vika", "133333339");
        Entry entry3 = new Entry("Ivan", "123456789");
        Entry entry4 = new Entry("Petr", "123456789");
        TelephoneDirectory telephoneDirectory = new TelephoneDirectory();
        telephoneDirectory.add(entry1);
        telephoneDirectory.add(entry2);
        telephoneDirectory.add(entry3);
        telephoneDirectory.add(entry4);
        for (Entry entry : telephoneDirectory.getAllEntrys()) {
            System.out.println("Name: " + entry.getName() + " | Number: " + entry.getNumber());

        }

        System.out.println(telephoneDirectory.find("Ivan"));

        List<Entry> duplicates = telephoneDirectory.findAll();

        for (Entry entry : duplicates) {
            System.out.println("Name: " + entry.getName() + " | Number: " + entry.getNumber());
        }


    }


    public static int countOccurrence(List<String> list, String row) {
        int count = 0;
        for (String item : list) {
            if (Objects.equals(item, row)) {
                count++;
            }
        }
        return count;
    }

    public static List<Integer> toList(Integer[] arr) {
        if (arr == null) {
            return new ArrayList<>();
        }
        return Arrays.asList(arr);
    }

    public static List<Integer> toList(int[] array) {
        List<Integer> list = new ArrayList<>();
        if (array == null) {
            return new ArrayList<>();
        }
        for (int num : array) {
            list.add(num);
        }
        return list;
    }

    public static List<Integer> findUnique(List<Integer> list) {
        if (list == null) {
            return new ArrayList<>();
        }

        Set<Integer> uniqueSet = new LinkedHashSet<>(list);
        return new ArrayList<>(uniqueSet);
    }


    public static Map<String, Integer> findOccurance(List<String> list, String row) {
        Map<String, Integer> map = new HashMap<String, Integer>();

        for (String item : list) {
            if (Objects.equals(item, row)) {
                map.put(item, map.getOrDefault(item, 0) + 1);
            } else {
                map.put(item, map.getOrDefault(item, 0) + 1);
            }
        }
        return map;
    }
}









