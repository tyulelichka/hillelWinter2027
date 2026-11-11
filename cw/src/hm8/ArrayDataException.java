package hm8;

class ArrayDataException extends Exception {
    private final int row;
    private final int col;

    public ArrayDataException(String message, int row, int col, Throwable cause) {
        super(message, cause);
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}