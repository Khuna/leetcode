package done;

public class HightestAttitude {

    public static void main(String[] args) {
        int[] gain = new int[] {-4,-3,-2,-1,4,3,2};

        System.out.println(largestAltitude(gain));
    }

    public static int largestAltitude(int[] gain)  {
        int attitude = 0;

        int sum = 0;
        for (int i = 0; i < gain.length; i++) {
            sum = sum + gain[i];
            attitude = Math.max(attitude, sum);
        }

        return attitude;
    }
}

