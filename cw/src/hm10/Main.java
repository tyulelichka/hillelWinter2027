package hm10;


import javax.sound.midi.Soundbank;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        FileData fileData1 = new FileData("document.txt", 15, "/documents");
        FileData fileData2 = new FileData("image.png", 64, "/images");
        FileData fileData3 = new FileData("script.js", 8, "/scripts");
        FileData fileData4 = new FileData("index.html", 12, "/var/www");
        FileData fileData5 = new FileData("notes.txt", 10, "/notes");
        FileData fileData6 = new FileData("data.json", 25, "/path/to/file");
        FileData fileData7 = new FileData("notes.txt", 4, "/notes");
        FileData fileData8 = new FileData("photo.jpg", 120, "/images");
        FileData fileData9 = new FileData("config.xml", 6, "/path/to/file");
        FileData fileData10 = new FileData("archive.zip", 95, "/path/to/file");

        FileNavigator fileNavigator = new FileNavigator();
        fileNavigator.add(fileData1);
        fileNavigator.add(fileData2);
        fileNavigator.add(fileData3);
        fileNavigator.add(fileData4);
        fileNavigator.add(fileData5);
        fileNavigator.add(fileData6);
        fileNavigator.add(fileData7);
        fileNavigator.add(fileData8);
        fileNavigator.add(fileData9);
        fileNavigator.add(fileData10);

        for (Map.Entry<String, List<FileData>> fileNavigators : fileNavigator.getMap().entrySet()) {
            String path = fileNavigators.getKey();
            List<FileData> files = fileNavigators.getValue();

            System.out.println("Way: " + path);
            for (FileData file : files) {
                System.out.println("  - File: " + file.getNameFile() + ", Size: " + file.getSize());
            }
        }
        System.out.println(fileNavigator.find("/path/to/file"));
        System.out.println(fileNavigator.filterBySize(25));
        fileNavigator.sortBySize();

        FileData file1 = new FileData("report.txt", 15, "/documents");
        fileNavigator.add("/documents", file1);
        fileNavigator.add("/path", file1);

    }

}


