package com.od.OD.OD200;

import java.util.HashMap;
import java.util.Scanner;

//看不懂代码的意思
public class OD_03_0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        int[] count = new int[N + 1];
        int res = 1;
        HashMap<Integer, Integer> cnt = new HashMap<>();
        HashMap<Integer, Integer> last = new HashMap<>();


        for (int i = 0; i < N; i++) {
            count[i + 1] = count[i] + nums[i];

            for (int j = i; j >= 0; j--) {

                int target = count[i + 1] - count[j];
                if (last.getOrDefault(target, 0) <= j) {
                    last.put(target, i + 1);
                    cnt.put(target, cnt.getOrDefault(target, 0) + 1);
                    res = Math.max(res, cnt.get(target));
                }
            }
        }
        System.out.println(res);

    }
}
