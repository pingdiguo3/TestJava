package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class Test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        // float f=(float) 3.4;
        String tempstr = "";
        String str = "wang";
        try {
            tempstr = new String(str.getBytes("ISO-8859-1"), "GBK");
            tempstr = tempstr.trim();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(tempstr);

        List<Map<String, Object>> list = Collections.synchronizedList(new ArrayList<Map<String, Object>>());
        List<Integer> ll = new Vector<>();

    }


}
