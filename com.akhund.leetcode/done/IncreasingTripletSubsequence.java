package done;

public class IncreasingTripletSubsequence {

    public static void main(String[] args) {
        int[] nums = new int[] {2,1,5,0,7,6};
        System.out.println(increasingTriplet(nums));
    }

    public static boolean increasingTriplet(int[] nums) {
        int k = Integer.MAX_VALUE;
        int l = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= k)
                k = nums[i];
            else if (nums[i] < l)
                l = nums[i];
            else if (nums[i] > l)
                return true;
        }
        return false;
    }
}
