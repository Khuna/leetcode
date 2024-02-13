package todo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BasicCalculator {

    public static void main(String[] args) {
        String s = " 2-1 + 2 ";

        System.out.println(calculate(s));
    }
    public static int calculate(String s) {

        int pointer = 0;
        while (pointer < s.length()) {
            char c = s.charAt(pointer);
            if (digit(c) != -1) {
                StringBuilder leftSb = new StringBuilder();
                while (pointer < s.length()){
                    c = s.charAt(pointer);
                    if (digit(c) != - 1)
                        leftSb.append(c);
                    else
                        break;
                    pointer++;
                }
                if (pointer >= s.length())
                    return Integer.parseInt(leftSb.toString());

                char action = s.charAt(pointer);

                if (action == '+' || action == '-') {
                    pointer ++;
                    StringBuilder rigthSb = new StringBuilder();
                    while (pointer < s.length()) {
                        rigthSb.append(s.charAt(pointer));
                        pointer++;
                    }

                    return doAction(leftSb.toString(), rigthSb.toString(), action);
                }

                if (action == '*' || action == '/') {
                    pointer++;
                    StringBuilder rigthSb = new StringBuilder();
                    while (pointer < s.length()) {
                        c = s.charAt(pointer);
                        if (digit(c) != -1)
                            rigthSb.append(c);
                        else
                            break;
                        pointer++;
                    }

                    if (pointer >= s.length())
                        return doAction(leftSb.toString(), rigthSb.toString(), action);

                    StringBuilder otherSb = new StringBuilder();
                    while (pointer < s.length()) {
                        otherSb.append(s.charAt(pointer));
                        pointer++;
                    }

                    return calculate(String.valueOf(doAction(leftSb.toString(), rigthSb.toString(), action)) + otherSb.toString());
                }
            }
            else {

            }

            pointer++;
        }

        return pointer;


        /*
        digit - > left -> get action
            action +- -> str =  till end -> right = calculate str
            action *\ -> next - digit -> rigth = till action or end
                next is action left = left *\right new str =  left + action + till end - > calculate new str
                if end  return left *\ right
       if ( -> str = get till ')', recalcilate (calculate(str) + till end
         */

    }

    public static int doAction(String left, String right, char action) {
        int l = Integer.parseInt(left);
        int r = Integer.parseInt(right);
        if (action == '*')
            return l * r;
        else if (action == '/')
            return l * r;
        else if (action == '+')
            return l * r;
        else if (action == '-')
            return l * r;
        else
            return 0;
    }

    public static boolean isAction(char c) {
        return c == '*' || c == '/' || c == '+' || c == '-';
    }

    public static int digit(char c) {
        return c - '0' >= 0 && c - '0' < 10 ? c - '0' : -1 ;
    }

    public static String getToEnd(char[] chars, int from) {
        StringBuilder sb = new StringBuilder();
        for (int i = from; i < chars.length; i++)
            sb.append(chars[i]);

        return sb.toString();
    }

}
