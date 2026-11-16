package hm13;

import javax.sound.midi.Soundbank;
import java.util.Arrays;

public class ValueCalculator {
    private static final int MIN_SIZE = 1_000_000;
    private float[] array;
    private int size;
    private int halfSize;

    public ValueCalculator(int size) {
        this.size = Math.max(size, MIN_SIZE);
        this.halfSize = this.size / 2;
        this.array = new float[this.size];
    }

    public float[] getArray() {
        return array;
    }

    public int getSize() {
        return size;
    }

    public int getHalfSize() {
        return halfSize;
    }

    public void doCalc() {
        long start = System.currentTimeMillis();
        Arrays.fill(array, 1f);
        float[] a1 = new float[halfSize];
        float[] a2 = new float[halfSize];
        System.arraycopy(array, 0, a1, 0, halfSize);
        System.arraycopy(array, halfSize, a2, 0, halfSize);

        Thread t1 = new Thread(() -> calculate(a1));
        Thread t2 = new Thread(() -> calculate(a2));
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("The stream was interrupted.", e);
        }

        System.arraycopy(a1, 0, array, 0, halfSize);
        System.arraycopy(a2, 0, array, halfSize, halfSize);


        long end = System.currentTimeMillis();
        System.out.println("Execution time: " + (end - start) + "s");
        printArray("a1", a1);
        printArray("a2", a2);
        printArray("array", array);
    }

    private void calculate(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5)
                    * Math.cos(0.2f + i / 5)
                    * Math.cos(0.4f + i / 2));
        }
    }

    private void printArray(String name, float[] arr) {
        int n = 5;
        System.out.println(name + ", size " + arr.length + ":");
        System.out.println("  first:    " + Arrays.toString(Arrays.copyOfRange(arr, 0, n)));
        System.out.println("  last: " + Arrays.toString(Arrays.copyOfRange(arr, arr.length - n, arr.length)));
        System.out.println();
    }
}

