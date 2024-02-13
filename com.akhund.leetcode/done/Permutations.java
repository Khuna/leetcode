package done;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 4, 5};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums.length == 1) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[0]);
            result.add(list);
            return result;
        }

        for (int i = 0; i < nums.length; i++) {
            int[] newNums = new int[nums.length - 1];
            int prefix = 0;
            int currNum = nums[i];

            for (int j = 0; j < nums.length; j++)
                if (i != j) newNums[j + prefix] = nums[j];
                else prefix = -1;

            List<List<Integer>> currResult = permute(newNums);

            currResult.stream()
                    .forEach(list -> list.add(currNum));

            result.addAll(currResult);
        }

        return result;
    }
}
