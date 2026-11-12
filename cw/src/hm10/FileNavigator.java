package hm10;

import hm9.phonebook.Entry;

import java.util.*;

public class FileNavigator {

    private Map<String, List<FileData>> map = new HashMap<>();

    public Map<String, List<FileData>> getMap() {
        return map;
    }

    public void add(String path, FileData file) {
        if (!map.containsKey(path)) {
            map.put(path, new ArrayList<>());
        }
        map.get(path).add(file);

    }

    public void add(FileData file) {
        String path = file.getWay();
        map.computeIfAbsent(path, k -> new ArrayList<>()).add(file);
    }

    public String find(String way) {
        List<FileData> files = map.get(way);

        StringBuilder result = new StringBuilder();
        for (FileData fileData : files) {
            result.append(fileData.getNameFile())
                    .append(" (size:    ")
                    .append(fileData.getSize())
                    .append(")\n");
        }
        return result.toString().trim();
    }

    public String filterBySize(int maxSize) {
        StringBuilder result = new StringBuilder();

        for (List<FileData> fileList : map.values()) {
            for (FileData file : fileList) {
                if (file.getSize() <= maxSize) {
                    result.append(file.getNameFile())
                            .append(" (size: ")
                            .append(file.getSize())
                            .append(")\n");
                }
            }
        }

        return result.toString().trim();
    }

    public List<FileData> sortBySize() {
        List<FileData> allFiles = new ArrayList<>();
        for (List<FileData> fileList : map.values()) {
            allFiles.addAll(fileList);
        }
        allFiles.sort(Comparator.comparingInt(FileData::getSize));
        for (FileData file : allFiles) {
            System.out.println("File " + file.getNameFile() +
                    " | size: " + file.getSize() +
                    " | way: " + file.getWay());
        }
        return allFiles;
    }


    public void addKey(String path, FileData file) {

        if (!path.equals(file.getWay())) {
            System.out.println("ПОМИЛКА: Неможливо додати файл '" + file.getNameFile() +
                    "'. Шлях-ключ (" + path + ") не відповідає шляху файлу (" + file.getWay() + ")!");
            return; // Прерываем выполнение, файл НЕ добавляется никуда
        }

        // 2. Если пути совпадают, добавляем в мапу по ключу
       map.computeIfAbsent(path, k -> new ArrayList<>()).add(file);
        System.out.println("Файл успішно додано за шляхом: " + path);
    }
}
