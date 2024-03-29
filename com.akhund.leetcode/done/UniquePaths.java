package done;

public class UniquePaths {

    public static void main(String[] args) {
        int n = 10;
        int m = 3;

        System.out.println(uniquePaths(m ,n));
    }

    public static int uniquePaths(int m, int n) {
        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++)
            grid[i][0] = 1;

        for (int i = 0; i < m; i++)
            grid[0][i] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                grid[i][j] = grid[i - 1][ j] + grid[i][j - 1];
            }
        }

        return grid[n - 1][m - 1];
    }
}
