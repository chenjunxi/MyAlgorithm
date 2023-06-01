package com.od.B.fenshu100;

import java.util.Scanner;

public class OD22 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();

        String[] ss = s.split(" ");

        int[] ints = new int[ss.length];

        for (int i = 0; i < ss.length; i++) {
            ints[i] = Integer.parseInt(ss[i]);
        }

        int step = 0;   //步数的进度（数组下标）
        int count = 0;  //步数
        int x = Integer.MAX_VALUE;
        for (int i = 0; i < ints.length / 2 - 1; i++) { //从第一个元素开始，第一步<length/2(下标为0，所以要减一)
            step = i;
            count = 1;
            while (step < ints.length - 1) {  //没有走完就需要继续
                step += ints[step];
                count++;
            }
            if (step == ints.length - 1) {  //正好走完，比较步数
                x = Math.min(x, count);
            }
        }
        if (x == Integer.MAX_VALUE) {
            System.out.println("-1");
        } else {
            System.out.println(x);
        }
    }
}
