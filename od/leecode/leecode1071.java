package com.leecode;


/*
*
*
就是求两个数的公约数
* */
public class leecode1071 {
    public static void main(String[] args) {


        String str2 = "CXTXNCXTXNCXTXNCXTXNCXTXN";
        String str1 = "CXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXN";


        if (!((str1 + str2).equals(str2 + str1))) {

            System.out.println("");
            return;
        }

        int a = str1.length();
        int b = str2.length();

        if (a < b) {
            int i = get(a, b);
            System.out.println(str1.substring(0, i));
        } else {
            int i = get(b, a);
            System.out.println(str2.substring(0, i));
        }


    }

    public static int get(int a, int b) {
        int yushu = 0;
        while (b % a != 0) {
            yushu = b % a;
            b = a;
            a = yushu;
        }

        return yushu;
    }


}
