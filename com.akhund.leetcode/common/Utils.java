package common;

import java.util.Arrays;

public class Utils {
    public static void printIntArray(int[][] array) {
        Arrays.stream(array)
                .forEach(arr -> {
                    Arrays.stream(arr)
                            .forEach(i -> System.out.print(i + " "));
                    System.out.println();
                });
    }

    public static void printIntArray(int[] array) {
        Arrays.stream(array)
                .forEach(i -> System.out.print(i + " "));
    }
}
