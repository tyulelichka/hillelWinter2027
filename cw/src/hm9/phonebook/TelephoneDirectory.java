package hm9.phonebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TelephoneDirectory {
    private List<Entry> entrys;

    public TelephoneDirectory() {
        this.entrys = new ArrayList<>();
    }

    public void add(Entry entry) {
        entrys.add(entry);
    }

    public List<Entry> getAllEntrys() {

        return entrys;
    }


    public String find(String name) {
        for (Entry entry : entrys) {
            if (entry.getName().equalsIgnoreCase(name)) {
                return entry.getName() + " " + entry.getNumber();
            }
        }
        return null;
    }


    public List<Entry> findAll() {

        Map<String, Integer> nameCounts = new HashMap<>();
        for (Entry entry : entrys) {
            String name = entry.getName();
            nameCounts.put(name, nameCounts.getOrDefault(name, 0) + 1);
        }

        List<Entry> duplicateEntries = new ArrayList<>();
        for (Entry entry : entrys) {
            if (nameCounts.get(entry.getName()) > 1) {
                duplicateEntries.add(entry);
            }
        }

        return duplicateEntries;
    }

}
