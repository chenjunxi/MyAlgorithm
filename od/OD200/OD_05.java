package com.od.OD.OD200;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.HashMap;
import java.util.Scanner;

public class OD_05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char c = sc.nextLine().charAt(0);
        String s = sc.nextLine();
        int l = 0;
        int result = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp == c) { //遇到不包含字符map重置，l更新开始点
                map.clear();
                l = i + 1;
                continue;
            }

            map.put(temp, map.getOrDefault(temp, 0) + 1);
            while (map.get(temp) == 3) {
                char c1 = s.charAt(l);
                l++;
                map.put(c1, map.get(c1) - 1); //减到某个字符的次数降到小于
            }

            result = Math.max(result, i - l + 1);
        }

        System.out.println(result);

    }
}
