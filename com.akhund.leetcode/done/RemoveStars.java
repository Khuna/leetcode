package done;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class RemoveStars {

    public static void main(String[] args) {
        String s = "leet*******coood*e";

        System.out.println(removeStars(s));
    }


    public static String removeStars(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '*') {
                if (!stack.isEmpty())
                    stack.pop();
                }
            else
                stack.push(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}
