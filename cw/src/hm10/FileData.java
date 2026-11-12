package hm10;

public class FileData {
    private String nameFile;
    private int size;
    private String way;

    public FileData(String nameFile,
                    int size,
                    String way) {
        this.nameFile = nameFile;
        this.size = size;
        this.way = way;
    }

    public int getSize() {
        return size;
    }

    public String getNameFile() {
        return nameFile;
    }

    public String getWay() {
        return way;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    public void setSize(byte size) {
        this.size = size;
    }

    public void setWay(String way) {
        this.way = way;
    }
}
