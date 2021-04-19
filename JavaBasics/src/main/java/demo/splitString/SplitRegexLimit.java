package demo.splitString;

import java.util.Arrays;
import java.util.regex.Pattern;

public class SplitRegexLimit {
    private static Pattern NUMBERR_PATTERN = Pattern.compile(":");
    public static void main(String[] args) {
        String str = "boo:and:foo";
        System.out.println(Arrays.toString(str.split(":",2)));
        System.out.println(Arrays.toString(str.split(":",5)));
        System.out.println(Arrays.toString(str.split(":",-2)));
        System.out.println(Arrays.toString(str.split("o",5)));
        System.out.println(Arrays.toString(str.split("o",-2)));
        System.out.println(Arrays.toString(str.split("o",0)));

        //Pattern.compile(regex).split(str, n)
        System.out.println(Arrays.toString(NUMBERR_PATTERN.split(str,2)));
    }
}
