package done;

import java.util.*;

public class DecodeString {

    public static void main(String[] args) {
        String s = "2[abc]3[cd]ef";

        System.out.println(decodeString(s));
    }

    public static String decodeString(String s) {
        int pointer = 0;
        Queue<String> strings = new LinkedList<>();
        Queue<Integer> times = new LinkedList<>();

        while (pointer < s.length()) {
            char c = s.charAt(pointer);
            if (isLetter(c)) {
                times.add(1);
                StringBuilder sb = new StringBuilder();
                while (pointer < s.length() && isLetter(s.charAt(pointer))) {
                    sb.append(s.charAt(pointer));
                    pointer++;
                }
                strings.add(sb.toString());
            }
            if (digit(c) != -1) {
                times.add(digit(c));

                int count = 1;
                c = s.charAt(pointer);
                StringBuilder sb = new StringBuilder();
                pointer = pointer + 2;
                while (pointer < s.length() && !(count == 1 && s.charAt(pointer) == ']')) {
                    c = s.charAt(pointer);
                    if (c == '[')
                        count++;
                    else if (c == ']')
                        count--;

                    sb.append(c);
                    pointer++;
                }
                strings.add(decodeString(sb.toString()));
                pointer++;
            }
        }

        StringBuilder sb = new StringBuilder();
        int length = times.size();
        for (int i = 0; i < length; i++) {
            int count = times.poll();
            String str = strings.poll();
            for (int j = 0; j < count; j++)
                sb.append(str);
        }

        return sb.toString();
    }



    public static int digit(char c) {
        return c - '0' <= 9 && c - '0' > 0 ? c - '0' : -1;
    }

    public static boolean isLetter(char c) {
        if (c - 'a' < 26 && c - 'a' >= 0)
            return true;
        else
            return false;
    }



}
