package current;

public class RemoveDuplicates2 {

    public static void main(String[] args) {

        int[] nums = new int[] {1,2,2,2};
        System.out.println(removeDuplicates(nums));
        for (int num: nums) {
            System.out.println(num);
        }

    }

    public static int removeDuplicates(int[] nums) {
        int first = 0;
        int second = 0;
        int flag = 0;
        int previous = nums[0];

        while (second < nums.length) {
            if (flag == 2) {
                while(previous == nums[second])
                    second++;
                previous = nums[second];
                flag = 0;
            }
            else {
                if (previous == nums[second]) {
                    flag++;
                    first++;
                    second++;
                }
                else {
                    previous = nums[second];
                    nums[first] = nums[second];
                    flag = 1;
                    first++;
                    second++;
                }
            }
        }

        return first;
    }
}
