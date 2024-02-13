package done;

import java.util.*;
import java.util.stream.IntStream;

public class InsertInterval {

    public static void main(String[] args) {
        int [][] intervals = new int[][] {{1, 5}};
        int[] newInterval = new int[] {0, 6};

        Arrays.stream(intervals)
                .forEach(interval -> {
                    IntStream.of(interval)
                            .forEach(i -> System.out.print(i + " "));
                    System.out.println();
                });
        System.out.println("--------------------------------");
        Arrays.stream(insert(intervals, newInterval))
                .forEach(interval -> {
                    IntStream.of(interval)
                            .forEach(i -> System.out.print(i + " "));
                    System.out.println();
                });
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {

        if (intervals.length == 0) {
            return new int[][] {newInterval};
        }
        List<int[]> result = new ArrayList<>();
        boolean ifLastAddNewInterval = true;
        for (int i = 0; i < intervals.length; i++) {
            ifLastAddNewInterval = true;
            if (newInterval[1] < intervals[i][0]) {
                ifLastAddNewInterval = false;
                result.add(newInterval);
                for (int j = i; j < intervals.length; j++) {
                    result.add(intervals[j]);
                }
                break;
            }
            if (newInterval[0] >= intervals[i][0] && newInterval[0] <= intervals[i][1]) {
                newInterval[0] = intervals[i][0];
                newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            }
            if (newInterval[1] >= intervals[i][0] && newInterval[1] <= intervals[i][1]) {
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]) ;
                newInterval[1] = intervals[i][1];
           }
            if (newInterval[0] > intervals[i][1]) {
                result.add(intervals[i]);
            }
        }

        if (ifLastAddNewInterval) {
            result.add(newInterval);
        }

        int[][] arrays = new int[result.size()][];
        for (int i = 0; i < result.size(); i++) {
            arrays[i] = result.get(i);
        }

        return arrays;
    }
}
