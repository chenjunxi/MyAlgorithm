package com.leecode;
/*
*
交替合并字符串
思路：你加一次我加一次，剩下的尾巴单独处理
* */
public class leecode1768 {
    public static void main(String[] args) {
        String word01 = "abcd";
        String word02 = "pq";

        StringBuilder sb = new StringBuilder();

        //偶数数添加word1


        int indexa = 0, indexb = 0;

        boolean flag = true;
        while (indexa < word01.length() && indexb < word02.length()) {
            char a = word01.charAt(indexa);
            char b = word02.charAt(indexb);

            if (flag) {
                sb.append(a);
                indexa++;
                flag = !flag;
            } else {
                sb.append(b);
                indexb++;
                flag = !flag;
            }

        }

        if (word01.length() > word02.length()) {
            for (int i = indexa; i < word01.length(); i++) {
                sb.append(word01.charAt(i));
            }
        } else {
            for (int i = indexb; i < word02.length(); i++) {
                sb.append(word02.charAt(i));
            }
        }


        System.out.println(sb.toString());

    }
}
