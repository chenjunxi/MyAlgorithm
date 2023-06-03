package com.od.B.fenshu200;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/*
* 找最小数
2615371
4
输出131  2615371删掉4个数，使得剩下的数值是最小的
1110021
4
001
循环比较开头两位数
第二位比第一位大，就删第二位，否则删第一位，当剩下len+1的时候，删掉最大数值的。
特殊情况考虑两位值相等的情况
* */
public class OD02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        int m = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i) - '0');
            set.add(s.charAt(i) - '0');
        }

        int len = s.length() - m;

        //针对特殊情况 同一个值的字符串 如：111111
        if (set.size() == 1) {
            for (int i = 0; i < len; i++) {
                System.out.print(list.get(0));
            }
            return;
        }


        while (list.size() > len + 1) {
            Integer a = list.get(0);
            Integer b = list.get(1);

            if (a != b) {
                if (b > a) {
                    list.remove(1);
                }

                if (a > b) {
                    list.remove(0);
                }
            } else { //针对开头值都是相同值

                int index = 2;
                for (int i = 2; i < list.size(); i++) {
                    Integer c = list.get(i);
                    if (c != b) {
                        index = i;
                        break;
                    }
                }
                if (list.get(index - 1) > list.get(index)) {
                    list.remove(index - 1);
                } else {
                    list.remove(index);
                }

            }

        }

        //剩下len+1个的时候，找出最大值，并删除即可
        int max = -1;
        for (int i : list) {
            max = Math.max(max, i);
        }

        list.remove(list.indexOf(max));
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
        }


    }

    private static void demo() {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        int m = sc.nextInt();
        //截取字符的右边界
        int l = m + 1;
        int index = 0;
        String res = "";

        while (res.length() < s.length() - m) {
            //求出第一个数字的最小值
            String str = s.substring(index, l);
            int min = Integer.MAX_VALUE;
            int len = str.length();
            int[] ints = new int[len];
            for (int i = 0; i < len; i++) {
                //char转换成int
                int temp = str.charAt(i) - '0';
                //放入数组求出下标
                ints[i] = temp;
                //第一位不能为0（如没有要求可以删掉）
                if (res == "" && temp == 0) {
                    continue;
                }
                min = Math.min(min, temp);
            }
            res += String.valueOf(min);

            for (int i = 0; i < len; i++) {
                if (ints[i] == min) {
                    //求出第一个最小值的下标然后去截取循环获取最小值
                    index += i;
                    break;
                }
            }
            index++;
            //数字要往后移一位
            l++;
        }
        System.out.println(res);
    }

}
