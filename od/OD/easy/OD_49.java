package com.od.OD.OD130;


import java.util.Arrays;
import java.util.Scanner;

/*优雅子数组
给定一个数组和k，求数组有多少个子数组的元素出现的次数大于等于k的

利用数组左右指针，滑动统计元素个数
右指针不断移动，当满足条件的时候，res++
然后左指针移到一位，然后再判断条件，条件不满足，右指针继续移到
7 2
1 2 3 1 2 3 1

*/
public class OD_49 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];

        int[] count = new int[n + 1];

        int res = 0;
        int right = 0;
        for (int left = 0; left < n; left++) { //左移动
            if (left == 0) {
                count[nums[left]]++;
            } else {
                count[nums[left - 1]]--;
            }

            int max = Arrays.stream(count).max().getAsInt();
            if (max == k) {
                res += n - right; //后面肯定有n-right个子数组
                continue;
            }

            //右移到
            for (int i = right + 1; i < n; i++) {
                count[nums[i]]++;
                max = Arrays.stream(count).max().getAsInt();
                if (max == k) {
                    res += n - i;
                    right = i;
                    break;
                }
            }
        }
        System.out.println(res);

    }
}
