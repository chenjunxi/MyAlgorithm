package com.od.B.fenshu100;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
敏感字段加密  逻辑题，点睛之笔是判断是否在""内， falg = !falg;

命令以一个或多个_分割，如果命令中包含_,会用""标识,空命令也用""
1
password__a12345678_time_100
输出：password_******_time_100

1
password__a12345678_"a12_454_67"_time_100
输出：password_******_"a12_454_67"_time_100

字符串以_分割一共有4个命令，题目指出下标为1(0开始)的名字进行加密，也就是a12345678

思路：首先把""内的_替换为#，然后分割_,指定索引字符串变成******，然后那#改为_,输出
* */
public class OD05 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int idnex = sc.nextInt();
        sc.nextLine();
        String line = sc.nextLine();

        boolean falg = false;
        char[] chars = line.toCharArray();
        for (int i = 0; i < line.length(); i++) {

            char c = line.charAt(i);
            if (c == '\"') {
                falg = !falg;
            }

            if (falg && c == '_') {
                chars[i] = '#';
            }

        }

        String s = String.valueOf(chars);
        String[] split = s.split("_+");
        String res = "";

        boolean isFlag = false;
        for (int i = 0; i < split.length; i++) {

            if (i == idnex) {
                res += "******_";
                isFlag = true;
                continue;
            }
            res += split[i].replaceAll("#", "_") + "_";

        }
        System.out.println(isFlag ? res.substring(0, res.length() - 1) : "ERROR");

    }

    private static void demo() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        int len = s.length();
        List<String> list = new ArrayList<>();

        String temp = "";
        Boolean yh = false; //是否有引号
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != '_') {
                if (s.charAt(i) == '\"') {
                    yh = !yh;
                }
                temp += s.charAt(i);  //非下划线直接拼接字符
                if (i == len - 1) {
                    list.add(temp); //最后一位直接push
                }

            } else {
                if (temp == "") {
                    continue;   //字符串为空则进入下个循环
                }
                if (yh) {
                    temp += s.charAt(i);  //引号内的下划线直接拼接字符串
                } else {
                    list.add(temp); //push字符串
                    temp = "";  //置空为下次使用
                }
            }
        }
        int count = list.size();
        if (n >= count) {
            System.out.println("ERROR");
        } else {
            String res = "";
            for (int i = 0; i < count; i++) {
                if (i == n) {
                    res += "******";  //对应下标的字符串进行加密
                } else {
                    res += list.get(i);   //拼接字符串
                }
                if (i != list.size() - 1) {
                    res += "_";   //非最后一个后面需要加下划线
                }
            }
            System.out.println(res);
        }
    }
}
