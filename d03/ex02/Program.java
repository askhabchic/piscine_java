package ex02;

import java.util.Random;

public class Program {
    public static final int MAX = 1000;
    public static final int MIN = -1000;

    public static void main(String[] args) {
        if (args.length != 2) {
            printErr("Invalid number of arguments");
        } else if (!args[0].contains("--arraySize=") && !args[1].contains(" --threadsCount=")) {
            printErr("Invalid arguments");
        } else {
            int arraySize = getSize(args[0]);
            int threadsCount = getSize(args[1]);
            if (arraySize < threadsCount)
                printErr("Invalid number of threads");
            int[] array = createRandomArray(arraySize);
            int sumWithoutThreads = 0;
            for (int i = 0; i < arraySize; i++) {
                sumWithoutThreads += array[i];
            }
            System.out.println("Sum: " + sumWithoutThreads);
            Threader threader = new Threader(threadsCount, array);
            System.out.println("Sum by threads: " + threader.getSum());
        }
    }

    public static int getSize(String str) { return Integer.parseInt(str.substring(str.indexOf('=') + 1)); }

    public static void printErr(String err) {
        System.err.println(err);
        System.exit(-1);
    }

    public static int[] createRandomArray(int size) {
        int min = MIN;
        int max = MAX;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int)Math.floor(Math.random() * (max - min - 1) + min);
        }
        return arr;
    }
}
