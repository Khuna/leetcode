public class TrappingRainWater {

    public static void main(String[] args) {
        int[] height = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));

    }
    public static int trap(int[] height) {
        if (height.length == 0 || height.length == 1 || height.length == 2) {
            return 0;
        }

        int start = 0;
        int maxStart = height[0];
        int end = height.length-1;
        int maxEnd = height[end];
        int result = 0;

        while (start < end) {
            if (maxStart <= maxEnd) {
                start++;
                if (maxStart > height[start]) {
                    result = result + maxStart - height[start];
                }
                else {
                    maxStart = height[start];
                }
            }
            else {
                end--;
                if (maxEnd > height[end]) {
                    result = result +  maxEnd - height[end];
                }
                else {
                    maxEnd = height[end];
                }
            }

        }
        return result;
    }
}
