package Packgae_Day10;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author 王嗣鑫
 * @Date 2020/8/7 21:54
 * @Version 1.0
 */
public class Test_Debugger {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println("i = " + i);
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("name","Tom");
        map.put("age","12");
        map.put("school","Beihang");
        map.put("major","IT");
        String age = map.get("age");
        System.out.println("age = " + age);
        map.remove("major");
        System.out.println("map = " + map);


    }
}
