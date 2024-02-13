package done;

import java.util.*;

public class CombinationSum {

    public static void main(String[] args) {

        int[] candidates = new int[] {6, 8, 11 ,15};
        int target = 37;

        System.out.println(combinationSum(candidates, target));
    }


    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        repeat(result, new ArrayList<>(), candidates, target, 0);

        return result;
    }

    public static void repeat(List<List<Integer>> result, List<Integer> temp, int[] candidates, int target, int start) {

        if (target < 0)
            return;
        else if (target == 0)
            result.add(new ArrayList<>(temp));
        else {
            for (int i = start; i < candidates.length; i++) {
                temp.add(candidates[i]);
                repeat(result, temp, candidates, target - candidates[i], i);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
