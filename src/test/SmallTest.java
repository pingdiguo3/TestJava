package test;

import java.util.ArrayList;
import java.util.List;

public class SmallTest {

    static int a = 5, b = 5;
    static String s1 = "我是好孩子";
    static String s2 = "我是好孩子";
    static String s3 = new String("我是好孩子");

    public static void main(String[] args) {
        System.out.println(a == b);
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s3));

        int b = 35624;
        System.out.println(b / 1000);
        List<Object> list = new ArrayList<Object>();
        System.out.println(list);

    }
}
