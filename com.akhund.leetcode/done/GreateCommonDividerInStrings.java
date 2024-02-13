package done;

public class GreateCommonDividerInStrings {

    public static void main(String[] args) {


    }
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1))
            return "";
        int divider = getDivider(str1.length(), str2.length());
        return str2.substring(0, divider);
    }

    int getDivider(int x, int y){
        if (y == 0)
            return x;
        else
            return getDivider(y,x%y);
    }


}
