package done;

import java.util.Stack;

public class StringCompression {

    public static void main(String[] args) {
        char[] chars = "aabbccccccccccccccccccccccd".toCharArray();
        System.out.println(compress(chars));
    }

    public static int compress(char[] chars) {
        if (chars.length == 1)
            return 2;

        if (chars.length == 2)
            if (chars[0] == chars[1])
                return 2;
            else
                return 4;

        int left = 0;
        int right = 1;
        int pointer = 0;

        while (right <= chars.length) {
            if (right < chars.length && chars[left] == chars[right])
                right++;
            else {
                pointer = pointer + String.valueOf(right - left).length() + 1;
                left = right;
                right++;
            }
        }

        return pointer;
    }
}
