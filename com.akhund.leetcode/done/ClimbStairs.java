package done;

import java.util.HashMap;
import java.util.Map;

public class ClimbStairs {

    public static void main(String[] args) {

        System.out.println(climbStairs(10));
    }
    static Map<Integer, Integer> memo = new HashMap<>();

    public static int climbStairs(int n) {

        if (memo.containsKey(n))
            return memo.get(n);

        if (n <= 0)
            return 1;
        if (n == 1)
            return 1;


        int result =  climbStairs(n - 1) + climbStairs(n - 2);
        memo.put(n, result);

        return result;

    }
}