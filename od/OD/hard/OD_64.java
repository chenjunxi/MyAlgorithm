package com.od.OD.bei;

import java.util.*;
import java.util.stream.Collectors;

/*二进制差异数
 *
 *
 * */
//满分答案直接背。求出二进制位数，存放在32长度数组中。
public class OD_64 {
    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        //转为数组
        List<Integer> nums = Arrays.stream(in.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int[] bit_info = new int[100];

        for (int num : nums) {
            String num_binary = Integer.toBinaryString(num);
            int len = num_binary.length();

            if ("0".equals(num_binary)) {
                bit_info[0]++;
            } else {
                bit_info[num_binary.length()]++;
            }
        }

        int res = 0;
        for (int i = 0; i < bit_info.length; i++) {
            for (int j = i + 1; j < bit_info.length; j++) {
                res += bit_info[i] * bit_info[j];
            }
        }


        System.out.print(res);

    }

    private static void demo1() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[32];
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int h = Integer.toBinaryString(x).length();
            nums[h]++;
            ans += (i + 1) - nums[h];
        }

        System.out.println(ans);
    }
}
