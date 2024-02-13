package done;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FloodFill {

    public static void main(String[] args) {
        int[][] image = new int[][] {{1,1,1},{1,1,0},{1,0,1}};

        Arrays.stream(image)
                .forEach(line -> {
                    IntStream.of(line)
                            .forEach(i -> System.out.print(i + " "));
                    System.out.println();
                });
        System.out.println("---------------------");
        Arrays.stream(floodFill(image, 0, 0, 2))
                .forEach(line -> {
                    IntStream.of(line)
                            .forEach(i -> System.out.print(i + " "));
                    System.out.println();
                });
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        floodFillPoint(image, sr, sc, image[sr][sc]);
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                if (image[i][j] == -1)
                    image[i][j] = color;
            }
        }

        return image;
    }

    public static void floodFillPoint(int[][] image, int i, int j, int before) {

        if (i < 0 || j < 0 || i >= image.length || j >= image[0].length)
            return;

        if (image[i][j] == before) {
            image[i][j] = -1;
            floodFillPoint(image, i + 1, j, before);
            floodFillPoint(image, i - 1, j, before);
            floodFillPoint(image, i ,j + 1, before);
            floodFillPoint(image, i, j - 1, before);
        }

    }


}
