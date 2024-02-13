package done;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class ValidParentless {

    public static void main(String[] args) {
        String s = "]";

        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            else if (c == ')') {
                if (!stack.isEmpty() && stack.peek() == '(')
                    stack.pop();
                else
                    return false;
            }
            else if (c == '}') {
                if (!stack.isEmpty() && stack.peek() == '{')
                    stack.pop();
                else
                    return false;
            }
            else if (c == ']') {
                if (!stack.isEmpty() && stack.peek() == '[')
                    stack.pop();
                else
                    return false;
            }
        }

        return stack.isEmpty();
    }


}
