package done;

public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = new char[][]{
                          {'1','1','0','0','0'},
                          {'1','1','0','0','0'},
                          {'0','0','1','0','0'},
                          {'0','0','0','1','1'}};

        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int islands = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    doZero(grid, i, j);
                }
            }
        }


        return islands;
    }

    public static void doZero(char[][] grid, int i, int j){
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0' )
            return;

        grid[i][j] = '0';
        doZero(grid, i + 1, j);
        doZero(grid, i - 1, j);
        doZero(grid, i, j + 1);
        doZero(grid, i, j - 1);
    }
    
}
