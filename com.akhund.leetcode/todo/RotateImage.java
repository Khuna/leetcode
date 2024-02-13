package todo;

import java.io.BufferedInputStream;
import java.util.Arrays;

public class RotateImage {

    public static void main(String[] args) {
        int[][]  matrix = new int[][] {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        rotate(matrix);

        Arrays.stream(matrix)
                .forEach(m -> {
                    Arrays.stream(m).forEach(i -> System.out.print(i + "    "));
                    System.out.println();
                });

    }
    public static void rotate(int[][] matrix) {
        int size = matrix.length;
        for (int i = 0; i < size / 2; i++) {
            for (int j = i; i < size / 2 - i; j++){
                //int val =
            }
        }



    }
}
