package com.od.B.fenshu100;

import java.util.*;

/*
* 数字反转打印
第n行开始数字=第n-1最小数字+(n+1)


思路：首先动态数组计算每一行的开始值
然后循环添加n个元素和n-1个空格元素
如果是偶数使用Collections.reverse反转
然后list前添加n-i个空格元素list.add(0, "    ")

* */
public class OD55_1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = i - 1 + dp[i - 1];
        }

        System.out.println(Arrays.toString(dp));
        List<List<String>> lists = new ArrayList<>();

        for (int i = 1; i <= n; i++) {      //为了方便i初始值设为1
            List<String> list = new ArrayList<>();
            int fn = dp[i];     //先计算出行头数字

            for (int j = 0; j < i; j++) {
                String temp = fn++ + "***";        //每个数后面都加三个*，因为至少一位数，所以只要加三个
                list.add(temp.substring(0, 4));     //头数向后递加，只取前面四个字符串
                if (j != i - 1) {
                    list.add("    ");       //除了最后一个数，其余全部加上"    "
                }
            }
            if ((i) % 2 == 0) {
                Collections.reverse(list);      //偶数行进行翻转
            }

            for (int j = 0; j < n - i; j++) { //添加n-i各个    元素

                list.add(0, "    ");
            }
            lists.add(list);
        }


        lists.forEach(x -> {
            String res = "";        //把所有行转化成字符串类型
            for (int i = 0; i < x.size(); i++) {
                res += x.get(i);
            }
            System.out.println(res);
        });
    }

    public static int firstNum(int n) {
        if (n == 1) {
            return 1;
        }
        return firstNum(n - 1) + n - 1;       //根据规律推出第n行的头为n-1的头加上n-1
    }
}
