package com.leecode;

public class leecode443_2 {
    public static void main(String[] args) {

        char[] chars = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'a'};


        int left = 0, right = 1;


        int sum = 0;
        while (right < chars.length) {
            char a = chars[left];
            char b = chars[right];


            if (a != b || right == chars.length - 1) {
                int count = right - left;

                if (count == 1) {
                    sum++;
                } else {
                    sum++;
                    sum += String.valueOf(count).length();
                }

                if (a != b && right == chars.length - 1) {
                    sum++;
                }

                left = right;

            }
            right++;

        }

//        return sum;
        System.out.println(sum);


    }
}
