package done;

import java.util.HashMap;
import java.util.Map;

public class Fibo {

    public static void main(String[] args) {

        Fibo f = new Fibo();
        System.out.println(f.fibo(6));

    }

    Map<Integer, Integer> memo = new HashMap<>();

    int fibo(int n) {
        if (n < 0)
            throw  new ArithmeticException("n < 0");
        if (n == 0)
            return 0;

        if (n == 1 || n == 2)
            return 1;

        if (memo.containsKey(n))
            return memo.get(n);

        int fn2 = memo.containsKey(n - 2) ? memo.get(n - 2) : fibo(n - 2);
        int fn1 = memo.containsKey(n - 1) ? memo.get(n - 1) : fibo(n - 1);

        memo.put(n, fn2 + fn1);

        return fn1 + fn2;
    }

}
