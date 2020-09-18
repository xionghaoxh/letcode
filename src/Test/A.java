package Test;

import java.util.ArrayList;

public class A {
    public static void main(String[] args) {

        String a = "a";
        String b = "b";
        String c = "ab";
        String d = new String("ab");
        System.out.println((a + b) == c);
        System.out.println(c == d);
        System.out.println(c == d.intern());
    }
}
