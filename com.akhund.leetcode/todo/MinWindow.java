package todo;

import java.util.HashMap;
import java.util.Map;

public class MinWindow {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        if (t.length() > s.length())
            return "";

        if (t.length() == s.length())
            return s.equals(t) ? s : "";

        Map<Character, Boolean> memo = new HashMap<>();
        for (Character c : t.toCharArray())
            memo.put(c, false);


        return s;


    }

}
