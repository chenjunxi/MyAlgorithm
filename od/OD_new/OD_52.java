package com.od.OD.OD130;

import java.util.Arrays;
import java.util.Scanner;
/*分界线 匿名信
*
*
* */
public class OD_52 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] newspaper = sc.nextLine().split(" ");
        String[] anonyLetter = sc.nextLine().split(" ");


        for (int i = 0; i < anonyLetter.length; i++) {
            String word = anonyLetter[i];
            char[] charsAnony = word.toCharArray();
            Arrays.sort(charsAnony);
            boolean flag = false;

            for (int j = 0; j < newspaper.length; j++) {
                String word1 = anonyLetter[j];
                char[] charsNew = word1.toCharArray();
                Arrays.sort(charsNew);
                if (charsAnony.length == charsNew.length && Arrays.equals(charsAnony, charsNew)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                System.out.println(false);
                break;
            }
        }

        System.out.println(true);
    }
}
