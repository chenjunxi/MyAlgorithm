package com.od.OD.OD130;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
/*组合出合法最小数
*
* */
class OD_99_new {
    public static List<String> result = new ArrayList<>();
    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        String[] numbers = in.nextLine().split(" ");

        //先排序
        Arrays.sort(numbers, (a, b) -> (a + b).compareTo(b + a));


        if (numbers[0].charAt(0) == '0') {
            for (int i = 1; i < numbers.length; i++) {
                if (numbers[i].charAt(0) != '0') {
                    numbers[0] = numbers[i] + numbers[0];
                    numbers[i] = "";
                    break;
                }
            }
        }

        String result = "";
        for (String str : numbers) {
            result += str;
        }

        result = result.replaceAll("^0+", "");
        if (result.equals("")){
            System.out.println("0");
        } else {
            System.out.println(result);
        }

    }

}