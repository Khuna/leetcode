package done;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class EvalRPN {

    public static void main(String[] args) {
        String[] tokens = new String[] {"4","13","5","/","+"};
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        if (tokens.length == 1)
            return Integer.parseInt(tokens[0]);

        if (tokens.length < 3)
            return 0;

        Deque<Integer> stack = new LinkedList<>();
        stack.push(Integer.parseInt(tokens[0]));
        stack.push(Integer.parseInt(tokens[1]));

        for (int i = 2; i < tokens.length; i++) {
            if (tokens[i].equals("*")) {
                int right = stack.pop();
                int left = stack.pop();
                stack.push(left * right);
            }
            else if (tokens[i].equals("/")) {
                int right = stack.pop();
                int left = stack.pop();
                stack.push(left / right);
            }
            else if (tokens[i].equals("+")) {
                int right = stack.pop();
                int left = stack.pop();
                stack.push(left + right);
            }
            else if (tokens[i].equals("-")) {
                int right = stack.pop();
                int left = stack.pop();
                stack.push(left - right);
            }
            else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }

        return stack.peek();

    }

}
