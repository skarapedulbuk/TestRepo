package HW12;

import java.util.stream.IntStream;

public class ArrayCalculator {
    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;
    float[] array = new float[SIZE];

    public void doMethod2() throws InterruptedException {
        IntStream.range(0, array.length).forEach(i -> array[i] = 1);
        long start = System.currentTimeMillis();

        float[] a1 = new float[HALF];
        float[] a2 = new float[HALF];

        System.arraycopy(array, 0, a1, 0, HALF);
        System.arraycopy(array, HALF, a2, 0, HALF);

        Thread t1 = new Thread(() -> doCalc(a1));
        Thread t2 = new Thread(() -> doCalc(a2));
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.arraycopy(a1, 0, array, 0, HALF);
        System.arraycopy(a2, 0, array, HALF, HALF);

        long end = System.currentTimeMillis() - start;
        System.out.println("Время выполнения Методом 2: " + end);
    }

    public void doMethod1() {
        IntStream.range(0, array.length).forEach(i -> array[i] = 1);
        long start = System.currentTimeMillis();
        doCalc(array);
        long end = System.currentTimeMillis() - start;
        System.out.println("Время выполнения Методом 1: " + end);
    }

    private void doCalc(float[] array) {
        IntStream.range(0, array.length).forEach(i -> array[i] = (float) (array[i] * Math.sin(0.2f + i / 5f) * Math.cos(0.2f + i / 5f) * Math.cos(0.4f + i / 2f)));
    }
}
