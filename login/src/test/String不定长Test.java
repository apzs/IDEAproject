package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 无名氏
 * @Data 2021/7/4
 */
public class String不定长Test {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<Object>();
        list.add("111");
        list.add("222");
        Object[] objects = list.toArray();
        Object[] s = new Object[objects.length+2];
        for (int i = 0; i < objects.length; i++) {
            s[i] = objects[i];
        }
        s[objects.length] = 1;
        s[objects.length+1] = 2;
        System.out.println(Arrays.toString(s));
    }

    public static void fun(Object... s){
        for (Object s1 : s) {
            System.out.println(s1);
        }
    }
}
