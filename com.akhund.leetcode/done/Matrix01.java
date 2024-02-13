package done;

import common.Utils;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Matrix01 {

    public static void main(String[] args) {
        int[][] mat = new int[][] {
                {0,0,1,0,1,1,1,0,1,1},
                {1,1,1,1,0,1,1,1,1,1},
                {1,1,1,1,1,0,0,0,1,1},
                {1,0,1,0,1,1,1,0,1,1},
                {0,0,1,1,1,0,1,1,1,1},
                {1,0,1,1,1,1,1,1,1,1},
                {1,1,1,1,0,1,0,1,0,1},
                {0,1,0,0,0,1,0,0,1,1},
                {1,1,1,0,1,1,0,1,0,1},
                {1,0,1,1,1,0,1,1,1,0}};

        Utils.printIntArray(mat);
        System.out.println("----------------------------");
        Utils.printIntArray(updateMatrix(mat));


    }

    public static int[][] updateMatrix(int[][] mat) {

        if (mat.length == 0 || mat[0].length == 0)
            return new int[0][0];

        int n = mat.length;
        int m = mat[0].length;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0)
                    queue.add(new int[] {i,j});
                else
                    mat[i][j] = -1;
            }
        }
        int distance = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k ++) {
                int[] element = queue.poll();
                int i = element[0];
                int j = element[1];
                doDistance(mat, i, j, n, m, distance, queue);
            }

            distance++;
        }

        return mat;
    }

    private static void doDistance(int[][] mat, int i, int j, int n, int m, int distance,  Queue<int[]> queue) {
        changeTo(mat, i + 1, j, n, m, distance, queue);
        changeTo(mat, i - 1, j, n, m, distance, queue);
        changeTo(mat, i, j + 1, n, m, distance, queue);
        changeTo(mat, i, j - 1, n, m, distance, queue);
    }

    private static void changeTo(int[][] mat, int i, int j, int n, int m, int distance, Queue<int[]> queue) {
        if (i >= 0 && i < n && j >= 0 && j < m && mat[i][j] == -1) {
            mat[i][j] = distance;
            queue.add(new int[] {i, j});
        }
    }


}
