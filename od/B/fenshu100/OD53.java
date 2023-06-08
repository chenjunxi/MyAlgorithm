package com.od.B.fenshu100;

import java.util.ArrayDeque;
import java.util.Scanner;

/*
*非严格递增连续数字序列
abc2234019A334bc

使用stack记录递增元素，stack的大小就是个数

首先有三种情况会进行计算连续个数
1.遇到不连续的时候
2.最后一个元素
3.遇到字母的时候

* */
public class OD53 {

    static public int max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < line.length(); i++) {

            char c = line.charAt(i);

            if (Character.isDigit(c)) {
                if (!stack.isEmpty() && line.charAt(stack.peek()) > c) {
                    max = Math.max(max, stack.size());
                    stack.clear();

                }
                stack.push(i);
                if (!stack.isEmpty() && i == line.length() - 1) {

                    max = Math.max(max, stack.size());
                    stack.clear();
                    break;
                }

            } else {
                if (!stack.isEmpty()) {
                    max = Math.max(max, stack.size());
                    stack.clear();
                }
            }


        }
        System.out.println(max);
    }

    private static void demo() {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        int n = s.length();
        int max = 0;
        int count = 0;

        if (Character.isDigit(s.charAt(0))) { //如果第一个字符为数字则将count置1
            count = 1;
        }

        for (int i = 1; i < n; i++) {
            //判断字符是否为数字
            if (Character.isDigit(s.charAt(i))) {
                if (count != 0) {
                    //count不为0则可以进行比较，反则置为1，下次进行比较
                    if ((s.charAt(i) >= s.charAt(i - 1))) {
                        //符合条件
                        count++;
                    } else {
                        //不符合条件则抛出最大
                        max = Math.max(max, count);
                        //因为本次是数字，所以置1
                        count = 1;
                    }
                } else {
                    count = 1;
                }
            } else if (count != 0) {
                max = Math.max(max, count);
                count = 0;
            }
        }

        System.out.println(Math.max(max, count));
    }
}
