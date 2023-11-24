import java.util.Arrays;
import java.util.stream.IntStream;

public class MultiplyStrings {

    public static void main(String[] args) {
        String num1 = "123456789";
        String num2 = "987654321";



        System.out.println(multiply(num1, num2));

    }

    public static String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();

        int size = 4;
        String[] tokens1 =  num1.split("(?<=\\G.{" + size + "})");;
        String[] tokens2 =  num2.split("(?<=\\G.{" + size + "})");;

        String result = "0";

        for (int i = 0; i < tokens1.length; i++) {
            for (int j = 0; j < tokens2.length; j++) {
                String multiplyResult = multiplyStrings(tokens1[i], tokens2[j]);
                System.out.println(multiplyResult);
                if ((i + j) > 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(multiplyResult);
                    IntStream.range(0, (i + j) * 4)
                            .forEach(v -> sb.insert(0, '0'));
                    multiplyResult = sb.toString();
                }
                result = sumStrings(result, multiplyResult);
            }
        }

        return new StringBuilder().append(result).reverse().toString();
    }

    public static String multiplyStrings(String s1, String s2) {
        String num1 = new StringBuilder().append(s1).reverse().toString();
        String num2 = new StringBuilder().append(s2).reverse().toString();

        return new StringBuilder()
                .append(String.valueOf(Integer.parseInt(num1) * Integer.parseInt(num2)))
                .reverse()
                .toString();
    }

    public static String sumStrings(String s1, String s2) {
        boolean biggerThen10 = false;
        StringBuilder sb = new StringBuilder();
        int length = Math.max(s1.length(), s2.length());

        for (int i = 0; i < length; i++) {
            int res;
            if (s1.length() > i && s2.length() > i) {
                int i1 = Character.getNumericValue(s1.charAt(i));
                int i2 = Character.getNumericValue(s2.charAt(i));
                res = i1 + i2 + (biggerThen10 ? 1 : 0);
            } else if (s1.length() > i) {
                res = Character.getNumericValue(s1.charAt(i)) + (biggerThen10 ? 1 : 0);
            } else {
                res = Character.getNumericValue(s2.charAt(i)) + + (biggerThen10 ? 1 : 0);
            }

            if (res > 9) {
                res = res - 10;
                biggerThen10 = true;
            } else {
                biggerThen10 = false;
            }

            sb.append(res);
        }

        if (biggerThen10) sb.append(1);

        return sb.toString();
    }
}
