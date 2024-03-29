package com.od.B.fenshu100;

import java.util.Scanner;
/*
* 最长公共后缀
["bbc","abc","c"]
输出："c"

思路：获取最短字符串，作为首个字符串遍历字符
* */
public class OD32 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] strings = sc.nextLine().replace("[", "")
                .replace("]", "")
                .replace("\"", "")
                .split(",");

        StringBuffer res = new StringBuffer();
        //以首个字符作为参照对象
        String temp = strings[0];
        //是否结束循环
        boolean isOver = false;
        for (int i = 0; i < temp.length(); i++) {
            //字符从后往前遍历
            char c = temp.charAt(temp.length() - i - 1);
            for (int j = 1; j < strings.length; j++) {
                //当前用来对比的字符串
                String str = strings[j];
                if (str.length() <= i || c != str.charAt(str.length() - i - 1)) {
                    //如果长度不满足，或者字符对不上则跳出循环
                    isOver = true;
                    break;
                }
            }

            if (isOver) {
                break;
            }

            res.append(c);
        }

        System.out.println(res.length() == 0 ? "@Zero" : res.reverse());

    }
}
