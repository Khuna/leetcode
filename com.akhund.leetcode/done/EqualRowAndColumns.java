package done;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EqualRowAndColumns {

    public static void main(String[] args) {
        int[][] grid = new int[][] {
                {3,2,1},
                {1,7,6},
                {2,7,7}
        };

        System.out.println(equalPairs(grid));
    }

    public static int equalPairs(int[][] grid) {

        Map<Line, Integer> rows = new HashMap<>();
        Map<Line, Integer> columns = new HashMap<>();

        for (int i = 0; i < grid.length; i++) {
            Line line = new Line(grid[i]);
            rows.put(line, rows.getOrDefault(line, 0) + 1);
        }

        for (int i = 0; i < grid.length; i++) {
            int[] column = new int[grid.length];
            for (int j = 0; j < grid.length; j++)
                column[j] =grid[j][i];
            Line line = new Line(column);
            columns.put(line, columns.getOrDefault(line, 0) + 1);
        }

        int count = 0;
        for (Line line : rows.keySet()) {
            if (columns.containsKey(line)) {
                count += rows.get(line) * columns.get(line);
            }
        }

        return count;
    }

    static class Line {
        private int[] line;

        public Line(int[] line) {
            this.line = line;
        }

        private Line() {

        }

        public int[] getLine() {
            return line;
        }

        @Override
        public int hashCode() {
            int sum = 0;
            for (int i = 0; i < line.length; i++) {
                sum += 7 * line[i];
            }

            return sum;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this)
                return true;
            if (!(obj instanceof Line)) {
                return false;
            }
            Line lineObj = (Line) obj;

            if (line.length != lineObj.line.length) {
                return false;
            }

            for (int i = 1; i < line.length; i++) {
                if (line[i] != lineObj.getLine()[i]) {
                    return false;
                }
            }

            return true;
        }
    }
}
