import java.util.*;
import java.util.stream.IntStream;

public class Permutations {

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 0, 5};
        System.out.println(permute(nums));
    }


    public static List<List<Integer>> permute(int[] nums) {
        int len = nums.length;

        if (len == 1) {
            return List.of(List.of(nums[0]));
        }

        if (len == 2) {
            return List.of(
                    List.of(nums[0], nums[1]),
                    List.of(nums[1], nums[2]));
        }

        if (len == 3) {
            return List.of(
                    List.of(nums[0], nums[1], nums[2]),
                    List.of(nums[0], nums[2], nums[1]),
                    List.of(nums[1], nums[0], nums[2]),
                    List.of(nums[1], nums[2], nums[0]),
                    List.of(nums[2], nums[0], nums[1]),
                    List.of(nums[2], nums[1], nums[0]));
        }

        List<List<Integer>> lists= new LinkedList<>();

        for (int i = 0; i < len; i++) {
            int[] nums2 = new int[len - 1];
            int index = 0;
            for (int j = 0; j < len; j++) {
                if (i == j) continue;
                nums2[index] = nums[j];
                index++;
            }

            var permutes = permute(nums2);
            for (List<Integer> permute : permutes) {
                List<Integer> list = new LinkedList<>();
                list.add(nums[i]);
                list.addAll(permute);
                lists.add(list);
            }
        }

        return lists;
    }
}
