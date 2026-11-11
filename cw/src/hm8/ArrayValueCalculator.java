package hm8;

public class ArrayValueCalculator {

    public static int doCalc(String[][] array) throws ArraySizeException, ArrayDataException {
        if (array == null || array.length != 4) {
            throw new ArraySizeException("Incorrect number of rows!");
        }

        int sum = 0;

        for (int i = 0; i < 4; i++) {
            if (array[i] == null || array[i].length != 4) {
                throw new ArraySizeException("Incorrect number of rows! but not: " + i);
            }
            for (int j = 0; j < 4; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new ArrayDataException(
                            "Warning: element  [" + i + "][" + j + "]: " + array[i][j] + " is not a number",
                            i, j, e
                    );
                }
            }
        }

        return sum;
    }
}